package kr.ac.yja.cse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.yja.cse.model.Cart;
import kr.ac.yja.cse.model.CartItem;
import kr.ac.yja.cse.model.Product;
import kr.ac.yja.cse.service.CartItemService;
import kr.ac.yja.cse.service.CartService;
import kr.ac.yja.cse.service.ProductService;

@RestController // @Controller + @ResponseBody
@RequestMapping("/api/cart")
public class CartRestController {

	@Autowired
	private CartService cartService;

	@Autowired
	private CartItemService cartItemService;
	
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/{cart_id}", method = RequestMethod.GET)
	public ResponseEntity<Cart> getCartById(@PathVariable(value = "cart_id") int cart_id) { //login된 사용자의 cartid
		
		Cart cart = cartService.getCartById(cart_id);
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
		
	}

	@RequestMapping(value = "/{cart_id}", method = RequestMethod.DELETE) //사용자 cart를 전체 비우는 것 
	public ResponseEntity<Void> clearCart(@PathVariable(value = "cart_id") int cart_id) {
		
		Cart cart = cartService.getCartById(cart_id);
		cartItemService.removeAllCartItems(cart);

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
	}

	@RequestMapping(value = "/cartItem/{product_id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> addItem(@PathVariable(value = "product_id") String product_id) {
			//product_id를 기준으로 product정보를 가져온다.
		Product product = productService.getProductById(product_id);
		
		Cart cart = cartService.getCartById(1);  // temporary

		
		List<CartItem> cartItems = cart.getCartItems();

		// check if cartitem for a given product already exists 카트아이템을 다 뒤져서 같은 아이템이 존재하면 
		// quantity를 증가 시키고 
		for (int i = 0; i < cartItems.size(); i++) {
			if (product.getProduct_id() == cartItems.get(i).getProduct().getProduct_id()) {
				CartItem cartItem = cartItems.get(i);
				cartItem.setQuantity(cartItem.getQuantity() + 1);
				cartItem.setTotalPrice(product.getProduct_price() * cartItem.getQuantity());
				
				cartItemService.addCartItem(cartItem);

				return new ResponseEntity<Void>(HttpStatus.OK);
			}
		}

		// create new cartItem // 그렇지 않으면 아이템을 하나 만들어주면서 수량은 1로 넣는다. 
		CartItem cartItem = new CartItem();
		cartItem.setQuantity(1);
		cartItem.setTotalPrice(product.getProduct_price() * cartItem.getQuantity());
		
		cartItem.setProduct(product);
		cartItem.setCart(cart);
		
		cartItemService.addCartItem(cartItem);

		// bidirectional
		cart.getCartItems().add(cartItem);		

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/cartItem/{product_id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> removeItem(@PathVariable(value = "product_id") String product_id) {

		Cart cart = cartService.getCartById(1);  // temporary

		CartItem cartItem = cartItemService.getCartItemByProduct_id(cart.getCart_id(), product_id);
		cartItemService.removeCartItem(cartItem);

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

	}


}
