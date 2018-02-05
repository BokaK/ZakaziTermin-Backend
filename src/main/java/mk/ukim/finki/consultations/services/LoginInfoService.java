package mk.ukim.finki.consultations.services;

import mk.ukim.finki.consultations.models.LoginInfo;

import java.util.List;

/**
 * Created by user on 30.1.2018.
 */
public interface LoginInfoService {

     LoginInfo findByEmailAndPassword(String email, String password);

     List<LoginInfo> findAll();
}
