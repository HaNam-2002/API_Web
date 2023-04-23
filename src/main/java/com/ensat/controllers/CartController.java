//package com.ensat.controllers;
//
//import com.ensat.entities.Cart;
//import com.ensat.entities.CartItem;
//import com.ensat.services.CartItemService;
//import com.ensat.services.CartService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/cart") // http://localhost:8083/cart
//public class CartController {
//
//    @Autowired
//    private CartService cartService;
//
//    @Autowired
//    private CartItemService cartItemService;
//
//    @GetMapping("/{cartId}")
//    public ResponseEntity<Cart> getCartById(@PathVariable Integer cartId) {
//        Cart cart = cartService.getCartById(cartId);
//        if (cart == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(cart, HttpStatus.OK);
//    }
//
//    @PostMapping("/{cartId}/items")
//    public ResponseEntity<CartItem> addItemToCart(@PathVariable Integer cartId, @RequestBody CartItem cartItem) {
//        Cart cart = cartService.getCartById(cartId);
//        if (cart == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        cartItem.setCart(cart);
//        cartItem = cartItemService.createOrUpdateCartItem(cartItem);
//        cart = cartService.saveCart(cart); // Lưu giỏ hàng sau khi cập nhật
//        return new ResponseEntity<>(cartItem, HttpStatus.OK);
//    }
//
//    @PutMapping("/{cartId}/items/{cartItemId}")
//    public ResponseEntity<CartItem> updateCartItem(@PathVariable Integer cartId, @PathVariable Integer cartItemId, @RequestBody CartItem cartItem) {
//        Cart cart = cartService.getCartById(cartId);
//        if (cart == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        CartItem existingCartItem = cartItemService.getCartItemById(cartItemId);
//        if (existingCartItem == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        existingCartItem.setAmount(cartItem.getAmount());
//        existingCartItem.setProduct(cartItem.getProduct());
//        existingCartItem = cartItemService.createOrUpdateCartItem(existingCartItem);
//        cart = cartService.saveCart(cart); // Lưu giỏ hàng sau khi cập nhật
//        return new ResponseEntity<>(existingCartItem, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{cartId}/items/{cartItemId}")
//    public ResponseEntity<Void> removeItemFromCart(@PathVariable Integer cartId, @PathVariable Integer cartItemId) {
//        Cart cart = cartService.getCartById(cartId);
//        if (cart == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        CartItem cartItem = cartItemService.getCartItemById(cartItemId);
//        if (cartItem == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        cartItemService.deleteCartItemById(cartItemId);
//        cart = cartService.saveCart(cart);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//}
