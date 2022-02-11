package kr.ac.yja.cse.model;


import java.io.Serializable;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity//entity class라는 것을 알려줄 수 있다. 
@Table(name="product")
public class Product implements Serializable{//접근하기 위해서 롬복으로 구현해주었다.
	/**
	 * 
	 */
	private static final long serialVersionUID = -4099833393054939505L;
	@Id
	@NotEmpty(message="The Product id must not be null")
	@Column(name="product_id", nullable =false)//name은 product_id이고 null이 되서는 안된다.
	private String product_id;
	
	@NotEmpty(message="The Product name must not be null")
	private String product_name;
	
	private String product_category;
	
	@Min(value=0, message="The product price must not be less then zero")
	private int product_price;
	
	private String product_info;
	private String filename;//file name을 저장하기 위한 필드
	
	@Transient //db테이블에는 얘가 아닌 위에 file name이 들어간다.
	private MultipartFile product_image;

}
