package Ex1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainEx1 {
    public static void main(String args[]) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Setting.class);

        Customer customer1 = ctx.getBean("customer1", Customer.class);
        Customer customer2 = ctx.getBean("customer2", Customer.class);

        customer1.printInfo(1);
        customer1.changeSecurityKey(1, 77);
        customer1.speaking();

        customer2.printInfo(7);
        customer2.changeSecurityKey(2, 77);
        customer2.speaking();
    }
}
