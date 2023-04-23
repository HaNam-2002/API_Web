package com.ensat.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensat.entities.Account;
import com.ensat.entities.Cart;
import com.ensat.entities.CartItem;
import com.ensat.repositories.CartRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Cart getCartById(Integer cartId) {
        return cartRepository.findById(cartId).orElse(null);
    }

    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public void deleteCartById(Integer cartId) {
        cartRepository.deleteById(cartId);
    }

    public CartItem updateCartItemInCart(Cart cart, CartItem cartItem) {
        List<CartItem> cartItems = cart.getCartItems();
        for (int i = 0; i < cartItems.size(); i++) {
            if (cartItems.get(i).getCartItemID().equals(cartItem.getCartItemID())) {
                cartItems.set(i, cartItem);
                cart.setCartItems(cartItems);
                return cartRepository.save(cart).getCartItems().get(i);
            }
        }
        return null;
    }

    public Account getAccountByCart(Cart cart) {
        return cart.getAccount();
    }
}
