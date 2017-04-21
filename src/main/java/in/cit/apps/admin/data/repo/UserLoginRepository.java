package in.cit.apps.admin.data.repo;

import in.cit.apps.admin.data.entities.UserEntity;
import in.cit.apps.admin.data.entities.UserLoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Prabhat on 4/21/2017.
 */
public interface UserLoginRepository extends JpaRepository<UserLoginEntity, Integer> {
    public UserLoginEntity findByUserId(String userId);
}
