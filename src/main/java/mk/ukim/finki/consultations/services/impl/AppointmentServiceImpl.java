package mk.ukim.finki.consultations.services.impl;

import mk.ukim.finki.consultations.enumerations.AppointmentType;
import mk.ukim.finki.consultations.models.Appointment;
import mk.ukim.finki.consultations.persistance.AppointmentRepository;
import mk.ukim.finki.consultations.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 09.1.2018.
 */
@Service
public class AppointmentServiceImpl implements AppointmentService{

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> GetAllAppointments()
    {
        return (List<Appointment>) appointmentRepository.findAll();
    }

    public List<Appointment> GetAllAppointmentsForProffesor(Long professorID,  AppointmentType appointmentType)
    {
        return appointmentRepository.findByProfessorIdAndAppointmentType(professorID, appointmentType);
    }

    public List<Appointment> GetAllAppointmentsForStudent(Long studentID)
    {
        return appointmentRepository.findByStudentId(studentID);
    }

    public Appointment findById(Long id)
    {
        return appointmentRepository.findOne(id);
    }

    public void save(Appointment appointment)
    {
        appointmentRepository.save(appointment);
    }
}
