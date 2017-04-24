(ns clojure-python-interaction.core
  (:import (java.util Properties)
           (org.python.util PythonInterpreter)))

(defn -main []
  (let [props (new Properties)]
    (do
      (.put props "python.console.encoding" "UTF-8")
      (PythonInterpreter/initialize (System/getProperties) props (make-array String 0))
      (let [interp (new PythonInterpreter)]
        (.exec interp "import csv")
        (.exec interp "from sklearn.naive_bayes import MultinomialNB")
        (.exec interp "from sklearn.feature_extraction.text import CountVectorizer")
        (.exec interp "vectorizer = CountVectorizer(stop_words=[])")))))
