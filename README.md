# Factory (Head First Design Patterns) — Projet IntelliJ/Gradle

## Objectif
Illustrer les **patterns Factory** du livre *Head First Design Patterns* (chapitre “Factory”) via l’exemple **Pizza Store** :
- **Simple Factory** (centraliser la création)
- **Factory Method** (laisser les sous-classes décider)
- **Abstract Factory** (familles d’ingrédients)

## Exécuter
```bash
# (si gradlew absent) copier le wrapper depuis ton projet Strategy
# cp -a ~/Documents/projets_persos/patterns/strategy/strategy/gradlew .
# cp -a ~/Documents/projets_persos/patterns/strategy/strategy/gradlew.bat .
# cp -a ~/Documents/projets_persos/patterns/strategy/strategy/gradle .

chmod +x gradlew 2>/dev/null || true
./gradlew run
```

## Documentation
- `docs/FACTORY.md` : explication détaillée + cartographie du code.
