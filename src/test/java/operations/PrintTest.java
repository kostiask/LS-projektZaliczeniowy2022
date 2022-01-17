package operations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.kul.Product;
import pl.kul.Shop;
import pl.kul.operations.Operation;

import java.util.ArrayList;

import static pl.kul.operations.validation.OperationValidatoError.INVALID_NUMBER_OF_ARGUMENTS;

public class PrintTest {

    private Shop shop;
    private ArrayList<Product> products;

    @BeforeEach
    void setUp() {
        products = new ArrayList<>();
        products.add(new Product("mleko", 2.34));
        products.add(new Product("makaron", 3.34));
        products.add(new Product("chleb", 1.34));
        shop = new Shop(products);
    }

    @Test
    public void shouldReturnErrorIfInvalidNumberOfArguments() {
        //given
        String operation = "print";
        String operation1 = "print ssd sdsd";
        //when
        String answer = shop.executeOperation(operation);
        String answer1 = shop.executeOperation(operation1);
        //then
        Assertions.assertEquals(answer, INVALID_NUMBER_OF_ARGUMENTS.getMessage());
        Assertions.assertEquals(answer1, INVALID_NUMBER_OF_ARGUMENTS.getMessage());
    }



    @Test
    public void shouldReturnAllProductIfArgumentIsAll() {
        //given
        String operation = "print all";

        String result = "";
        for(int i = 0; i < products.size(); i++){
            result += products.get(i).toString() ;
            if(i < products.size()-1){
                result += "\n";
            }
        }

        //when
        String answer = shop.executeOperation(operation);
        //then
        Assertions.assertEquals(answer, result);
    }

    @Test
    public void shouldReturnProductIfArgumentIsId() {
        //given
        String operation = "print 13";
        String operation1 = "print 14";

        String result1 = products.get(1).toString();
        String result2 = products.get(2).toString();
        //when
        String answer1 = shop.executeOperation(operation);
        String answer2 = shop.executeOperation(operation1);
        //then
        Assertions.assertEquals(answer1, result1);
        Assertions.assertEquals(answer2, result2);
    }

    @Test
    public void shouldReturnNotificationIfInvalidId() {
        //given
        String operation = "print 1000";

        String result1 = "Produkt o takim id nie istnieje.";
        //when
        String answer1 = shop.executeOperation(operation);
        //then
        Assertions.assertEquals(answer1, result1);
    }

    @Test
    public void shouldReturnNotificationIfArgumentIsAllAndShopDontHaveProducts() {
        //given
        String operation = "print all";

        String result = "W sklepie nie ma produktow.";
        shop.executeOperation("delete all");
        //when
        String answer = shop.executeOperation(operation);
        //then
        Assertions.assertEquals(answer, result);
    }
}
