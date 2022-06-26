package com.micropos.order.model;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import com.micropos.dto.OrderDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Accessors(fluent = true, chain = true)
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer id;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "orderanditems", joinColumns = @JoinColumn(name = "orderitems_orders_id_fk"))
    @Setter
    @Getter
    private List<Item> items = new ArrayList<>();

    @Getter
    @Setter
    OrderDto.StatusEnum status;
}
