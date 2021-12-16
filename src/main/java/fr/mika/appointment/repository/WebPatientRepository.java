package fr.mika.appointment.repository;

import fr.mika.appointment.dto.PatientDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Repository
public class WebPatientRepository {
    private WebClient webClient;

    public WebPatientRepository(@Qualifier("patientWebClient") WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<PatientDTO> getPatientById(String id) {
        return this.webClient.get()
                .uri("/patients/"+id)
                .retrieve()
                .bodyToMono(PatientDTO.class);
    }
}
