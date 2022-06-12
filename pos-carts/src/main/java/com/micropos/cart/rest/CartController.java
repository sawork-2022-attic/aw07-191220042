package com.micropos.cart.rest;

import com.micropos.api.CartsApi;
import com.micropos.cart.mapper.CartMapper;
import com.micropos.cart.model.Cart;
import com.micropos.cart.model.Item;
import com.micropos.cart.service.CartService;
import com.micropos.dto.CartDto;
import com.micropos.dto.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class CartController implements CartsApi {

    private CartService cartService;

    @Resource
    private CartMapper cartMapper;

    @Autowired
    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }

    @Override
    public ResponseEntity<CartDto> addItemToCart(Integer cartId, ItemDto cartItemDto) {
//        return CartsApi.super.addItemToCart(cartId, cartItemDto);
        Optional<Cart> optionalCart = cartService.getCart(cartId);
        if (optionalCart.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Cart cart = cartService.add(optionalCart.get(), cartMapper.toItem(cartItemDto, cartMapper.toCartDto(optionalCart.get())));
        return new ResponseEntity<>(cartMapper.toCartDto(cart), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CartDto> createCart() {
//        return CartsApi.super.createCart(cartDto);
        Cart cart = cartService.newCart();
        if (cart == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(cartMapper.toCartDto(cart), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CartDto>> listCarts() {
        return CartsApi.super.listCarts();
    }

    @Override
    public ResponseEntity<CartDto> showCartById(Integer cartId) {
        return CartsApi.super.showCartById(cartId);
    }

    @Override
    public ResponseEntity<Double> showCartTotal(Integer cartId) {

//        Cart cart = new Cart();
//        Item item1 = new Item();
//        item1.productId("a").productName("abc").unitPrice(2).quantity(2);
//        cart.addItem(item1);
//        Item item2 = new Item();
//        item2.productId("b").productName("bcd").unitPrice(3.1).quantity(1);
//        cart.addItem(item2);
//        Double total = cartService.checkout(cart);

        Double total = cartService.checkout(cartId);

        if (total == -1d) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(total);
    }
}
