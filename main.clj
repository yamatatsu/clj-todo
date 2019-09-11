(defn choice-next []
  (println "What? (list:'l', add:'a', done:'d', exie: 'e')")
  (case (read-line)
    "l" "List"
    "a" "Add"
    "d" "Done"
    "e" "Exit"
    ))

(defn add []
  (print "Input your new task:")
  (read-line))

(defn recursive [word state]
  (println word)
  (let [input (read-line)]
    (case (get state "type")
      "ChoiceNext" (recursive { "type" (choice-next) })
      "List" (recursive {
        "type" "ChoiceNext"
        "tasks" (get state "tasks")})
      "Add" (recursive {
        "type" "ChoiceNext"
        "tasks" [(add)]})
      "Done" (println "done")
      "Exit" (println "exit"))))


(recursive "This is clj-todo!" false {"type" "ChoiceNext"})
