package pl.kul.operations.validation;

public class OperationValidationResult {

    private final boolean isOperationValid;
    private OperationValidatoError validationError;

    public OperationValidationResult(boolean isOperationValid) {
        this.isOperationValid = isOperationValid;
    }

    public OperationValidationResult(boolean isOperationValid, OperationValidatoError validationError) {
        this.isOperationValid = isOperationValid;
        this.validationError = validationError;
    }

    public static OperationValidationResult successfulValidation() {
        return new OperationValidationResult(true, null);
    }

    public static OperationValidationResult validationFailed(OperationValidatoError operationValidatoError){
        return new OperationValidationResult(false, operationValidatoError);
    }

    public boolean isOperationValid() {
        return isOperationValid;
    }

    public OperationValidatoError getValidationError() {
        return validationError;
    }
}
