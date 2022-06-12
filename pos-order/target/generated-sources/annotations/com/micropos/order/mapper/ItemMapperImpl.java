package com.micropos.order.mapper;

import com.micropos.dto.CartItemDto;
import com.micropos.order.model.Item;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public Item toItem(CartItemDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Item item = new Item();

        item.id( productDto.getId() );

        return item;
    }

    @Override
    public CartItemDto toCartItemDto(Item item) {
        if ( item == null ) {
            return null;
        }

        CartItemDto cartItemDto = new CartItemDto();

        return cartItemDto;
    }
}
