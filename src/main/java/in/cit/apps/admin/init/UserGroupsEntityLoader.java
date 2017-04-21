package in.cit.apps.admin.init;

import in.cit.apps.admin.data.entities.UserEntity;
import in.cit.apps.admin.data.entities.UserGroupsEntity;
import in.cit.apps.admin.data.repo.UserGroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

/**
 * Created by Prabhat on 4/20/2017.
 */
@Component
public class UserGroupsEntityLoader {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private UserGroupsRepository userGroupsRepository;

    @PostConstruct
    public void loadUserGroups() {
        List<UserGroupsEntity> entities = userGroupsRepository.findAll();

        for (UserGroupsEntity entity : entities) {
            System.out.println(entity);
        }

        createUser();
    }

    private void createUser() {
        UserEntity user = new UserEntity();
        user.setUserId("U001");
        user.setUserFName("Prabhat");
        user.setUserLName("Jena");
        user.setEmail("pp.jena@pp.com");
        user.setPhone(1234444L);
        user.setSex('M');
        user.setActive(true);
        user.setCreatedTime(new Date());
        user.setUpdateTime(new Date());
    }
}
