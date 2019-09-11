(defn render [type tasks]
  (case type
    "List" tasks
    "Add" ["Input your new task:"]
    "Done" (conj tasks "Select done task:")
    "Exit" ["Bye"]))

(defn choice-next []
  (println "What? (list:'l', add:'a', done:'d', exie: 'e')")
  (case (read-line)
    "l" "List"
    "a" "Add"
    "d" "Done"
    "e" "Exit"
    ))

(defn recurse [tasks]
  (let [type (choice-next)]
    (doseq [word (render type tasks)] (println word))
    (case type
      "List" (recurse tasks)
      "Add" (recurse (conj tasks (read-line)))
      "Done" (recurse (disj tasks (read-line)))
      "Exit")))

(recurse #{})
