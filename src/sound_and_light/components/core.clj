;; Components
(ns sound-and-light.components.core)

(defn position
  [x y z]
  {:x x :y y :z z :type :position})

(defn keyboard-mouse
  [left-click right-click])