package Ex1;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Setting {
    @Bean
    @Qualifier("customer1")
    public Customer customer1(){
        return new Customer("L.H.S","010-1234-5678", 24, 1, "악!");
    }

    @Bean
    @Qualifier("customer2")
    public Customer customer2(){
        return new Customer("Y.D.G","010-8765-4321", 33, 7, "나의 Security key는?");
    }
}
