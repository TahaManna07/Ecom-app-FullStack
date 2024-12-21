package ma.enset.orderservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;
}
