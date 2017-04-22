package in.cit.apps.admin.service;

import in.cit.apps.admin.exceptions.InvalidUserDataException;
import in.cit.apps.admin.model.LoginData;

/**
 * Created by Prabhat on 4/18/2017.
 */
public interface LoginService {
    boolean isValidLogin(LoginData loginData) throws InvalidUserDataException;
}
