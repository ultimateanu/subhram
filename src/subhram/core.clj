(ns subhram.core
  (:gen-class)
  (:require [cljfx.api :as fx])
  (:import [javafx.application Platform]))

(defn hello-world [& args]
  {:fx/type :label
   :text "Hello, World!"})

(defn root [& args]
  {:fx/type :stage
   :showing true
   :title "Subhram"
   :scene {:fx/type :scene
           :root {:fx/type :v-box
                  :padding 250
                  :spacing 40
                  :children [{:fx/type hello-world}]}}})

(def renderer
  (fx/create-renderer))

(defn -main [& args]
  (Platform/setImplicitExit true)
  (renderer {:fx/type root}))
