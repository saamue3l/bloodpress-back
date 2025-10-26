# Flyway Database Migrations

Ce dossier contient les migrations de base de données gérées par Flyway.

## Convention de nommage

Les fichiers doivent suivre le format : `V{version}__{description}.sql`

- `V` : Préfixe obligatoire (en majuscule)
- `{version}` : Numéro de version (ex: 1, 2, 3, 1.1, 2.3)
- `__` : Deux underscores
- `{description}` : Description en snake_case

## Exemples

- `V1__init_schema.sql` - Création initiale du schéma
- `V2__add_notes_column.sql` - Ajout d'une colonne notes
- `V3__create_users_table.sql` - Création de la table users
- `V4__add_index_on_date.sql` - Ajout d'un index

## Bonnes pratiques

✅ **SQL standard** : Utilisez du SQL compatible H2 et PostgreSQL
✅ **Idempotent** : Les migrations doivent pouvoir échouer proprement
✅ **Testées** : Testez d'abord en dev avec H2
✅ **Atomiques** : Une migration = une modification logique
✅ **Jamais modifier** : Ne modifiez JAMAIS une migration déjà déployée

## Types supportés compatibles H2 et PostgreSQL

```sql
-- Nombres
INTEGER, BIGINT, DECIMAL, NUMERIC

-- Texte
VARCHAR(n), TEXT

-- Date/Heure
TIMESTAMP, DATE, TIME

-- Auto-increment
BIGSERIAL (PostgreSQL) / AUTO_INCREMENT (H2) → Utilisez BIGSERIAL
```

## Commandes utiles

```bash
# Voir l'état des migrations
./mvnw flyway:info

# Réparer une migration échouée
./mvnw flyway:repair

# Nettoyer la DB (DANGER - dev uniquement)
./mvnw flyway:clean
```
