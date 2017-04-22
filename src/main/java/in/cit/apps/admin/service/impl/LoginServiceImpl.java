package in.cit.apps.admin.service.impl;

import in.cit.apps.admin.data.entities.UserLoginEntity;
import in.cit.apps.admin.data.repo.UserLoginRepository;
import in.cit.apps.admin.data.repo.UserRoleRepository;
import in.cit.apps.admin.exceptions.InvalidUserDataException;
import in.cit.apps.admin.init.Messages;
import in.cit.apps.admin.model.LoginData;
import in.cit.apps.admin.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * Created by Prabhat on 4/21/2017.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserLoginRepository userLoginRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private Messages messages;

    @Override
    public boolean isValidLogin(LoginData loginData) throws InvalidUserDataException {
        UserLoginEntity loginEntity = userLoginRepository.findByLoginNameAndLoginPwdAndStatus(loginData.getUserName(), loginData.getUserCredential(), true);
        if (loginEntity == null) {
            throw new InvalidUserDataException(messages.get("error.invalid.login"));
        }
        if(loginEntity.getUserEntity() == null){
            throw new InvalidUserDataException(messages.get("error.notfound.user"));
        }
//        UserRoleEntity userRole = userRoleRepository.findByUserId(loginEntity.getUserEntity().getUserId());
        return true;
    }
}
