package in.cit.apps.admin.data.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Created by Prabhat on 4/21/2017.
 */
@Embeddable
public class UserRoleId {
    @ManyToOne
    private UserEntity userId;

    @ManyToOne
    private UserGroupsEntity groupId;

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }

    public UserGroupsEntity getGroupId() {
        return groupId;
    }

    public void setGroupId(UserGroupsEntity groupId) {
        this.groupId = groupId;
    }
}
