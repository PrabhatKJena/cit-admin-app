package in.cit.apps.admin.model;

import in.cit.apps.admin.data.entities.UserGroupsEntity;
import in.cit.apps.admin.model.enums.ResourceType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prabhat on 4/20/2017.
 */
@Component
public final class UserGroupsModel {
    private List<UserGroupsEntity> records;

    public List<UserGroupsEntity> getRecords() {
        return new ArrayList<>(records);
    }

    public void setRecords(List<UserGroupsEntity> records) {
        this.records = new ArrayList<>(records);
    }

    public boolean isAccessible(ResourceType resourceType) {

        return false;
    }
}
