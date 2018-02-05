package mk.ukim.finki.consultations.resources;

import mk.ukim.finki.consultations.models.LoginInfo;
import mk.ukim.finki.consultations.models.Student;
import mk.ukim.finki.consultations.services.StudentService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by user on 31.1.2018.
 */
@RestController
@RequestMapping(value = "/student", produces = "application/json")
public class StudentResource implements ApplicationContextAware {

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        StudentService bean = applicationContext.getBean(StudentService.class);
        System.out.println(bean);
    }

    private StudentService service;

    @Autowired
    public StudentResource(StudentService service)
    {
        this.service = service;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Student> findAll()
    {
        return (List<Student>) service.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Student findByUsernameAndPassword(@Valid @RequestBody LoginInfo loginInfo) {
        return service.findByLoginInfoID(loginInfo.id);
    }
}