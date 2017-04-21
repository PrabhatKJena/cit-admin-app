package in.cit.apps.admin.data.repo;

import in.cit.apps.admin.data.entities.UserGroupsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Prabhat on 4/20/2017.
 */
public interface UserGroupsRepository extends JpaRepository<UserGroupsEntity, Byte> {
    public UserGroupsEntity findByGroupName(String groupName);
}

