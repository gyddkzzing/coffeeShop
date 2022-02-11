package kr.ac.yja.cse.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="cart")
public class Cart implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2073537754884434188L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cart_id;
	
	@OneToMany(mappedBy="cart", cascade = CascadeType.ALL, fetch =FetchType.EAGER)
	private List<CartItem> cartItems = new ArrayList<CartItem>();
	
	private int grandTotal;

}
