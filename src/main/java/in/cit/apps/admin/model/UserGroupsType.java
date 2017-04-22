package in.cit.apps.admin.model;

import in.cit.apps.admin.data.entities.UserGroupsEntity;
import in.cit.apps.admin.model.enums.ResourceType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Prabhat on 4/20/2017.
 * <p>
 * ADMIN
 * RECRUITER
 * FINANCE
 * ALL
 */
public enum UserGroupsType {
    ADMIN, RECRUITER, FINANCE;
    private int groupId;
    private int groupValue;

    public void setData(int groupId) {
        this.groupId = groupId;
        this.groupValue = 1 << (groupId - 1); // 1<<2 => 100 => 4
    }

    public static UserGroupsType forName(String name) {
        return Arrays.stream(UserGroupsType.values()).filter(userGroupsType -> userGroupsType.name().equalsIgnoreCase(name)).findFirst().get();
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getGroupValue() {
        return groupValue;
    }

    public void setGroupValue(int groupValue) {
        this.groupValue = groupValue;
    }

    @Override
    public String toString() {
        return "UserGroupsType{" +
                "name=" + name() +
                "groupId=" + groupId +
                ", groupValue=" + groupValue +
                '}';
    }
}
