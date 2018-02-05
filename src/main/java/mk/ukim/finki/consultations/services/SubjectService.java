package mk.ukim.finki.consultations.services;

import mk.ukim.finki.consultations.enumerations.SemesterType;
import mk.ukim.finki.consultations.models.Subject;

import java.util.List;

/**
 * Created by user on 30.1.2018.
 */
public interface SubjectService {

    List<Subject> findAll();

    List<Subject> findBySemesterType(SemesterType semesterType);
}
