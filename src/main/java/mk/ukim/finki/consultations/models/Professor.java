package mk.ukim.finki.consultations.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

/**
 * Created by user on 09.1.2018.
 */
@Entity
@Table(name="professor")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Professor extends BaseEntity {

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "loginInfo_id")
    private LoginInfo loginInfo;

    private String firstName;

    private String lastName;

    public LoginInfo getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
