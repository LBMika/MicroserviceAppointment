# Description

Exercice de formation.

Réalisation d’un micro-service déplacement
Le micro-service devra posséder les routes suivantes :
- **findAll()** : Méthode permettant d’afficher tous les déplacements
- **findOne(id)** : Méthode affichant un déplacement par id
- **findNext()** : Méthode permettant d’afficher uniquement les déplacements à
venir
- **findByPatient(idPatient)** : Méthode permettant d’afficher tous les déplacements à venir d’un patient
- **findByInfirmier(idInfirmier)** : Méthode permettant d’afficher tous les déplacements à venir d’un infirmier
- **findDetails(id)** : Méthode permettant d’afficher un déplacement avec les noms
prénom du patient et de l’infirmier
- **create(deplacement)** : Méthode permettant de créer un déplacement
- **update(deplacement)** : Méthode permettant de modifier un déplacement
- **delete(id)** : Méthode permettant de supprimer un déplacement

Un déplacement se caractérise par une id, une idInfirmier, une idPatient, une
date et un coût.
