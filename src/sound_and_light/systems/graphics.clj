;; Graphics and drawing systems
(ns sound-and-light.systems.graphics
  (:require [sound-and-light.systems.core :refer [PSystem]])
  (:import [org.lwjgl.opengl Display DisplayMode]
           [org.lwjgl LWJGLException]))

(defrecord RenderSystem []
    PSystem
  (components [_] #{:position})

  (setup [_]
    (try
      (Display/setDisplayMode (DisplayMode. 800 600))
      (Display/create)
      (catch LWJGLException e
        (println e))))

  (run [_ entities]
    (when (Display/isCloseRequested)
      (Display/destroy))

    ;; Render code goes here

    (Display/update))
)

(defn get-render-system
  []
  (RenderSystem.))