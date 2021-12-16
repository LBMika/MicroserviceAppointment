package fr.mika.appointment.repository;

import fr.mika.appointment.dto.NurseDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Repository
public class WebNurseRepository {
    private WebClient webClient;

    public WebNurseRepository(@Qualifier("nurseWebClient") WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<NurseDTO> getNurseById(String id) {
        return this.webClient.get()
                .uri("/nurses/"+id)
                .retrieve()
                .bodyToMono(NurseDTO.class);
    }
}
