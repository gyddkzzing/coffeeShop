package kr.ac.yja.cse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.yja.cse.dao.CartItemDao;
import kr.ac.yja.cse.model.Cart;
import kr.ac.yja.cse.model.CartItem;

@Service
public class  CartItemService{

    @Autowired
    private CartItemDao cartItemDao;

    public void addCartItem(CartItem cartItem) {
        cartItemDao.addCartItem(cartItem);
    }

    public void removeCartItem(CartItem cartItem) {
        cartItemDao.removeCartItem(cartItem);
    }

    public void removeAllCartItems(Cart cart){
        cartItemDao.removeAllCartItems(cart);
    }

    public CartItem getCartItemByProduct_id (int cart_id, String product_id) {
        return cartItemDao.getCartItemByProduct_id(cart_id, product_id);
    }
}