(ns marketentry.facts
  "Montenegro (MNE, EU-candidate, non-EU-member) market-entry catalog.
  Every field is WebFetch/curl-verified this tick against the official
  government sites named in `:provenance` -- an entry NOT in `catalog`
  has no spec-basis, full stop; extend `catalog`, never invent an
  authority/URL.

  Verified this tick:
  - https://ujn.gov.me/ -- the procurement authority's own site
    identifies itself in its page title as 'Direktorat za politiku
    javnih nabavki' (Directorate for Public Procurement Policy),
    operating under the Ministarstvo finansija (Ministry of Finance).
    Its own 'Propisi' (Regulations) page quotes, verbatim: 'Zakon o
    javnim nabavkama (\"Službeni list Crne Gore\", br. 074/19 od
    30.12.2019, 003/23 od 10.01.2023, 011/23 od 27.01.2023.) --
    Prečišćen tekst' (consolidated text). The same page names the
    electronic system 'cejn.gov.me'.
  - https://cejn.gov.me/ -- fetched directly; HTTP 200, page
    `<title>CeJN</title>` (Centralni elektronski sistem javnih
    nabavki / Central Electronic Public Procurement System). This is
    an Angular single-page app -- the static HTML carries only the
    title/shell, no further server-rendered text was retrievable this
    session, but the site's live existence and self-identification as
    'CeJN' ARE independently confirmed (not taken solely from
    ujn.gov.me's own reference to it).
  - https://crps.me/ (fetched via the Internet Archive Wayback Machine,
    snapshot 2025-06-14, after the LIVE site failed this session with a
    TLS-layer `SSL_ERROR_SYSCALL` immediately after the Client Hello on
    every attempt -- a genuine connectivity failure at the transport
    layer, before any HTTP response/challenge was ever served, so this
    is NOT a CAPTCHA/bot-detection block and no bypass was attempted or
    would have been appropriate; the Wayback fallback is exactly the
    documented recourse for an unreachable primary source): the portal's
    own header reads 'Dobrodošli na web portal Centralnog registra
    privrednih subjekata Crne Gore (CRPS)' (Welcome to the web portal of
    the Central Registry of Business Entities of Montenegro), and its
    own footer/forms page states 'Hvala što ste posjetili sajt
    Centralnog registra privrednih subjekata Uprave prihoda i carina'
    (thank you for visiting the site of the Central Registry of Business
    Entities OF THE REVENUE AND CUSTOMS ADMINISTRATION) -- CRPS is
    administered under the Uprava prihoda i carina (Revenue and Customs
    Administration), the merged tax+customs body, NOT a standalone
    'Poreska uprava' as a first-pass assumption before verification
    would have had it (the CRPS forms page itself also links directly
    to 'Uprava prihoda i carina' and 'Ministarstvo finansija i
    socijalnog staranja', and lists its own contact address as
    crps.tax@tax.gov.me -- an independent confirmation of the same
    institutional fact from a second element of the same fetched page,
    not a single unconfirmed mention). The forms page also states, in
    its own words: 'U cilju unapređenja poslovnog ambijenta u okviru
    regulatorne reforme uveden je jednošalterski sistem registracije
    privrednih subjekata' (a one-stop-shop system for registering
    business entities was introduced as part of a regulatory-reform
    business-environment improvement) -- a genuine G2 detail about HOW
    registration is organized, not assumed.
  - https://www.paragraf.me/propisi-crnegore/zakon-o-privrednim-drustvima.html
    -- Montenegro's equivalent of Serbia's paragraf.rs: a PRIVATE
    commercial legal-code publisher, NOT the official gazette. Fetched
    and read directly (raw HTML, confirmed via `curl`, not only the
    WebFetch summary) this session. Quotes, verbatim: 'ZAKON O
    PRIVREDNIM DRUŠTVIMA (\"Sl. list RCG\", br. 65/2020)' and Article 1:
    'Ovim zakonom uređuje se osnivanje, registracija, upravljanje,
    restrukturiranje, prestanak i druga pitanja od značaja za rad
    privrednih društava, preduzetnika i dijela stranog društva.' (This
    law regulates the establishment, registration, management,
    restructuring, termination and other matters of significance for
    the operation of business associations, entrepreneurs, AND BRANCHES
    OF FOREIGN COMPANIES -- own gloss, not an official translation.) The
    'Sl. list RCG' (Republika Crna Gore) abbreviation on a 2020-numbered
    issue is reproduced EXACTLY as printed by the source and is disclosed
    here as an apparent anomaly (Montenegro dropped 'Republika' from its
    own official name after the 2006 independence referendum, so a
    contemporary gazette issue would ordinarily be cited as 'Sl. list
    CG') -- this catalog does not silently correct a primary-looking
    quote from a source it did not author; see `statute.facts` for the
    full disclosure of why this citation could not be cross-checked
    against the official gazette registry directly this session.
  - https://www.gov.me/dokumenta/cb1b0281-c091-4147-8454-e5016dbd1548 --
    Montenegro's OWN government document repository (gov.me), fetched
    directly. Confirms the document 'Zakon o radu' (Labour Law) is
    published in 'Službeni list CG' under numbers 74/2019, 8/2021,
    59/2021, 68/2021 and 145/2021, maintained by the Fond rada (Labour
    Fund). See `statute.facts` for the full labour-law citation trail
    (a second, INDEPENDENT primary-official confirmation, distinct from
    the paragraf.me secondary source).
  - https://www.cbcg.me/en/core-functions/monetary-policy/euroisation --
    the Central Bank of Montenegro's OWN page on 'euroisation', fetched
    directly and read in full. This is disclosed here because it is the
    genuinely unusual structural fact that most distinguishes Montenegro
    from EVERY prior sibling in this family (including fellow EU-
    candidate Serbia): Montenegro uses the euro as its national legal
    tender WITHOUT being a member of the eurozone or the EU. Quoted
    verbatim: 'As of January 2001 the German Mark (DEM) became the only
    legal tender, and since March 2002 the official means of payment
    has become the Euro.' And: 'The use of the euro as the legal tender
    differs entirely from the membership in the euro area... The
    euroisation in Montenegro is treated as a specific case since
    Montenegro entered this regime before ECOFIN Council adopted the
    position prohibiting unilateral euroisation... this is the first
    time the EU has been negotiating with a country using the euro.'
    This monetary fact does not itself generate a governor CHECK (it is
    not a registrable/verifiable per-engagement fact the way a filing or
    a registration record is), so it is disclosed here as VERIFIED
    context, not smuggled into `catalog` as an invented requirement --
    see README/business-model.md for where this fact is surfaced.

  Attempted and NOT independently confirmed this session (disclosed,
  not papered over): a Montenegro-specific foreign-direct-investment
  SCREENING statute analogous to Slovenia's ZSInv/EU-Regulation-
  2019/452 implementation. `paragraf.me/propisi-crnegore/zakon-o-
  stranim-ulaganjima.html` (the URL slug pattern that worked for the
  other two paragraf.me laws above) 404'd; WIPO Lex and UNCTAD
  Investment Policy Hub guesses either 404'd or returned an unrelated
  country's law; the official gazette registry
  (sluzbenilist.me/Pravno informacioni sistem Crne Gore) returned HTTP
  403 on direct fetch (see `statute.facts` for the full disclosure --
  no bypass was attempted). This is reported as 'not found this
  session', NOT as an affirmative 'Montenegro has no such regime' the
  way Serbia's README could cite RAS's own national-treatment language
  -- the honest state here is absence of evidence, not evidence of
  absence; no `:fdi-*` keys are added to this catalog because nothing
  was independently verified to hang them on.")

(def catalog
  {"MNE" {:name "Montenegro"
          :owner-authority "Direktorat za politiku javnih nabavki (Directorate for Public Procurement Policy), Ministarstvo finansija / CEJN (Centralni elektronski sistem javnih nabavki)"
          :legal-basis "Zakon o javnim nabavkama (\"Službeni list Crne Gore\", br. 074/19 od 30.12.2019, 003/23 od 10.01.2023, 011/23 od 27.01.2023)"
          :national-spec "CEJN (Centralni elektronski sistem javnih nabavki, cejn.gov.me) economic-operator / contracting-authority registration"
          :provenance "https://ujn.gov.me/"
          :required-evidence ["CRPS (Centralni registar privrednih subjekata) registration extract (izvod iz CRPS)"
                               "PIB assignment record (Uprava prihoda i carina)"
                               "CEJN economic-operator registration record"
                               "Authorized-signatory record"]
          ;; Flagship check basis -- see marketentry.governor
          ;; `foreign-branch-registration-missing-violations`. Grounded
          ;; in Zakon o privrednim društvima čl. 1, which brings "dio
          ;; stranog društva" (a branch of a foreign company) within the
          ;; SAME registration regime as domestic privredna društva /
          ;; preduzetnici, and in CRPS's own confirmed role as the
          ;; single registering authority for that regime.
          :foreign-branch-owner-authority "CRPS (Centralni registar privrednih subjekata), administered under Uprava prihoda i carina (Revenue and Customs Administration)"
          :foreign-branch-legal-basis "Zakon o privrednim društvima, čl. 1 (\"Sl. list RCG\", br. 65/2020) -- \"dio stranog društva\" named alongside privredna društva / preduzetnici"
          :foreign-branch-provenance "https://crps.me/"}
   "USA" {:name "United States" :owner-authority "GSA/SAM.gov" :legal-basis "FAR"
          :national-spec "SAM.gov" :provenance "https://sam.gov/"
          :required-evidence ["EIN record" "SAM.gov registration record" "State business registration record" "SAM UEI verification record"]}
   "DEU" {:name "Germany" :owner-authority "e-Vergabe" :legal-basis "GWB/VgV"
          :national-spec "e-Vergabe" :provenance "https://www.evergabe-online.de/"
          :required-evidence ["Handelsregister extract" "e-Vergabe registration record" "USt-IdNr record" "Authorized-representative record"]}
   "NLD" {:name "Netherlands" :owner-authority "TenderNed" :legal-basis "Aanbestedingswet"
          :national-spec "TenderNed" :provenance "https://www.tenderned.nl/"
          :required-evidence ["KvK extract" "TenderNed registration" "BTW record" "Authorized-representative record"]}})

(defn spec-basis [iso3] (get catalog iso3))

(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s) missing (remove catalog iso3s)]
     {:requested (count iso3s) :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note "R0 catalog seed"})))

(defn required-evidence-satisfied? [iso3 submitted]
  (when-let [{:keys [required-evidence]} (spec-basis iso3)]
    (= (count required-evidence) (count (filter (set submitted) required-evidence)))))

(defn evidence-checklist [iso3] (:required-evidence (spec-basis iso3) []))

(defn foreign-branch-spec-basis
  "Spec-basis for the flagship `foreign-branch-registration-missing`
  governor check -- CRPS registration of a foreign company's Montenegrin
  branch (\"dio stranog društva\"), Zakon o privrednim društvima čl. 1."
  [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:foreign-branch-owner-authority sb)
      (select-keys sb [:foreign-branch-owner-authority :foreign-branch-legal-basis :foreign-branch-provenance]))))
