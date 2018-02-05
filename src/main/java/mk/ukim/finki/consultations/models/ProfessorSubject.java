package mk.ukim.finki.consultations.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import javax.persistence.*;

/**
 * Created by user on 09.1.2018.
 */
@Entity
@Table(name="professor_subject")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfessorSubject extends BaseEntity{

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
