package operations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.kul.Product;
import pl.kul.Shop;
import pl.kul.operations.Operation;
import pl.kul.operations.validation.OperationValidatoError;

import java.util.ArrayList;

import static pl.kul.operations.validation.OperationValidatoError.INVALID_NUMBER_OF_ARGUMENTS;
import static pl.kul.operations.validation.OperationValidatoError.INVALID_VALUE;

public class HelpTest {

    private Shop shop;

    @BeforeEach
    void setUp() {
        shop = new Shop(new ArrayList<Product>());
    }

    @Test
    public void shouldReturnErrorIfInvalidNumberOfArguments() {
        //given
        String operation = "help all 2.34 dfsdg";
        //when
        String answer = shop.executeOperation(operation);
        //then
        Assertions.assertEquals(answer, INVALID_NUMBER_OF_ARGUMENTS.getMessage());
    }

    @Test
    public void shouldReturnErrorIfInvalidId() {
        //given
        String operation = "help";
        ArrayList<Operation> operations = shop.getOperations();
        String result = "";
        for (int i = 0; i < operations.size(); i++){
            result += operations.get(i).getOperation() + " " + operations.get(i).getDescription();
            if(i < operations.size()-1){
                result += "\n";
            }
        }
        //when
        String answer = shop.executeOperation(operation);
        //then
        Assertions.assertEquals(answer, result);
    }
}
