(ns statute.facts
  "General-law compliance catalog for Montenegro (MNE) -- per
  ADR-2607141700 (cloud-itonami-compliance-fact-federation), mirroring
  the shape of cloud-itonami-iso3166-pol/-srb/-svn/-usa/-... `statute.facts`.
  Montenegro was previously culture-catalog-only in this repo, with no
  statute.facts -- this entry closes that structural gap for the MNE
  entity.

  PROVENANCE DISCLOSURE (read before trusting any citation below):

  Montenegro's official legal-gazette / legal-information-system site,
  sluzbenilist.me (Službeni list Crne Gore i Pravno informacioni sistem
  Crne Gore -- the government-adjacent ELI-style legal-act registry,
  analogous to Poland's eli.gov.pl and Serbia's pravno-informacioni-
  sistem.rs), was attempted directly this session and returned HTTP 403
  Forbidden. This was NOT bypassed by any means -- no CAPTCHA/JS
  challenge was solved, no browser automation was used; the fetch was
  simply reported as blocked. A Wayback Machine snapshot from
  2026-07-15 confirms the site's own identity ('Službeni list Crne
  Gore', 'Elektronsko izdanje Službenog lista Crne Gore i Pravno
  informacioni sistem Crne Gore (PIS)') but the site is a client-side-
  rendered Vue/Laravel single-page app, so the static snapshot carries
  no server-rendered statute text to extract -- a genuinely different
  failure mode than Serbia's `ECONNREFUSED` (this is an HTTP-layer
  block/redirect-to-home, not a TCP/TLS-layer refusal), disclosed
  precisely as such.

  Because the primary official registry could not be read this
  session, the TWO law citations below were instead corroborated via:

  1. https://www.gov.me/dokumenta/cb1b0281-c091-4147-8454-e5016dbd1548
     -- Montenegro's OWN government document repository (gov.me itself,
     an official primary source, fetched directly this session) --
     for the Labour Law ONLY. This confirms 'Zakon o radu' is published
     in 'Službeni list CG' under numbers 74/2019, 8/2021, 59/2021,
     68/2021 and 145/2021, maintained by the Fond rada (Labour Fund).
     This is a STRONGER provenance than Serbia's paragraf.rs-only
     corroboration -- it is Montenegro's own government portal, not a
     private publisher.
  2. https://www.paragraf.me/propisi-crnegore/ -- Montenegro's
     equivalent of Serbia's paragraf.rs: a PRIVATE commercial legal-code
     publisher, NOT the official gazette. Fetched and read directly
     this session (raw HTML confirmed via `curl`, not only a WebFetch
     summary) for BOTH laws below. paragraf.me's own Labour Law page
     cites only '\"Sl. list CG\", br. 74/2019 i 8/2021' -- narrower than
     gov.me's fuller amendment list above (74/2019, 8/2021, 59/2021,
     68/2021, 145/2021), an apparent sign paragraf.me's copy is an
     earlier consolidated text; the fuller gov.me citation is used as
     canonical below, and this discrepancy is disclosed rather than
     silently reconciled. For the Companies Law, paragraf.me is the
     ONLY citation found this session -- its own text reads '\"Sl. list
     RCG\", br. 65/2020', reproduced EXACTLY as printed (see
     `marketentry.facts` docstring for the 'RCG vs CG' anomaly
     disclosure; this citation could not be cross-checked against the
     official gazette this session).

  A THIRD category present in sibling catalogs (personal-data-protection
  law) is DELIBERATELY ABSENT here: no Montenegro-specific data-
  protection-law citation was independently fetched and read this
  session, so none is fabricated to round out the table to three
  entries. Two honestly-sourced entries beat three where one is
  invented.

  Zakon o privrednim društvima (Law on Business Associations, \"Sl. list
  RCG\", br. 65/2020, per paragraf.me) -- Article 1, quoted verbatim:
  'Ovim zakonom uređuje se osnivanje, registracija, upravljanje,
  restrukturiranje, prestanak i druga pitanja od značaja za rad
  privrednih društava, preduzetnika i dijela stranog društva.'

  Zakon o radu (Labour Law, \"Sl. list CG\", br. 74/2019, 8/2021,
  59/2021, 68/2021 i 145/2021, per gov.me's own document repository) --
  paragraf.me additionally quotes Article 1 verbatim (against its own
  narrower 74/2019 i 8/2021 citation): 'Prava i obaveze zaposlenih iz
  radnog odnosa, odnosno po osnovu rada, način i postupak njihovog
  ostvarivanja uređuju se ovim zakonom, kolektivnim ugovorom i ugovorom
  o radu.' (Employee rights and duties arising from employment
  relationships, or on the basis of work, and the manner and procedure
  of their exercise, are regulated by this law, collective agreements
  and employment contracts -- own gloss, not an official translation.)

  An entry not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url/date.")

(def catalog
  "ISO3166 alpha-3 -> vector of statute entries."
  {"MNE"
   [{:statute/id "mne.sl-list-rcg-2020-65-zakon-o-privrednim-drustvima"
     :statute/title "Zakon o privrednim društvima (Law on Business Associations)"
     :statute/jurisdiction "MNE"
     :statute/kind :law
     :statute/law-number "\"Sl. list RCG\", br. 65/2020"
     :statute/url "https://www.paragraf.me/propisi-crnegore/zakon-o-privrednim-drustvima.html"
     :statute/url-provenance :private-paragraf-me-official-registry-blocked-403
     :statute/enacted-date "2020-06-30"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:corporate-governance :incorporation}}
    {:statute/id "mne.sl-list-cg-2019-74-zakon-o-radu"
     :statute/title "Zakon o radu (Labour Law)"
     :statute/jurisdiction "MNE"
     :statute/kind :law
     :statute/law-number "\"Sl. list CG\", br. 74/2019, 8/2021, 59/2021, 68/2021 i 145/2021"
     :statute/url "https://www.gov.me/dokumenta/cb1b0281-c091-4147-8454-e5016dbd1548"
     :statute/url-provenance :official-gov-me-document-repository
     :statute/enacted-date "2019-12-30"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:labor :employment}}]})

(defn spec-basis [jurisdiction] (get catalog jurisdiction))

(defn coverage
  ([] (coverage (keys catalog)))
  ([jurisdictions]
   (let [have (filter catalog jurisdictions)
         missing (remove catalog jurisdictions)]
     {:requested (count jurisdictions)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-mne statute.facts Wave 0 (ADR-2607141700): "
                 (count (get catalog "MNE")) " Montenegro entries seeded. Labour Law "
                 "citation corroborated via gov.me's OWN document repository "
                 "(official primary source); Companies Law citation corroborated "
                 "via paragraf.me (private publisher) only -- sluzbenilist.me "
                 "(official gazette/PIS) returned HTTP 403 on direct fetch this "
                 "session, not bypassed. See catalog docstring for full "
                 "disclosure. Extend `statute.facts/catalog`, never fabricate "
                 "an id/url.")})))

(defn by-topic [jurisdiction topic]
  (filterv #(contains? (:statute/topic %) topic) (spec-basis jurisdiction)))
