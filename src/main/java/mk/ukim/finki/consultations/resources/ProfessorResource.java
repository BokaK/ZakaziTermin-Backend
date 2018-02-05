package mk.ukim.finki.consultations.resources;

import mk.ukim.finki.consultations.models.LoginInfo;
import mk.ukim.finki.consultations.models.Professor;
import mk.ukim.finki.consultations.services.ProfessorService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by user on 31.1.2018.
 */
@RestController
@RequestMapping(value = "/professor/", produces = "application/json")
public class ProfessorResource implements ApplicationContextAware {

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ProfessorService bean = applicationContext.getBean(ProfessorService.class);
        System.out.println(bean);
    }

    private ProfessorService service;

    @Autowired
    public ProfessorResource(ProfessorService service) {
        this.service = service;
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Professor findByUsernameAndPassword(@Valid @RequestBody LoginInfo loginInfo) {
        return service.findByLoginInfoID(loginInfo.id);
    }
}