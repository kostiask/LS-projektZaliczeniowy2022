package pl.kul.operations;

import pl.kul.Shop;

import java.util.stream.IntStream;

public abstract class Operation {
    private String operacja;
    private Shop shop;
    private String description;
    private int[] numberOfArguments;

    public static String INVALID_NUMBER_OF_ARGUMENTS = "Nie poprawna ilosc argumentow.";
    public static String INVALID_ARGUMENT = "Argumenty sa nie prawidlowe.";

    public Operation(String operacja, Shop shop, String description,int[] numberOfArguments) {
        this.operacja = operacja;
        this.shop = shop;
        this.description = description;
        this.numberOfArguments = numberOfArguments;
    }

    public int[] getNumberOfArguments() {
        return numberOfArguments;
    }

    public String getDescription() {
        return description;
    }

    public String execute(String ... arg) {
        return null;
    }

    public boolean checkNumberOfArguments(int i){
        if(IntStream.of(this.getNumberOfArguments()).anyMatch(x -> x == i)){
            return true;
        }
        return false;
    }

    public String getOperation(){
       return operacja;
    }

    public Shop getShop(){
        return this.shop;
    }

    public static boolean isParsableInt(String s){
        try{
            Integer.parseInt(s);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public static boolean isParsableDouble(String s){
        try{
            Double.parseDouble(s);
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
