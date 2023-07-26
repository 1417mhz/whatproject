package myproject.whatproject.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProductStockNotEnoughException extends RuntimeException {
    public ProductStockNotEnoughException(String message) {
        super(message);
    }
}
