import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import shopping.ShoppingMall;

public class Main {
    public static void main(String args[]){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Setting.class);

        ShoppingMall shopMall = ctx.getBean("shoppingMall", ShoppingMall.class);
        shopMall.shopping();
    }
}
