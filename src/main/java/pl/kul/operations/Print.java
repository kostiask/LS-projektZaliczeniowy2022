package pl.kul.operations;

import pl.kul.Shop;

import static pl.kul.operations.validation.OperationValidatoError.INVALID_ID;
import static pl.kul.operations.validation.OperationValidatoError.INVALID_VALUE_ID;

public class Print extends Operation {
    public Print(Shop shop) {
        super("PRINT", shop, "'all' lub [id] - Wyswietla wszystkie lub wybrany produkt.", new int[]{1});
    }

    @Override
    public String execute(String ... arg) {
        if(arg[0].equals("all")){
            if(this.getShop().howManyProducts() == 0){
                return "W sklepie nie ma produktow.";
            }
            else {
                String answer = "";
                for (int i = 0; i < this.getShop().howManyProducts(); i++) {
                    answer += this.getShop().getProduct(i);
                    if(i < this.getShop().howManyProducts()-1){
                        answer += "\n";
                    }
                }
                return answer;
            }
        }
        else {
            if(Operation.isParsableInt(arg[0])){
                if(this.getShop().productsEmpty()){
                    return "Produkt o takim id nie istnieje.";
                }
                int id = Integer.parseInt(arg[0]);
                for(int i = 0; i < this.getShop().howManyProducts(); i++){
                    if(this.getShop().getProduct(i).getId() == id){
                        return this.getShop().getProduct(i).toString();
                    }
                }
                //return "Produkt o takim id nie istnieje.";
                throw new OperationValidationException(INVALID_ID.getMessage());
            } else {
                throw new OperationValidationException(INVALID_VALUE_ID.getMessage());
            }
        }
    }


}
