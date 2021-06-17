(ns learning-clojure.core-test
  (:require [clojure.test :as t]
            [learning-clojure.core :as lct]))

(t/deftest Reverse-Interleave
  (t/is (= (lct/Reverse-Interleave [1 2 3 4 5 6] 2)
           '((1 3 5) (2 4 6))))
  (t/is (= (lct/Reverse-Interleave (range 9) 3)
           '((0 3 6) (1 4 7) (2 5 8))))
  (t/is (= (lct/Reverse-Interleave (range 10) 5)
           '((0 5) (1 6) (2 7) (3 8) (4 9)))))

(t/deftest Intersection-set
  (t/is (= (lct/Intersection-set #{0 1 2 3} #{2 3 4 5})
           #{2 3}))
  (t/is (= (lct/Intersection-set #{0 1 2} #{3 4 5})
           #{}))
  (t/is (= (lct/Intersection-set #{:a :b :c :d} #{:c :e :a :f :d})
           #{:a :c :d})))

(t/deftest sequence-of-list
  (t/is (= (lct/sequence-of-list 3 (range 9))
            '((0 1 2) (3 4 5) (6 7 8))))
  (t/is (= (lct/sequence-of-list 2 (range 8))
            '((0 1) (2 3) (4 5) (6 7))))
  (t/is (= (lct/sequence-of-list 3 (range 8))
           '((0 1 2) (3 4 5)))))

(t/deftest Duplicate-a-sequence
  (t/is (= (lct/Duplicate-a-sequence [1 2 3])
           '(1 1 2 2 3 3)))
  (t/is (= (lct/Duplicate-a-sequence [:a :a :b :b])
           '(:a :a :a :a :b :b :b :b)))
  (t/is (= (lct/Duplicate-a-sequence [[1 2] [3 4]])
           '([1 2] [1 2] [3 4] [3 4])))
  (t/is (= (lct/Duplicate-a-sequence [[1 2] [3 4]])
           '([1 2] [1 2] [3 4] [3 4]))))
