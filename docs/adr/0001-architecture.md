# ADR-0001: MNE marketentry `:implemented`

Flagship `foreign-branch-registration-missing` (Zakon o privrednim
društvima čl. 1, "Sl. list RCG" br. 65/2020, per paragraf.me — CRPS
registration of a foreign company's Montenegrin branch, "dio stranog
društva"). No `nonresident-pib-missing`-shaped check copied from Serbia,
and no `fdi-notification-missing`-shaped check copied from Slovenia:
neither could be independently grounded for Montenegro this session (no
Montenegro-specific tax-administration article naming non-resident PIB
assignment was fetched; no Montenegro-specific FDI-screening statute
was found — `paragraf.me/propisi-crnegore/zakon-o-stranim-ulaganjima.html`
404'd, and the official gazette registry sluzbenilist.me returned HTTP
403 on direct fetch). What WAS independently verified is the CRPS/
Companies-Law fact: Zakon o privrednim društvima čl. 1 brings "dio
stranog društva" within the same registration regime as domestic
privredna društva/preduzetnici, and CRPS (reached via the Wayback
Machine after the live site failed at the TLS layer) is confirmed as
the registering authority, administered under Uprava prihoda i carina
(not a standalone "Poreska uprava"). See `src/marketentry/governor.cljc`
docstring for the full reasoning and citation trail.

Also disclosed and NOT smuggled into the compliance catalog: Montenegro
uses the euro as its national legal tender without being an EU or
eurozone member (Central Bank of Montenegro, cbcg.me, "euroisation" —
verified this session). This is a genuinely unusual monetary fact about
the jurisdiction, surfaced in README.md/docs/business-model.md as
context, not turned into a fabricated governor check — it is not a
per-engagement registrable/verifiable fact the way a CRPS registration
or a filing is.
