package mk.ukim.finki.consultations.services;

import mk.ukim.finki.consultations.models.Professor;

/**
 * Created by user on 30.1.2018.
 */
public interface ProfessorService {

    Professor findByLoginInfoID(Long ID);
}
