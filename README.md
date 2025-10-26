# BloodPress

Application de suivi de tension artérielle avec Spring Boot et base de données H2 locale.

## Prérequis

- Java 17 ou supérieur
- Maven (ou utiliser le wrapper `mvnw` inclus)

## Démarrage rapide

### Windows
```bash
./mvnw.cmd spring-boot:run
```

### Linux/Mac
```bash
./mvnw spring-boot:run
```

L'application démarre sur `http://localhost:8080`

La base de données H2 est automatiquement créée dans `./data/bloodpress.mv.db`

## Endpoints

### Health Check
```bash
curl http://localhost:8080/api/health
```

### Blood Pressure Readings

**Créer une mesure**
```bash
curl -X POST http://localhost:8080/api/bloodPressureReadings \
  -H "Content-Type: application/json" \
  -d '{
    "userId": "test_user",
    "date": "2025-10-23T14:30:00",
    "systolic": 120,
    "diastolic": 80,
    "pulse": 72
  }'
```

**Lister toutes les mesures**
```bash
curl http://localhost:8080/api/bloodPressureReadings
```

**Récupérer une mesure par ID**
```bash
curl http://localhost:8080/api/bloodPressureReadings/1
```

**Modifier une mesure**
```bash
curl -X PUT http://localhost:8080/api/bloodPressureReadings/1 \
  -H "Content-Type: application/json" \
  -d '{
    "userId": "test_user",
    "date": "2025-10-23T14:30:00",
    "systolic": 125,
    "diastolic": 82,
    "pulse": 74
  }'
```

**Supprimer une mesure**
```bash
curl -X DELETE http://localhost:8080/api/bloodPressureReadings/1
```

## Console H2

Accéder à la base de données : `http://localhost:8080/h2-console`

- **JDBC URL:** `jdbc:h2:file:./data/bloodpress`
- **Username:** `sa`
- **Password:** (vide)

## Stack Technique

- **Java 17** - Langage de programmation
- **Spring Boot 3.5.6** - Framework web
- **H2 Database** - Base de données embarquée (stockage fichier local)
- **Flyway** - Migrations de base de données
- **Maven** - Gestion des dépendances


