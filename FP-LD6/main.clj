;; Uzd1 Palindrome detector
(defn uzd1 ([x] (= (reverse (seq x)) (seq x))))
(false? (uzd1 '(1 2 3 4 5)))
(true? (uzd1 "racecar"))
(true? (uzd1 [:foo :bar :foo]))
(true? (uzd1 '(1 1 3 3 1 1)))
(false? (uzd1 '(:a :b :c)))

;; Uzd2 Maximum value
(defn uzd2 ([& x] (first (sort > x))))
(= (uzd2 1 8 3 4) 8)
(= (uzd2 30 20) 30)
(= (uzd2 45 67 11) 67)