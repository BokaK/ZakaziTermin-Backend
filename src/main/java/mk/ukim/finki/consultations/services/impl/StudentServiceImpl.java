package mk.ukim.finki.consultations.services.impl;

import mk.ukim.finki.consultations.models.Student;
import mk.ukim.finki.consultations.persistance.StudentRepository;
import mk.ukim.finki.consultations.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 30.1.2018.
 */
@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student findByLoginInfoID(Long ID)
    {
        return this.studentRepository.findByLoginInfoId(ID);
    }

    public List<Student> findAll()
    {
        return (List<Student>) this.studentRepository.findAll();
    }
}
