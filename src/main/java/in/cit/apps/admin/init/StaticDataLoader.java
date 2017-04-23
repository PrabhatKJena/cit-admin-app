package in.cit.apps.admin.init;

import in.cit.apps.admin.data.entities.UserEntity;
import in.cit.apps.admin.data.entities.UserGroupsEntity;
import in.cit.apps.admin.data.entities.UserLoginEntity;
import in.cit.apps.admin.data.entities.UserRoleEntity;
import in.cit.apps.admin.data.repo.UserGroupsRepository;
import in.cit.apps.admin.data.repo.UserLoginRepository;
import in.cit.apps.admin.data.repo.UserRoleRepository;
import in.cit.apps.admin.data.repo.UsersRepository;
import in.cit.apps.admin.model.UserGroupsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Prabhat on 4/20/2017.
 */
@Component
public class StaticDataLoader {
    @Autowired
    private UserGroupsRepository userGroupsRepository;

    @Autowired
    private UserLoginRepository userLoginRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;


    @PostConstruct
    public void init() {
        loadUserGroups();

        testDataLoader();
    }

    public void loadUserGroups() {
        List<UserGroupsEntity> entities = userGroupsRepository.findAll();
        for (UserGroupsEntity entity : entities) {
            UserGroupsType.forName(entity.getGroupName()).setData(entity.getGroupId());
        }
        System.out.println("All User Groups >>>>>>>>>> ");
        Arrays.stream(UserGroupsType.values()).forEach(userGroupsType -> System.out.println(userGroupsType));

    }

    private void testDataLoader() {
        try {
            UserEntity userEntity = usersRepository.findByUserId("U0001");
            UserLoginEntity entity = new UserLoginEntity();
            entity.setUserEntity(userEntity);
            entity.setLoginName("prajena");
            entity.setLoginPwd("pwd");
            entity.setStatus(true);
            userLoginRepository.save(entity);
            List<UserLoginEntity> all = userLoginRepository.findAll();
            System.out.println(all);

            UserGroupsEntity groupsEntity = userGroupsRepository.findByGroupName("ADMIN");
            UserRoleEntity roleEntity = new UserRoleEntity();
            roleEntity.setUserEntity(userEntity);
            roleEntity.setActive(true);
            roleEntity.setGroupsEntity(groupsEntity);
            userRoleRepository.save(roleEntity);

            groupsEntity = userGroupsRepository.findByGroupName("FINANCE");
            roleEntity = new UserRoleEntity();
            roleEntity.setUserEntity(userEntity);
            roleEntity.setActive(true);
            roleEntity.setGroupsEntity(groupsEntity);
            userRoleRepository.save(roleEntity);


            List<UserRoleEntity> all1 = userRoleRepository.findAll();
            System.out.println(all1);

        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

}
