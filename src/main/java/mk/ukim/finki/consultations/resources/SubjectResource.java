package mk.ukim.finki.consultations.resources;

import mk.ukim.finki.consultations.enumerations.SemesterType;
import mk.ukim.finki.consultations.models.Subject;
import mk.ukim.finki.consultations.services.SubjectService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by user on 30.1.2018.
 */

@RestController
@RequestMapping(value = "/subject", produces = "application/json")
public class SubjectResource implements ApplicationContextAware {

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SubjectService bean = applicationContext.getBean(SubjectService.class);
        System.out.println(bean);
    }

    private SubjectService service;

    @Autowired
    public SubjectResource(SubjectService service) {
        this.service = service;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Subject> getAll() {
        return service.findAll();
    }

    @RequestMapping(value="/{semester}", method=RequestMethod.GET)
    public List<Subject> getAllSubjectsBySemester(@PathVariable SemesterType semester) {

         return service.findBySemesterType(semester);
    }

}
