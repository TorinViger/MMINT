(assert (forall (( c Goal))(=> (node ConvenientMeetingDate c )(not (or (node AgreeableMeetingDate c ))))))
(assert (forall (( c Goal))(=> (node AgreeableMeetingDate c )(not (or (node ConvenientMeetingDate c ))))))
(assert (exists (( c Task))(node ProvideDetails  c )))
(assert (exists (( c DependeeLink))(edge Details2ProvideDetails  c )))
(assert (exists (( c Decomposition))(edge LowEffortMP2ProvideDetails  c )))