package fr.mika.appointment.repository;

import fr.mika.appointment.entity.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;


public interface AppointmentRepository extends MongoRepository<Appointment, String> {
    public List<Appointment> findAllByDateAfter(Date date);
    List<Appointment> findAllByPatientIdAndDateAfter(String id, Date date);
    List<Appointment> findAllByNurseIdAndDateAfter(String id, Date date);
}
