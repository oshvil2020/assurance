## Style
**Langage utilisé** : Java

**IDE utilisé** : IntelliJ IDEA

**Standard de positionnement des accolades** : 
Function() {

}

* Pour les if/else ou les try/catch, nous les positionnons avec le else ou le catch
  sur la même ligne que l'accolade fermante du if ou du try.

**Positionnement des espaces** : 
* Pas d'espace dans les parenthèses.
Par exemple: for(int i = 0; i< this.tableauSoins.size(); i++)
* Espace suivant les if entre le if et la parenthèse. 

**Mise en page des commentaires** : 

* Un commentaire principal sera
placé au début de chaque classe pour expliquer sa fonctionnalité globale.
* Pendant que l'on travaille, on ajoute des TODO directement au-dessus des méthodes concernés avec
une explication de ce qui est à faire. Ces TODO devront être retirés pour la remise.
* Nous placons également des commentaires au-dessus des 5 classes types pour clarifier quel type correspond à quel soin
pour qu'il soit plus simple de suivre le code par la suite.

**Mise en page des tests** : 

* Chaque méthode de test ne contient qu'un seul assert.
* Chaque assert doit contenir un message expliquant la logique du test.
* Une Classe test existe pour chaque classe qu'il est possible de tester. Autrement dit une classe = une seule classe test.
* Les annotations BeforeEach, BeforeAll, AfterEach, AfterAll et Rule sont placés au début des classes tests.
* Les méthodes des classes tests respectent le même ordre que les méthodes de la classe qu'elle teste. 

**Logique d'encapsulation** :
* Pour s'assurer de respecter l'encapsulation des classes. Tous les attributs des classes
sont déclarés Private et les méthodes public. On modifie donc les propriétés via les getters et setters.

**Ordre d'apparition des éléments d'une classe** :

* Les attributs sont au début de chaque classe. 
* Les attributs private sont avant les attributs public.
* Le constructeur vient après les attributs
* Sous le constructeur, les méthodes logiques et arithmétiques.
* Sous les méthodes logiques et arithmétiques, les getters et les setters 
à la fin de chaque classe.


#### **Style d'écriture du code**:
camelCase.
Sauf pour les constantes qui sont SNAKE_CASE et en majuscule.

Ex: nomVariable;
NOM_CONSTANTE
#### **Langue des variables, attributs et méthodes** : 
Français, sauf pour le nom de la classe Main et les get/set comme ce sont des standards.
Chaque nom de méthode devra commencer par un verbe.

