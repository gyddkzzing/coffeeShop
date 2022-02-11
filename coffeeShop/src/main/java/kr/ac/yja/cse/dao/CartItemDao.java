package kr.ac.yja.cse.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.yja.cse.model.Cart;
import kr.ac.yja.cse.model.CartItem;

@Repository
@Transactional
public class CartItemDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addCartItem(CartItem cartItem) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);
		session.flush();
	}

	public void removeCartItem(CartItem cartItem) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(cartItem);
		session.flush();
	}

	public void removeAllCartItems(Cart cart) {
		List<CartItem> cartItems = cart.getCartItems();

		for (CartItem item : cartItems) {
			removeCartItem(item);
		}
	}

	public CartItem getCartItemByProduct_id(int cart_id, String product_id) {
		Session session = sessionFactory.getCurrentSession();
		Query<CartItem> query = session.createQuery("from CartItem where cart.cart_id=:cid and product.product_id = :pid ",
				CartItem.class);
		query.setParameter("cid", cart_id);
		query.setParameter("pid", product_id);

		return (CartItem) query.getSingleResult();

	}

}
