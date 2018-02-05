package mk.ukim.finki.consultations.persistance;

import mk.ukim.finki.consultations.enumerations.SemesterType;
import mk.ukim.finki.consultations.models.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by user on 30.1.2018.
 */
@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long> {

    List<Subject> findBySemesterType(SemesterType semesterType);
}
