package mk.ukim.finki.consultations.services.impl;

import mk.ukim.finki.consultations.models.Professor;
import mk.ukim.finki.consultations.persistance.ProfessorRepository;
import mk.ukim.finki.consultations.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by user on 30.1.2018.
 */

@Service
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;

    @Autowired
    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public Professor findByLoginInfoID(Long id)
    {
        return this.professorRepository.findByLoginInfoId(id);
    }

}