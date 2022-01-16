package operations;

import org.junit.jupiter.api.BeforeEach;
import pl.kul.Product;
import pl.kul.operations.Operation;
import pl.kul.Shop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.kul.operations.validation.OperationValidationResult;
import pl.kul.operations.validation.OperationValidatoError;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.kul.operations.validation.OperationValidationResult.validationFailed;
import static pl.kul.operations.validation.OperationValidatoError.INVALID_NUMBER_OF_ARGUMENTS;
import static pl.kul.operations.validation.OperationValidatoError.INVALID_VALUE;

public class AddTest {

    private Shop shop;

    @BeforeEach
    void setUp() {
        shop = new Shop(new ArrayList<Product>());
    }

    @Test
    public void shouldReturnErrorIfInvalidNumberOfArguments(){
        //given
        String operation = "add mleko 2.34 dfsdg";
        //when
        String answer = shop.executeOperation(operation);
        //then
        Assertions.assertEquals(answer, INVALID_NUMBER_OF_ARGUMENTS.getMessage());
    }

    @Test
    public void shouldInvalidSecondArgument(){
        //given
        String operation = "add mleko dgsdg";
        //when
        String answer = shop.executeOperation(operation);
        //then
        Assertions.assertEquals(answer, INVALID_VALUE.getMessage());
    }

    @Test
    public void shouldReturnOkWhenExecuteOperationAdd(){
        //given
        String operation = "add mleko 2.34";
        //when
        String answer = shop.executeOperation(operation);
        //then
        Assertions.assertEquals(shop.howManyProducts(),1);
        Assertions.assertEquals(answer, "Dodano Product id=0, name='mleko', cena=2.34zl");
    }

}
