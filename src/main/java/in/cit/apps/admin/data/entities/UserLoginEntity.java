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
@Table(name = "user_login", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id"}))
public class UserLoginEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_generator")
    @SequenceGenerator(name = "user_id_generator", sequenceName = "user_login_seq", initialValue = 1, allocationSize = 10)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @Column(name = "login_name", nullable = false)
    private String loginName;

    @Column(name = "login_pwd", nullable = false)
    private String loginPwd;

    @Column(name = "status", nullable = false)
    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
