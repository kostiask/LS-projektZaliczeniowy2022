package pl.kul.operations.validation;

import pl.kul.operations.Operation;

import java.util.ArrayList;
import java.util.stream.IntStream;

import static java.util.Objects.isNull;
import static pl.kul.operations.validation.OperationValidationResult.validationFailed;
import static pl.kul.operations.validation.OperationValidatoError.*;

public class OperationValidator {

    private final ArrayList<Operation> operations;
    
    public OperationValidator(ArrayList<Operation> operations) {
        this.operations = operations;
    }

    public OperationValidationResult validateOperation(String[] operation) {
        if(isNull(operation)) {
            return validationFailed(NULL_VALUE);
        }
        if(!validationOperation(operation)){
            return validationFailed(INVALID_OPERATION);
        }
        if(!validationNumberArgumentsOfOperation(operation)){
            return validationFailed(INVALID_NUMBER_OF_ARGUMENTS);
        }
        return OperationValidationResult.successfulValidation();

    }

    private boolean validationNumberArgumentsOfOperation(String[] operation) {
        for(int i = 0; i < operations.size(); i++){
            if(operations.get(i).getOperation().equals(operation[0])){
                if(IntStream.of(operations.get(i).getNumberOfArguments()).anyMatch(x -> x == operation.length-1)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean validationOperation(String[] operation) {
        for (int i = 0; i < operations.size(); i++){
            if(operations.get(i).getOperation().equals(operation[0])){
                return true;
            }
        }
        return false;
    }
}
