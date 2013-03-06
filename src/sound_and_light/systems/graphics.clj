;; Graphics and drawing systems
(ns sound-and-light.systems.graphics
  (:require [sound-and-light.systems :refer [PSystem]]
            [sound-and-light.graphics :as graphics]))

(defn get-key-mouse-events
  []

)

(defrecord RenderSystem []
    PSystem
  (components [_] #{:position})

  (setup [_]
    (graphics/setup-graphics)
    )

  (run [_ entities]
    (graphics/render-tick))
)

(defn get-render-system
  []
  (RenderSystem.))