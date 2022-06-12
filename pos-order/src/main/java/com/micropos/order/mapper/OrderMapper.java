package com.micropos.order.mapper;

import com.micropos.order.model.Item;
import com.micropos.order.model.Order;
import org.mapstruct.Mapper;
import com.micropos.dto.OrderDto;
import com.micropos.dto.ItemDto;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface OrderMapper {
    List<OrderDto> toOrderDtos(List<Order> orders);

    default Order toOrder(OrderDto orderDto) {
        Order order = new Order();
        order.id(orderDto.getId())
                .items(toItems(orderDto.getItems(), order))
                .status(orderDto.getStatus());
        return order;
    }

    default OrderDto toOrderDto(Order order) {
        return new OrderDto().id(order.id())
                .items(toItemDtos(order.items()))
                .status(order.status());
    }


    default List<com.micropos.dto.ItemDto> toItemDtos(List<Item> items) {
        if (items == null || items.isEmpty()) {
            return null;
        }
        List<com.micropos.dto.ItemDto> list = new ArrayList<>(items.size());
        for (Item item : items) {
            list.add(toItemDto(item));
        }

        return list;
    }

    default List<Item> toItems(List<ItemDto> itemDtos, Order order) {
        if (itemDtos == null || itemDtos.isEmpty()) {
            return null;
        }
        List<Item> list = new ArrayList<>(itemDtos.size());
        for (com.micropos.dto.ItemDto itemDto : itemDtos) {
            list.add(toItem(itemDto));
        }

        return list;
    }

    default com.micropos.dto.ItemDto toItemDto(Item item) {
        return new com.micropos.dto.ItemDto().id(item.id())
                .amount(item.quantity())
                .product(getProductDto(item));
    }

    default Item toItem(ItemDto itemDto) {
        return new Item().id(itemDto.getId())
                .productId(itemDto.getProduct().getId())
                .productName(itemDto.getProduct().getName())
                .quantity(itemDto.getAmount())
                .unitPrice(itemDto.getProduct().getPrice());
    }

    default com.micropos.dto.ProductDto getProductDto(Item item) {
        return new com.micropos.dto.ProductDto().id(item.productId())
                .name(item.productName())
                .price(item.unitPrice());
    }

}
