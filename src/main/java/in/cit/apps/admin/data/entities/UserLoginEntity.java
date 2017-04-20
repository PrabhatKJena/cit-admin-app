package in.cit.apps.admin.data.entities;

import javax.persistence.*;

/**
 * Created by Prabhat on 4/20/2017.
 */
@Entity
@Table(name = "users")
public class UserLoginEntity extends BaseEntity {
    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "login_name", nullable = false)
    private String loginName;

    @Column(name = "login_pwd", nullable = false)
    private String loginPwd;

    @ManyToOne(targetEntity = UserEntity.class)
    private UserGroupsEntity userGroupsEntity;

    private Boolean status;

}
