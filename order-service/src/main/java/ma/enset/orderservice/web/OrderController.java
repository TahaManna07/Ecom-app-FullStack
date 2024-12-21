package ma.enset.orderservice.web;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ma.enset.orderservice.entities.Order;
import ma.enset.orderservice.repositories.OrderRepository;
import ma.enset.orderservice.repositories.ProductItemRepository;
import ma.enset.orderservice.restclients.InventoryRestClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class OrderController {

    private OrderRepository orderRepository;
    private InventoryRestClient inventoryRestClient;

    @GetMapping("/orders/{id}")
    public Order getOrder(@PathVariable String id ){
        Order order = orderRepository.findById(id).orElse(null);
        order.getProductItemList().forEach(p->{
            p.setProduct(inventoryRestClient.findProductById(p.getProductId()));
        });
        return order;
    }

    @GetMapping("/orders")
    public List<Order> AllOrders(){
        List<Order> orders = orderRepository.findAll();
        orders.forEach(o->{
            o.getProductItemList().forEach(p->{
                p.setProduct(inventoryRestClient.findProductById(p.getProductId()));
            });
        });
        return orders;

    }
}
