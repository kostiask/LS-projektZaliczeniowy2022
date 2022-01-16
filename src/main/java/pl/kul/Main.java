package pl.kul;

import pl.kul.operations.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("mlieko", 1.23));
        products.add(new Product("chleb", 4.12));
        products.add(new Product("kola", 5.67));
        products.add(new Product("ryz", 2.50));
        products.add(new Product("herbata", 4.0));

        Shop shop = new Shop(products);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Kassa fiskalna");
        boolean czy = true;
        String operacja;
        while(czy){
            operacja = scanner.nextLine();

            if(operacja.equals("end")){
                czy = false;
            } else if(operacja.equals("")){

            } else {
                System.out.println(shop.executeOperation(operacja));
            }
        }
        scanner.close();
    }

}
