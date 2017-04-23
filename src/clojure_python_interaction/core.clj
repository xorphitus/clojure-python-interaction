(ns clojure-python-interaction.core
  (:import (java.util Properties)
           (org.python.util PythonInterpreter)))

(defn main []
  (let [props (new Properties)]
    (do
      (.put props "python.console.encoding" "UTF-8")
      (PythonInterpreter/initialize (System/getProperties) props (make-array String 0))
      (let [interp (new PythonInterpreter)]
        (.exec interp "print(1234)")))))
