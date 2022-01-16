package pl.kul.operations;

import pl.kul.Shop;

import java.util.ArrayList;

public class Help extends Operation{

    public Help(Shop shop) {
        super("HELP", shop, "- Wyswitla wszystkie polecenia.", new int[]{0});
    }

    @Override
    public String execute(String... arg) {
        String answer = "";
        ArrayList<Operation> operations = this.getShop().getOperations();
        for (int i = 0; i < operations.size(); i++){
            answer += operations.get(i).getOperation() + " " + operations.get(i).getDescription() ;
            if(i < operations.size()-1){
                answer += "\n";
            }
        }
        return answer;
    }
}
