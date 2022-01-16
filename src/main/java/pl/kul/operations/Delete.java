package pl.kul.operations;

import pl.kul.Shop;

import static pl.kul.operations.validation.OperationValidatoError.INVALID_ID;
import static pl.kul.operations.validation.OperationValidatoError.INVALID_VALUE;

//Usuniecie produktu
public class Delete extends Operation{


    public Delete(String operacja, Shop shop, String description, int[] numberOfArguments) {
        super(operacja, shop, description, numberOfArguments);
    }
}
