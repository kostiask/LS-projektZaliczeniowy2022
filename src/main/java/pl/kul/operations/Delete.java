package pl.kul.operations;

import pl.kul.Shop;

import static pl.kul.operations.validation.OperationValidatoError.INVALID_ID;
import static pl.kul.operations.validation.OperationValidatoError.INVALID_VALUE;

//Usuniecie produktu
public class Delete extends Operation{


    public Delete(Shop shop) {
        super("DELETE", shop, "'all' lub [id] - Usuwa wszystkie lub wybrany produkt", new int[]{1});
    }

    @Override
    public String execute(String ... arg) {
        if(arg[0].equals("all")){
            this.getShop().removeAllProducts();
            return "Zostaly usuniete wszystkie produkty ze sklepu.";
        }
        else {
            if(Operation.isParsableInt(arg[0])){
                int id = Integer.parseInt(arg[0]);
                for(int i = 0; i < this.getShop().howManyProducts(); i ++){
                    if(this.getShop().getProduct(i).getId() == id){
                        String answer =  "Zostal usuniety: " + this.getShop().getProduct(i);
                        this.getShop().removeProduct(i);
                        return answer;
                    }
                }
                throw  new OperationValidationException(INVALID_ID.getMessage());
            }
            else {
                throw new OperationValidationException(INVALID_VALUE.getMessage());
            }
        }
    }
}
