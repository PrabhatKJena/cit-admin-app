package in.cit.apps.admin.data.repo;

import in.cit.apps.admin.data.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Prabhat on 4/20/2017.
 */
public interface UsersRepository extends JpaRepository<UserEntity, String> {
    public UserEntity findByUserId(String userId);
}
