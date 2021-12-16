package fr.mika.appointment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppointmentDetailDTO {
    private PatientNameDTO patient;
    private NurseNameDTO nurse;
    private Date date;
    private float price;
}
