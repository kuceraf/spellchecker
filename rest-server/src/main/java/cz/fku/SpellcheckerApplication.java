package cz.fku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created
 * by Filip on 14.11.2016.
 */
@Configuration
@ComponentScan("cz.fku.*")
@EnableAutoConfiguration
public class SpellcheckerApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpellcheckerApplication.class, args);
    }
}
