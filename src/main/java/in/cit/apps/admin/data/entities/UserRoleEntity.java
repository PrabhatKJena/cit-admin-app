package in.cit.apps.admin.data.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

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
@Table(name = "user_role")
public class UserRoleEntity extends BaseEntity {
    @EmbeddedId
    private UserRoleId id;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    public UserRoleId getId() {
        return id;
    }

    public void setId(UserRoleId id) {
        this.id = id;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
