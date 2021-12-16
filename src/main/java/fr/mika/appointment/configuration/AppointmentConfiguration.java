package fr.mika.appointment.configuration;

import fr.mika.appointment.repository.AppointmentRepository;
import fr.mika.appointment.repository.WebNurseRepository;
import fr.mika.appointment.repository.WebPatientRepository;
import fr.mika.appointment.service.AppointmentService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppointmentConfiguration {
    @Bean
    public AppointmentService appointmentService(AppointmentRepository repository, WebPatientRepository patientRepository,
                                                 WebNurseRepository nurseRepository, ModelMapper mapper) {
        return new AppointmentService(repository, patientRepository, nurseRepository, mapper);
    }
}
