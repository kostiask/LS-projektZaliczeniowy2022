package pl.kul.operations;

import pl.kul.Product;
import pl.kul.Shop;

import java.util.Scanner;

import static pl.kul.operations.validation.OperationValidatoError.INVALID_VALUE;

//dodac product
public class Add extends Operation{

    public Add(Shop shop) {
        super("ADD", shop, "[nazwa] [cena] - Dodaje nowy produkt. Mozna odrazu przez spacje podac nazwu i cenu produktu. Jesli wprowadzic tylko nazwu polecenia, wyswietlo sie komunikaty postempowania.", new int[]{0,2});
    }

    @Override
    public String execute(String ... arg) {
        if(arg.length == 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Podaj nazwe produktu: ");
            String name = scanner.nextLine();
            System.out.print("Podaj cene produktu: ");
            if(scanner.hasNextDouble()){
                double cena = scanner.nextDouble();
                return this.getShop().executeOperation("ADD " + name + " " + cena);
//                    Product product = new Product(name, cena);
//                    this.getShop().addProduct(product);
//                    return "Dodano " + product.toString();
            } else {
                throw new OperationValidationException(INVALID_VALUE.getMessage());
            }
        }
        else {
            if(isParsableDouble(arg[1])){
                Product product = new Product(arg[0], Double.parseDouble(arg[1]));
                this.getShop().addProduct(product);
                return "Dodano " + product.toString();
            } else {
                throw new OperationValidationException(INVALID_VALUE.getMessage());
            }

        }
    }
}
