package ma.enset.orderservice.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.enset.orderservice.enums.OrdreState;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table(name = "ORDERS")
public class Order {
    @Id
    private String id;
    private LocalDate localDate;
    @Enumerated(EnumType.STRING)
    private OrdreState ordreState;
    @OneToMany(mappedBy = "order")
    private List<ProductItem> productItemList;
}
