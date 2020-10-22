(ns example
  (:require
    [com.fulcrologic.fulcro.components :as comp :refer [defsc]]
    [com.fulcrologic.fulcro.routing.dynamic-routing :as dr]
    [com.fulcrologic.fulcro.ui-state-machines :as uism :refer [defstatemachine]]
    [com.fulcrologic.fulcro.mutations :as m :refer [defmutation]]
    [com.fulcrologic.fulcro-css.css-injection :as inj]
    [com.fulcrologic.fulcro-css.css :as css]
    [com.fulcrologic.fulcro-css.localized-dom :as dom
     :refer [div label button span]]))

First:
{:left-side/top
 {:top-left/contents
  {:href/id "gamin", :href/link "https://en.wikipedia.org/wiki/Gaming",
   :href/image
            {:image/id "gamin",
             :image/src "../images/WITH_OUR_THREE_POWERS_COMBINED.png",
             :image/alt "I play games I KNOW I'M SORRY",
             :image/classes nil}}},
 :left-side/bottom
 {:bottom-left/contents
  {:href/id "pho",
   :href/link "https://www.whatisitliketobeaphilosopher.com/",
   :href/image
   {:image/id "pho",
    :image/src "../images/the-thinker.png",
    :image/alt "But really, what even IS a rock anyways???",
    :image/classes nil}}}}
Second:
{:left-side/top
 {:top-left/contents
  {:href/id "gamin",
   :href/link "https://en.wikipedia.org/wiki/Gaming",
   :href/image
            {:image/id "pho",
             :image/src "../images/the-thinker.png",
             :image/alt "But really, what even IS a rock anyways???",
             :image/classes nil}}},
 :left-side/bottom
                                                                                                                                                                                                                                                                                                                                                                                                                                                                 {:bottom-left/contents
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    {:href/id "pho", :href/link "https://www.whatisitliketobeaphilosopher.com/", :href/image
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    {:image/id "pho", :image/src "../images/the-thinker.png", :image/alt "But really, what even IS a rock anyways???",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    :image/classes nil}}}}


;{
; :home/left
; (comp/get-initial-state
;   LeftSide
;   {:top
;    {:link "https://en.wikipedia.org/wiki/Gaming"
;     :id "gamin"
;     :src "../images/WITH_OUR_THREE_POWERS_COMBINED.png"
;     :alt "I play games I KNOW I'M SORRY"}
;    :bottom
;    {:link "https://www.whatisitliketobeaphilosopher.com/"
;     :id "pho"
;     :src "../images/the-thinker.png"
;     :alt "But really, what even IS a rock anyways???"}})
; }


;(defsc Home [this {:test/keys [imagea]}]
;  {:query [{:test/imagea (comp/get-query Image)}]
;   :route-segment ["home"]
;   :ident (fn [] [:component/id :home])
;   :initial-state
;   (fn [_]
;     {:test/imagea
;      (comp/get-initial-state
;        Image {:id "yo"
;               :src "../images/WITH_OUR_THREE_POWERS_COMBINED.png"
;               :alt "test"
;               :classes "none"})
;      })}
;  (dom/div
;    "words? "
;    (ui-image imagea)))

;(ui-left-side                                             ;left
;  (comp/get-initial-state
;    LeftSide
;    {:top
;     {:link "https://en.wikipedia.org/wiki/Gaming"
;      :id "gamin"
;      :src "../images/WITH_OUR_THREE_POWERS_COMBINED.png"
;      :alt "I play games I KNOW I'M SORRY"}
;     :bottom
;     {:link "https://www.whatisitliketobeaphilosopher.com/"
;      :id "pho"
;      :src "../images/the-thinker.png"
;      :alt "But really, what even IS a rock anyways???"}}))

;(def teste
;  {:home/left
;   (comp/get-initial-state
;     LeftSide
;     {:top
;      {:link "https://en.wikipedia.org/wiki/Gaming"
;       :id "gamin"
;       :src "../images/WITH_OUR_THREE_POWERS_COMBINED.png"
;       :alt "I play games I KNOW I'M SORRY"}
;      :bottom
;      {:link "https://www.whatisitliketobeaphilosopher.com/"
;       :id "pho"
;       :src "../images/the-thinker.png"
;       :alt "But really, what even IS a rock anyways???"}})})

;(defsc Home [this {:home/keys [left]}]
;  {:query [:home/left]
;   :route-segment ["home"]
;   :ident (fn [] [:component/id :home])
;   :initial-state
;    (fn [_] teste)}
;  (dom/div
;    (ui-left-side
;      left
;    ;              (comp/get-initial-state
;    ;                LeftSide
;    ;                {:top
;    ;                 {:link "https://en.wikipedia.org/wiki/Gaming"
;    ;                  :id "gamin"
;    ;                  :src "../images/WITH_OUR_THREE_POWERS_COMBINED.png"
;    ;                  :alt "I play games I KNOW I'M SORRY"}
;    ;                 :bottom
;    ;                 {:link "https://www.whatisitliketobeaphilosopher.com/"
;    ;                  :id "pho"
;    ;                  :src "../images/the-thinker.png"
;    ;                  :alt "But really, what even IS a rock anyways???"}})
;                  )
;    ))


;(defsc Test [this {:test/keys [left
;                               ] :as props}]
;  {:query [:test/left
;           ]
;   :ident (fn [] [:component/id :test])
;   :route-segment ["test"]
;   :initial-state
;   (fn [_]
;     {
;      :test/left
;        (comp/get-initial-state
;          LeftSide
;          {:top
;           {:link "https://en.wikipedia.org/wiki/Gaming"
;            :id "gamin"
;            :src "../images/WITH_OUR_THREE_POWERS_COMBINED.png"
;            :alt "I play games I KNOW I'M SORRY"}
;           :bottom
;           {:link "https://www.whatisitliketobeaphilosopher.com/"
;            :id "pho"
;            :src "../images/the-thinker.png\\"
;            :alt "But really, what even IS a rock anyways???"}})}
;     )
;   }
;  (dom/div
;    (ui-left-side left
;      ;(comp/get-initial-state
;      ;  LeftSide
;      ;  {:top
;      ;   {:link "https://en.wikipedia.org/wiki/Gaming"
;      ;    :id "gamin"
;      ;    :src "../images/WITH_OUR_THREE_POWERS_COMBINED.png"
;      ;    :alt "I play games I KNOW I'M SORRY"}
;      ;   :bottom
;      ;   {:link "https://www.whatisitliketobeaphilosopher.com/"
;      ;    :id "pho"
;      ;    :src "../images/the-thinker.png\\"
;      ;    :alt "But really, what even IS a rock anyways???"}})
;      )
;    ))

