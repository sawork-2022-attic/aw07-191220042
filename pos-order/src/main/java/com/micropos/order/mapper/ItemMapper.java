package com.micropos.order.mapper;


import com.micropos.order.model.Item;
import com.micropos.dto.ItemDto;
import org.mapstruct.Mapper;

@Mapper
public interface ItemMapper {

    Item toItem(ItemDto productDto);

    ItemDto toCartItemDto(Item item);
}
