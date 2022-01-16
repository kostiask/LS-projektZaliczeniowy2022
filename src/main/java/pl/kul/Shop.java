package pl.kul;

import pl.kul.Product;
import pl.kul.operations.*;
import pl.kul.operations.validation.OperationValidationResult;
import pl.kul.operations.validation.OperationValidator;

import java.util.ArrayList;
import java.util.Locale;

public class Shop {

    private final OperationValidator operationValidator;

    private ArrayList<Operation> operations;

    private ArrayList<Product> products;

    public Shop(ArrayList<Product> products) {
        this.operations = new ArrayList<>();
        operations.add(new Add(this));

        this.products = products;
        this.operationValidator = new OperationValidator(operations);
    }

    public String executeOperation(String name_operation){
        // wykonac operacje
        try{
            String[] tab = name_operation.split(" ");
            if(tab.length > 0){
                tab[0] = tab[0].toUpperCase(Locale.ROOT);
            }
            validateOperation(tab);
            String[] args = new String[tab.length-1];
            System.arraycopy(tab, 1, args, 0, tab.length-1);
//        for(int i = 0; i < args.length; i ++){
//            System.out.println(args[i]);
//        }
            if(tab.length == 0){
                return "Nie prawiedlole polecenie";
            } else {
                for(int i = 0; i < operations.size(); i++){
                    if(operations.get(i).getOperation().equals(tab[0])){
                       // try{
                            return operations.get(i).execute(args);
//                        } catch (RuntimeException e){
//                            return e.getMessage();
//                        }

                        //break;
                    } else if(i == operations.size() - 1) {
                        return "Nie mam takiego polecenia";
                    }
                }
            }
            return null;
        }
        catch (RuntimeException e){
            return e.getMessage();
        }
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public int howManyProducts(){
        return products.size();
    }

    public Product getProduct(int index){
        return products.get(index);
    }

    public void removeAllProducts(){
        products.clear();
    }

    public void removeProduct(int i){
        products.remove(i);
    }

    public ArrayList<Operation> getOperations() {
        return operations;
    }

    private void validateOperation(String[] operation){
        OperationValidationResult operationValidationResult = operationValidator.validateOperation(operation);
        if(!operationValidationResult.isOperationValid()){
            throw new OperationValidationException(operationValidationResult.getValidationError().getMessage());
        }
    }

    public boolean productsEmpty(){
        if(products.isEmpty()){
            return true;
        }
        return false;
    }
}
