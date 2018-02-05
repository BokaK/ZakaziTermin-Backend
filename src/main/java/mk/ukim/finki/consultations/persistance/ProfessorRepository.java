package mk.ukim.finki.consultations.persistance;

import mk.ukim.finki.consultations.models.Professor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 30.1.2018.
 */
@Repository
public interface ProfessorRepository extends CrudRepository<Professor, Long>{

    Professor findByLoginInfoId(Long id);
}
