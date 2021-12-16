package fr.mika.appointment.service;


import fr.mika.appointment.dto.*;
import fr.mika.appointment.entity.Appointment;
import fr.mika.appointment.repository.AppointmentRepository;
import fr.mika.appointment.repository.WebNurseRepository;
import fr.mika.appointment.repository.WebPatientRepository;
import org.modelmapper.ModelMapper;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.List;

public class AppointmentService {
    private AppointmentRepository repository;
    private WebPatientRepository patientRepository;
    private WebNurseRepository nurseRepository;
    private ModelMapper mapper;

    public AppointmentService(AppointmentRepository repository, WebPatientRepository patientRepository,
                              WebNurseRepository nurseRepository, ModelMapper mapper) {
        this.repository = repository;
        this.patientRepository = patientRepository;
        this.nurseRepository = nurseRepository;
        this.mapper = mapper;
    }

    public List<Appointment> findAll() {
        return this.repository.findAll();
    }

    public Appointment findById(String id) {
        return this.repository.findById(id).orElse(null);
    }

    public Appointment save(Appointment appointment) {
        return this.repository.save(appointment);
    }

    public Appointment update(Appointment appointment) {
        return this.repository.save(appointment);
    }

    public void deleteById(String id) {
        this.repository.deleteById(id);
    }

    public List<Appointment> findNext() {
        return this.repository.findAllByDateAfter(new Date());
    }

    public List<Appointment> findAllFutureAppointmentByPatientId(String id) {
        return this.repository.findAllByPatientIdAndDateAfter(id, new Date());
    }

    public List<Appointment> findAllFutureAppointmentByNurseId(String id) {
        return this.repository.findAllByNurseIdAndDateAfter(id, new Date());
    }

    public AppointmentDetailDTO findDetails(String id) {
        // Get the appointment
        Appointment appointment = this.repository.findById(id).orElse(null);
        AppointmentDetailDTO result = null;
        if (appointment!=null) {
            // Get the patient's name
            Mono<PatientDTO> monoPatient = this.patientRepository.getPatientById(appointment.getPatientId());

            // AppointmentDetailDTO mapping
            result = this.mapper.map(appointment, AppointmentDetailDTO.class);
            PatientDTO patientDTO = monoPatient.block();
            result.setPatient(this.mapper.map(patientDTO, PatientNameDTO.class));
            result.setNurse(this.mapper.map(patientDTO.getNurse(), NurseNameDTO.class));
        }
        return result;
    }
}
