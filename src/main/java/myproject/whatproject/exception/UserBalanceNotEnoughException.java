package myproject.whatproject.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserBalanceNotEnoughException extends RuntimeException {
    public UserBalanceNotEnoughException(String message) {
        super(message);
    }
}
