# Compte Rendu du TP 1 : Patrons de Conceptions

Noms des étudiants du binôme : Aurélien Boissot et Céline Constant

## Exercices 1

Quel patron de conception reflète ce modèle ? Identifiez le rôle de chaque de ces deux classes dans ce patron.

Le diagramme de classe présenté dans le sujet représente le pattern visiteur composite. Comme précisé dans le sujet, un véhicule est un objet mobile spécifique, tout comme ses différents composants.  Ainsi, la classe "Vehicle" représente le composite et l'interface "MobileObject" représente le Composant. De plus, la classe Wheel représente les feuilles. 

Doit-on récrire la méthode `getVelocity()` ou la méthode `getMass()` pour la nouvelle classe ?

Il n'est pas nécessaire de réimplémenter les méthodes `getVelocity()` et `getMass()` car on va profiter de l'implémentation de ces méthodes située dans la classe Vehicle. En effet, la classe TagAlongBike peut profiter de l'implémentation de ces méthodes car elle hérite de SimpleBike, qui hérite de Bike qui elle-même hérite de la classe Vehicle. Plus précisément, dans le constructeur de TagAlongBike, nous ajoutons un SimpleBike (représentant le vélo enfant) aux composants du vélo parent. De plus, les méthodes `getVelocity()` et `getMass()` de la classe Vehicle parcourent les différents composants à l'aide d'un itérateur. De ce fait, la vélocité et la masse du vélo enfant seront bien prises en compte grâce aux méthodes de Vehicle. 

## Exercices 2

Quel patron de conception utilise la méthode getVelocity() pour parcourir les composants d'un véhicule ? Quel avantage apporte ce patron ?

La méthode `getVelocity()` utilise le patron de conception itérateur afin de parcourir les composants d'un véhicule et de calculer la vélocité totale. Ce patron de conception nous permet de parcourir les différents composants de notre véhicule, sans se soucier du type de notre structure de données (Set, List...).

Modifier la structure de donnée utilisée pour stocker les composants d'un véhicule de Set à List. Doit-on modifier la réalisation de la méthode getVelocity() ?

Il n'est pas nécessaire de modifier l'implémentation de la méthode `getVelocity()` car comme indiqué précédemment, le patron de conception itérateur nous permet de parcourir les différents composants de notre véhicule sans se soucier du type de la structure de données contenant les différents composants. 



## Exercices 3

## Exercices 4

## Exercices 5

## Exercices 6

## Exercices 7

## Exercices 8


