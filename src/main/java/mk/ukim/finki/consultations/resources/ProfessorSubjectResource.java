package mk.ukim.finki.consultations.resources;

import mk.ukim.finki.consultations.models.ProfessorSubject;
import mk.ukim.finki.consultations.services.ProfessorService;
import mk.ukim.finki.consultations.services.ProfessorSubjectService;
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
 * Created by user on 01.2.2018.
 */
@RestController
@RequestMapping(value = "/professorSubject", produces = "application/json")
public class ProfessorSubjectResource implements ApplicationContextAware{

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ProfessorService bean = applicationContext.getBean(ProfessorService.class);
        System.out.println(bean);
    }

    private ProfessorService professorService;

    private ProfessorSubjectService professorSubjectService;

    @Autowired
    public ProfessorSubjectResource(ProfessorService service, ProfessorSubjectService professorSubjectService) {
        this.professorService = service;
        this.professorSubjectService = professorSubjectService;
    }

    @RequestMapping(value="/{subjectId}", method=RequestMethod.GET)
    public List<ProfessorSubject> changeStatusOfAppointment(@PathVariable Long subjectId) {

        return professorSubjectService.findBySubjectId(subjectId);
    }
}
