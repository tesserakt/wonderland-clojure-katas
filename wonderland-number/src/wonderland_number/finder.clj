(ns wonderland-number.finder)

(defn myhasAllTheSameDigits? [n1 n2]
  (let [s1 (set (str n1))
        s2 (set (str n2))]
    (= s1 s2)))

(defn my-checker [wondernum]
      (and
        (= 6 (count (str wondernum)))
        (myhasAllTheSameDigits? wondernum (* 2 wondernum))
        (myhasAllTheSameDigits? wondernum (* 3 wondernum))
        (myhasAllTheSameDigits? wondernum (* 4 wondernum))
        (myhasAllTheSameDigits? wondernum (* 5 wondernum))
        (myhasAllTheSameDigits? wondernum (* 6 wondernum))
      )
  )

(defn find-first
         [f coll]
         (first (filter f coll)))

;;142879
(defn wonderland-number []
  (find-first
     #(
       my-checker %1
      )
     (range 100000 200000)
    )
  )
