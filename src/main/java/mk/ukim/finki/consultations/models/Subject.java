package mk.ukim.finki.consultations.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import mk.ukim.finki.consultations.enumerations.SemesterType;

import javax.persistence.*;

/**
 * Created by user on 09.1.2018.
 */
@Entity
@Table(name="subject")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Subject extends BaseEntity {

    private String description;

    @Enumerated(EnumType.STRING)
    private SemesterType semesterType;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SemesterType getSemesterType() {
        return semesterType;
    }

    public void setSemesterType(SemesterType semesterType) {
        this.semesterType = semesterType;
    }
}
