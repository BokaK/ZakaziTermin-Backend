package mk.ukim.finki.consultations.persistance;

import mk.ukim.finki.consultations.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 30.1.2018.
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    Student findByLoginInfoId(Long id);
}
