# Documentation utilisateur-Logiciel de remboursement de réclamations d'assurance de soins de santé

### Introduction

L'objectif de remboursement des réclamations d'assurances de soins de santé a pour but de faciliter
le processus de remboursement des réclamations soumises pas les clients de notre entreprise.
Il permettra de traiter les réclamations en fonction de contrats d'assurance souscrits par les clients.

### Utilisation du logiciel

Comme il est conçu pour être utilisé via une application web, le logiciel de remboursement de
réclamations d'assurances de soins de santé n'a pas d'interface utilisateur directe. Pour lancer
le programme, il est donc essentiel de spécifier les paramètres suivants :

`java -jar Refund.jar inputfile.json ¸output.json`

* `input.json`: Fichier d'entrée, en format JSON, contenant les informations sur les réclamations à traiter.
* `output.json`: Fichier de sortie, en format JSON, contenant les informations sur les remboursements à effectuer.

### Structure du fichier d'entrée

Le fichier d'entrée doit être au format JSON et doit contenir les informations suivantes :

* `dossier`: Numéro de dossier (exemple A526485 premiere lettre comme Type de contrat et le reste le numeri de de client).
* `mois`: Mois et année de la réclamation au format "AAAA-MM" (chaîne de caractères).
* `reclamations`: Liste des réclamations soumises par le client. Chaque réclamation est définie par les champs suivants :
  * `soin`: Code du soin (entier).
  * `date`: Date de la réclamation au format "AAAA-MM-JJ" (chaîne de caractères).
  * `montant`: Montant de la réclamation (chaîne de caractères au format "XXX.XX$").

Voici un exemple de fichier d'entrée :

{
 "dossier": "A100323",
 "mois": "2022-01",
 "reclamations": [
 {
 "soin": 100,
 "date": "2022-01-11",
 "montant": "234.00$"
 }
 ]
}

### Structure du fichier

Le fichier de sortie généré par le logiciel aura la structure suivante :

* `dossier` : numero de dossier de client
* `mois` : le mois pour lequel les remboursements ont été calculés
* `remboursements` : une liste des remboursements calculés pour chaque réclamation
  * `soin` : le numéro de soin correspondant à la réclamation
  * `date` : la date de la réclamation au format "AAAA-MM-JJ"
  * `montant` : le montant remboursé pour cette réclamation au format "XXX.XX$"
* `total` : le total des remboursements de soins effectués du mois

Voici un exemple de fichier de sortie :

{
 "dossier": "A100323",
 "mois": "2022-01",
 "remboursements": [
 {
 "soin": 175,
 "date": "2022-01-15",
 "montant": "65.00$"
 },
 {
 "soin": 175,
 "date": "2022-01-17",
 "montant": "5.00$"
 }
 ],
 "total": "7.00$"
}

### Statistiques

Le logiciel accumule des statistiques lors de chaque exécution et les conserve dans un fichier.
Le format du fichier peut être de la nature que vous voulez (texte, JSON, XML ou autre).

Les statistiques suivantes sont calculées à chaque exécution :

* Le nombre de réclamations valides traitées
* Le nombre de réclamations rejetées
* Le nombre de soins déclarés pour chaque type de soin (ne concerne que les réclamations valides)

Pour produire la liste des statistiques, l'utilisateur doit exécuter le logiciel en spécifiant
l'option "-S" et les statistiques seront affichées à la console. Par exemple :

`java -jar Refund -S`

L'option "-SR" réinitialise les statistiques, c'est-à-dire les remet à 0. Un message de
confirmation est affiché à la console.

`java -jar Refund -SR`

### Plan de tests

Un plan de tests doit être rédigé pour vérifier chaque exigence fonctionnelle du projet.
Le plan de tests doit suivre le format vu en atelier et être disponible dans un fichier
`planDeTests.md` situé a la racine du projet

### Parametres du programme

Le programme doit être exécuté à partir de la console en spécifiant deux arguments :

1. Le chemin du fichier d'entrée au format JSON
2. Le chemin du fichier de sortie au format JSON

### Données invalides

Si les données d'entrée ne sont pas valides, l'application générera le fichier de sortie suivant :

{
 "message": "Données invalides"
}

### Conclusion

En conclusion, nous sommes convaincus que cette documentation vous a fourni les informations
nécessaires pour utiliser notre logiciel de remboursement de réclamations d'assurance santé.
Si vous rencontrez des difficultés ou si vous avez des questions, n'hésitez pas à contacter
notre service d'assistance, qui se fera un plaisir de vous aider.

