package in.cit.apps.admin.data.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by Prabhat on 4/21/2017.
 */
@Embeddable
public class UserLoginId {
    @ManyToOne
    private UserEntity userId;

    @Column(name = "login_name", nullable = false)
    private String loginName;

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
