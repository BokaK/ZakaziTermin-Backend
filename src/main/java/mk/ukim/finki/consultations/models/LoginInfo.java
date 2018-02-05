package mk.ukim.finki.consultations.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import mk.ukim.finki.consultations.enumerations.UserType;

import javax.persistence.*;

/**
 * Created by user on 09.1.2018.
 */
@Entity
@Table(name="loginInfo")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginInfo extends BaseEntity{


    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserType userType;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
