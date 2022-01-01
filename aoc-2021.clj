;; gorilla-repl.fileformat = 1

;; **
;;; # Advent of Code 2021
;;; 
;;; Wherein we wrestle a Gorilla (repl) and try to make some code.
;; **

;; @@
(ns aoc-2021
  (:require [clojure.string :as s]
            [clojure.java.io :as io]))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; **
;;; ## Day 1
;;; 
;;; 
;; **

;; **
;;; First, let's try the example input
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

;; **
;;; Create a function that grabs subsequent pairs, compares them, finds those that are true (where they are increasing) and counts them.
;; **

;; @@
(defn d1a [x]
 (->> x
   (partition 2 1)
   (map #(apply < %))
   (filter identity)
   count))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;aoc-2021/d1a</span>","value":"#'aoc-2021/d1a"}
;; <=

;; **
;;; This output matches the expected output:
;; **

;; @@
(d1a d1-ex)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>7</span>","value":"7"}
;; <=

;; **
;;; Let's create a function to load example files:
;; **

;; @@
(defn load-data [fname]
  (s/split-lines (slurp fname)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;aoc-2021/load-data</span>","value":"#'aoc-2021/load-data"}
;; <=

;; **
;;; And run against today's data:
;; **

;; @@
(d1a (map #(Integer/parseInt %) (load-data "d1.txt")))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>1754</span>","value":"1754"}
;; <=

;; **
;;; Here's the part 2 function:
;; **

;; @@
(defn d1b [x]
 (->> x
   (partition 3 1)
   (map #(apply + %))
   d1a))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;aoc-2021/d1b</span>","value":"#'aoc-2021/d1b"}
;; <=

;; **
;;; Which we apply to the original example data:
;; **

;; @@
(d1b d1-ex)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>5</span>","value":"5"}
;; <=

;; **
;;; This checks out so we apply it to the full data set:
;; **

;; @@
(d1b (map #(Integer/parseInt %) (load-data "d1.txt")))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>1789</span>","value":"1789"}
;; <=
