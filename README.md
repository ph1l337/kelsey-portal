# Diseametry

## Conceptual Model

The goal of this application is to uncover relationships between diseases that share symptoms/signs or findings in patients.

The following questions need to be answerable with the system:

  - Given a disease, what other diseases have the highest number of common indicators (symptom/sign or finding)?
  - Given a disease, what indicators connect it to other diseases?
  - Given an indicator, what other indicators commonly present in diseases where said indicator is present?

Data used are annotated documents, e.g. research papers, web pages, encyclopedias, that contain information on diseases and their related symptoms/signs and/or findings. Since the documents are annotated with UMLS/SNOMED notations, we first to understand some relevant vocabulary for it. 

UMLS & SNOMED terminology:

  - CUI (Concept): a meaning, e.g. headache
  - SUI (String ID): a string/form of text, e.g. Headache vs HEADACHE vs headache
  - TUI (Semantic type): categorization of a concept, in a hierchical structure, e.g. biological term, chemical compound
  
  
How is it all connected:

  - Different string formats can map to the same meaning, i.e. CUI (concept)
  - One meaning can have different categorizations, i.e. TUI (semantic type), regardless of its expressed format, i.e. SUI (string ID)
  - The actual categorization (semantic type, TUI) of a meaning (concept, CUI) is dependent on context; that's what's attempted with NLP: identifying the correct categorization of a meaning
  - A single unique string, i.e. SUI, can refer to different meanings (concept, CUI)
  
Therefore, the following is concluded:

  - When reading documents, the actual string format is not relevant. What is relevant is its meaning, i.e CUI
  - Each disease, and each symptom/sign or finding will have its own unique meaning, which will be different from any other concept
  
Modeling wise, we establish the following entities are required to represent the diseases and symptoms/sign and findings:

  - A disease entity, with a unique CUI
  - A indicator entity with a unique CUI, to represent symptom/sign, and findings
  - A `HAS_FINDING` relationship between a (Disease) entity and an (Indicator) entity
  - A `HAS_SYM_OR_SIGN` relationship between a (Disease) entity and an (Indicator) entity
  
Note that this model excludes the following information:
  - Reference of the source of the connections between diseases and indicators
  - Count/Stock of how many references present a connection a disease and an indicator 


