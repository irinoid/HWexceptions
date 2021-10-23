package work.with.exceptions.HWexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmpNotFoundException extends ClassNotFoundException {
    public EmpNotFoundException() {
        super();
    }
}
