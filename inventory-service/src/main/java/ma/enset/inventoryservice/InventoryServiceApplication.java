package ma.enset.inventoryservice;

import ma.enset.inventoryservice.entities.Product;
import ma.enset.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {
          productRepository.save(Product.builder().id("P01").name("HP").price(25000).quantity(150).build());
          productRepository.save(Product.builder().id("P02").name("LG").price(14000).quantity(160).build());
          productRepository.save(Product.builder().id("P03").name("MAC").price(65000).quantity(170).build());

        };
    }


}
