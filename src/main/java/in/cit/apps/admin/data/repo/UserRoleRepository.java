package in.cit.apps.admin.data.repo;

import in.cit.apps.admin.data.entities.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Prabhat on 4/21/2017.
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Integer> {
    @Query("select ure from UserRoleEntity ure where ure.userEntity.userId = :userId")
    public List<UserRoleEntity> findByUserId(@Param("userId") String userId);
}
