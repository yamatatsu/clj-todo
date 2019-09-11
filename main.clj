(defn get-type [abbreviation]
  (case abbreviation
    "l" "List"
    "a" "Add"
    "d" "Done"
    "e" "Exit"
    ))

(defn format-for-render [arr]
  (clojure.string/join "\n" (concat [""] arr)))

(defn recurse [tasks]
  (println "\nWhat? (list:'l', add:'a', done:'d', exie: 'e')")
  (case (get-type (read-line))
    "List" (do
      (println (format-for-render tasks))
      (recurse tasks))
    "Add" (do
      (println "\nInput your new task:")
      (recurse (conj tasks (read-line))))
    "Done" (do
      (println (str (format-for-render tasks) "\nSelect done task:"))
      (recurse (disj tasks (read-line))))
    "Exit" (println "\nBye!")))

(recurse #{})
