package pl.kul.operations;

import pl.kul.Product;
import pl.kul.Shop;

import java.util.ArrayList;
import java.util.Scanner;

public class Cart extends Operation{

    public Cart(Shop shop) {
        super("CART", shop, " - Tworzy koszyk i dadaje do niego poszczegolne elementy", new int[]{0});
    }

    @Override
    public String execute(String... arg) {
        if(arg.length == 0){
            ArrayList<Product> products = new ArrayList<>();
            int id;
            String str = "";
            boolean czy = true;
            Scanner scanner = new Scanner(System.in);
            do {
                while(true){
                    System.out.print("Podaj id produkty: ");
                    if(scanner.hasNextInt()){
                        id = scanner.nextInt();
                        for(int i = 0; i < this.getShop().howManyProducts(); i ++){
                            if(this.getShop().getProduct(i).getId() == id){
                                products.add(this.getShop().getProduct(i));
                                System.out.println("Do koszyka dodany " + products.get(products.size()-1));
                                break;
                            } else if(i == this.getShop().howManyProducts()-1){
                                System.out.println("Produktu o takim id nie istnieje.");
                            }
                        }
                        break;
                    }
                    else{
                        System.out.println("Id powinno byc liczba.");
                    }
                }
                while(true){

                    if(scanner.hasNextLine()) {
                        str = scanner.nextLine();
                        if (str.equals("y") || str.equals("n")) {
                            if (str.equals("y")) {
                                czy = true;
                            } else {
                                czy = false;
                            }
                            break;
                        }
                    }
                    System.out.print("Dodac product[n/y]: ");
                }
            } while (czy);
            System.out.println("\n-----Paragon-----");
            double summa = 0;
            for(int i = 0; i < products.size(); i++){
                System.out.println(products.get(i).getName() + "----------" + products.get(i).getCena()+"zl");
                summa+=products.get(i).getCena();
            }
            System.out.println("-----------------------");
            System.out.println("Summa----------" + summa + "zl");
        } else {
            System.out.println("Polecenie nie przyjmuje argumentow.");
        }
        return null;
    }
}