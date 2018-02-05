package mk.ukim.finki.consultations.persistance;

import mk.ukim.finki.consultations.models.ProfessorSubject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by user on 09.1.2018.
 */
@Repository
public interface ProfessorSubjectRepository extends CrudRepository<ProfessorSubject, Long> {

    List<ProfessorSubject> findBySubjectId(Long id);
}
