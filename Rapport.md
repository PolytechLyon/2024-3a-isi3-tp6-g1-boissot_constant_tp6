# Compte Rendu du TP 1 : Patrons de Conceptions

Noms des étudiants du binôme : Aurélien Boissot et Céline Constant

## Exercices 1

_Quel patron de conception reflète ce modèle ? Identifiez le rôle de chaque de ces deux classes dans ce patron._

Le diagramme de classe présenté dans le sujet représente le pattern visiteur composite. Comme précisé dans le sujet, un véhicule est un objet mobile spécifique, tout comme ses différents composants.  Ainsi, la classe "Vehicle" représente le composite et l'interface "MobileObject" représente le Composant. De plus, la classe Wheel représente les feuilles. 

_Doit-on récrire la méthode `getVelocity()` ou la méthode `getMass()` pour la nouvelle classe ?_

Il n'est pas nécessaire de réimplémenter les méthodes `getVelocity()` et `getMass()` car on va profiter de l'implémentation de ces méthodes située dans la classe Vehicle. En effet, la classe TagAlongBike peut profiter de l'implémentation de ces méthodes car elle hérite de SimpleBike, qui hérite de Bike qui elle-même hérite de la classe Vehicle. Plus précisément, dans le constructeur de TagAlongBike, nous ajoutons un SimpleBike (représentant le vélo enfant) aux composants du vélo parent. De plus, les méthodes `getVelocity()` et `getMass()` de la classe Vehicle parcourent les différents composants à l'aide d'un itérateur. De ce fait, la vélocité et la masse du vélo enfant seront bien prises en compte grâce aux méthodes de Vehicle. 

## Exercices 2

_Quel patron de conception utilise la méthode getVelocity() pour parcourir les composants d'un véhicule ? Quel avantage apporte ce patron ?_

La méthode `getVelocity()` utilise le patron de conception itérateur afin de parcourir les composants d'un véhicule et de calculer la vélocité totale. Ce patron de conception nous permet de parcourir les différents composants de notre véhicule, sans se soucier du type de notre structure de données (Set, List...).

_Modifier la structure de donnée utilisée pour stocker les composants d'un véhicule de Set à List. Doit-on modifier la réalisation de la méthode getVelocity() ?_

Il n'est pas nécessaire de modifier l'implémentation de la méthode `getVelocity()` car comme indiqué précédemment, le patron de conception itérateur nous permet de parcourir les différents composants de notre véhicule sans se soucier du type de la structure de données contenant les différents composants. 

## Exercices 3

Pour implémenter le pattern Singleton, on ajoute une donnée membre statique et privée de type Clock. Le constructeur est privé afin que les autres classes ne puissent pas instancer la classe Clock. On ajoute ensuite une méthode publique et statique getClock() qui crée une instance de Clock lors du premier appel, et la stocke dans la donnée membre. Lors des appels suivants, on renvoie alors l'instance de Clock stockée dans la donnée membre.

## Exercices 4

Les classes `Bike` et `Wheel` n'appartiennent pas au même paquetage. `Bike` appartient au paquetage `cycling`, `Wheel` appartient au paquetage `transport`.

Il existe une dépendance cyclique entre ces deux classes. En effet, `Wheel` dispose d'une donnée membre de type `Bike`. Inversement, la classe `Vehicle` a une collection de type `MobileObject`. Or, la classe `Bike` hérite de la classe `Vehicle` et la classe `Wheel` hérite de la classe `MobileObject`. Ainsi, on a également une dépendance entre entre la classe `Bike` et `Wheel`.

Ainsi, les modifications d'un package est suscpetible d'impacter l'autre package. Les deux packages sont donc étroitement liés.

La classe `Wheel` dispose d'une donnée membre de type `Bike`, et utilise la méthode `getpush()` de la classe `Bike`.

La classe abstraite `Vehicle`, faisant partie du paquetage `transport`, déclare la méthode abstraite `getpush()` implémentée dans la classe `Bike`.

Ainsi, il suffit donc de déclarer une donnée membre de type `Vehicle` plutôt que `Bike`, et de modifier le type de paramètre de la méthode `getPush()`, afin de profiter de l'abstraction déjà mise en place, grâce au polymorphisme.

Avant modifications, nous avions le diagramme de classe suivant : 

![Diagramme de classe avant modifications](/images/ClassDiagram_EXO4_before.png)

Puis, après avoir apporté les modifications citées ci-dessus, nous obtenons le diagramme de classe suivant : 

![Diagramme de classe après modifications](/images/ClassDiagram_EXO4_after.png)

## Exercices 5

Nous avons donc implémenté le pattern Patron de méthode pour les classes associées au `NamedLogger`.

La classe `NamedLogger` réprésente la classe abstraite du design pattern, et `FileLogger` et `ConsoleLogger` sont les deux classes concrètes.

Dans la classe `NamedLogger` nous avons défini une méthode abstraite `output()` qui sera responsable de l'affichage du message. Cette méthode est implémentée dans les classes `FileLogger` et `ConsoleLogger` afin de respectivement afficher le message dans un fichier et dans la console.

La méthode `log()` de la classe `NamedLogger` fait donc appel à la méthode `output()` des classes concrètes.

## Exercices 6

Nous avons implémenté le patron de conception "méthode de fabrique" en créant une nouvelle classe `LoggerFactory` dont le rôle est de renvoyer une instance de la classe `ConsoleLogger`. Ainsi, lorsque l'on veut créer une instance d'une réalisation de l'interface `Logger`, on appelle alors la méthode `CreateLogger()` de `LoggerFactory`. Dans toutes les classes on utilise donc uniquement la classe `ConsoleLogger` pour écrire un message dans les journaux.

![Diagramme de classe de l'exercice 6](/images/ClassDiagram_EXO6.png)


Ici, nous pouvons instancier plusieurs fois la classe `LoggerFactory`. En effet, à chaque appel de la méthode `CreateLogger()`, on crée une nouvelle instance. Contrairement au patron singleton où l'on utilise une instance unique.

## Exercices 7

Nous avons créé une classe `LoggerDecorator` implémentant l'interface `Logger`. Implémenter l'interface permet de décorer toutes les classe héritant elles-mêmes de l'interface (ici, `ConsoleLogger` et `FileLogger`). Cette classe permet d'apporter de la modularité supplémentaire au code puisque cela permet de facilement implémenter de nouveaux décorateurs par la suite.

La classe `TimestampedLoggerDecorator`, héritant de la classe `LoggerDecorator` permet ainsi d'ajouter la date et l'heure au début d'un message.

![Diagramme de classe de l'exercice 7](/images/ClassDiagram_EXO7.png)

## Exercices 8

La classe `Context` suit le patron de conception "Facade" vis-à-vis de l'outil `ServiceLoader`. En effet, celle-ci propose une interface offrant un accès simplifié aux fonctionnalités proposées par la classe `ServiceLoader`.

Il est possible d'avoir plusieurs lignes dans le fichier `fr.polytech.sim.cycling.Bike`. Chaque ligne correspond à une sous-classe que nous devons injecter lorsque l'on veut instancier un objet de type `Bike` par injection de dépendance.

## Exercice 9

Le type de renvoie de la méthode `injectAll()` est `Iterator<T>`, c'est-à-dire un itérateur sur le type `T` passé en paramètre.

Cette méthode propose le patron de conception "Itérateur" pour parcourir tous les objets d'un certain type.