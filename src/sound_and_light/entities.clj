;; Entities methods
(ns sound-and-light.entities
  (:require [clojure.set :as s]))

(defn get-types
  "gets all the types of the components"
  [components]
  (set (map :type components)))

(defn get-with-components
  [entity-map components]
  (->> (filter
        (fn [[k comps]]
          (s/subset? (get-types comps) components))
        entity-map)
       (into {})))

(defn change-entities
  "replaces the changed entities"
  [entity-map new-entities]
  (merge entity-map new-entities))