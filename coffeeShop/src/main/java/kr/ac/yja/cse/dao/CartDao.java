package kr.ac.yja.cse.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.yja.cse.model.Cart;

@Repository
@Transactional
public class CartDao {
	
	@Autowired
    private SessionFactory sessionFactory;

    public Cart getCartById (int cart_id) {
        Session session = sessionFactory.getCurrentSession();
        return (Cart) session.get(Cart.class, cart_id);
    }

	public void saveCart(Cart cart) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cart);
		session.flush();

	}

}
