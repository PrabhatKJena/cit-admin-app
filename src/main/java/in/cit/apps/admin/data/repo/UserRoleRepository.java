package in.cit.apps.admin.data.repo;

import in.cit.apps.admin.data.entities.UserLoginEntity;
import in.cit.apps.admin.data.entities.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Prabhat on 4/21/2017.
 */
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Integer> {
    public UserRoleEntity findByUserId(String userId);
}
