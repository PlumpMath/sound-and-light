;; Graphics and drawing systems
(ns sound-and-light.systems.graphics
  (:require [sound-and-light.systems.core :refer [PSystem]])
  (:import [org.lwjgl.opengl Display DisplayMode GL11]
           [org.lwjgl LWJGLException]))

(defn get-key-mouse-events
  []

)

(defrecord RenderSystem []
    PSystem
  (components [_] #{:position})

  (setup [_]
    (try
      (Display/setDisplayMode (DisplayMode. 800 600))
      (Display/create)
      (catch LWJGLException e
        (println e)
        (System/exit 0)
        ))
      (GL11/glMatrixMode GL11/GL_PROJECTION)
      (GL11/glLoadIdentity)
      (GL11/glOrtho 0 800 0 600 1 -1)
      (GL11/glMatrixMode  GL11/GL_MODELVIEW)
    )

  (run [_ entities]
    (when (Display/isCloseRequested)
      (Display/destroy))

    ;; Render code goes here
    (GL11/glClear
     (bit-or GL11/GL_COLOR_BUFFER_BIT
             GL11/GL_DEPTH_BUFFER_BIT))

    (GL11/glColor3f (float 0.5) (float 0.5) (float 1.0))

    (GL11/glBegin GL11/GL_QUADS)
    (GL11/glVertex2f 100 100)
    (GL11/glVertex2f (+ 100 200) 100)
    (GL11/glVertex2f (+ 100 200) (+ 100 200))
    (GL11/glVertex2f 100 (+ 100 200))
    (GL11/glEnd)

    ;; Getting keyboard events is also done here because of lwjgl

    (Display/update)
)
)

(defn get-render-system
  []
  (RenderSystem.))