package com.micropos.order.mapper;

import com.micropos.dto.ItemDto;
import com.micropos.order.model.Item;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public Item toItem(ItemDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Item item = new Item();

        item.id( productDto.getId() );

        return item;
    }

    @Override
    public ItemDto toCartItemDto(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemDto itemDto = new ItemDto();

        return itemDto;
    }
}
