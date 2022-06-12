package com.micropos.order.mapper;


import com.micropos.order.model.Item;
import com.micropos.dto.CartItemDto;
import org.mapstruct.Mapper;

@Mapper
public interface ItemMapper {

    Item toItem(CartItemDto productDto);

    CartItemDto toCartItemDto(Item item);
}
