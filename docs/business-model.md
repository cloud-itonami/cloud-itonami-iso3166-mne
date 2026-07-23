# Business Model: Independent Public-Sector Market-Entry & Procurement Compliance Service — Montenegro

## Classification

- Repository: `cloud-itonami-iso3166-mne`
- ISO 3166: `MNE` (Montenegro)
- Activity: public-procurement market-entry and ongoing regulatory-
  compliance navigation for an already-incorporated operator
- Social impact: [:sme-market-access :public-spend-transparency :cross-border-friction-reduction]

## Customer

- an already-incorporated `cloud-itonami-cofog-{code}` /
  `cloud-itonami-isco-{code}` / `cloud-itonami-unspsc-{segment}` /
  `cloud-itonami-{ISIC}` operator wanting to bid on a Montenegrin public
  contract
- a foreign SME or civic-tech vendor entering the public sector in
  Montenegro for the first time
- a `cloud-itonami-M6910` client that has just completed incorporation
  and now needs public-sector market access

## Offer

- registration walkthrough for CEJN (Centralni elektronski sistem
  javnih nabavki, cejn.gov.me), operated by the Direktorat za politiku
  javnih nabavki (Directorate for Public Procurement Policy, ujn.gov.me)
  under the Ministarstvo finansija, under the Zakon o javnim nabavkama
  ("Službeni list Crne Gore", br. 074/19 od 30.12.2019, 003/23 od
  10.01.2023, 011/23 od 27.01.2023)
- business/tax registration checklist: a CRPS (Centralni registar
  privrednih subjekata) business-register entry plus a PIB (poreski
  identifikacioni broj, tax identification number) — CRPS is
  administered under Uprava prihoda i carina (Revenue and Customs
  Administration), NOT a standalone "Poreska uprava"
- for operators entering via a Montenegrin branch of a foreign company
  ("dio stranog društva", a form Zakon o privrednim društvima čl. 1
  brings within the same CRPS registration regime as domestic privredna
  društva/preduzetnici): CRPS branch-registration verification before
  any real filing submission
- local-content / preferential-procurement navigation: Montenegro is an
  EU-candidate country, NOT an EU member — no EU-wide FDI-screening
  regime (Regulation (EU) 2019/452) applies the way it does for
  Slovenia; procurement runs entirely under Montenegro's own national
  Zakon o javnim nabavkama via the CEJN portal
- ongoing regulatory-change monitoring subscription
- compliance-audit export package for the client's own records

## Revenue

- per-engagement market-entry fee (one-time registration + checklist
  completion)
- recurring regulatory-change monitoring subscription
- compliance-audit export package

## Trust Controls

- any actual CEJN registration or filing submission requires
  Market-Entry Compliance Governor clearance and always escalates to
  human sign-off (`:filing/submit` is never automated at any phase)
- a false or fabricated regulatory-requirement claim is a HARD hold
  that cannot be overridden by human approval alone — it must be
  corrected against a cited official source first
- this service does **not** provide legal or tax advice; characterization
  and filing on the client's behalf beyond checklist/draft assistance
  routes to Montenegrin-licensed counsel or a registered agent
- every requirement cites the official portal or regulation, never
  invented; where the primary official gazette source
  (sluzbenilist.me / Pravno informacioni sistem Crne Gore) returned
  HTTP 403 on direct fetch this session, the gap is disclosed explicitly
  in `src/statute/facts.cljc` rather than papered over

## Honest disclosure: no FDI-screening mechanism independently confirmed

Unlike EU-member sibling Slovenia (which has adopted an FDI-screening
mechanism implementing EU Regulation 2019/452 via its Zakon o
spodbujanju investicij), this session could not independently locate a
Montenegro-specific foreign-investment-screening statute
(`paragraf.me/propisi-crnegore/zakon-o-stranim-ulaganjima.html` 404'd;
the official gazette registry returned HTTP 403; WIPO Lex and UNCTAD
Investment Policy Hub lookups either 404'd or returned an unrelated
country's law). This is reported as **absence of evidence**, not
**evidence of absence** — a materially weaker claim than fellow
EU-candidate Serbia's, whose own README could cite an affirmative
national-treatment statement from Serbia's investment-promotion agency.
No `:fdi-*` fact or governor check is fabricated to fill this gap.

## Honest disclosure: an unusual monetary arrangement

Montenegro uses the **euro** as its national legal tender without being
a member of the eurozone or the EU. Per the Central Bank of Montenegro's
own "euroisation" page (cbcg.me, verified this session): the German Mark
became Montenegro's sole legal tender in January 2001, replaced by the
euro in March 2002, years before Montenegro's 2018 EU-accession
negotiations opened Chapter 17 ("Economic and monetary policy"). "The
euroisation in Montenegro is treated as a specific case since Montenegro
entered this regime before ECOFIN Council adopted the position
prohibiting unilateral euroisation" — in the Bank's own words, "this is
the first time the EU has been negotiating with a country using the
euro." This is stated here as verified context for operators (pricing,
invoicing and engagement fees in this catalog are already euro-
denominated, with no FX-conversion risk for a Montenegro engagement) —
it is not turned into a governor check, since it is not a per-engagement
registrable/verifiable fact the way a CRPS registration or filing is.

## Boundary with adjacent actors (read before forking)

- **`com-etzhayyim-ooyake`** (etzhayyim/root): read-only civic-wayfinding
  mirror of government structure, non-commercial, barred from acting as
  or for the government (G3 impersonation ban). This blueprint is
  commercial and never claims to be an official channel.
- **`matsurigoto`** (etzhayyim/root): sovereign e-government statecraft —
  literally the government, for etzhayyim's own covenant or an adopting
  nation-state. This blueprint is an independent operator the government
  contracts with or that bids into its procurement — never the
  government.
- **`com-etzhayyim-toritsugi`** (etzhayyim/root): guides a consenting
  INDIVIDUAL citizen through their OWN procedure, non-profit,
  donation-only. This blueprint's client is a business operator, not an
  individual citizen, and it is commercial.
- **`legal-entity.etzhayyim.com`**: read-only aggregated company-registry
  data, no execution. This blueprint executes (gated) registrations.
- **`cloud-itonami-M6910`**: helps a client BECOME a legal entity
  (incorporation, ISIC 6910) — a prior, different regulatory phase
  (company law, Zakon o privrednim društvima). This blueprint assumes
  incorporation is already done and handles public-procurement market
  entry (a different regulatory domain).
- **`cloud-itonami-cofog-{code}`**: a jurisdiction-agnostic operator
  template for ONE public function. This blueprint is the orthogonal
  jurisdiction-specific axis — the two compose (fork a COFOG-function
  blueprint AND this one to operate in Montenegro).
