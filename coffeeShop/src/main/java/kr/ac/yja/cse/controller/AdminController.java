package kr.ac.yja.cse.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.yja.cse.model.Product;
import kr.ac.yja.cse.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ProductService productService;

	@RequestMapping
	public String adminPage() {
		return "admin";
	}

	@RequestMapping("/productInventory")
	public String getProducts(Model model) {
		List<Product> products = productService.getProducts();
		model.addAttribute("products", products);
		return "productInventory";
	}

	@RequestMapping(value = "/productInventory/addProduct", method = RequestMethod.GET)
	public String addProduct(Model model) {

		Product product = new Product();
		product.setProduct_category("Espresso");// Espresso로 default 셋팅
		model.addAttribute("product", product);

		return "addProduct";
	}// getmethod처리 하는 것이니까 아래 하나 더 만들어줌.

	@RequestMapping(value = "/productInventory/addProduct", method = RequestMethod.POST)
	public String addProductPost(@Valid Product product, BindingResult result, HttpServletRequest request) {

		if (result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "addProduct";
		}

		MultipartFile product_image = product.getProduct_image();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		Path savePath = Paths.get(rootDirectory + "\\resources\\img\\" + product_image.getOriginalFilename());

		if (product_image.isEmpty() == false) {
			System.out.println("------file start------");
			System.out.println("name : " + product_image.getName());
			System.out.println("filename : " + product_image.getOriginalFilename());
			System.out.println("size : " + product_image.getSize());
			System.out.println("savePath : " + savePath);
			System.out.println("------file end------\n");

		}
		if (product_image != null && !product_image.isEmpty()) {
			try {
				product_image.transferTo(new File(savePath.toString()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// form에서 받은 걸 add해서 처리하는 함수 //객체에 넘겨준다. =>Data Binding
		product.setFilename(product_image.getOriginalFilename());
		productService.addProduct(product);
		return "redirect:/admin/productInventory";// 다시 조회를 해서 products 넣어준다.
	}

	@RequestMapping(value = "/productInventory/deleteProduct/{product_id}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable String product_id,  HttpServletRequest request) {// spring에서 url에 있는 인자를 자동으로 넣어줌 -? @pa
		Product product = productService.getProductById(product_id);
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		Path savePath = Paths.get(rootDirectory + "\\resources\\img\\" + product.getFilename());
		
		if(Files.exists(savePath)) {
			try {
				Files.delete(savePath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		productService.deleteProduct(product);
		return "redirect:/admin/productInventory";
	}

	@RequestMapping(value = "/productInventory/updateProduct/{product_id}", method = RequestMethod.GET)
	public String updateProduct(@PathVariable String product_id, Model model) {

		Product product = productService.getProductById(product_id);
		model.addAttribute("product", product);
		return "updateProduct";
	}

	@RequestMapping(value = "/productInventory/updateProduct", method = RequestMethod.POST)
	public String updateProduct(@Valid Product product, BindingResult result, HttpServletRequest request) {
		if (result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "updateProduct";
		}
		MultipartFile product_image = product.getProduct_image();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		Path savePath = Paths.get(rootDirectory + "\\resources\\img\\" + product_image.getOriginalFilename());

		if (product_image.isEmpty() == false) {
			System.out.println("------file start------");
			System.out.println("name : " + product_image.getName());
			System.out.println("filename : " + product_image.getOriginalFilename());
			System.out.println("size : " + product_image.getSize());
			System.out.println("savePath : " + savePath);
			System.out.println("------file end------\n");

		}
		if (product_image != null && !product_image.isEmpty()) {
			try {
				product_image.transferTo(new File(savePath.toString()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		product.setFilename(product_image.getOriginalFilename());
		productService.updateProduct(product);
		return "redirect:/admin/productInventory";
	}

}
