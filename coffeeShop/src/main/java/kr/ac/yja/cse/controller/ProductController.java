package kr.ac.yja.cse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.yja.cse.model.Product;
import kr.ac.yja.cse.service.ProductService;

@Controller //servlet-context.xml에 정해준 경로에 따라 controller들 자동 빈 등록
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/products")
	public String getProducts(Model model) {
		
		List<Product> products =productService.getProducts();//서비스에 있는 리스트를 가져온다.
		
		model.addAttribute("products", products);//후에 그 값을 모델에 저장함
		
		
		return "products"; //view의 jsp name
	}
	@RequestMapping("/viewProduct/{product_id}")
	public String viewProduct (@PathVariable String product_id, Model model) {
		
		Product product =productService.getProductById(product_id);
		model.addAttribute("product", product);
		return "viewProduct";
		
	}

}
