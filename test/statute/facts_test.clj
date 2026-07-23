(ns statute.facts-test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [statute.facts :as facts]))

(deftest mne-has-spec-basis
  (let [sb (facts/spec-basis "MNE")]
    (is (= 2 (count sb)))
    (is (every? #(str/starts-with? (:statute/url %) "https://") sb))
    (is (every? :statute/law-number sb))))

(deftest unknown-jurisdiction-has-no-spec-basis
  (is (nil? (facts/spec-basis "ATL")))
  (is (nil? (facts/spec-basis "ZZZ"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["MNE" "SRB" "ATL"])]
    (is (= 3 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["ATL" "SRB"] (:missing-jurisdictions c)))))

(deftest by-topic-filters
  (is (= ["mne.sl-list-rcg-2020-65-zakon-o-privrednim-drustvima"]
         (mapv :statute/id (facts/by-topic "MNE" :incorporation))))
  (is (= ["mne.sl-list-cg-2019-74-zakon-o-radu"]
         (mapv :statute/id (facts/by-topic "MNE" :labor))))
  (is (empty? (facts/by-topic "ATL" :labor))))
