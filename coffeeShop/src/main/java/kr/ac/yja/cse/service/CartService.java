package kr.ac.yja.cse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.yja.cse.dao.CartDao;
import kr.ac.yja.cse.model.Cart;

@Service
public class CartService {
	
	@Autowired
    private CartDao cartDao;

    public Cart getCartById(int cart_id) {
        return cartDao.getCartById(cart_id);
    }
    
    public void saveCart(Cart cart) {
    	cartDao.saveCart(cart);
    }

}
