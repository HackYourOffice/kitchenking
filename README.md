<img align="start" position="right" height="260" src="https://user-images.githubusercontent.com/33748912/32958939-3e8b1ec0-cbc0-11e7-927b-108452c6218c.png">

## Idee: 
Über einen Gamificationansatz soll versucht werden Kollegen dazu zu bringen eine Küche ohne Küchendienst in Ordnung zu halten.

Dazu sollte es in einer ersten Ausbaustufe so sein, dass man auf einem Android-Device in der Küche sich per NFC authentifiziert und dann eine Aktion auswählt, die man durchgeführt hat. 

Auf Grund einer Punkteverteilung je Aktion z.B.:
* Sein Geschirr einräumt: 1 Punkt
* Die Spülmaschine ausräumt: 5 Punkte
* Die Spülmaschine einräumt: 7 Punkte
*	Den Boden fegt: 3 Punkte
*	Die Theke/Arbeitsplatte wischt: 2 Punkte
*	Sein Geschirr auf die Spülmaschine stellt: -2 Punkte
*	… gerne auch noch mehr Punkte
*	Automatisch vom System: 2 Punkte für ein Voting

bekommt man Punkte zugeschrieben und wird dann mit den meisten Punkten zum KitchenKing.

## Funktionalitäten
* Identifikation per NFC
 * Sollte der User noch nicht bekannt sein, wird ein Name abgefragt.
* Übersicht der Top-3 KitchenKings
* Durchführung einer Aktion
* Punkteübersicht
* Automatischer Logout

## Ideen für weitere Funktionalitäten
* Mit der Identifikation per NFC wird ein Foto geschossen
* Belohnungssystem:
 * Musikwunsch per Sprachsteuerung abgeben
 * Es erscheint ein Random-Katzenfoto/Witz-des-Tages/...
 * Veröffentlichung der Aktionen und Zwischenstände in unterschiedliche Kanäle (Mattermost, Twitter, Monitoring, ...)
* Statistik über Aktionen
* Kundenkonto
 * Persönliche Statistik
 * Aktionshistorie
* Aktionen erweiteren, gruppieren, ...
* Umgekehrte Reihenfolge auf der Startseite
* Änderungen am Punktesystem
 * Berücksichtigung des eingeräumten/ausgeräumten Gewichts 
 * Höhe der Punkte zu je nach Tageszeit höher/niederiger
 * x-fach Punkte zu belibieger Zeit
 * x-Fach Punkte bei besonderen Events (z.B. Sprintwechsel)
