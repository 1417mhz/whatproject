package myproject.whatproject.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProductDataNotFoundException extends RuntimeException {
    public ProductDataNotFoundException(String message) {
        super(message);
    }
}
