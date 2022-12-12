
# Architecture Ref. Card 03 
Spring Boot Application mit MariaDB Database

## Übersicht
Link zur Übersicht:<br/>
https://gitlab.com/bbwrl/m346-ref-card-overview

## Installation der benötigten Werkzeuge
Maven Tutorial for Beginners<br/>
https://www.simplilearn.com/tutorials/maven-tutorial

Installation von Maven<br/>
https://maven.apache.org/install.html

Apache Maven starten<br/>
https://maven.apache.org/run.html

Anleitung zur Installation von Maven und Java<br/>
https://www.digitalocean.com/community/tutorials/install-maven-mac-os

## Inbetriebnahme auf eigenem Computer

Projekt herunterladen<br/>
```git clone https://gitlab.com/bbwrl/m346-ref-card-03.git```
<br/>
```cd m346-ref-card-03```


### Projekt bauen und starten
Die Ausführung der Befehle erfolgt im Projektordner

**Datenbank mit Docker Umgebung starten**
Die Docker-Compose Datei enthält die Konfiguration für eine Postgres-
Datenbank und Adminer als Verwaltungsoberfläche.<br/>
```$ docker compose up```


**Builden des Projektes mit Maven**<br/>
```$ mvn package```

Das Projekt wird gebaut und die entsprechende JAR-Datei im Ordner Target erstellt (Artefakt).

**Umgebungsvariablen**<br/>
Der Benutzernamen und das Passwort müssen in den Umgebungsvariablen gesetzt werden.<br/>
```DB_USERNAME```<br/>
```DB_PASSWORD```

**Starten der App**<br/>
Die erstellte Datei kann nun direkt mit Java gestartet werden.<br/>
```$ java -DDB_USERNAME="jokedbuser" -DDB_PASSWORD="123456" -jar target/architecture-refcard-03-0.0.1-SNAPSHOT.jar```

Im Browser ist die App unter der URL http://localhost:8080 erreichbar.
