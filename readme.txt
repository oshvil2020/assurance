#Éxécution du code
Le fichier Refund.jar, situé à la racine de notre projet, peut être exécuté en appelant en paramètres le nom du fichier
Json d'entrée (input) et le fichier Json de sortie (output). via une commande de ce type:

java -jar Refund.jar inputfile.json output.json

Les 2 paramètres sont obligatoires.

#Ajout des statistique

On peut optionnellement ajouter le paramètre -S pour afficher à la console les statistiques du projet: le nombre de réclamations
valides, invalides ainsi que le nombre de chaque type de soin. Ces données sont également dans le fichier statistique.json
à la racine du projet.

Le paramètre -SR réinitialise le fichier statistique.

# Fonctionnement des classes

 - La classe main reçoit le fichier JSON d'entré et test d'abord le format du JSON,
 l'existence du fichier ainsi que le format des deux paramètres.
Des méthodes de la classe ValidationJson sont appelées pour ces différents tests.

- Si le fichier JSON est valide et contient les bons champs, le fichier JSON est lu et changé en objet JSON dans
la classe LectureJSON.

- On valide ensuite les données qui s'y trouvent dans la classe ValidationDonnees
qui utilise des méthodes de la classe Utile contenant différentes méthodes de tests.

- Une fois les données validées, on formatte les données dans la classe Formatage qui crée un objet de type
Client et un tableau
contenant les différents Soins.

- Dans Formattage, on crée également un objet de chaque type A, B C et D, contenant les informations sur les pourcentages et plafonds qui sont ajustés
selon les différents soins de la réclamations. On fait également le calcul du montant total des soins.

- Le calcul du montant du remboursement se fait via la classe CalculRemboursement qui est appelée dans chaque Soin.
Chaque montant appel la création d'un objet Monnaie qui appel des méthodes permettant d'effectuer les calculs sur des types
primitifs pour ne pas perdre de précision dans les montants.

- Dans les classes de Type (TypeA à TypeE) on récupère l'information des pourcentages de remboursements et des plafonds.
Ces informations sont utilisés dans le calcul du remboursement.

- La classe EcritureJson génère finalement un JSON de sortie contenant l'objet Client,le tableau d'objet Soins et le montant total
ou un message de données non valides si les données contiennent des erreurs de validation.

