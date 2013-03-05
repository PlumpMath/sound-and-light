(ns sound-and-light.core
  (:require [sound-and-light.systems.core :as sys]
            [sound-and-light.systems.graphics :as graphics]
            [sound-and-light.components.core :as components]
            [sound-and-light.entities :as ent])
  (:gen-class))

(defn get-systems
  "Gets an array of all the systems"
  []
  [
   (graphics/get-render-system)
   ])

(defn setup-starting-entities
  "Sets up the entities to start the game."
  []
  {:1 [(components/position 0 0 0)]})

(defn main []
  "Game entry point"
  []
  (let [entities (atom (setup-starting-entities))
        systems (get-systems)]

    ;; Setup systems
    (doseq [s systems]
      (sys/setup s))

    ;; Event loop
    (loop []
        (doseq [s systems]
          (let [needed-components (sys/components s)
                needed-entities
                (ent/get-with-components @entities needed-components)
                changed-entities (sys/run s needed-entities)]
            (swap! entities ent/change-entities changed-entities)))
      (recur))))
