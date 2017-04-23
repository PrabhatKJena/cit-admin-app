package in.cit.apps.admin.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Prabhat on 4/21/2017.
 */
@ResponseStatus(value= HttpStatus.UNAUTHORIZED, reason="Invalid User Data")
public class InvalidUserDataException extends Exception {
    public InvalidUserDataException(String msg) {
        super(msg);
    }
}
