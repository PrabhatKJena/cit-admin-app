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
    /*@Column(name = "group_value", nullable = false)
    private Integer groupValue;*/
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
    public String toString() {
        return "UserGroupsEntity{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", groupDesc='" + groupDesc + '\'' +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserGroupsEntity that = (UserGroupsEntity) o;

        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
        return groupName != null ? groupName.equals(that.groupName) : that.groupName == null;
    }

    @Override
    public int hashCode() {
        int result = groupId != null ? groupId.hashCode() : 0;
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        return result;
    }
}
