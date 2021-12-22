(ns subhram.core
  (:gen-class)
  (:require [seesaw.core :as seesaw])
  (:require [seesaw.chooser])
  ;; (:use seesaw.core)
  )

(def button
      (seesaw/button
         :text "Click Me"
        ;;  :listen [:action (fn [event](seesaw/alert "Click!" ))]
         :listen [:action (fn [event]
            (let [chosenFile (seesaw.chooser/choose-file :multi? true :selection-mode :files-and-dirs)]
              (println "Files chosen:" chosenFile))
            ;; (seesaw.chooser/choose-file)
            )]
         ))

(def lb (seesaw/scrollable (seesaw/listbox :model (-> 'seesaw.core ns-publics keys sort))))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, Worldzzzz!")
  (seesaw/invoke-later
    (-> (seesaw/frame :title "Subhram",
          ;;  :content "Hello, Seesaw",
           :content button,
           :on-close :exit)
     seesaw/pack!
     seesaw/show!)))
