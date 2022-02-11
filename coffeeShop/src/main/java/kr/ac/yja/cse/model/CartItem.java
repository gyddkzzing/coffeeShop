package kr.ac.yja.cse.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="cartitem")
public class CartItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6686312278832949381L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="cart_id") //사용자마다 값이 나오니까 사용자 id와 동일하다고 줘야지.
	@JsonIgnore
	private Cart cart;//나중에 forgnkey 역할
	//반복하니까 무시해라 //jackson pom.xml에 해줘야함.
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	private int quantity;
	
	private int totalPrice;

}
