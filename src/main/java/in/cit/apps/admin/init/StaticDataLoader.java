package in.cit.apps.admin.init;

import in.cit.apps.admin.data.entities.UserEntity;
import in.cit.apps.admin.data.entities.UserGroupsEntity;
import in.cit.apps.admin.data.entities.UserLoginEntity;
import in.cit.apps.admin.data.entities.UserRoleEntity;
import in.cit.apps.admin.data.repo.UserGroupsRepository;
import in.cit.apps.admin.data.repo.UserLoginRepository;
import in.cit.apps.admin.data.repo.UserRoleRepository;
import in.cit.apps.admin.data.repo.UsersRepository;
import in.cit.apps.admin.model.UserGroupsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Prabhat on 4/20/2017.
 */
@Component
public class StaticDataLoader {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private UserGroupsRepository userGroupsRepository;

    @Autowired
    private UserGroupsModel userGroupsModel;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private UserLoginRepository userLoginRepository;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private UsersRepository usersRepository;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private UserRoleRepository userRoleRepository;


    @PostConstruct
    public void loadUserGroups() {
        List<UserGroupsEntity> entities = userGroupsRepository.findAll();
        for (UserGroupsEntity entity : entities) {
            System.out.println(entity);
        }
        userGroupsModel.setEntries(entities);

        test();
    }

    private void test() {
        try {
            UserEntity userEntity = usersRepository.findByUserId("U0001");
            UserLoginEntity entity = new UserLoginEntity();
            entity.setUserId(userEntity);
            entity.setLoginName("prajena");
            entity.setLoginPwd("pwd");
            entity.setStatus(true);
            userLoginRepository.save(entity);
            List<UserLoginEntity> all = userLoginRepository.findAll();
            System.out.println(all);

            UserGroupsEntity groupsEntity = userGroupsRepository.findByGroupName("ADMIN");
            UserRoleEntity roleEntity = new UserRoleEntity();
            roleEntity.setUserId(userEntity);
            roleEntity.setActive(false);
            roleEntity.setGroupId(groupsEntity);
            userRoleRepository.save(roleEntity);
            List<UserRoleEntity> all1 = userRoleRepository.findAll();
            System.out.println(all1);

        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

}
