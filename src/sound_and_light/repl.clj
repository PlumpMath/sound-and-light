;; Namespace for loading and running and switching things from the repl
(ns sound-and-light.repl
  (:require [sound-and-light.core :as core]))

;; Would like a way to reload systems on the fly
;; without changing anything else.

(def main-loop (atom nil))

(defn start-main-loop
  "Restarts the main loop using the current value.
   I think this might work but could use tweaking"
  []
  (reset! main-loop (future core/main)))