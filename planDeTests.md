
## Exigences fonctionnalités à tester :

| Identifiants des fonctionnalités | Description des fonctionnalités |
| :-------------:|---------------|
| EF - 001      | Créer un dossier client Type |
| EF - 002      | Créer un soin reçu  |
| EF - 003      | Créer un soin assuré  |
| EF - 004      | Créer une réclamation  |
| EF - 005      | Créer un remboursement (police d'assurance) |
| EF - 006      | Créer un historique (fichier statistique) |
| EF - 007      | Créer un monnais   |
| EF - 008      | Créer un dossier client   |
| EF - 009      | Manipulation chaine de caractère(fichier utile)   |


## Suites et cas de tests :

| Identifiants des fonctionnalités | Identifiants des suites de tests | Description des suites de tests | Nombre de cas de tests |
| :-----------: | :-----------: | ----------- | :-----------: |
| EF - 001  | ST - 001  | Tester création de dossier client TypeA, TypeB, TypeC, TypeD, TypeE | 16 |
| EF - 002  | ST - 002  | Tester la dépense de soin | 4 |
| EF - 003  | ST - 003  | Tester le soin assuré | 3 |
| EF - 004  | ST - 004  | Tester une réclamation | 4 |
| EF - 005  | ST - 005  | Tester le remboursement d'une réclamation | 2 |
| EF - 006  | ST - 006  | Tester l'historique (calcul de Statistique) | 6  |
| EF - 007  | ST - 007  | Tester le calcul du monnais | 12 |
| EF - 008  | ST - 008  | Tester création de dossier client | 2 |
| EF - 009  | ST - 009  | Tester manipulation de chaine de caractere | 4 |


## Cas de tests :

|Identifiants des suites de tests   | Identifiants des cas de tests  | Description des cas de test   | Préconditions  |  Sortie attendue |  Priorité |
|:---:|:---:|---|---|---|---|
| ST-001 |CT-001| Tester le pourcentage du numéro soin  | La mise en place de donnée pourcentage |  pourcentage attendu est de 25% | Moyen  |
|        |CT-002| Tester le pourcentage des soins entre 300 et 399 | La mise en place des donnée pourcentage des soins entre 300 et 399 | Pourcentage attendu est de 0% | Moyen |
|        |CT-003| Tester les plafonds des remboursement | La mise en place des donnée plafond | Plafond attendu est de 200$ |  Moyen |
|        |CT-004| Tester le bon fonctionnement des plafond | La mise en place le bon fonctionnements | Le plafond attendu est de 100$ |  Moyen |
| ST-002 |CT-001| Tester le pourcentage du numéro soin  | La mise en place de donnée pourcentage |  Pourcentage attendu est de 75% | Moyen  |
|        |CT-002| Tester le pourcentage des soins entre 300 et 399 | La mise en place des donnée pourcentage des soins entre 300 et 399 | Pourcentage attendu est de 50% | Moyen |
|        |CT-003| Tester les plafonds des remboursement | La mise en place des donnée plafond | Plafond attendu est de 100$ |  Moyen |
|        |CT-004| Tester le bon fonctionnement des plafond | La mise en place le bon fonctionnements | Le plafond attendu est de 100$ |  Moyen |
| ST-003 |CT-001| Tester le pourcentage du numéro soin  | La mise en place de donnée pourcentage |  Pourcentage attendu est de 90% | Moyen  |
|        |CT-002| Tester le pourcentage des soins entre 300 et 399 | La mise en place des donnée pourcentage des soins entre 300 et 399 | Pourcentage attendu est de 90% | Moyen |
|        |CT-003| Tester les plafonds des remboursement | La mise en place des donnée plafond | Plafond attendu est de 100$ |  Moyen |
|        |CT-004| Tester le bon fonctionnement des plafond | La mise en place le bon fonctionnements | Le pourcentage attendu est de 75% |  Moyen |
| ST-004 |CT-001| Tester le pourcentage du numéro soin  | La mise en place de donnée pourcentage |  Pourcentage attendu est de 0% | Moyen  |
|        |CT-002| Tester le pourcentage des soins entre 300 et 399 | La mise en place des donnée pourcentage des soins entre 300 et 399 | Pourcentage attendu est de 0% | Moyen |
|        |CT-003| Tester les plafonds des remboursement | La mise en place des donnée plafond | Plafond attendu est de 100$ |  Moyen |
|        |CT-004| Tester le bon fonctionnement des plafond | La mise en place le bon fonctionnements | Le pourcentage attendu est de 100% |  Moyen |
| ST-005 |CT-001| Tester le remboursement d’une réclamation dépendamment du type de contrat  | Les fichiers d'entrée Json comportent un client qui a reçu 100 $ de soin avec un remboursement de 90%, sans plafond |  Montant à rembourser est de 90$ | Haute  |
|        |CT-002| Tester le remboursement d’une réclamation qui a des plafonds pour chaque soin | Un client a reçu un soin de 1000$ remboursable à 40% avec une limite mensuelle de 300$ | Le remboursement calculé est de 300$ | Haute |
| ST-006 |CT-001| Tester le contenu de fichier statistique reinitialise  | Output de compter le nombre de reclamations ne fonction pas correctement |  Le fichier statistique réinitialisé devrait être remise à zéro correctement | Moyen  |
|        |CT-002| Tester Compter Reclamations Valide quant valeur de validation est false | Il faut que logiciel incrément le valeur de Validations dans chaque tour  | Le fonction compterReclamationsValide ne fonction pas correctement. | Moyen |
| ST-007 |CT-001| Tester la conversion de dollar qui est double à cent qui est integer  | Le montant est une chiffre de double avec deux nombre de décimale |  La conversion dollars à cent ne fonctionne pas! | Moyen  |
|        |CT-002| Tester multiplication de deux nombres | Il faut multiplier deux nombres et sortir en nombre entier. | Calcul multiplication n’est pas correct! | Moyen |
|        |CT-003| Tester la division de deux nombre entier | Il faut multiplier deux nombres et sortir en nombre entier. | Division de deux entiers ne sont pas corrects! |  Haute |
|        |CT-004| Tester la division de une nombre qui est négative | Il faut multiplier deux nombres et sortir en nombre entier negative. | Division de deux entiers ne sont pas corrects! |  Haute |
|        |CT-005| Tester la conversion d'un nombre integer en nombre double pour obtenir partie de cent d’une montant | Il faut retourner le partie cent en integer | Calcule de cent par obtenir Cent n'est pas correct! | Haute |
|        |CT-006| Tester la conversion d'un nombre double en nombre integer pour obtenir partie dollar d’une montant en integer | Il faut retourner le partie dollar de montant en integer | Calculer de dollar par obtenir Dollars n'est pas correct! | Haute |
|        |CT-007| Tester d'additionner deux montant en String | Il faut calculer en integer et retourner en String | Le calcule addition Montant n'est pas correc 6 |  Haute |
|        |CT-008| Tester de calculer nouveau plafond | Chaque fois qu’on fait un remboursement, il faut recalculer le plafond. | Le nouveau plafond est zéro quand le montant remboursé est plus grand que le plafond. |  Moyen |
|        |CT-009| Tester de  calculer Remboursement | Il faut prendre montant et plafond et calculer pourcentage de remboursement | calcule remboursement n'est pas correct quand le plafond est plus petit que montant remboursement ! |  Moyen |
| ST-008 |CT-001| Tester le pourcentage du numéro soin  | La mise en place de donnée pourcentage |  pourcentage attendu est de 60% | Moyen  |
|        |CT-002| Tester le pourcentage des soins entre 300 et 399 | La mise en place des donnée pourcentage des soins entre 300 et 399 | Pourcentage attendu est de 15% | Moyen |
|        |CT-003| Tester les plafonds des remboursement | La mise en place des donnée plafond | Plafond attendu est de 100$ |  Moyen |
|        |CT-004| Tester le bon fonctionnement des plafond | La mise en place le bon fonctionnements | Le plafond attendu est de 100$ |  Moyen |
| ST-009 |CT-001| Tester montant remboursé  | Retourner montant en String avec $  |  Le format attendu est “200.00$” | Haute  |
| ST-010 |CT-001| Tester numéro soin valide  | Retourner un bon numéro |  regarder si 400 fais parti des bon numéro de soin | Moyen  |
|        |CT-002| Tester le type de dossier | Retourner un bon type de dossier | Vérifier si A fait parti des type valide | Haute |
|        |CT-003| Tester numéro soin invalide | Retourner le mauvais numéro de soin | Vérifier si 900 fais parti de numéro invalide |  Moyen |
|        |CT-004| Tester montant | Retourner un mauvais type dossier | Vérifier si Z fais parti de numero dossier invalide |  Haute |
| ST-011 |CT-001| Tester si  numéro de dossier est en bonne forme  | Le dossier doit commencer par une lettre et ensuite 6 chiffres. |  Le numéro de dossier retourné par getDossier devrait être le bon. | Moyen  |
|        |CT-002| Tester la forme de date en bonne forme | La date doit avoir de forme : yyyy-MM-dd | La date de réclamation retournée par le getDateReclamation doit être la bonne. | Moyen |
| ST-012 |CT-001| Tester si numéro de soin  | Retourne True si nombre |  Numéro de soin devrait être nombre | Moyen  |
|        |CT-002| Tester la longueur | Retourner true si il a une bonne longueur | La longueur doit être 7 caractères | Moyen |
|        |CT-003| Tester Type contrat | Retourner le numéro de dossier invalid | La longueur invalide |  Haute |
|        |CT-004| Tester le mois | Retourner mois invalide | Vérifier si le mois 03 est valide |  Moyen |









