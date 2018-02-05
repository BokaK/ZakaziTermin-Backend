package mk.ukim.finki.consultations.resources;

import mk.ukim.finki.consultations.enumerations.AppointmentType;
import mk.ukim.finki.consultations.models.Appointment;
import mk.ukim.finki.consultations.services.AppointmentService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by user on 09.1.2018.
 */

@RestController
@RequestMapping(value = "/appointment", produces = "application/json")
public class AppointmentResource implements ApplicationContextAware {

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        AppointmentService bean = applicationContext.getBean(AppointmentService.class);
        System.out.println(bean);
    }

    private AppointmentService service;

    @Autowired
    public AppointmentResource(AppointmentService service) {
        this.service = service;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Appointment> getAll() {
        return service.GetAllAppointments();
    }

    @RequestMapping(value = "/student/{studentID}", method = RequestMethod.GET)
    public List<Appointment> getByStudentId(@PathVariable Long studentID) throws ParseException {
        List<Appointment> appointments = service.GetAllAppointmentsForStudent(studentID);

        for (Appointment a: appointments) {

            String oldstring = a.getDate() + " 00:00:00.0";
            LocalDateTime datetime = LocalDateTime.parse(oldstring, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"));

            String newstring = datetime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            a.setDate(newstring);
        }

        return appointments;
    }

    @RequestMapping(value = "/professor/{professorID}", method = RequestMethod.GET)
    public List<Appointment> getByProfessorId(@PathVariable Long professorID) {

        AppointmentType pending = AppointmentType.PENDING;
        List<Appointment> appointments = service.GetAllAppointmentsForProffesor(professorID, pending);
        for (Appointment a: appointments) {

            String oldstring = a.getDate() + " 00:00:00.0";
            LocalDateTime datetime = LocalDateTime.parse(oldstring, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"));

            String newstring = datetime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            a.setDate(newstring);
        }

        return appointments;

    }
    @RequestMapping(value = "/professor/approvedAppointments/{professorID}", method = RequestMethod.GET)
    public List<Appointment> getApprovedByProfessorId(@PathVariable Long professorID) {

        AppointmentType pending = AppointmentType.APPROVED;
        List<Appointment> appointments = service.GetAllAppointmentsForProffesor(professorID, pending);
        for (Appointment a: appointments) {

            String oldstring = a.getDate() + " 00:00:00.0";
            LocalDateTime datetime = LocalDateTime.parse(oldstring, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"));

            String newstring = datetime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            a.setDate(newstring);
        }

        return appointments;

    }

    @RequestMapping(value="/changeStatus/{appointmentId}/{status}", method=RequestMethod.GET)
    public void changeStatusOfAppointment(@PathVariable Long appointmentId, @PathVariable AppointmentType status) {

        Appointment appointment = service.findById(appointmentId);

        appointment.setAppointmentType(status);

        service.save(appointment);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@Valid @RequestBody Appointment appointment) {

        appointment.setAppointmentType(AppointmentType.PENDING);
        service.save(appointment);

    }

}