package in.cit.apps.admin.data.entities;

import javax.persistence.*;

/**
 * Created by Prabhat on 4/21/2017.
 * <p>
 * user_id    VARCHAR2(8) NOT NULL,
 * group_id  NUMBER(3)   NOT NULL,
 * is_active  NUMBER(1),
 * create_ts  DATE        NOT NULL,
 * updated_ts DATE        NOT NULL
 */
@Entity
@Table(name = "user_role", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "group_id"}))
public class UserRoleEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_login_id_generator")
    @SequenceGenerator(name = "user_login_id_generator", sequenceName = "user_login_seq", initialValue = 1, allocationSize = 10)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private UserGroupsEntity groupsEntity;

    @Column(name = "status", nullable = false)
    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserGroupsEntity getGroupsEntity() {
        return groupsEntity;
    }

    public void setGroupsEntity(UserGroupsEntity groupsEntity) {
        this.groupsEntity = groupsEntity;
    }

    public Boolean getActive() {
        return status;
    }

    public void setActive(Boolean status) {
        this.status = status;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
