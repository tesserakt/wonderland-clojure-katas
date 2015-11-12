(ns alphabet-cipher.coder)

(defn char-range-for-letter [letter]
  (concat
   (map char (range (int letter) 123))
   (map char (range 97 (int letter)))
   )
  )

(defn letter-to-vector-pos [letter]
  (- (int letter) 97)
  )

(defn a-to-z-vector []
  (map char (range 97 123))
  )

(defn hash-of-a-to-z-vectors []
  (reduce #(assoc %1 %2 (char-range-for-letter %2)) {} (a-to-z-vector))
  )

(defn encode [encrypt-key message]
  (let [letter-hash-of-arrays (hash-of-a-to-z-vectors)]
    (apply str
           (map
            #(nth  (get letter-hash-of-arrays %2) (letter-to-vector-pos %1))
            message
            (cycle encrypt-key))
           )
    )
  )

(defn decode [encrypt-key message]
  (let [letter-hash-of-arrays (hash-of-a-to-z-vectors)]
    (apply str
           (map
              #(ffirst
                 (filter
                          (fn [[k v]]    (=
                                            %1 ;; e
                                            (nth v (letter-to-vector-pos %2)) ;; [m [mnopqrs]]
                                           )
                          )
                          letter-hash-of-arrays
                 )
              )
              message
             (cycle encrypt-key)
            )
    )
   )
  )

(defn decipher [cipher message]
  "decypherme")

