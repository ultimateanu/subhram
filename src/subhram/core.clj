(ns subhram.core
  (:gen-class)
  (:require [seesaw.core :as seesaw])
  (:require [seesaw.chooser]))

(def selectButton
  (seesaw/button
   :text "Select"
   :listen [:action (fn [event]
                      (let [chosenFile (seesaw.chooser/choose-file
                                        :multi? true
                                        :selection-mode :files-and-dirs)]
                        (println "Files chosen:" chosenFile)
                        (println "Type chosen:" (type chosenFile))))]))

(def lb (seesaw/scrollable (seesaw/listbox :model (-> 'seesaw.core ns-publics keys sort))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, Worldzzzz!")
  (seesaw/invoke-later
   (-> (seesaw/frame :title "Subhram",
                     :content selectButton,
                     :on-close :exit)
       seesaw/pack!
       seesaw/show!)))
