package mk.ukim.finki.consultations.services;

import mk.ukim.finki.consultations.enumerations.AppointmentType;
import mk.ukim.finki.consultations.models.Appointment;

import java.util.List;

/**
 * Created by user on 09.1.2018.
 */
public interface AppointmentService {

    List<Appointment> GetAllAppointmentsForProffesor(Long professorID, AppointmentType appointmentType);

    List<Appointment> GetAllAppointmentsForStudent(Long studentID);

    List<Appointment> GetAllAppointments();

    Appointment findById(Long id);

    void save(Appointment appointment);
}
