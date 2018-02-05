package mk.ukim.finki.consultations.services.impl;

import mk.ukim.finki.consultations.models.ProfessorSubject;
import mk.ukim.finki.consultations.persistance.ProfessorSubjectRepository;
import mk.ukim.finki.consultations.services.ProfessorSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 01.2.2018.
 */
@Service
public class ProfessorSubjectServiceImpl implements ProfessorSubjectService {

    private final ProfessorSubjectRepository professorSubjectRepository;

    @Autowired
    public ProfessorSubjectServiceImpl(ProfessorSubjectRepository professorSubjectRepository) {
        this.professorSubjectRepository = professorSubjectRepository;
    }

    public List<ProfessorSubject> findBySubjectId(Long id)
    {
        return this.professorSubjectRepository.findBySubjectId(id);
    }
}
