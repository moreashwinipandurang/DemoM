package com.example.orderservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order")
@Getter
@Setter
public class Order {
    @Id
    private int id;
    private String orderNumber;
    private List<OrderLineItems> OrderLineItemsList;
}
