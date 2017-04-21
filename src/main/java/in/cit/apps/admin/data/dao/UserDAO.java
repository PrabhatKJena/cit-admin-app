package in.cit.apps.admin.data.dao;

import in.cit.apps.admin.data.entities.UserEntity;
import in.cit.apps.admin.data.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Prabhat on 4/21/2017.
 */
@Repository
public class UserDAO {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private UsersRepository usersRepository;

    public UserEntity insertUser(UserEntity userEntity){
        return usersRepository.save(userEntity);
    }
}
