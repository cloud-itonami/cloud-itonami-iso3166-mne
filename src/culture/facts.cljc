(ns culture.facts
  "Country-level regional-culture catalog for Montenegro (MNE) -- national
  dishes, protected products, beverages, crafts, festivals and heritage
  sites, per ADR-2607171400 addendum 2 (cloud-itonami-municipality-
  culture-catalog Wave 1, in com-junkawasaki/root). Sibling namespace to
  `marketentry.facts` / `statute.facts` (ADR-2607141700); city-level
  counterparts live in the cloud-itonami-municipality-* repos.

  Catalog is keyed by UPPERCASE ISO3 (mirrors `statute.facts`); entries
  carry no :culture/municipality (that attribute is city-level only).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of culture entries."
  {"MNE"
   [{:culture/id "mne.dish.kacamak"
     :culture/name "Kačamak"
     :culture/country "MNE"
     :culture/kind :dish
     :culture/summary "Maize/polenta porridge with buttered potato and kaymak, made in parts of Western Asia and Southeastern Europe including Montenegro, Bulgaria, Albania, Bosnia and Herzegovina, and Serbia."
     :culture/url "https://en.wikipedia.org/wiki/Ka%C4%8Damak"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "mne.dish.ukljeva"
     :culture/name "Ukljeva"
     :culture/country "MNE"
     :culture/kind :dish
     :culture/summary "Smoked and dried bleak from Lake Skadar, Montenegro, per the Cuisine of Montenegro article."
     :culture/url "https://en.wikipedia.org/wiki/Cuisine_of_Montenegro"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "mne.dish.brav-u-mlijeku"
     :culture/name "Brav u mlijeku"
     :culture/country "MNE"
     :culture/kind :dish
     :culture/summary "Lamb cooked in milk, described by the Cuisine of Montenegro article as a national dish of Albanians from Montenegro."
     :culture/url "https://en.wikipedia.org/wiki/Cuisine_of_Montenegro"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "mne.product.njeguski-prsut"
     :culture/name "Njeguški pršut"
     :culture/country "MNE"
     :culture/kind :product
     :culture/summary "Dry-cured ham specialty from the village of Njeguši in Montenegro, similar to Italian prosciutto crudo, flavored by sea and mountain air and beech-wood smoke during drying."
     :culture/url "https://en.wikipedia.org/wiki/Njegu%C5%A1ki_pr%C5%A1ut"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "mne.product.njeguski-sir"
     :culture/name "Njeguški sir"
     :culture/country "MNE"
     :culture/kind :product
     :culture/summary "Special cheese kept in oil, a named cheese product of Montenegro per the Cuisine of Montenegro article."
     :culture/url "https://en.wikipedia.org/wiki/Cuisine_of_Montenegro"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "mne.beverage.vranac"
     :culture/name "Vranac"
     :culture/country "MNE"
     :culture/kind :beverage
     :culture/summary "Red grape variety that originates from Montenegro and is the most planted grape variety there, protected as a Montenegrin geographical indication of origin since 1977."
     :culture/url "https://en.wikipedia.org/wiki/Vranac"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "mne.festival.boka-navy-kotor"
     :culture/name "Cultural Heritage of Boka Navy Kotor"
     :culture/country "MNE"
     :culture/kind :festival
     :culture/summary "Traditional maritime organization founded in Kotor, Montenegro in 809, whose annual St. Tryphon festivities (13 Jan-3 Feb) and ceremonial kolo dance were inscribed on UNESCO's Representative List of the Intangible Cultural Heritage of Humanity in 2021."
     :culture/url "https://ich.unesco.org/en/RL/cultural-heritage-of-boka-navy-kotor-a-festive-representation-of-a-memory-and-cultural-identity-01727"
     :culture/url-provenance :official-ich-unesco-org
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "mne.heritage.kotor"
     :culture/name "Natural and Culturo-Historical Region of Kotor"
     :culture/country "MNE"
     :culture/kind :heritage
     :culture/summary "UNESCO World Heritage Site inscribed in 1979, encompassing the medieval old town of Kotor, its fortification systems, and the surrounding inner Bay of Kotor, Montenegro."
     :culture/url "https://en.wikipedia.org/wiki/Natural_and_Culturo-Historical_Region_of_Kotor"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [iso3] (get catalog iso3))

(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-mne culture catalog "
                 "(ADR-2607171400 addendum 2, Wave 1): " (count (get catalog "MNE"))
                 " MNE entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [iso3 kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis iso3)))
