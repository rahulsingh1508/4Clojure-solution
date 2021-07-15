(ns learning-clojure.core-test
  (:require [clojure.test :as t]
            [learning-clojure.core :as lct]))

(t/deftest Reverse-Interleave
  (t/is (= '((1 3 5) (2 4 6)) (lct/Reverse-Interleave [1 2 3 4 5 6] 2)))
  (t/is (=  '((0 3 6) (1 4 7) (2 5 8)) (lct/Reverse-Interleave (range 9) 3)))
  (t/is (= '((0 5) (1 6) (2 7) (3 8) (4 9)) (lct/Reverse-Interleave (range 10) 5))))

(t/deftest Intersection-set
  (t/is (=  #{2 3} (lct/Intersection-set #{0 1 2 3} #{2 3 4 5})))
  (t/is (= #{} (lct/Intersection-set #{0 1 2} #{3 4 5})))
  (t/is (=  #{:a :c :d} (lct/Intersection-set #{:a :b :c :d} #{:c :e :a :f :d}))))

(t/deftest sequence-of-list
  (t/is (=  '((0 1 2) (3 4 5) (6 7 8)) (lct/sequence-of-list 3 (range 9))))
  (t/is (=  '((0 1) (2 3) (4 5) (6 7)) (lct/sequence-of-list 2 (range 8))))
  (t/is (= '((0 1 2) (3 4 5)) (lct/sequence-of-list 3 (range 8)))))

(t/deftest Duplicate-a-sequence
  (t/is (=  '(1 1 2 2 3 3) (lct/Duplicate-a-sequence [1 2 3])))
  (t/is (= '(:a :a :a :a :b :b :b :b) (lct/Duplicate-a-sequence [:a :a :b :b])))
  (t/is (= '([1 2] [1 2] [3 4] [3 4]) (lct/Duplicate-a-sequence [[1 2] [3 4]])))
  (t/is (= '([1 2] [1 2] [3 4] [3 4]) (lct/Duplicate-a-sequence [[1 2] [3 4]]))))

(t/deftest Black-box-testing
  (t/is (= :map (lct/Black-box-testing {:a 1, :b 2})))
  (t/is (= :list (lct/Black-box-testing (range (rand-int 20)))))
  (t/is (= :vector (lct/Black-box-testing [1 2 3 4 5 6])))
  (t/is (= :set (lct/Black-box-testing #{10 (rand-int 5)}))))

(t/deftest reverse-number
  (t/is (= 654321(lct/reverse-number 123456 0)))
  (t/is (= 5123 (lct/reverse-number 3215 0))))

(t/deftest nil-key
  (t/is (= true (lct/nil-key :a {:a nil :b 2})))
  (t/is (= false (lct/nil-key :b {:a nil :b 2})))
  (t/is (= false (lct/nil-key :c {:a nil :b 2}))))

(t/deftest greatest-common-divisor
  (t/is (= 2 (lct/greatest-common-divisor 2 4)))
  (t/is (= 5 (lct/greatest-common-divisor 10 5)))
  (t/is (= 1 (lct/greatest-common-divisor 5 7)))
  (t/is (= 33 (lct/greatest-common-divisor 1023 858))))


(t/deftest perfect-number
  (t/is (= true (lct/perfect-number 6)))
  (t/is (= false (lct/perfect-number 7)))
  (t/is (= true (lct/perfect-number 496)))
  (t/is (= false (lct/perfect-number 500)))
  (t/is (= true (lct/perfect-number 8128))))


(t/deftest capital-letters
  (t/is (= "HE" (lct/capital-letters "HEllo")))
  (t/is (= "HLOWRD" (lct/capital-letters "HeLlO, WoRlD!")))
  (t/is (= "" (lct/capital-letters "nothing")))
  (t/is (= "AZ" (lct/capital-letters "$#A*&987Zf"))))

(t/deftest remove-duplicates
  (t/is (= "Leroy" (lct/remove-duplicates "Leeeeeerrroyyy")))
  (t/is (= '(1 2 3 2 3) (lct/remove-duplicates [1 1 2 3 3 2 2 3])))
  (t/is (= '([1 2] [3 4] [1 2]) (lct/remove-duplicates [[1 2] [1 2] [3 4] [1 2]]))))

(t/deftest fibonacci-number
  (t/is (=  '(1 1 2) (lct/fibonacci-number 3)))
  (t/is (=  '(1 1 2 3 5 8) (lct/fibonacci-number 6)))
  (t/is (= '(1 1 2 3 5 8 13 21) (lct/fibonacci-number 8))))

(t/deftest palindrome-check
  (t/is (= false (lct/palindrome-check '(1 2 3 4 5))))
  (t/is (= true (lct/palindrome-check "racecar")))
  (t/is (= true (lct/palindrome-check '(1 1 3 3 1 1))))
  (t/is (= false (lct/palindrome-check '(:a :b :c))))
  (t/is (= true (lct/palindrome-check [:foo :bar :foo]))))


(t/deftest implement-range
  (t/is (= '(1 2 3)(lct/implement-range 1 4)))
  (t/is (=  '(-2 -1 0 1) (lct/implement-range -2 2)))
  (t/is (=  '(5 6 7) (lct/implement-range 5 8))))

(t/deftest factorial-of-number
  (t/is (= 1 (lct/factorial-of-number 1)))
  (t/is (= 6 (lct/factorial-of-number 3)))
  (t/is (= 120 (lct/factorial-of-number 5)))
  (t/is (= 40320 (lct/factorial-of-number 8))))

(t/deftest reverse-interleave
  (t/is (= '((1 3 5) (2 4 6)) (lct/reverse-interleave [1 2 3 4 5 6] 2)))
  (t/is (= '((0 3 6) (1 4 7) (2 5 8)) (lct/reverse-interleave (range 9) 3)))
  (t/is (= '((0 5) (1 6) (2 7) (3 8) (4 9)) (lct/reverse-interleave (range 10) 5))))

(t/deftest rotate-seq
  (t/is (= '(3 4 5 1 2) (lct/rotate-seq 2 [1 2 3 4 5])))
  (t/is (= '(4 5 1 2 3) (lct/rotate-seq -2 [1 2 3 4 5])))
  (t/is (= '(2 3 4 5 1) (lct/rotate-seq 6 [1 2 3 4 5])))
  (t/is (= '(:b :c :a) (lct/rotate-seq 1 '(:a :b :c))))
  (t/is (= '(:c :a :b) (lct/rotate-seq -4 '(:a :b :c)))))

(t/deftest flips-orders
  (t/is (= 3 ((lct/flips-orders nth) 2 [1 2 3 4 5])))
  (t/is (= true ((lct/flips-orders >) 7 8)))
  (t/is (= 4 ((lct/flips-orders quot) 2 8)))
  (t/is (= [1 2 3] ((lct/flips-orders take) [1 2 3 4 5] 3))))
