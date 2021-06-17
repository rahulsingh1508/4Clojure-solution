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

;;Write a function which returns the first X fibonacci numbers.

(fn Fibonacci-seqs
  [n]
  (letfn [fibonacci [a b]
          (lazy-seq 
           (cons (+ a b) (fibonacci b (+ a b))))]
    (take n (cons 1 (fibonacci 0 1)))))
;; Error : - Don't know how to create ISeq from: clojure.lang.Symbol
