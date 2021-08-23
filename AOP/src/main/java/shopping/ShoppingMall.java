package shopping;

import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class ShoppingMall {
    public void shopping(){
        Scanner s = new Scanner(System.in);
        while(true){
            System.out.println("원하시는 쇼핑목록을 고리세요.");
            System.out.println("...\n...\n...\n...\n");
            String input = s.nextLine();
            if(input.equals("exit")) break;
        }
    }
}
