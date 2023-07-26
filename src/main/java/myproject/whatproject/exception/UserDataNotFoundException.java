package myproject.whatproject.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserDataNotFoundException extends RuntimeException {
    public UserDataNotFoundException(String message) {
        super(message);
    }
}
