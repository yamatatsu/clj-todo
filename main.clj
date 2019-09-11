(defn get-type [abbreviation]
  (case abbreviation
    "l" "List"
    "a" "Add"
    "d" "Done"
    "e" "Exit"
    ))

(defn format-tasks [tasks & more]
  (clojure.string/join
    "\n"
    (flatten [
      ""
      (vec tasks)
      more])))

(defn recurse [tasks]
  (println "\nWhat? (list:'l', add:'a', done:'d', exie: 'e')")
  (case (get-type (read-line))
    "List" (do
      (println (format-tasks tasks))
      (recurse tasks))
    "Add" (do
      (println "\nInput your new task:")
      (recurse (conj tasks (read-line))))
    "Done" (do
      (println (format-tasks tasks "Select done task:"))
      (recurse (disj tasks (read-line))))
    "Exit" (println "\nBye!")))

(recurse #{})
