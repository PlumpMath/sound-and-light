;; Graphics Functions, called by systems.
(ns sound-and-light.graphics
  (:import [org.lwjgl.opengl Display DisplayMode GL11]
           [org.lwjgl LWJGLException]))

;; TODO: make size configurable?
(defn setup-graphics
  "Sets up the initial opengl context"
  []
  (try
    (Display/setDisplayMode (DisplayMode. 800 600))
    (Display/create)
    (catch LWJGLException e
      (println e)
      (System/exit 0)
      ))

  ;; Sets up the identity for a quad, this must be done differently!
  ;; TODO
  (GL11/glMatrixMode GL11/GL_PROJECTION)
  (GL11/glLoadIdentity)
  (GL11/glOrtho 0 800 0 600 1 -1)
  (GL11/glMatrixMode  GL11/GL_MODELVIEW))

(defn render-tick []
  (when (Display/isCloseRequested)
    (Display/destroy))

  ;; Drawing a quad, don't know how this works
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

  (Display/update))