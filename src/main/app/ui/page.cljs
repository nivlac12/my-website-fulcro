(ns app.ui.page
  (:require
    [com.fulcrologic.fulcro.components :as comp
     :refer [defsc get-query get-initial-state factory]]
    [com.fulcrologic.fulcro.routing.dynamic-routing :as dr
     :refer [defrouter]]
    [com.fulcrologic.fulcro.ui-state-machines :as uism
     :refer [defstatemachine]]
    [com.fulcrologic.fulcro-css.css-injection :as inj
     :refer [style-element]]
    [com.fulcrologic.fulcro-css.localized-dom :as dom
     :refer [div]]
    [app.ui.components :as uic
     :refer [ContainerHeader ui-container-header]]
    [com.fulcrologic.fulcro-css.css :as css
     :refer [get-classnames]]
    [app.ui.sidebar.core :as sidebar
     :refer [Sidebar ui-sidebar]]
    [app.ui.pages.projects :as p]
    [app.ui.pages.contact :as c]
    [app.ui.pages.about :as a]
    [app.ui.pages.home :as h]
    [taoensso.timbre :as log]
    [app.ui.css :as uicss]))

(defrouter RootRouter
  [this {:keys [current-state pending-path-segment]}]
  {:router-targets [h/Home a/About c/Contact p/Projects]})
(def ui-root-router (factory RootRouter))

(defsc OuterBox [this {:outer/keys [id router] :as props}]
  {:query [:outer/id
           :outer/header
           {:outer/router (get-query RootRouter)}
           [::uism/asm-id ::RootRouter]]
   :pre-merge
          (fn [{:keys [data-tree]}]
            (merge (get-initial-state OuterBox)
                   data-tree))
   :ident :outer/id
   :initial-state
          (fn [{:outer/keys [id route] :as params}]
            {:outer/id     id
             :outer/router (get-initial-state RootRouter {})})
   :css   uicss/OuterBox}
  (let [{:keys [outer box]} (get-classnames OuterBox)]
    (div {:nonsense "TURN BACK, YE WHO ENTER THE DOMAIN OF HTML"
          :classes  [outer]}
         (ui-container-header
           (get-initial-state
             ContainerHeader
             {:container-header/id    id
              :container-header/route (first (dr/current-route this))}))
         (div {:classes [box]}
              (ui-root-router router)))))
(def ui-outer (factory OuterBox))

(defsc Page [this {:page/keys [outer sidebar]}]
  {:query [{:page/outer (get-query OuterBox)}
           {:page/sidebar (get-query Sidebar)}]
   :initial-state
          (fn [_] {:page/outer
                   (get-initial-state
                     OuterBox {:outer/id    1
                               :outer/route "home"})
                   :page/sidebar
                   (get-initial-state
                     Sidebar {:sidebar/id 1})})
   :css   [[:.page
            {:display         "flex"
             :align-items     "center"
             :justify-content "center"}]]}
  (let [{:keys [page]} (get-classnames Page)]
    (div {:classes [page]}
         (ui-outer outer)
         (ui-sidebar sidebar))))
(def ui-page (factory Page))

(defsc Root [this {:root/keys [page] :as props}]
  {:query [{:root/page (get-query Page)}]
   :initial-state
          (fn [_] {:root/page
                   (get-initial-state Page)})
   :css   [[:.container
            {:display         "flex"
             :align-items     "center"
             :justify-content "center"}]]}
  (let [{:keys [container]} (get-classnames Root)]
    (div
      {:classes [container]}
      (style-element {:component Root})
      (style-element {:component h/Home})
      (style-element {:component ContainerHeader})
      (ui-page page))))
