;;------------------------------------------------------------------------------
;; Components
(ns sound-and-light.components)

(defn position
  [x y z]
  {:x x :y y :z z :type :position})

(defn keyboard-mouse
  [left-click right-click])