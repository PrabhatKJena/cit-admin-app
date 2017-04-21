package in.cit.apps.admin.data.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Prabhat on 4/20/2017.
 */
@Entity
@Table(name = "user_groups")
public class UserGroupsEntity extends BaseEntity {
    @Id
    @Column(name = "group_id")
    private Integer groupId;
    @Column(name = "group_name", nullable = false)
    private String groupName;
    @Column(name = "group_value", nullable = false)
    private Integer groupValue;
    @Column(name = "group_desc", nullable = false)
    private String groupDesc;
    @Column(name = "status", nullable = false)
    private Boolean status;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getGroupValue() {
        return groupValue;
    }

    public void setGroupValue(Integer groupValue) {
        this.groupValue = groupValue;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserGroupsEntity entity = (UserGroupsEntity) o;

        if (!groupId.equals(entity.groupId)) return false;
        if (!groupName.equals(entity.groupName)) return false;
        return groupValue.equals(entity.groupValue);

    }

    @Override
    public int hashCode() {
        int result = groupId.hashCode();
        result = 31 * result + groupName.hashCode();
        result = 31 * result + groupValue.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserGroupsEntity{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", groupValue=" + groupValue +
                ", groupDesc='" + groupDesc + '\'' +
                ", status=" + status +
                "} " + super.toString();
    }
}
