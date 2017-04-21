package in.cit.apps.admin.model;

import java.util.List;

/**
 * Created by Prabhat on 4/18/2017.
 */
public class LoginData {
    private String userName;
    private String userCredential;
    private List<Integer> userGroupIds;

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

    public void setUserGroupIds(List<Integer> userGroupIds) {
        this.userGroupIds = userGroupIds;
    }

    public List<Integer> getUserGroupIds() {
        return userGroupIds;
    }
}
