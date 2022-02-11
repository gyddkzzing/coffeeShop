package kr.ac.yja.cse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@RequestMapping
	public String getCart (Model model) {
		
		model.addAttribute("cart_id", 1);
		
		return "cart";
	}

}
