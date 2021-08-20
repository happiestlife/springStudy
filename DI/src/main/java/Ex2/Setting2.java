package Ex2;
import Ex2.Customer.CustomerList;
import Ex2.Customer.PrintCustomerInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
@Configuration
@ComponentScan(basePackages = {"Customer"})
public class Setting2 {

    @Bean
    public CustomerList customerList(){
        return new CustomerList();
    }

    @Bean
    public PrintCustomerInfo printCustomerInfo(){
        return new PrintCustomerInfo();
    }
}
