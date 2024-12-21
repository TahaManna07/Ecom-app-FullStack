package ma.enset.inventoryservice.web;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ma.enset.inventoryservice.entities.Product;
import ma.enset.inventoryservice.repositories.ProductRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor

public class ProductController {

    private ProductRepository productRepository;

    @GetMapping("/products")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public List<Product> products(){
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
   // @PreAuthorize("hasAuthority('USER')")

    public Product getProducts(@PathVariable String id){
        return productRepository.findById(id).orElse(null);
    }
    @GetMapping("/auth")
    public Authentication authentication(Authentication authentication){
        return authentication;
    }
}
