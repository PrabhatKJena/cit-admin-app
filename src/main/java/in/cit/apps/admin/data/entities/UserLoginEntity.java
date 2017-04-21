package in.cit.apps.admin.data.entities;

import javax.persistence.*;

/**
 * Created by Prabhat on 4/20/2017.
 * <p>
 * CREATE TABLE user_login (
 * user_id    VARCHAR2(8)  NOT NULL,
 * login_name VARCHAR2(16) NOT NULL,
 * login_pwd  VARCHAR2(16) NOT NULL,
 * status     NUMBER(1)    NOT NULL,
 * create_ts  DATE         NOT NULL,
 * updated_ts DATE         NOT NULL
 * );
 */
@Entity
@Table(name = "user_login")
public class UserLoginEntity extends BaseEntity {
    @EmbeddedId
    private UserLoginId id;

    @Column(name = "login_pwd", nullable = false)
    private String loginPwd;

    @ManyToOne(targetEntity = UserEntity.class)
    private UserGroupsEntity userGroupsEntity;

    @Column(name = "status", nullable = false)
    private Boolean status;

    public UserLoginId getId() {
        return id;
    }

    public void setId(UserLoginId id) {
        this.id = id;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public UserGroupsEntity getUserGroupsEntity() {
        return userGroupsEntity;
    }

    public void setUserGroupsEntity(UserGroupsEntity userGroupsEntity) {
        this.userGroupsEntity = userGroupsEntity;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
