package mk.ukim.finki.consultations.services.impl;

import mk.ukim.finki.consultations.models.LoginInfo;
import mk.ukim.finki.consultations.persistance.LoginInfoRepository;
import mk.ukim.finki.consultations.services.LoginInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 30.1.2018.
 */
@Service
public class LoginInfoServiceImpl implements LoginInfoService {

    private final LoginInfoRepository loginInfoRepository;

    @Autowired
    public LoginInfoServiceImpl(LoginInfoRepository loginInfoRepository) {
        this.loginInfoRepository = loginInfoRepository;
    }

    @Override
    public LoginInfo findByEmailAndPassword(String email, String password) {
        return this.loginInfoRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public List<LoginInfo> findAll() {
        return (List<LoginInfo>) this.loginInfoRepository.findAll();
    }
}
