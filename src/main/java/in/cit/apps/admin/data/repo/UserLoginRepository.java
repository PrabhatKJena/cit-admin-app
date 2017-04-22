package in.cit.apps.admin.data.repo;

import in.cit.apps.admin.data.entities.UserEntity;
import in.cit.apps.admin.data.entities.UserLoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Prabhat on 4/21/2017.
 */
@Repository
public interface UserLoginRepository extends JpaRepository<UserLoginEntity, Integer> {
    public UserLoginEntity findByLoginNameAndLoginPwdAndStatus(String loginName, String loginPwd, boolean status);
}
