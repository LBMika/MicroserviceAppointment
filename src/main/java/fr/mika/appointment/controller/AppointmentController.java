package fr.mika.appointment.controller;

import fr.mika.appointment.entity.Appointment;
import fr.mika.appointment.dto.AppointmentDetailDTO;
import fr.mika.appointment.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/appointments")
public class AppointmentController {
    private AppointmentService service;

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    /**
     * Route to get all the appointment in DB
     * @return List of appointments
     */
    @GetMapping
    public List<Appointment> findAll() {
        return this.service.findAll();
    }

    /**
     * Route to get an appointment by its id
     * @param id Id of the appointment to get
     * @return An appointment ou null value if not presents
     */
    @GetMapping("{id}")
    public Appointment findById(@PathVariable String id) {
        return this.service.findById(id);
    }

    /**
     * Route to find all appointment in the future from current date
     * @return List of appointments
     */
    @GetMapping("/next")
    public List<Appointment> findNext() {
        return this.service.findNext();
    }

    /**
     * Route to get all future appointments from a patient by the patient's id
     * @param id The patient's id
     * @return List of appointments
     */
    @GetMapping("/patient/{id}")
    public List<Appointment> findAllAppointmentByPatientId(@PathVariable String id) {
        return this.service.findAllFutureAppointmentByPatientId(id);
    }

    /**
     * Route to get all future appointments from a nurse id by the nurse's id
     * @param id The nurse's id
     * @return List of appointments
     */
    @GetMapping("nurse/{id}")
    public List<Appointment> findAllAppointmentByNurseId(@PathVariable String id) {
        return this.service.findAllFutureAppointmentByNurseId(id);
    }

    /**
     * Route to get a more detailed info for an appointment
     * @param id The appointment's id
     * @return An AppointmentDetailDTO
     */
    @GetMapping("/detail/{id}")
    public AppointmentDetailDTO findDetails(@PathVariable String id) {
        return this.service.findDetails(id);
    }

    /**
     * Route to create an appointment in DB
     * @param appointment Body JSON of the appointment to add
     * @return The newly created appointment
     */
    @PostMapping
    public ResponseEntity<Appointment> save(@RequestBody Appointment appointment) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(appointment));
    }

    /**
     * Route to update an existing appointment
     * @param appointment Body JSON of the appointment to update (must contain appointment's id)
     * @return The modified appointment
     */
    @PutMapping
    public ResponseEntity<Appointment> updateById(@RequestBody Appointment appointment) {
        return ResponseEntity.ok(this.service.update(appointment));
    }

    /**
     * Route to remove an appointment in DB with its id in the body
     * @param appointment Body JSON of the appointment with only its id
     * @return
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(@RequestBody Appointment appointment) {
        this.service.deleteById(appointment.getId());
        return ResponseEntity.ok(true);
    }
}
