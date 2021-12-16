# Description

Exercice de formation.

Réalisation d’un micro-service déplacement
Le micro-service devra posséder les routes suivantes :
- **findAll() (GET /appointments)** : Méthode permettant d’afficher tous les déplacements.
- **findById(id) (GET /appointments/id)** : Méthode affichant un déplacement par id.
- **findNext() (GET /appointments/next)**: Méthode permettant d’afficher uniquement les déplacements à venir.
- **findAllFutureAppointmentByPatientId(id) (GET /appointments/patients/id)** : Méthode permettant d’afficher tous les déplacements à venir d’un patient.
- **findAllFutureAppointmentByNurseId(id) (GET /appointments/nurses/id)** : Méthode permettant d’afficher tous les déplacements à venir d’un infirmier
- **findDetails(id) (GET /appointments/details/id)** : Méthode permettant d’afficher un déplacement avec les noms
prénom du patient et de l’infirmier
- **create(deplacement) (POST /appointments)** : Méthode permettant de créer un déplacement
- **update(deplacement) (PUT /appointments)** : Méthode permettant de modifier un déplacement
- **delete(id) (DELETE /appointments)** : Méthode permettant de supprimer un déplacement

Un déplacement se caractérise par une id, une idInfirmier, une idPatient, une
date et un coût.

**Exemple JSON** :
~~~json
{
    "patientId": "61b8b78fa4ea424df66de2dd",
    "nurseId": "61b8641aa9f34d1585aec498",
    "date": "2022-01-20T16:00:00.000+00:00",
    "price": 52.0
}
~~~
