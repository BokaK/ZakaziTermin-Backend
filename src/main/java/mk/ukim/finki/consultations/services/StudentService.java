package mk.ukim.finki.consultations.services;

import mk.ukim.finki.consultations.models.Student;

import java.util.List;

/**
 * Created by user on 30.1.2018.
 */
public interface StudentService {


    Student findByLoginInfoID(Long ID);

    List<Student> findAll();
}
