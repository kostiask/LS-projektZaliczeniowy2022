import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Kassa fiskalna");
        boolean czy = true;
        String operacja;
        while(czy){
            operacja = scanner.nextLine();

            if(operacja == "end"){
                czy = false;
            }
        }
        scanner.close();
    }

}
