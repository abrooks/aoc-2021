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
;;; ### Part 1
;;; 
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
;;; Now run against today's data:
;; **

;; @@
(d1a (map #(Integer/parseInt %) (load-data "d1.txt")))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>1754</span>","value":"1754"}
;; <=

;; **
;;; ### Part 2
;;; 
;;; Here's the part 2 function, building on part 1:
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

;; **
;;; ## Day 2
;; **

;; @@
(def d2-ex
  (s/split-lines
"forward 5
down 5
forward 8
up 3
down 8
forward 2"))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;aoc-2021/d2-ex</span>","value":"#'aoc-2021/d2-ex"}
;; <=

;; @@
(def direction {"forward"  [1  0]
                 "up"      [0 -1]
                 "down"    [0  1]})
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;aoc-2021/direction</span>","value":"#'aoc-2021/direction"}
;; <=

;; @@
(defn go [init [dir mag]]
  (map +
       init
       (map #(* mag %) (direction dir))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;aoc-2021/go</span>","value":"#'aoc-2021/go"}
;; <=

;; **
;;; Test it out a little:
;; **

;; @@
(go [0 0] ["forward" 5])
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-long'>0</span>","value":"0"}],"value":"(5 0)"}
;; <=

;; @@
(reduce go [0 0] [["forward" 4]["down" 3]["forward" 1] ["up" 1]])
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"}],"value":"(5 2)"}
;; <=

;; @@
(def d2-data (load-data "d2.txt"))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;aoc-2021/d2-data</span>","value":"#'aoc-2021/d2-data"}
;; <=

;; @@
(defn d2a-commands [data]
  (map #(let [[dir mag] (s/split % #" ")]
          [dir (Integer/parseInt mag)])
       data))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;aoc-2021/d2a-commands</span>","value":"#'aoc-2021/d2a-commands"}
;; <=

;; @@
(defn d2a [cmds]
  (reduce go [0 0] cmds))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;aoc-2021/d2a</span>","value":"#'aoc-2021/d2a"}
;; <=

;; @@
(->> d2-data
  d2a-commands
  d2a
  (apply *))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>1484118</span>","value":"1484118"}
;; <=

;; **
;;; Because of the change in complexity, we'll adjust our approach, making the direction lookup map more complex and the go function simpler.
;; **

;; @@
(def dir-aim
  {"forward" (fn [[p d a] m]
               [(+ p m), (+ d (* a m)), a])
   "up"      (fn [[p d a] m]
               [p, d, (- a m)])
   "down"    (fn [[p d a] m]
               [p, d, (+ a m)])})
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;aoc-2021/dir-aim</span>","value":"#'aoc-2021/dir-aim"}
;; <=

;; @@
(defn go-aim [state [dir mag]]
  (let [dfn (dir-aim dir)]
    (dfn state mag)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;aoc-2021/go-aim</span>","value":"#'aoc-2021/go-aim"}
;; <=

;; @@
(->> d2-ex
  d2a-commands
  (reduce go-aim [0 0 0])
  (take 2)
  (apply *))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>900</span>","value":"900"}
;; <=

;; @@
(->> d2-data
  d2a-commands
  (reduce go-aim [0 0 0])
  (take 2)
  (apply *))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>1463827010</span>","value":"1463827010"}
;; <=
