(ns subhram.core
  (:gen-class)
  (:require [seesaw.core :as seesaw])
  ;; (:use seesaw.core)
  )

(def button
      (seesaw/button
         :text "Click Me"
         :listen [:action (fn [event](seesaw/alert "Click!" ))]))

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
