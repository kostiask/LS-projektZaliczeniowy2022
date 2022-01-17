import pl.kul.Product;
import pl.kul.Shop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ShopTest {

    private Shop shop;

    @Test
    public void shouldOperationAdd(){

        String operation = "add mleko 2.34";

        shop = new Shop(new ArrayList<Product>());

        shop.executeOperation(operation);

        Assertions.assertEquals(shop.howManyProducts(),1);

    }

    @Test
    public void shoulDeleteAll(){
        String operation = "add mleko 2.34";
        String operation1 = "add chleb 4,56";
        String operation2 = "add kola 6.78";
        String operation3 = "delete all";

        shop = new Shop(new ArrayList<Product>());

        shop.executeOperation(operation);
        shop.executeOperation(operation1);
        shop.executeOperation(operation2);
        shop.executeOperation(operation3);

        int length = 0;

        Assertions.assertEquals(shop.howManyProducts(),0);
    }

    @Test
    public void shouldDeleteId(){
        String operation = "add mleko 2.34";
        String operation1 = "add chleb 4,56";
        String operation2 = "add kola 6.78";
        String operation3 = "delete 1";

        shop = new Shop(new ArrayList<Product>());

        shop.executeOperation(operation);
        shop.executeOperation(operation1);
        shop.executeOperation(operation2);

        int length = shop.howManyProducts();

        shop.executeOperation(operation3);

        Assertions.assertEquals(shop.howManyProducts(),length-1);
    }

}
