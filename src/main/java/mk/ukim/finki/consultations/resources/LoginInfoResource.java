package mk.ukim.finki.consultations.resources;

import mk.ukim.finki.consultations.models.LoginInfo;
import mk.ukim.finki.consultations.services.LoginInfoService;
import mk.ukim.finki.consultations.services.ProfessorService;
import mk.ukim.finki.consultations.services.StudentService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by user on 30.1.2018.
 */
@RestController
@RequestMapping(value = "/loginInfo", produces = "application/json")
public class LoginInfoResource implements ApplicationContextAware {

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        LoginInfoService bean = applicationContext.getBean(LoginInfoService.class);
        System.out.println(bean);
    }

    private LoginInfoService service;

    private ProfessorService professorService;

    private StudentService studentService;

    @Autowired
    public LoginInfoResource(LoginInfoService service, ProfessorService professorService, StudentService studentService) {

        this.service = service;
        this.professorService = professorService;
        this.studentService = studentService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public LoginInfo findByEmailAndPassword(@Valid @RequestBody LoginInfo user) {
       return service.findByEmailAndPassword(user.getEmail(), user.getPassword());
//
//        if(tmp.getUserType() == UserType.PROFESSOR)
//        {
//           return this.professorService.findByUsername(tmp.getUsername());
//        }
//        else
//        {
//            return this.studentService.findByUsername(tmp.getUsername());
//        }
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<LoginInfo> getAll() {
        return service.findAll();
    }

}
