package org.sid.inventoryservice;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository,
                            RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Product.class);
        return args -> {
            productRepository.save(new Product(null,"Laptop",23145,23369));
            productRepository.save(new Product(null,"Mouse",600,4576));
            productRepository.save(new Product(null,"Keyboard",1600,6606));
            productRepository.save(new Product(null,"HeadSet",1099,2345));
            productRepository.save(new Product(null,"MousePad",200,1256));
            productRepository.save(new Product(null,"Monitor",3700,64366));
        };
    }
}
    @Entity
    @Data
    @AllArgsConstructor @NoArgsConstructor
    class Product{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private double price;
        private double quantity;
    }
    @RepositoryRestResource
    interface ProductRepository extends JpaRepository<Product,Long> {

    }

