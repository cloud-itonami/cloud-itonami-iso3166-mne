(ns marketentry.governor
  "Market-Entry Compliance Governor -- the independent compliance layer
  that earns the MarketEntry-LLM the right to commit. The LLM has no
  notion of Montenegrin procurement law, whether a foreign company's
  Montenegrin branch has actually been registered with CRPS, whether a
  claimed engagement fee actually equals base + months x rate, or when
  a draft stops being a draft and becomes a real-world CEJN portal
  submission, so this MUST be a separate system able to *reject* a
  proposal and fall back to HOLD.

  `:itonami.blueprint/governor` is `:market-entry-compliance-governor`
  (shared family keyword on blueprints; this fleet's Poland
  implementation was the first *running* instance of this governor for
  the iso3166 family, Serbia the second, Slovenia the third; this is
  Montenegro's).

  This blueprint's own text (docs/business-model.md Trust Controls: 'any
  actual CEJN registration or filing submission requires Market-Entry
  Compliance Governor clearance and always escalates to human sign-off';
  'a false or fabricated regulatory-requirement claim is a HARD hold')
  names exactly the checks below.

  Montenegro is an EU-CANDIDATE, non-EU-member state -- like Serbia, NOT
  like Slovenia (EU member, eurozone member, with its own EU-Regulation-
  2019/452 FDI-screening mechanism). A Slovenia-shaped
  `fdi-notification-missing` check was deliberately NOT copied here: this
  session could not independently confirm any Montenegro-specific
  FDI-screening statute (`paragraf.me/propisi-crnegore/zakon-o-stranim-
  ulaganjima.html` 404'd; the official gazette registry
  sluzbenilist.me returned HTTP 403 on direct fetch; WIPO Lex/UNCTAD
  guesses failed) -- see `marketentry.facts`/`statute.facts` docstrings
  for the full disclosure. Absence of evidence is reported as absence of
  evidence, not fabricated into a check the way a Slovenia-shaped
  padding would.

  A Serbia-shaped `nonresident-pib-missing` check was ALSO deliberately
  NOT copied here in that exact shape: this session could not
  independently confirm an article of Montenegrin tax-administration law
  that names non-resident permanent-establishment PIB assignment the way
  Serbia's Art. 26 Zakon o poreskom postupku i poreskoj administraciji
  does (the CRPS site was reachable only via the Wayback Machine this
  session, and its own forms page lists 'Zakon o poreskoj administraciji'
  by title only, without a fetchable article-level text this session).

  Montenegro's own INDEPENDENTLY VERIFIED distinguishing structural fact
  is instead the CRPS/Companies-Law one: Zakon o privrednim društvima
  čl. 1 (\"Sl. list RCG\", br. 65/2020, per paragraf.me -- fetched and
  read directly this session) brings 'dio stranog društva' (a branch of
  a foreign company) within the SAME registration regime as domestic
  privredna društva / preduzetnici, and CRPS (Centralni registar
  privrednih subjekata, administered under Uprava prihoda i carina --
  confirmed via crps.me, fetched via the Wayback Machine after the live
  site failed at the TLS layer) is independently confirmed as the single
  registering authority for that regime. A foreign operator that entered
  the Montenegrin market via a branch (rather than a purely domestic
  subsidiary, or a bidder with no Montenegrin establishment at all) is
  only market-entry-clean once that branch is actually on file at CRPS --
  this governor independently verifies that, exactly CONDITIONAL on the
  engagement's own `:requires-foreign-branch-registration?` ground truth
  (an engagement that entered organically as a domestic entity, or that
  bids without any Montenegrin establishment, does not need it -- never
  force every engagement through a check the source law does not impose
  on it). A smaller honest check set, grounded in what was ACTUALLY
  verified for Montenegro, beats a padded one copied from a sibling.

  Six checks, in priority order, ALL HARD violations: a human approver
  CANNOT override them. The confidence/actuation gate is SOFT: it asks a
  human to look (low confidence / actuation), and the human may approve
  -- but see `marketentry.phase`: for `:stake :actuation/draft-filing`/
  `:actuation/submit-filing` NO phase ever allows auto-commit either. Two
  independent layers agree that actuation is always a human call.

    1. Spec-basis                  -- did the jurisdiction proposal cite
                                       an OFFICIAL source
                                       (`marketentry.facts`), or invent
                                       one?
    2. Evidence incomplete         -- for `:filing/draft`/
                                       `:filing/submit`, has the
                                       jurisdiction actually been
                                       assessed with a full evidence
                                       checklist on file?
    3. Foreign-branch registration -- for `:filing/submit`, when the
       missing                        engagement declares
                                       `:requires-foreign-branch-
                                       registration? true`, INDEPENDENTLY
                                       verify `:foreign-branch-
                                       registration-verified?` is true.
                                       FLAGSHIP check for this vertical,
                                       grounded in Zakon o privrednim
                                       društvima čl. 1 + CRPS's
                                       confirmed registering-authority
                                       role.
    4. Engagement fee mismatch     -- for `:filing/submit`,
                                       INDEPENDENTLY recompute whether
                                       the engagement's own `:claimed-
                                       fee` equals `base-fee + monthly-
                                       rate x monitoring-months` --
                                       honest reapplication of the
                                       ground-truth-recompute discipline
                                       sibling actors use.
    5/6. Double-draft / double-submit prevention -- enforced off
                                       dedicated `:drafted?`/
                                       `:submitted?` facts (never a
                                       `:status` value)."
  (:require [marketentry.facts :as facts]
            [marketentry.registry :as registry]
            [marketentry.store :as store]))

(def confidence-floor 0.6)

(def high-stakes
  "Stakes grave enough to always require a human, even when clean.
  Drafting a real CEJN filing package and submitting a real portal
  registration are the two real-world actuation events this actor
  performs."
  #{:actuation/draft-filing :actuation/submit-filing})

;; ----------------------------- checks -----------------------------

(defn- spec-basis-violations
  "A `:jurisdiction/assess` (or `:filing/draft`/`:filing/submit`)
  proposal with no spec-basis citation is a HARD violation -- never
  invent a jurisdiction's market-entry requirements."
  [{:keys [op]} proposal]
  (when (contains? #{:jurisdiction/assess :filing/draft :filing/submit} op)
    (let [value (:value proposal)]
      (when (or (empty? (:cites proposal))
                (and (contains? value :spec-basis) (nil? (:spec-basis value))))
        [{:rule :no-spec-basis
          :detail "公式spec-basisの引用が無い提案は法域要件として扱えない"}]))))

(defn- evidence-incomplete-violations
  "For `:filing/draft`/`:filing/submit`, the jurisdiction's required
  registration evidence must actually be satisfied."
  [{:keys [op subject]} st]
  (when (contains? #{:filing/draft :filing/submit} op)
    (let [e (store/engagement st subject)
          assessment (store/assessment-of st subject)]
      (when-not (and assessment
                     (facts/required-evidence-satisfied?
                      (:jurisdiction e) (:checklist assessment)))
        [{:rule :evidence-incomplete
          :detail "法域の必要書類(CRPS登録/PIB/CEJN登録/署名権限者確認等)が充足していない状態での提案"}]))))

(defn- foreign-branch-registration-missing-violations
  "For `:filing/submit`, when the engagement declares
  `:requires-foreign-branch-registration? true`, INDEPENDENTLY verify
  `:foreign-branch-registration-verified?` is true -- the flagship
  genuinely new check this vertical adds. CONDITIONAL on the
  engagement's own `:requires-foreign-branch-registration?` ground
  truth. Grounded in Zakon o privrednim društvima čl. 1 (naming 'dio
  stranog društva') and CRPS's confirmed role as registering authority."
  [{:keys [op subject]} st]
  (when (= op :filing/submit)
    (let [e (store/engagement st subject)]
      (when (and (true? (:requires-foreign-branch-registration? e))
                 (not (true? (:foreign-branch-registration-verified? e))))
        [{:rule :foreign-branch-registration-missing
          :detail (str subject " はCRPSへの外国会社支店(dio stranog društva)登録確認を要するが未確認 -- 提出提案は進められない")}]))))

(defn- engagement-fee-mismatch-violations
  "For `:filing/submit`, INDEPENDENTLY recompute whether the
  engagement's own claimed fee equals base + months x rate."
  [{:keys [op subject]} st]
  (when (= op :filing/submit)
    (let [e (store/engagement st subject)]
      (when-not (registry/engagement-fee-matches-claim? e)
        [{:rule :engagement-fee-mismatch
          :detail (str subject " の申告手数料(" (:claimed-fee e)
                      ")が独立再計算値(" (registry/compute-engagement-fee e) ")と一致しない")}]))))

(defn- already-drafted-violations
  "For `:filing/draft`, refuses to draft the SAME engagement twice."
  [{:keys [op subject]} st]
  (when (= op :filing/draft)
    (when (store/engagement-already-drafted? st subject)
      [{:rule :already-drafted
        :detail (str subject " は既にドラフト済み")}])))

(defn- already-submitted-violations
  "For `:filing/submit`, refuses to submit the SAME engagement twice."
  [{:keys [op subject]} st]
  (when (= op :filing/submit)
    (when (store/engagement-already-submitted? st subject)
      [{:rule :already-submitted
        :detail (str subject " は既に提出済み")}])))

(defn check
  "Censors a MarketEntry-LLM proposal against the governor rules.
  Returns {:ok? bool :violations [..] :confidence c :escalate? bool
  :high-stakes? bool :hard? bool}."
  [request _context proposal st]
  (let [hard (into []
                   (concat (spec-basis-violations request proposal)
                           (evidence-incomplete-violations request st)
                           (foreign-branch-registration-missing-violations request st)
                           (engagement-fee-mismatch-violations request st)
                           (already-drafted-violations request st)
                           (already-submitted-violations request st)))
        conf (:confidence proposal 0.0)
        low? (< conf confidence-floor)
        stakes? (boolean (high-stakes (:stake proposal)))
        hard? (boolean (seq hard))]
    {:ok?          (and (not hard?) (not low?) (not stakes?))
     :violations   hard
     :confidence   conf
     :hard?        hard?
     :escalate?    (and (not hard?) (or low? stakes?))
     :high-stakes? stakes?}))

(defn hold-fact
  "The audit fact written when a proposal is rejected (HOLD)."
  [request context verdict]
  {:t          :governor-hold
   :op         (:op request)
   :actor      (:actor-id context)
   :subject    (:subject request)
   :disposition :hold
   :basis      (mapv :rule (:violations verdict))
   :violations (:violations verdict)
   :confidence (:confidence verdict)})
