package in.cit.apps.admin.data.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Prabhat on 4/20/2017.
 */
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
    @Id
    @Column(name = "user_id")
    private String userId;
    @Column(name = "user_fname", nullable = false)
    private String userFName;
    @Column(name = "user_lname")
    private String userLName;
    @Column(name = "sex", nullable = false)
    private Character sex;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "phone", nullable = false)
    private Long phone;
    @Column(name = "status", nullable = false)
    private Boolean status;

    @OneToMany(mappedBy = "id")
    private List<UserRoleEntity> userRole;

    @OneToMany(mappedBy = "id")
    private List<UserLoginEntity> userLogin;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserFName() {
        return userFName;
    }

    public void setUserFName(String userFName) {
        this.userFName = userFName;
    }

    public String getUserLName() {
        return userLName;
    }

    public void setUserLName(String userLName) {
        this.userLName = userLName;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Boolean getActive() {
        return status;
    }

    public void setActive(Boolean status) {
        status = status;
    }

    public List<UserRoleEntity> getUserRole() {
        return userRole;
    }

    public void setUserRole(List<UserRoleEntity> userRole) {
        this.userRole = userRole;
    }

    public List<UserLoginEntity> getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(List<UserLoginEntity> userLogin) {
        this.userLogin = userLogin;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId='" + userId + '\'' +
                ", userFName='" + userFName + '\'' +
                ", userLName='" + userLName + '\'' +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", status=" + status +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (!userId.equals(that.userId)) return false;
        if (!userFName.equals(that.userFName)) return false;
        if (userLName != null ? !userLName.equals(that.userLName) : that.userLName != null) return false;
        if (!sex.equals(that.sex)) return false;
        if (!email.equals(that.email)) return false;
        if (!phone.equals(that.phone)) return false;
        return status.equals(that.status);

    }

    @Override
    public int hashCode() {
        int result = userId.hashCode();
        result = 31 * result + userFName.hashCode();
        result = 31 * result + (userLName != null ? userLName.hashCode() : 0);
        result = 31 * result + sex.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + status.hashCode();
        return result;
    }
}
