package operations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.kul.Product;
import pl.kul.Shop;
import pl.kul.operations.validation.OperationValidatoError;

import java.util.ArrayList;

import static pl.kul.operations.validation.OperationValidatoError.INVALID_NUMBER_OF_ARGUMENTS;

public class DeleteTest {

    private Shop shop;

    @BeforeEach
    void setUp() {
        shop = new Shop(new ArrayList<Product>());
    }

    @Test
    public void shouldReturnErrorIfInvalidNumberOfArguments() {
        //given
        String operation = "delete all 2.34 dfsdg";
        //when
        String answer = shop.executeOperation(operation);
        //then
        Assertions.assertEquals(answer, INVALID_NUMBER_OF_ARGUMENTS.getMessage());
    }

    @Test
    public void shouldReturnErrorIfInvalidId() {
        //given
        String operation = "delete -1";
        //when
        String answer = shop.executeOperation(operation);
        //then
        Assertions.assertEquals(answer, OperationValidatoError.INVALID_ID.getMessage());
    }

    @Test
    public void shouldReturnErrorIfInvalidValueArgument() {
        //given
        String operation = "delete asdad";
        //when
        String answer = shop.executeOperation(operation);
        //then
        Assertions.assertEquals(answer, OperationValidatoError.INVALID_VALUE.getMessage());
    }

    @Test
    public void shouldDeleteAllProductsIfArgumentIsAll() {
        //given
        String operation = "delete all";
        shop.executeOperation("add mleko 23.0");
        shop.executeOperation("add chleb 12.0");
        shop.executeOperation("add kola 34.0");
        //when
        String answer = shop.executeOperation(operation);
        //then
        Assertions.assertEquals(answer, "Zostaly usuniety wszystkie produkty ze sklepu.");
        Assertions.assertEquals(0, shop.howManyProducts());
    }

    @Test
    public void shouldDeleteOneProductIfArgumentIsId() {
        //given
        String operation = "delete 1";
        shop.executeOperation("add mleko 23.0");
        shop.executeOperation("add chleb 12.0");
        shop.executeOperation("add kola 34.0");
        String pr = shop.executeOperation("print 1");
        //when
        String answer = shop.executeOperation(operation);
        //then
        Assertions.assertEquals(answer, "Zostal usuniety: " + pr);
        Assertions.assertEquals(2, shop.howManyProducts());
    }

}
