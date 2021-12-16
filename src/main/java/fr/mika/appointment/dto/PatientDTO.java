package fr.mika.appointment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PatientDTO {
    private String firstname;
    private String lastname;
    private NurseDTO nurse;
}
