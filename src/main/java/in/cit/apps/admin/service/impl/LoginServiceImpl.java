package in.cit.apps.admin.service.impl;

import in.cit.apps.admin.data.entities.UserLoginEntity;
import in.cit.apps.admin.data.repo.UserLoginRepository;
import in.cit.apps.admin.data.repo.UserRoleRepository;
import in.cit.apps.admin.exceptions.InvalidCredentialException;
import in.cit.apps.admin.init.Messages;
import in.cit.apps.admin.model.LoginData;
import in.cit.apps.admin.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Prabhat on 4/21/2017.
 */
@Component
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserLoginRepository userLoginRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private Messages messages;

    @Override
    public boolean isValidLogin(LoginData loginData) throws InvalidCredentialException {
        UserLoginEntity loginEntity = userLoginRepository.findByLoginNameAndLoginPwdAndStatus(loginData.getUserName(), loginData.getUserCredential(), true);
        if (loginData == null) {
            throw new InvalidCredentialException(messages.get("error.invalid.login"));
        }
//      userRoleRepository
        return false;
    }
}
