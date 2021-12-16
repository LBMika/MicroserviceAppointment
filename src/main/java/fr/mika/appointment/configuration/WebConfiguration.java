package fr.mika.appointment.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class WebConfiguration {
    @Value("${nurse.uri}")
    private String nurseUri;

    @Value("${patient.uri}")
    private String patientUri;

    @Bean
    public WebClient nurseWebClient() {
        return WebClient.builder()
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .baseUrl(nurseUri)
                .build();
    }

    @Bean
    public WebClient patientWebClient() {
        return WebClient.builder()
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .baseUrl(patientUri)
                .build();
    }
}
