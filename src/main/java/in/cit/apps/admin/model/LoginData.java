package in.cit.apps.admin.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Prabhat on 4/18/2017.
 */
public class LoginData {
    @Size(min = 4, max = 16, message = "{msg.size.username}")
    private String userName;

    @Size(min = 3, max = 16, message = "{msg.size.userpwd}")
    private String userCredential;

    private Integer groupValue;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCredential() {
        return userCredential;
    }

    public void setUserCredential(String userCredential) {
        this.userCredential = userCredential;
    }

    public Integer getGroupValue() {
        return groupValue;
    }

    public void setGroupValue(Integer groupValue) {
        this.groupValue = groupValue;
    }
}
