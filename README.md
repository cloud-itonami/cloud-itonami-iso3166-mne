# cloud-itonami-iso3166-mne

Open ISO 3166 Blueprint for **MNE**: Montenegro (EU-candidate,
non-EU-member).

**`:implemented`** for **MNE**. Flagship
`foreign-branch-registration-missing` (Zakon o privrednim društvima
čl. 1, CRPS registration of a foreign company's Montenegrin branch).

```
clojure -M:dev:test
```

Independent public-sector market-entry & procurement-compliance service
for an already-incorporated operator entering public contracts in
Montenegro.

## Official surface (web-verified)

- Procurement: Direktorat za politiku javnih nabavki (Directorate for
  Public Procurement Policy, ujn.gov.me), under the Ministarstvo
  finansija (Ministry of Finance), operates CEJN (Centralni elektronski
  sistem javnih nabavki, cejn.gov.me) under the Zakon o javnim
  nabavkama ("Službeni list Crne Gore", br. 074/19 od 30.12.2019,
  003/23 od 10.01.2023, 011/23 od 27.01.2023).
- Business/tax: CRPS (Centralni registar privrednih subjekata),
  administered under Uprava prihoda i carina (Revenue and Customs
  Administration — confirmed via crps.me, fetched through the Internet
  Archive Wayback Machine after the live site failed at the TLS layer
  this session; NOT a standalone "Poreska uprava" as a first-pass
  assumption before verification would have had it), registers business
  entities under the Zakon o privrednim društvima. A PIB (poreski
  identifikacioni broj) is assigned as part of the same registration
  flow.
- Foreign investment: no Montenegro-specific FDI-screening statute was
  independently located this session (`paragraf.me/propisi-crnegore/
  zakon-o-stranim-ulaganjima.html` 404'd; the official gazette registry
  sluzbenilist.me returned HTTP 403 on direct fetch, not bypassed).
  This is disclosed as an honest gap (absence of evidence), not as an
  affirmative "Montenegro has no such regime" finding the way Serbia's
  README could cite RAS's own national-treatment language — see
  `src/marketentry/facts.cljc` for the full disclosure.
- Currency: Montenegro uses the **euro** as its legal tender **without
  being a member of the eurozone or the EU** — a genuinely unusual
  monetary arrangement independently verified via the Central Bank of
  Montenegro's own "euroisation" page (cbcg.me): the German Mark became
  sole legal tender in January 2001, replaced by the euro in March 2002,
  and "Montenegro entered this regime before ECOFIN Council adopted the
  position prohibiting unilateral euroisation." This fact does not
  generate a governor check (it is not a per-engagement verifiable
  record) — it is disclosed here and in `docs/business-model.md` as
  context for operators.

See `src/marketentry/facts.cljc` and `src/statute/facts.cljc` for the
full citation trail and explicit provenance disclosures (the official
gazette registry, sluzbenilist.me, returned HTTP 403 on direct fetch
this session — statute citations are corroborated via gov.me's own
document repository where possible, and via a private legal publisher
otherwise, both clearly marked as such).

## What this is NOT

- **Not the government of Montenegro.**

## License

AGPL-3.0-or-later.

## Culture catalog

Alongside the market-entry / statute catalogs, this repo carries a
**country-level regional-culture catalog** (ADR-2607171400 addendum 2,
`cloud-itonami-municipality-culture-catalog` Wave 1, in
`com-junkawasaki/root`) — national dishes, protected products, beverages,
crafts, festivals and heritage sites for Montenegro:

- `src/culture/facts.cljc` — the catalog, source of truth (keyed by
  uppercase ISO3, mirroring `statute.facts`).
- `schema/culture.edn` — DataScript schema.
- `data/culture-tx.edn` — derived DataScript tx-data (regenerated from
  the catalog, never hand-edited).

City-level counterparts live in the `cloud-itonami-municipality-*` repos.
Same provenance discipline as the compliance catalogs: every entry cites a
source URL that was actually fetched and read on `:culture/retrieved-at`;
summaries state only what the cited source confirms. An item not in
`culture.facts/catalog` has no spec-basis — never fabricate one.
