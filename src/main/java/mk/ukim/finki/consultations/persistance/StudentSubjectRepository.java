package mk.ukim.finki.consultations.persistance;

import mk.ukim.finki.consultations.models.StudentSubject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 09.1.2018.
 */
@Repository
public interface StudentSubjectRepository extends CrudRepository<StudentSubject, Long> {
}
