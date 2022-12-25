package org.sid.customerservice;
import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository,
                            RepositoryRestConfiguration restConfiguration) {
        restConfiguration.exposeIdsFor(Customer.class);
        return args -> {
            customerRepository.save(new Customer(null,"Youness","Youness@hotmail.com"));
            customerRepository.save(new Customer(null,"Khaoula","Khaoula@hotmail.com"));
            customerRepository.save(new Customer(null,"Wael","Wael@gmail.com"));
            customerRepository.save(new Customer(null,"Yasmine","Yasmine@live.fr"));
            customerRepository.save(new Customer(null,"Lyken","Lyken@live.fr"));
            customerRepository.save(new Customer(null,"Omar","Omar@gmail.com"));
        };
    }
}
