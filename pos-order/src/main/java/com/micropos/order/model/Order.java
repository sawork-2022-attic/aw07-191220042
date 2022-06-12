package com.micropos.order.model;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Accessors(fluent = true, chain = true)
public class Order implements Serializable {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Integer id;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "items", joinColumns = @JoinColumn(name = "order_id"))
    @Setter
    @Getter
    private List<Item> items = new ArrayList<>();
}
