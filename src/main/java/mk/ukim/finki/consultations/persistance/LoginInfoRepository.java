package mk.ukim.finki.consultations.persistance;

import mk.ukim.finki.consultations.models.LoginInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 30.1.2018.
 */
@Repository
public interface LoginInfoRepository extends CrudRepository<LoginInfo, Long> {

    LoginInfo findByEmailAndPassword(String email, String password);
}
