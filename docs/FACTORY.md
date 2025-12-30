# Pattern Factory — Explication détaillée (Pizza Store)

## 1) Intention
Résoudre un problème simple : **où** et **comment** créer des objets, sans répandre `new` partout.

Objectifs :
- **découpler** le code “client” (commande) du code “création”
- **centraliser** les variations (types de pizzas, ingrédients…)
- permettre d’ajouter de nouveaux produits avec le minimum de modifications

Dans le livre, les 3 niveaux sont illustrés sur **Pizza Store** :
1) Simple Factory (un créateur utilitaire)
2) Factory Method (une méthode de création surchargée)
3) Abstract Factory (familles d’objets compatibles)

---

## 2) Problème (ce qu’on veut éviter)
Si `PizzaStore` fait :
- `if (type == "cheese") new CheesePizza()`
- `else if (...) new VeggiePizza()`
Alors :
- on modifie `PizzaStore` à chaque nouvelle pizza (**pas fermé à la modif**)
- le “process” (préparer/cuisson/découpe/boîte) est mélangé avec la création
- les variantes régionales (NY vs Chicago) deviennent ingérables

---

## 3) Solution A — Simple Factory
### Idée
Un objet **factory** centralise la création :

- `SimplePizzaFactory.createPizza(type)` retourne la bonne `Pizza`

### Effet
- `PizzaStore` ne connaît plus les classes concrètes
- mais le choix (if/switch) reste dans la factory

Dans ce projet, le package `simple/` illustre ce niveau.

---

## 4) Solution B — Factory Method (celle que le livre pousse)
### Idée
`PizzaStore` définit l’algorithme **stable** `orderPizza(type)` :
1. créer la pizza
2. préparer
3. cuire
4. découper
5. emballer

Mais la création est déléguée à une méthode “hook” :
- `createPizza(type)` (abstraite) → implémentée par les sous-classes

### Conséquence
- `NYPizzaStore` crée des `NYStyle...Pizza`
- `ChicagoPizzaStore` crée des `ChicagoStyle...Pizza`
- l’algorithme de commande reste identique

Dans ce projet :
- `PizzaStore` (abstraite) + `NYPizzaStore` + `ChicagoPizzaStore`

---

## 5) Solution C — Abstract Factory (familles d’ingrédients)
### Idée
Même type de pizza, mais ingrédients différents selon la région.

On définit une factory d’ingrédients :
- `PizzaIngredientFactory`
  - `createDough()`, `createSauce()`, `createCheese()`, etc.

Puis on fournit une implémentation par région :
- `NYPizzaIngredientFactory`
- `ChicagoPizzaIngredientFactory`

Les pizzas (ex: `CheesePizza`) demandent leurs ingrédients à la factory :
- `dough = ingredientFactory.createDough()`
- etc.

---

## 6) Lecture de la sortie console (preuve)
Le `PizzaTestDrive` :
- commande une pizza NY
- commande une pizza Chicago
On doit voir :
- le même flux “prepare/bake/cut/box”
- mais des descriptions différentes (style + ingrédients)

---

## 7) Cartographie du projet
Package :
`src/main/java/headfirst/designpatterns/factory/`

- **Factory Method**
  - `PizzaStore` (template method `orderPizza`)
  - `NYPizzaStore`, `ChicagoPizzaStore`
- **Produit**
  - `Pizza` (classe abstraite)
  - pizzas concrètes : `CheesePizza`, `ClamPizza` (avec ingrédients via Abstract Factory)
- **Abstract Factory**
  - `PizzaIngredientFactory` + implémentations NY/Chicago
  - ingrédients : `Dough`, `Sauce`, `Cheese`, `Clams`
- **Démo**
  - `PizzaTestDrive` (main)

---

## 8) Principes OO
- Encapsuler ce qui varie (création)
- Programmer vers une interface (factories, ingrédients)
- Préférer composition + délégation aux gros `if/switch`
