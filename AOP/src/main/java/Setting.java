import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import shopping.Announcement;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"shopping"})
public class Setting {
    @Bean
    public Announcement announcement(){
        return new Announcement();
    }
}
