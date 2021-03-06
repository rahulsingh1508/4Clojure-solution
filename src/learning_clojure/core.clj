(ns learning-clojure.core
  (:gen-class))

;;Write a function which reverses the interleave process into x number of subsequences

(defn Reverse-Interleave
  "Reverse the interleave process into x number of subsequences"
  [coll n]
  (for [i (range n)]
    (take-nth n (drop i coll))))

;;Write a function which returns the intersection of two sets. The intersection is the sub-set of items that each set has in common.

(defn Intersection-set
  "Give intersection of two sets"
  [set1 set2]
  (set (filter #(contains? set2 %) set1)))

;;;;Write a function which returns a sequence of lists of x items each.
;; Lists of less than x items should not be returned.

(defn sequence-of-list
  "Returns a sequence of lists of x items"
  [n coll]
  (when (>= (count coll) n)
    (cons (take n coll) (sequence-of-list n (nthnext coll n)))))

;; Count Occurrences
;;Write a function which returns a map containing the number of occurences of each distinct item in a sequence.

(defn map-frequencies
  [coll]
  (reduce (fn [m i]
            (assoc m
                   i (inc (m i 0))))
          {}
          coll))

;;Write a function which duplicates each element of a sequence.

(defn Duplicate-a-sequence
  [coll]
  (sort (take (* 2 (count coll))(cycle coll))))


;;Write a function which takes a collection and returns one of :map, :set, :list, or :vector - describing the type of collection it was given.
;;You won't be allowed to inspect their class or use the built-in predicates like list? - the point is to poke at them and understand their behavior.

(defn Black-box-testing [coll]
  (cond
    (= (get (conj coll [:t "t"]) :t) "t") :map
    (= (get (conj coll :t) :t) :t) :set
    (= (first (conj coll :b)) :b) :list
    (= (last (conj coll :b)) :b) :vector))

;;Transform a sequence into a sequence of pairs containing the original elements along with their index.

(defn indexing-sequence
  [coll]
  (map-indexed
   (fn [v i] (vector i v))
   coll))

;;reverse a number

(defn reverse-number
  [number reversed]
   (if (= number 0)
     reversed
     (reverse-number(quot number 10) 
                    (+ (rem number 10) (* reversed 10)))))

;;Write a function which, given a key and map, returns true iff the map contains an entry with that key and its value is nil.

(defn nil-key
  [k m]
  (if (contains? m k)
    (= (k m) nil)
    false))

;;When retrieving values from a map, you can specify default values in case the key is not found:

;;(= 2 (:foo {:bar 0, :baz 1} 2))

;;However, what if you want the map itself to contain the default values? Write a function which takes a default value and a sequence of keys and constructs a map.

(defn map-defaults
  [n seq]
  (apply hash-map
         (interleave seq
                     (repeat n))))

;;Given two integers, write a function which returns the greatest common divisor.

(defn greatest-common-divisor
  [a b]
  (if ( zero? b)
    a
    (recur b (mod a b))))

;;Problem 80
;;A number is "perfect" if the sum of its divisors equal
;;the number itself. 6 is a perfect number because 1+2+3=6. Write a
;;function which returns true for perfect numbers and false otherwise.

(defn perfect-number
  [n]
  (= n (reduce +
               (filter
                #(zero? (mod n %))
                (range 1 n)))))

;;Problem 29
;;Write a function which takes a string and returns a new string containing only the capital letters.

(defn capital-letters
  [s]
  (apply str (re-seq #"[A-Z]+" s)))

;;Problem 30
;;Write a function which removes consecutive duplicates from a sequence.

(defn remove-duplicates
  [s]
  (map first (partition-by identity s)))



(defn last-element
  [coll]
  (drop (dec (count coll)) coll))


;;Problem 26
;;Write a function which returns the first X fibonacci numbers.

(defn fibonacci-number
  [n]
  (take n (map first (iterate (fn [[a b]]
                                 [b (+ a b)])[1 1]) )))

;;Problem 27
;;Write a function which returns true if the given sequence is a palindrome. Hint: "racecar" does not equal '(\r \a \c \e \c \a \r)

(defn palindrome-check
  [coll]
   (#(= (seq coll) (reverse (seq coll)))))



;;Problem 32
;;Write a function which duplicates each element of a sequence.

(defn duplicate-seq
  [coll]
  ((take (* (count coll) 2)(cycle coll))))


;;Problem 33
;;Write a function which replicates each element of a sequence a variable number of times.

(defn replicate-seq
  [seq n]
  (mapcat #(repeat n %) seq))


;;Range-implemntation

(defn implement-range
  [s l]
  (take (- l s) (iterate inc s)))


;;


(defn square-number
  [n]
  (* n n))

(defn square-numbers
  [coll]
  (map square-number coll))


;;Problem 42
;;Write a function which calculates factorials.

(defn factorial-of-number
  [n]
  (if (<= n 1) 
    n
    (* n (factorial-of-number (dec n)))))


;;Problem 43
;;Write a function which reverses the interleave process into x number of subsequences

(defn reverse-interleave
  [coll n]
  (for [i (range n)]
    (take-nth n (drop i coll))))


;;Problem 44
;;Write a function which can rotate a sequence in either direction

(defn rotate-seq
  [n coll]
  (take (count coll) (drop (mod n (count coll)) (cycle coll))))


;;Problem 46
;;Write a higher-order function which flips the order of the arguments of an input function.

(defn flips-orders
  [f]
  (fn [& args]
    (apply f (reverse args))))





