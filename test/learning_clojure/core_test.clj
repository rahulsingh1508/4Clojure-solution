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

(t/deftest Black-box-testing
  (t/is (= (lct/Black-box-testing {:a 1, :b 2})
           :map))
  (t/is (= (lct/Black-box-testing (range (rand-int 20)))
           :list))
  (t/is (= (lct/Black-box-testing [1 2 3 4 5 6])
           :vector))
  (t/is (= (lct/Black-box-testing #{10 (rand-int 5)})
           :set))
  (t/is (= (lct/Black-box-testing [{} #{} [] '()])
           [:map :set :vector :list])))

(t/deftest reverse-number
  (t/is (= (lct/reverse-number 123456)
           654321))
  (t/is (= (lct/reverse-number 3215)
           5123)))

(t/deftest nil-key
  (t/is (= (lct/nil-key :a {:a nil :b 2})
           true))
  (t/is (= (lct/nil-key :b {:a nil :b 2})
           false))
  (t/is (= (lct/nil-key :c {:a nil :b 2})
           false)))

(t/deftest map-defaults
  (t/is (= (lct/map-defaults 0 [:a :b :c])
           {:a 0 :b 0 :c 0}))
  (t/is (= (lct/map-defaults "x" [1 2 3])
           {1 "x" 2 "x" 3 "x"}))
  (t/is (= (lct/map-defaults [:a :b] [:foo :bar])
           {:foo [:a :b] :bar [:a :b]})))
(t/deftest greatest-common-divisor
  (t/is (= (lct/greatest-common-divisor 2 4)
            2))
  (t/is (= (lct/greatest-common-divisor 10 5)
           5))
  (t/is (= (lct/greatest-common-divisor 5 7)
           1))
  (t/is (= (lct/greatest-common-divisor 1023 858)
           33)))
