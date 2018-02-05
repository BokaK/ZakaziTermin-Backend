package mk.ukim.finki.consultations.services;

import mk.ukim.finki.consultations.models.ProfessorSubject;

import java.util.List;

/**
 * Created by user on 01.2.2018.
 */
public interface ProfessorSubjectService {

    List<ProfessorSubject> findBySubjectId(Long id);
}
