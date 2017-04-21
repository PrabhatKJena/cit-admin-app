package in.cit.apps.admin.data.repo;

import in.cit.apps.admin.data.entities.UserLoginEntity;
import in.cit.apps.admin.data.entities.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Prabhat on 4/21/2017.
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Integer> {
    public UserRoleEntity findByUserId(String userId);

}