;(defsc Test [this {:test/keys [
;                               imagea
;                               imagex
;                               ] :as props}]
;  {:query [
;           :test/imagea
;           :test/imagex
;           ]
;   :ident (fn [] [:component/id :test])
;   :route-segment ["test"]
;   :initial-state
;   (fn [_]
;     {:test/imagea
;     (comp/get-initial-state
;       Image {:id "yo"
;              :src "../images/WITH_OUR_THREE_POWERS_COMBINED.png"
;              :alt "test"
;              :classes "none"})
;
;     :test/imagex
;     (comp/get-initial-state
;       Image {:id "yooo"
;              :src "../images/the-thinker.png"
;              :alt "teste"
;              :classes "none"}
;      )
;      }
;
;     )
;   }
;  (dom/div
;    (ui-image imagea)
;    (ui-image imagex)
;    ))


;; Stuff I probs want idk

;(defsc Test [this {:test/keys [image]}]
  ;  {:query [:test/image]
  ;   :initial-state
  ;   (fn [_]
  ;     {:test/image
  ;      (comp/get-initial-state
  ;        Image
  ;        {:id "yo"
  ;         :src "../images/WITH_OUR_THREE_POWERS_COMBINED.png"
  ;         :alt "test"
  ;         :classes "none"})})}
  ;  (dom/div
  ;    "Thing: " (ui-image image)))

  ;(defsc About [this {:test/keys [words left] :as props}]
  ;  {:query [:test/words
  ;           {:test/left (comp/get-query LeftSide)}]
  ;   :ident (fn [] [:component/id :home])
  ;   :route-segment ["about"]
  ;   :initial-state
  ;   (fn [_]
  ;     {:test/words "Here are some words"
  ;      :test/left (comp/get-initial-state
  ;                   LeftSide
  ;                   {:top
  ;                    {:link "https://en.wikipedia.org/wiki/Gaming"
  ;                     :id 3
  ;                     :src "../images/WITH_OUR_THREE_POWERS_COMBINED.png"
  ;                     :alt "I play games I KNOW I'M SORRY"}
  ;                    :bottom
  ;                    {:link "https://www.whatisitliketobeaphilosopher.com/"
  ;                     :id 2
  ;                     :src "../images/the-thinker.png\\"
  ;                     :alt "But really, what even IS a rock anyways???"}})})}
  ;  (dom/div
  ;    (str "Tis about: " words)
  ;    (str "Left side: ")
  ;    (ui-left-side left)))

  ;(defsc Contact [this {:contact/keys [id image span-image] :as props}]
  ;  {:query [:contact/id
  ;           {:contact/image (comp/get-query Image)}
  ;           {:contact/span-image (comp/get-query Image)}]
  ;   :route-segment ["contact"]
  ;   :ident (fn [] [:contact/id :contact])
  ;   ;:will-enter (dr/route-immediate [:contact/id ::contact])
  ;   :initial-state
  ;   (fn [{:keys [_] :as params}]
  ;     {:contact/id 1
  ;      :contact/image
  ;                  (comp/get-initial-state Image
  ;                                          {:id "mail-big"
  ;                                           :src "../images/mailV2.png"
  ;                                           :alt "email"
  ;                                           :classes "big-email-boi"})
  ;      :contact/span-image
  ;                  (comp/get-initial-state Image
  ;                                          {:id "mail-small"
  ;                                           :src "../images/mail_secure.PNG"
  ;                                           :alt "for security reasons"
  ;                                           :classes "small-email-boi"})})
  ;   :css [[:.general-container
  ;          {:display "flex"
  ;           :flex-direction "row"
  ;           :justify-content "center"
  ;           :align-items "center"}]
  ;         [:.general-container>div>.href-image-container
  ;          {:width "50%"
  ;           :height "50%"}]
  ;         [:.contact {:color "white"
  ;                     :position "relative"
  ;                     :top "0"
  ;                     :left "0"
  ;                     :transform "scale(0.7)"
  ;                     :display "flex"
  ;                     :flex-direction "column"
  ;                     :align-items "center"
  ;                     }]
  ;         [:.contact>img {:width "100%"
  ;                         :height "auto"
  ;                         :position "relative"
  ;                         :top "0"
  ;                         :left "0"}]
  ;         [:.contact>.big-email-boi {:position "relative"
  ;                                    :top "0"
  ;                                    :left "0"
  ;                                    :border-radius "1.5em"}]
  ;         [:.contact>.small-email-boi {:position "absolute"
  ;                                      :top "38%"
  ;                                      :left "0"
  ;                                      :visibility "hidden"
  ;                                      :transform "scale(0.8)"
  ;                                      }]
  ;         [:.contact>.big-email-boi:hover+.small-email-boi {
  ;                                                           :visibility "visible"
  ;                                                           }]
  ;         [:.very-small-text {
  ;
  ;
  ;                             }]
  ;         [:.contact>.small-email-boi:hover {:visibility "visible"}]
  ;         ]}
  ;  (let [{:keys [contact]} (css/get-classnames Contact)]
  ;    (dom/div
  ;      {:classes [contact
  ;                 ;           contact>big-mail-boi
  ;                 ;           contact>small-mail-boi
  ;                 ]
  ;       }
  ;      ;(inj/style-element {:component Contact})
  ;      (ui-image image)
  ;      (ui-image span-image)
  ;
  ;      ;(:span {:className "popup"})
  ;
  ;      ;(dom/div
  ;      ;(dom/div {:className "mail"} )
  ;      ;)
  ;      (dom/div {:className "very-small-text"}
  ;               "(email for social media)"))))

  ;(defsc Projects [this {:test/keys [words left] :as props}]
  ;  {:query [:test/words
  ;           {:test/left (comp/get-query LeftSide)}]
  ;   :ident (fn [] [:component/id :home])
  ;   :route-segment ["projects"]
  ;   :initial-state
  ;     (fn [_]
  ;       {:test/words "Here are some words"
  ;        :test/left (comp/get-initial-state LeftSide
  ;         {:top
  ;          {:link "https://en.wikipedia.org/wiki/Gaming"
  ;           :id 4
  ;           :src "../images/WITH_OUR_THREE_POWERS_COMBINED.png"
  ;           :alt "I play games I KNOW I'M SORRY"}
  ;          :bottom
  ;          {:link "https://www.whatisitliketobeaphilosopher.com/"
  ;           :id 4
  ;           :src "../images/the-thinker.png\\"
  ;           :alt "But really, what even IS a rock anyways???"}})})}
  ;  (dom/div (ui-left-side left)))
  ;;;;;

  ;[com.fulcrologic.fulcro.networking.http-remote :as net]
  ;[com.fulcrologic.fulcro.data-fetch :as df]
  ;[com.fulcrologic.fulcro.ui-state-machines :as uism]
  ;[com.fulcrologic.fulcro-css.css-injection :as cssi]
  ;[app.model.session :as session]
  ;[com.fulcrologic.fulcro.algorithms.denormalize :as fdn]
  ;[com.fulcrologic.fulcro.algorithms.merge :as merge]
  ;[com.fulcrologic.fulcro.inspect.inspect-client :as inspect]

  ;(defn ^:export refresh []
  ;  ;(log/info "Hot code Remount")
  ;  ;(cssi/upsert-css "componentcss" {:component root/Root})
  ;  ;(comp/refresh-dynamic-queries! root/Root)
  ;  (app/mount! SPA root/Root "app")
  ;  (comp/refresh-dynamic-queries! SPA))
  ;
  ;(defn ^:export init []
  ;  ;(log/info "Application starting.")
  ;  ;(cssi/upsert-css "componentcss" {:component root/Root})
  ;  ;(inspect/app-started! SPA)
  ;  (app/set-root! SPA root/Root {:initialize-state? true})
  ;  (dr/initialize! SPA)
  ;  ; (log/info "Starting session machine.")
  ;  ;(uism/begin! SPA session/session-machine ::session/session
  ;  ;{
  ;  ;:actor/login-form      root/Login
  ;  ;:actor/current-session root/Session})
  ;  (dr/change-route! SPA ["home"])
  ;  (app/mount! SPA root/Root "app" {:initialize-state? false})
  ;  ; (dr/change-route! SPA ["Home"])
  ;  )

  ;(fn [_]
  ;  {:outer/router
  ;   (comp/get-initial-state RootRouter {})})


  ;(defsc Test [this {:test/keys [
  ;                               words
  ;                               left
  ;                               ] :as props}]
  ;  {:query [:test/words
  ;           {:test/left (comp/get-query LeftSide)}
  ;           ]
  ;   :ident (fn [] [:component/id :test])
  ;   :route-segment ["test"]
  ;   :initial-state
  ;   (fn [_]
  ;     {:test/words "Here are some words"
  ;      :test/left
  ;        (comp/get-initial-state LeftSide
  ;         {:top
  ;          {:link "https://en.wikipedia.org/wiki/Gaming"
  ;           :id 1
  ;           :src "../images/WITH_OUR_THREE_POWERS_COMBINED.png"
  ;           :alt "I play games I KNOW I'M SORRY"}
  ;          :bottom
  ;          {:link "https://www.whatisitliketobeaphilosopher.com/"
  ;           :id 2
  ;           :src "../images/the-thinker.png\\"
  ;           :alt "But really, what even IS a rock anyways???"}})
  ;      }
  ;     )
  ;   }
  ;  (dom/div
  ;    (str "Tis a test: " words)
  ;    (str "Left side: ")
  ;    (ui-left-side left)
  ;    ))

  ;(defn client-did-mount
  ;  "Must be used as :client-did-mount parameter of app creation, or called just after you mount the app."
  ;  [app]
  ;  (dr/change-route app ["main"]))

  ;(fn [_] {                                                ;:home/left-side
  ;         ;(comp/get-initial-state LeftSide)
  ;         ;:home/middle
  ;         ;(comp/get-initial-state LeftSide)
  ;         ;:home/right-side
  ;         ;(comp/get-initial-state LeftSide)
  ;         })
  ;:css [[:.general-container
  ;       {:display "flex"
  ;        :flex-direction "row"
  ;        :justify-content "center"
  ;        :align-items "center"}]
  ;      [:.general-container>div>.href-image-container
  ;       {:width "50%"
  ;        :height "50%"}]]
  ;:initial-state (fn [])
  ;(fn [{:keys [_] :as params}] home-initial-state)
  ;:will-enter
  ;(fn [app {:home/keys [id] :as route-params}]
  ;  (log/info "will enter user with route params: " route-params)
  ;  (log/info "Id: " (:home/keys route-params))
  ;  (let [id (if (string? id) (js/parseInt id) id)]
  ;    (dr/route-deferred
  ;      [:home/id 1]
  ;      (fn [] (df/load!
  ;               app
  ;               [:home/id id]
  ;               Home
  ;               {:post-mutation `dr/target-ready
  ;                :post-mutation-params
  ;                {:target [:home/id id]}})))))
  ;:will-enter (fn [app {:home/keys [id] :as route-params}]
  ;              (dr/route-deferred [:home/id id]
  ;                #(df/load app [:home/id id] Home
  ;                    {:post-mutation `dr/target-ready
  ;                     :post-mutation-params
  ;                     {:target [:home/id id]}})))
  ;(dr/route-immediate [:home/id ::home])
  ;:will-enter
  ;(fn [app {:home/keys [id] :as route-params}]
  ; (log/info "Will enter user with route params " route-params)
  ; ;; be sure to convert strings to int for this case
  ; (let [id (if (string? id) (js/parseInt id) id)]
  ;    #(df/load app [:home/id id] Home
  ;      {:post-mutation `dr/target-ready
  ;       :post-mutation-params
  ;        {:target [:home/id id]}}))
  ;  )




  ;(defsc Home [this {:test/keys [words left] :as props}]
  ;  {:query [:test/words
  ;           {:test/left (comp/get-query LeftSide)}]
  ;   :ident (fn [] [:component/id :home])
  ;   :route-segment ["home"]
  ;   :initial-state
  ;   (fn [_]
  ;     {:test/words "Here are some words"
  ;      :test/left (comp/get-initial-state LeftSide
  ;       {:top
  ;        {:link "https://en.wikipedia.org/wiki/Gaming"
  ;         :id 1
  ;         :src "../images/WITH_OUR_THREE_POWERS_COMBINED.png"
  ;         :alt "I play games I KNOW I'M SORRY"}
  ;        :bottom
  ;        {:link "https://www.whatisitliketobeaphilosopher.com/"
  ;         :id 2
  ;         :src "../images/the-thinker.png\\"
  ;         :alt "But really, what even IS a rock anyways???"}})})}
  ;  (dom/div
  ;    (str "Tis a test: " words)
  ;    (str "Left side: ")
  ;    (ui-left-side left)))

  ;(defsc Home [this {:home/keys [words] :as props}]
  ;  {:query [:home/words]
  ;      :ident (fn [] [:component/id :home])
  ;
  ;   :route-segment ["home"]
  ;   :initial-state (fn [_] {:home/words "words"})}
  ;  (dom/div "home" words))

  ;HOME JUNK

  ;(defsc Home [this {:home/keys
  ;                   [
  ;                    ;left-side
  ;                    ;middle
  ;                    ;right-side
  ;                    ] :as props}]
  ;  {:query [
  ;           ;{:home/left-side (comp/get-query LeftSide)}
  ;           ;{:home/middle (comp/get-query Middle)}
  ;           ;{:home/right-side (comp/get-query RightSide)}
  ;           ]
  ;   :ident (fn [] :component/id :home)
  ;   :route-segment ["home"]
  ;   :initial-state
  ;   (fn [_] {                                                ;:home/left-side
  ;            ;(comp/get-initial-state LeftSide)
  ;            ;:home/middle
  ;            ;(comp/get-initial-state LeftSide)
  ;            ;:home/right-side
  ;            ;(comp/get-initial-state LeftSide)
  ;            })
  ;   ;:css [[:.general-container
  ;   ;       {:display "flex"
  ;   ;        :flex-direction "row"
  ;   ;        :justify-content "center"
  ;   ;        :align-items "center"}]
  ;   ;      [:.general-container>div>.href-image-container
  ;   ;       {:width "50%"
  ;   ;        :height "50%"}]]
  ;   ;:initial-state (fn [])
  ;   ;(fn [{:keys [_] :as params}] home-initial-state)
  ;   ;:will-enter
  ;   ;(fn [app {:home/keys [id] :as route-params}]
  ;   ;  (log/info "will enter user with route params: " route-params)
  ;   ;  (log/info "Id: " (:home/keys route-params))
  ;   ;  (let [id (if (string? id) (js/parseInt id) id)]
  ;   ;    (dr/route-deferred
  ;   ;      [:home/id 1]
  ;   ;      (fn [] (df/load!
  ;   ;               app
  ;   ;               [:home/id id]
  ;   ;               Home
  ;   ;               {:post-mutation `dr/target-ready
  ;   ;                :post-mutation-params
  ;   ;                {:target [:home/id id]}})))))
  ;   ;:will-enter (fn [app {:home/keys [id] :as route-params}]
  ;   ;              (dr/route-deferred [:home/id id]
  ;   ;                #(df/load app [:home/id id] Home
  ;   ;                    {:post-mutation `dr/target-ready
  ;   ;                     :post-mutation-params
  ;   ;                     {:target [:home/id id]}})))
  ;   ;(dr/route-immediate [:home/id ::home])
  ;   ;:will-enter
  ;   ;(fn [app {:home/keys [id] :as route-params}]
  ;   ; (log/info "Will enter user with route params " route-params)
  ;   ; ;; be sure to convert strings to int for this case
  ;   ; (let [id (if (string? id) (js/parseInt id) id)]
  ;   ;    #(df/load app [:home/id id] Home
  ;   ;      {:post-mutation `dr/target-ready
  ;   ;       :post-mutation-params
  ;   ;        {:target [:home/id id]}}))
  ;   ;  )
  ;   }
  ;  ;(let [{:keys [general-container]} (css/get-classnames Home)]
  ;    (dom/div "home"
  ;  ;    ;{:classes [general-container]}
  ;  ;           (ui-left-side left-side)
  ;  ;           ;(ui-middle middle)
  ;  ;           ;            (ui-right-side right-side)
  ;  ;           )
  ;    )
  ;
  ;  )
  ;(def ui-home (comp/factory Home {:keyfn :home/id}))


  ;(def home-initial-state
  ;  {:home/id 1
  ;   :home/left-side
  ;            (comp/get-initial-state LeftSide
  ;                                    {:top
  ;                                     {:link "https://en.wikipedia.org/wiki/Gaming"
  ;                                      :id 1
  ;                                      :src "../images/WITH_OUR_THREE_POWERS_COMBINED.png"
  ;                                      :alt "I play games I KNOW I'M SORRY"}
  ;                                     :bottom
  ;                                     {:link "https://www.whatisitliketobeaphilosopher.com/"
  ;                                      :id 2
  ;                                      :src "../images/the-thinker.png\\"
  ;                                      :alt "But really, what even IS a rock anyways???"}})
  ;   :home/middle
  ;            (comp/get-initial-state Middle
  ;                                    {:content
  ;                                     [(dom/p {:key 1
  ;                                              :className "enlarge-text"}
  ;                                             ;{:class "enlarge-text"}
  ;                                             "Mostly this stuff")
  ;                                      (dom/p
  ;                                        {:key 2
  ;                                         :className "small-text"}
  ;                                        "(check out my projects for novel things)")]
  ;                                     })
  ;   :home/right-side
  ;            (comp/get-initial-state RightSide
  ;                                    {:top
  ;                                     {:link "https://www.youtube.com/"
  ;                                      :id 3
  ;                                      :src "../images/tubes.png"
  ;                                      :alt "Youtube is my Netflix, sadly"}
  ;                                     :bottom
  ;                                     {:link "https://en.wikipedia.org/wiki/Programmer"
  ;                                      :id 4
  ;                                      :src "../images/meirl.png"
  ;                                      :alt "g! 'How to print newline in cljs'"}})})

  ;;;;









  ;(defrouter PageOptions [this {:keys [current-state] :as props}]
  ;  {:router-targets [Home]}
  ;  (case current-state
  ;    :pending (dom/div "...")
  ;    :failed (dom/div "Failed")
  ;    (dom/div "No Route Selected")))

  ;(update-in [:button/id id :button/num]
  ;           #(if (= %1 1) 0 1))

  ; also useful
  ;(defn style [& info]
  ;  {:style (.trim (apply str (map #(let [[kwd val] %]
  ;                                    (str (name kwd) ":" val "; "))
  ;                                 (apply hash-map info))))})
  ;(def body-style
  ;  (style
  ;    :background-image "url(/images/background.png)"
  ;    :background-color "black"
  ;    :background-position "center"
  ;    :background-attachment "fixed"
  ;    :background-repeat "no-repeat"
  ;    :background-size "cover"
  ;    :width "100%"
  ;    :height "100%"))
  ;;:html [                  height:100%;
  ;;       display: flex;
  ;;       flex-direction: column;
  ;;       overflow-x: hidden;
  ;;       ]
  ;;:body>* [flex-shrink 0]

  ; VERY HELPFUL
  ;(defsc LeftSide [this {:left-side/keys [
  ;                                        ;top
  ;                                        contents
  ;                                        ] :as props}]
  ;       {:query [
  ;                {:left-side/contents (comp/get-query TopLeft)}
  ;                ;{:left-side/bottom (comp/get-query BottomLeft)}
  ;                ]
  ;        :initial-state
  ;               (fn [{:keys [top
  ;                            ;bottom
  ;                            ] :as params}]
  ;                 (let [link (:link top)
  ;                       id (:id top)
  ;                       src (:src top)
  ;                       alt (:alt top)
  ;                       ]
  ;                   {:left-side/contents
  ;                    (comp/get-initial-state TopLeft
  ;                                            {:link link :id id :src src :alt alt}
  ;
  ;
  ;                                            )
  ;                    }
  ;                   )
  ;
  ;
  ;                 ;(comp/get-initial-state BottomLeft bottom)
  ;                 )}
  ;       (dom/div
  ;         (println "contents" contents)
  ;         (ui-top-left contents)
  ;         ;(ui-bottom-left bottom)
  ;         ))
  ;(def ui-left-side (comp/factory LeftSide))


  ;(defsc Test [this {:keys [image]}]
  ;       {:query [:type :id {:image (comp/get-query Image)}]
  ;        :initial-state
  ;               (fn [{:keys [id src alt]}]
  ;                 {:id id :type :test
  ;                  :image (comp/get-initial-state
  ;                           Image {:id 1 :src src :alt alt})})}
  ;       (dom/div
  ;         (ui-image image)))
  ;(def ui-test (comp/factory Test {:keyfn :id}))



  ;;; ENTRANCE CODE ;;;

  ;(comment
  ;  (inspect/app-started! SPA)
  ;  (app/mounted? SPA)
  ;  (app/set-root! SPA root/Root {:initialize-state? true})
  ;  (uism/begin! SPA session/session-machine ::session/session
  ;    {:actor/login-form      root/Login
  ;     :actor/current-session root/Session})
  ;
  ;  (reset! (::app/state-atom SPA) {})
  ;
  ;  (merge/merge-component! SPA root/Settings {:account/time-zone "America/Los_Angeles"
  ;                                             :account/real-name "Joe Schmoe"})
  ;  (dr/initialize! SPA)
  ;  (app/current-state SPA)
  ;  (dr/change-route SPA ["settings"])
  ;  (app/mount! SPA root/Root "app")
  ;  (comp/get-query root/Root {})
  ;  (comp/get-query root/Root (app/current-state SPA))
  ;
  ;  (-> SPA ::app/runtime-atom deref ::app/indexes)
  ;  (comp/class->any SPA root/Root)
  ;  (let [s (app/current-state SPA)]
  ;    (fdn/db->tree [{[:component/id :login] [:ui/open? :ui/error :account/email
  ;                                            {[:root/current-session '_] (comp/get-query root/Session)}
  ;                                            [::uism/asm-id ::session/session]]}] {} s)))

  ;(defsc Home [this {:inner-box/keys [id] :as props}]
  ;       {:query []
  ;        :ident :inner-box/keys
  ;        :initial-state (fn [{:keys [id] :as params}]
  ;                           {:inner-box/keys id})}
  ;       )
  ;
  ;(defsc ContainerHeader)
  ;
  ;
  ;(defsc InnerBox [this {:inner-box/keys [id] :as props}]
  ;       {:query []
  ;        :ident :inner-box/keys
  ;        :initial-state (fn [{:keys [id] :as params}]
  ;                           {:inner-box/keys id})}
  ;       (dom/div {:id "inner-box"}
  ;         (match [request]
  ;                ["home"] home/home-page-body
  ;                ["about"] about/about-page-body
  ;                ["projects"] projects/project-page-body
  ;                ["contact"] contact/contact-page-body)
  ;         ))
  ;
  ;(def ui-container (comp/factory Container))



  ;(defn get-header [request]
  ;      (match [request]
  ;             ["home"] (dom/p "What am I up to?")
  ;             ;["about"] about/about-page-header
  ;             ;["projects"] projects/project-page-header
  ;             ;["contact"] contact/contact-page-header
  ;             ))
  ;(defn get-inner-content [request]
  ;      (match [request]
  ;             ["home"] (ui-)
  ;             ;["about"] about/about-page-body
  ;             ;["projects"] projects/project-page-body
  ;             ;["contact"] contact/contact-page-body
  ;             ))

  ;(defn get-inner [req]
  ;      (dom/div
  ;        (match [req]
  ;               ["home"] (
  ;                         (ui-container-header header)
  ;                         (ui-container-body body)
  ;                          )
  ;               )
  ;        )
  ;)

  ;(defsc ImageContainer [this {:image-container/keys [id src alt] :as props}]
  ;  {:query [:image-container/id :image-container/src :image-container/alt]
  ;   :ident :image-container/id
  ;   :initial-state (fn [{:keys [id src alt] :as params}]
  ;                    {:image-container/id id
  ;                     :image-container/src src
  ;                     :image-container/alt alt})}
  ;  ;css/context
  ;  (dom/div
  ;    "ID: " id
  ;    "Src: " src
  ;    "Alt: " alt
  ;    )
  ;  ;(dom/img {:src src :alt alt}
  ;  ;  "Id: " id
  ;  ;  )
  ;  )
  ;(def ui-image-container (comp/factory ImageContainer))

  ;(defsc Container [this {:container/keys [id content] :as props}]
  ;       {:query [:container/id :container/content]
  ;        :ident :container/id
  ;        :initial-state (fn [{:keys [id content] :as params}]
  ;                           {:container/id id
  ;                            :container/content content})}
  ;        )
  ;(def ui-container (comp/factory Container))
  ;
  ;(defsc ContainerRight [this {:container-right/keys [id content] :as props}]
  ;       {:query [:container-right/id :container-right/content]
  ;        :ident :container-right/id
  ;        :initial-state (fn [{:keys [id content] :as params}]
  ;                           {:container-right/id id
  ;                            :container-right/container
  ;                              (comp/get-initial-state Container
  ;                                {:container/id id
  ;                                 :container/content content})})}
  ;       (dom/div :.container-right "right-side" content))
  ;(def ui-container-right (comp/factory ContainerRight))
  ;
  ;(defsc ContainerHorizontalMiddle [this {:container-hoz-middle/keys [id content] :as props}]
  ;       {:query [:container-hoz-middle/id :container-hoz-middle/content]
  ;        :ident :container-hoz-middle/id
  ;        :initial-state (fn [{:keys [id content] :as params}]
  ;                           {:container-hoz-middle/id id
  ;                            :container-hoz-middle/container
  ;                              (comp/get-initial-state Container
  ;                                {:container/id id
  ;                                 :container/content content})})}
  ;       (dom/div :.container-hoz-middle  "hoz-middle" content))
  ;(def ui-container-hoz-middle (comp/factory ContainerHorizontalMiddle))
  ;
  ;(defsc ContainerLeft [this {:container-left/keys [id content] :as props}]
  ;       {:query [:container-left/id :container-left/content]
  ;        :ident :container-left/id
  ;        :initial-state (fn [{:keys [id content] :as params}]
  ;                           {:container-left/id id
  ;                            :container-left/container
  ;                            (comp/get-initial-state Container
  ;                              {:container/id id
  ;                               :container/content content})})}
  ;       (dom/div :.container-left  "left-side" content))
  ;(def ui-container-left (comp/factory ContainerLeft))
  ;
  ;(defsc ContainerTop [this {:container-top/keys [id content] :as props}]
  ;       {:query [:container-top/id :container-top/content]
  ;        :ident :container-top/id
  ;        :initial-state (fn [{:keys [id content] :as params}]
  ;                           {:container-top/id id
  ;                            :container-top/container
  ;                              (comp/get-initial-state Container
  ;                                {:container/id id
  ;                                 :container/content content})})}
  ;       (dom/div :.container-top  "top" content))
  ;(def ui-container-top (comp/factory ContainerTop))
  ;
  ;(defsc ContainerVerticalMiddle [this {:container-vert-middle/keys [id content] :as props}]
  ;       {:query [:container-vert-middle/id :container-vert-middle/content]
  ;        :ident :container-vert-middle/id
  ;        :initial-state (fn [{:keys [id content] :as params}]
  ;                           {:container-vert-middle/id id
  ;                            :container-vert-middle/container
  ;                              (comp/get-initial-state Container
  ;                                {:container/id id
  ;                                 :container/content content})})}
  ;       (dom/div :.container-vert-middle  "top" content))
  ;(def ui-container-vert-middle (comp/factory ContainerTop))
  ;
  ;(defsc ContainerBottom [this {:container-bottom/keys [id content] :as props}]
  ;       {:query [:container-bottom/id :container-bottom/content]
  ;        :ident :container-bottom/id
  ;        :initial-state (fn [{:keys [id content] :as params}]
  ;                           {:container-bottom/id id
  ;                            :container-bottom/container
  ;                              (comp/get-initial-state Container
  ;                                {:container/id id
  ;                                 :container/content content})})
  ;        }
  ;       (dom/div :.container-bottom  "bottom" content))
  ;(def ui-container-bottom (comp/factory ContainerBottom))
  ;
  ;(defsc ContainerBody [this {:container-body/keys [id body] :as props}]
  ;       {:query [:container-body/id :container-body/body]
  ;        :ident :container-body/id
  ;        :initial-state (fn [{:keys [id body] :as params}]
  ;                           {:container-body/id id
  ;                            :container-body/body body})
  ;        :css [[:.outer-text
  ;               {:font-size "2em"
  ;                :color "white"
  ;                :text-align "center"
  ;                :font-family "MINIMAL"
  ;                :margin "0 auto"
  ;                :padding "0 auto"
  ;                :vertical-align "top"}]
  ;              [:.home
  ;               {:border "1px"
  ;                :border-color "white"
  ;                :border-style "solid"
  ;                :border-radius "1%"
  ;                :position "relative"
  ;                :width "inherit"
  ;                :overflow-wrap "anywhere"
  ;                :word-wrap "anywhere"
  ;                :hyphens "auto"
  ;                :display "flex"
  ;                :flex-direction "row"
  ;                :justify-content "center"
  ;                :align-items "center"}]]}
  ;(dom/div ":class \"box general-container\""
  ;         "hey look it's content + " body)
  ;       )
  ;(def ui-container-body (comp/factory ContainerBody))

  ;(defsc Test [this {:test/keys [name age]}]
  ;  {:query [:test/name :test/age]
  ;   :ident :test/name
  ;   :initial-state (fn [{:keys [name age] :as params}]
  ;                    {:test/name name :test/age age})}
  ;  (dom/li
  ;    (dom/h5 (str "Name: " name " | Age: " age))))
  ;
  ;(def ui-test (comp/factory Test {:keyfn :person/name}))

  ;(defsc TestList [this {:list/keys [label content]}]
  ;  {:query [:list/label :list/content]
  ;   :ident  :list/label
  ;   :initial-state (fn [{:keys [label]}]
  ;                    {:list/label label
  ;                     :list/people (if (= label "Hot")
  ;                        [(comp/get-initial-state Test
  ;                           {:name "tamali" :age "22"})
  ;                         (comp/get-initial-state Test
  ;                           {:name "Joe" :age 22})]
  ;                        [(comp/get-initial-state Test
  ;                           {:name "as ice" :age "99"})
  ;                           (comp/get-initial-state Test
  ;                             {:name "Bobby" :age 55})])})}
  ;  (dom/div
  ;    (dom/h4 label)
  ;    (dom/ul (str ui-test content))))
  ;(def ui-test-list (comp/factory TestList))




  ;{:home/id id
  ; :home/body
  ; (comp/get-initial-state
  ;   ContainerBody
  ;   {:container/id id
  ;    :container/content
  ;    ;{(comp/get-initial-state
  ;    ;   ContainerLeft
  ;    ;   ;{:container-left/id id
  ;    ;   ; :container-left/content
  ;    ;   ; {
  ;    ;   ;  ;(comp/get-initial-state
  ;    ;   ;  ;  ContainerTop
  ;    ;   ;  ;{:container-top/id id
  ;    ;   ;  ; :container-top/content
  ;    ;   ;  ; {(dom/div ":class table-role-video left-top href-image-container"
  ;    ;   ;  ;    (dom/a
  ;    ;   ;  ;      ":href \"https://en.wikipedia.org/wiki/Gaming\"
  ;    ;   ;  ;       :target \"__blank\" :rel \"noopener noreferrer\""
  ;    ;   ;  ;           (dom/img
  ;    ;   ;  ;             ":src \"../images/WITH_OUR_THREE_POWERS_COMBINED.png\"
  ;    ;   ;  ;             :alt "I play games I KNOW I'M SORRY"
  ;    ;   ;  ;             "))
  ;    ;   ;  ;           )}})
  ;    ;   ;  ;(comp/get-initial-state
  ;    ;   ;  ;  ContainerBottom
  ;    ;   ;  ;  {:container-bottom/id id
  ;    ;   ;  ;   :container-bottom/body
  ;    ;   ;  ;   {(dom/div ":class thonker left-bottom href-image-container"
  ;    ;   ;  ;             (dom/a
  ;    ;   ;  ;               ":href \"https://www.whatisitliketobeaphilosopher.com/\"
  ;    ;   ;  ;                :target \"__blank\" :rel \"noopener noreferrer\""
  ;    ;   ;  ;               (dom/img
  ;    ;   ;  ;                 ":src \"../images/the-thinker.png\"
  ;    ;   ;  ;                  :alt \"But really, what even IS a rock anyways???")))}})
  ;    ;   ;  }}
  ;    ;   )
  ;    ; (comp/get-initial-state
  ;    ;   ContainerHorizontalMiddle
  ;    ;   {
  ;    ;    ;(dom/div ":class middle-main-page padding-bottom"
  ;    ;    ;         (dom/p ":class enlarge-text" "Mostly this stuff")
  ;    ;    ;         (dom/p ":class small-text" "(check out my project for novel things"))
  ;    ;    })
  ;    ; (comp/get-initial-state
  ;    ;   ContainerRight
  ;    ;   {
  ;    ;    ;(dom/div ":class right"
  ;    ;    ;   (comp/get-initial-state
  ;    ;    ;     ContainerTop
  ;    ;    ;     {(dom/div ":class tuber right-top href-image-container"
  ;    ;    ;         (dom/a ":href \"https://www.youtube.com/\" :target \"__blank\" :rel \"noopener noreferrer"
  ;    ;    ;            (dom/img ":src \"../images/tubes.png\" :alt \"Youtube is my Netflix, sadly")))})
  ;    ;    ;         (comp/get-initial-state
  ;    ;    ;           ContainerMiddle
  ;    ;    ;           {(dom/div ":class sudo-apt-get-gf right-bottom href-image-container"
  ;    ;    ;                     (dom/a ":href \"https://en.wikipedia.org/wiki/Programmer\" :target \"__blank\" :rel \"noopener noreferrer\""
  ;    ;    ;                            (dom/img ":src \"../images/meirl.png\" :alt \"g! 'How to print newline in cljs'" )))}))
  ;    ;    })
  ;    ; }
  ; }
  ;   )}
  ;)}

  ;(dom/div
  ;  "id: " id
  ;  (ui-image-container img1 {:image-container/id 1
  ;                            :image-container/src "example"
  ;                            :image-container/alt "test"}))
  ;(ui-container-body
  ;  (ui-container-left
  ;    (ui-container-top ...)
  ;    (ui-container-bottom ...)
  ;    )
  ;  (ui-container-hoz-middle
  ;    ...)
  ;  (ui-container-right
  ;   (ui-container-top ...)
  ;   (ui-container-bottom ...)
  ;    ...)
  ;  body
  ;)

  ;
  ;(defmutation toggle-item
  ;  [{:keys [item]}]
  ;  (action [{:keys [state]}] (str "wahhhh")))

  ;(def sidebar-state (r/atom {:state "closed"}))
  ;:class (@sidebar-state :state)
  ;(menu-toggle sidebar-state)

  ;(defmutation toggle-value [ignored]
  ;  (action [{:keys [state]}]
  ;    ;(if (= state "on")
  ;    ;  (swap! state update :sidebar/num "off")
  ;    ;  (swap! state update :sidebar/num "on"))
  ;    (swap! state update :sidebar/num inc)))

  ;(defmutation toggle-value [ignored]
  ;             (action [{:keys [state]}]
  ;                     (swap! state update :sidebar/num inc)))
  ;
  ;(defsc SidebarContainer [this {:sidebar/keys [num]}]
  ;  {:query         [:sidebar/num]
  ;   :initial-state {:sidebar/num 0}
  ;   :css           [[:.green {:color "red"
  ;                             :margin "0px"}]]}
  ;    (dom/div
  ;      (dom/button
  ;        {:onClick #(comp/transact! this `[(toggle-value {})])}
  ;        "Times: " num)))
  ;
  ;(def ui-sidebar-container (comp/factory SidebarContainer))

  ;(defsc Root [this {:root/keys [;primary-container
  ;                                sidebar-container
  ;                               ;num
  ;                               ]}
  ;             {:keys [background]}
  ;             ]
  ;  {:query [;{:root/primary-container (comp/get-query PersonList)}
  ;           {:root/sidebar-container (comp/get-query SidebarContainer)}
  ;           ;:root/num
  ;           ]
  ;  :initial-state
  ;          (fn [params]
  ;            {;:root/friends
  ;             ;(comp/get-initial-state PersonList
  ;             ; {:id :friends :label "Friends"})
  ;             :root/sidebar-container
  ;             (comp/get-initial-state SidebarContainer)
  ;             ;:root/num 0
  ;             }
  ;              )
  ;   :css   [[:.background
  ;            {:width "100%"
  ;             :height "100%"
  ;             :color "blue"
  ;             :background-image "url('/images/background.png')"
  ;             :background-color "black"
  ;             :background-position "center"
  ;             :background-attachment "fixed"
  ;             :background-repeat "no-repeat"
  ;             :background-size "cover"}]]}
  ;  (let [{:keys [background]} (css/get-classnames Root)]
  ;    (dom/div :.background {:className [background]}
  ;      (inj/style-element {:component Root})
  ;      ;(ui-primary-container primary-container)
  ;      (ui-sidebar-container sidebar-container)
  ;
  ;      ;  (dom/button {:onClick #(comp/transact! this `[(toggle-value {})])}
  ;
  ;             )))

  ;(defsc Person [this {:person/keys [num]} {:keys [toggle-value]}]
  ;       {:query         [:person/num]
  ;        :initial-state (fn [{:keys [num] :as params}]
  ;                           {:person/num num})}
  ;       (dom/li
  ;         (dom/h5
  ;           (str num " (age: " num ")")
  ;           (dom/button
  ;             {:onClick #(toggle-value num)}
  ;             "X"))))
  ;
  ;(def ui-person (comp/factory Person {:keyfn :person/name}))
  ;
  ;(defsc Root [this {:list/keys [num]}]
  ;       {:query [:list/num (comp/get-query Person)]
  ;        :initial-state
  ;               (fn [{:keys [num]}]
  ;                   {:list/num (comp/get-initial-state Person)})}
  ;       (let [delete-person
  ;             (fn [name]
  ;                 (println label "asked to delete" name))]
  ;            (dom/div
  ;              (dom/h4 num)
  ;              (dom/ul (map
  ;                        (fn [p]
  ;                            (ui-person
  ;                              (comp/computed
  ;                                p {:toggle-value delete-person})))
  ;                        label)))))

  ;(defmutation toggle-value
  ;  [{sidebar-id :sidebar/id}]
  ;  (action [{:keys [state]}]
  ;          (println "State: " state)
  ;          (swap! state update
  ;                 [:sidebar/id sidebar-id :sidebar/num]
  ;                 inc)))
  ;
  ;(defsc SidebarContainer
  ;  [this {:sidebar/keys [num] :as props}]
  ;  {:query         [:sidebar/id :sidebar/num]
  ;   :ident         (fn []
  ;                    [:sidebar/id (:sidebar/id props)])
  ;   :initial-state (fn
  ;                    [{:keys [id] :as params}]
  ;                    {:sidebar/id {id
  ;                      {:sidebar/num 0}}})
  ;   :css           [[:.green {:color "red"
  ;                             :margin "0px"}]]}
  ;  (dom/div
  ;    (println "num " num)
  ;    (dom/button
  ;      {:onClick #(comp/transact! this
  ;                   [(toggle-value {})])}
  ;      "Times: " num)))
  ;
  ;(def ui-sidebar-container
  ;  (comp/factory SidebarContainer))

  ;(defmutation increase
  ;  [{sidebar-id :sidebar/id}]
  ;  (action [{:keys [state]}]
  ;          (println "State: " state)
  ;          (swap! state update
  ;                 [:sidebar/id sidebar-id :sidebar/num]
  ;                 inc)))

  ;(fn
  ;                    [{:keys [id] :as params}]
  ;                    {:sidebar/id {id
  ;                      {:sidebar/num 0}}})



  ;:root/sidebar-container
  ;(comp/get-initial-state SidebarContainer {:list-name "on"})})
  ;vvv
  ;:initial-state (fn [{:keys [list-name] :as params}] {:sidebar/list-name list-name})



  ;;some person stuff
  ;(defmutation delete-person
  ;  ;"Mutation: Delete the person with `name` from the list with `list-name`"
  ;  [{:keys [list-name name]}] ; (1)
  ;  (action [{:keys [state]}] ; (2)
  ;    (let [path     (if (= "Friends" list-name)
  ;                     [:friends :list/people]
  ;                     [:enemies :list/people])
  ;          old-list (get-in @state path)
  ;          new-list (vec (filter #(not= (:person/name %) name) old-list))]
  ;      (swap! state assoc-in path new-list))))
  ;
  ;(defsc Person [this {:person/keys [name age] :as props} {:keys [onDelete]}]
  ;  {:query         [:person/id :person/name :person/age] ; (2)
  ;   :ident         (fn [] [:person/id (:person/id props)]) ; (1)
  ;   :initial-state (fn [{:keys [id name age] :as params}]
  ;                    {:person/id id :person/name name :person/age age})} ; (3)
  ;  ;(dom/li
  ;  ;  (dom/h5
  ;      ;(str name " (age: " age ")")
  ;      ;(dom/button {:onClick #(onDelete name)} "X")
  ;      ;)
  ;    ;)
  ;  )

  ;(def ui-person (comp/factory Person {:keyfn :person/id}))
  ;
  ;(defsc PersonList [this {:list/keys [id label people] :as props}]
  ;  {:query [:list/id :list/label {:list/people (comp/get-query Person)}]
  ;   :ident (fn [] [:list/id (:list/id props)])
  ;   :initial-state
  ;          (fn [{:keys [id label]}]
  ;            {:list/id     id
  ;             :list/label  label
  ;             :list/people (if (= id :friends)
  ;                            [(comp/get-initial-state Person {:id 1 :name "Sally" :age 32})
  ;                             (comp/get-initial-state Person {:id 2 :name "Joe" :age 22})]
  ;                            [(comp/get-initial-state Person {:id 3 :name "Fred" :age 11})
  ;                             (comp/get-initial-state Person {:id 4 :name "Bobby" :age 55})])})}
  ;  (let [delete-person
  ;        (fn [item-id]
  ;          (comp/transact! this
  ;            [(delete-person {:list id :item item-id})]))]
  ;    ;(dom/div (dom/h4 label)
  ;    ;  (dom/ul (map #(ui-person
  ;    ;                  (comp/computed %
  ;    ;                    {:onDelete delete-person})) people)))
  ;    ))
  ;
  ;(def ui-person-list (comp/factory PersonList))
  ;
  ;;; OPTION 1: 4th arg destructing (requires adding props middleware)
  ;(defsc PageContainer [this props computed {:keys [green]}]
  ;  {:query [:text]
  ;   :initial-state (fn [{:keys [text] :as params}] {:text text})
  ;   :css   [[:.green {:color "green"}]]}
  ;
  ;  ; OPTION 2: Destructure them explicitly
  ;  (let [{:keys [green]} (css/get-classnames PageContainer)]
  ;    ; OPTION 3:
  ;    ; Use `localized-dom` keyword classes instead of `dom` for elements
  ;    ;(dom/div :.green
  ;    ;  (dom/li                                          ;{:classes [green]}
  ;    ;    "bahhh"))
  ;    ))
  ;
  ;(def ui-test-element (comp/factory PageContainer))
  ;
  ;(defsc Root [this {:root/keys [test-element friends enemies]} {:keys [background]}]
  ;  {:query [{:root/test-element (comp/get-query PageContainer)}
  ;           {:root/friends (comp/get-query PersonList)}
  ;           {:root/enemies (comp/get-query PersonList)}]
  ;   :initial-state
  ;          (fn [params]
  ;            {:root/test-element
  ;             (comp/get-initial-state PageContainer)
  ;             :root/friends
  ;             (comp/get-initial-state PersonList
  ;               {:id :friends :label "Friends"})
  ;             :root/enemies
  ;             (comp/get-initial-state PersonList
  ;               {:id :enemies :label "Enemies"})})
  ;   :css   [[:.background
  ;            {:width "100%"
  ;             :height "100%"
  ;             :background-image "url('images/background.png')"
  ;             :background-position "center"
  ;             :background-attachment "fixed"
  ;             :background-repeat "no-repeat"
  ;             :background-size "cover"}]]}
  ;  (let [{:keys [background]} (css/get-classnames Root)]
  ;    ;(dom/div :.background
  ;    ;  (inj/style-element {:component Root})
  ;    ;  (ui-test-element test-element)
  ;    ;  ;(ui-primary-container primary-container)
  ;    ;  ;(ui-sidebar-container sidebar-container)
  ;    ;  (ui-person-list friends)
  ;    ;  (ui-person-list enemies)
  ;    ;  )
  ;    ))