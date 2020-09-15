Ajouter un XSD dans jaxb-xsd-to-java/src/main/xsd pour générer les classes correspondant à la description.

Une fois les classes java généré, décommanter le test unitaire /jaxb-xsd-to-java/src/test/java/fr/pantheonsorbonne/ufr27/miage/ExoTest.java

et faites en sorte qu'il passe au vert

1. Une université dépend de plusieurs tutelles, qui ont un nom, un ministre et une année de création
2. une université contient plusieurs facultés, qui ont un numéro identifiant de la forme "UFRXX" ou XX est un nombre compris entre 01 et 99 et un directeur
3. au sein d'une faculté, on trouve plusieurs filières, qui ont toutes un directeurs et un nom 
4. au sein des filières, on trouve a minima 1 parcours, composé d'au moins 1 diplome de type L, M ou D, ainsi qu'un directeur de formation.