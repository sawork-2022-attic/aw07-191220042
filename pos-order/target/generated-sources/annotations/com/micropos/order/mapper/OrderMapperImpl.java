package com.micropos.order.mapper;

import com.micropos.dto.OrderDto;
import com.micropos.order.model.Order;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public List<OrderDto> toOrderDtos(List<Order> orders) {
        if ( orders == null ) {
            return null;
        }

        List<OrderDto> list = new ArrayList<OrderDto>( orders.size() );
        for ( Order order : orders ) {
            list.add( toOrderDto( order ) );
        }

        return list;
    }
}
