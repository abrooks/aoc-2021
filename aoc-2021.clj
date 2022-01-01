;; gorilla-repl.fileformat = 1

;; **
;;; # Advent of Code 2021
;;; 
;;; Wherein we wrestle a Gorilla (repl) and try to make some code.
;; **

;; @@
(ns aoc-2021)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; **
;;; ## Day 1
;;; 
;;; 
;; **

;; @@
(def d1-ex
  [199
   200
   208
   210
   200
   207
   240
   269
   260
   263])
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;aoc-2021/d1-ex</span>","value":"#'aoc-2021/d1-ex"}
;; <=

;; @@
(->> d1-ex
  (partition 2 1)
  (map #(apply < %))
  (filter identity)
  count)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>7</span>","value":"7"}
;; <=
