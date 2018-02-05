package mk.ukim.finki.consultations.persistance;

import mk.ukim.finki.consultations.enumerations.AppointmentType;
import mk.ukim.finki.consultations.models.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by user on 09.1.2018.
 */
@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

    List<Appointment> findByProfessorIdAndAppointmentType(Long professorID, AppointmentType appointmentType);

    List<Appointment> findByStudentId(Long studentID);

}
