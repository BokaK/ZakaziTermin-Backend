package mk.ukim.finki.consultations.services.impl;

import mk.ukim.finki.consultations.enumerations.SemesterType;
import mk.ukim.finki.consultations.models.Subject;
import mk.ukim.finki.consultations.persistance.SubjectRepository;
import mk.ukim.finki.consultations.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 30.1.2018.
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Subject> findAll() {
        return (List<Subject>) this.subjectRepository.findAll();
    }

    public List<Subject> findBySemesterType(SemesterType semesterType)
    {
        return this.subjectRepository.findBySemesterType(semesterType);
    }
}
