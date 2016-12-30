package com.aj.james.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aj.james.dao.CategoryDAO;
import com.aj.james.dao.ProductDAO;
import com.aj.james.dao.SupplierDAO;
import com.aj.james.model.Category;
import com.aj.james.model.Product;
import com.aj.james.model.Supplier;
import com.aj.james.util.Util;


@Controller
public class ProductController {
	

	@Autowired(required = true)
	private ProductDAO productDAO;

	@Autowired(required = true)
	private CategoryDAO categoryDAO;

	@Autowired(required = true)
	private SupplierDAO supplierDAO;

	private Path path;

	/*
	 * @Autowired(required=true)
	 * 
	 * @Qualifier(value="productDAO") public void setProductDAO(ProductDAO ps){
	 * this.productDAO = ps; }
	 */

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String listProducts(Model model) {
		System.out.println("Hello.. I'm inside /products list");
		model.addAttribute("isAdminClickedProducts", "true");
		model.addAttribute("product", new Product());
		model.addAttribute("productList", this.productDAO.list());

		model.addAttribute("Category", new Category());
		model.addAttribute("Supplier", new Supplier());

		model.addAttribute("supplierList", this.supplierDAO.list());
		model.addAttribute("categoryList", this.categoryDAO.list());

		return "product";
	}

	// For add and update product both
	@RequestMapping(value = "/product/add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product, Model model) {

		Category category = categoryDAO.getByName(product.getCategory().getCategory_name());
		System.out.println(category.getCategory_id() + ":" + category.getCategory_name() + ":" + category.getDescription());

		Supplier supplier = supplierDAO.getByName(product.getSupplier().getName());
		System.out.println(supplier.getId() + ":" + supplier.getName() + ":" + supplier.getAddress());

		model.addAttribute("Supplier", supplier);
		model.addAttribute("Category", category);
		model.addAttribute("supplierList", this.supplierDAO.list());
		model.addAttribute("categoryList", this.categoryDAO.list());

		String newID = Util.removeComma(product.getId());
		product.setId(newID);

		product.setCategory_id(category.getCategory_id());
		product.setSupplier_id(supplier.getId());

		product.setCategory(category);
		product.setSupplier(supplier);

		productDAO.saveOrUpdate(product);

		/*
		 * path="D:\\product\\image"; FileUtil.upload(path, itemImage,
		 * product.getId()+".png");
		 */
	
		MultipartFile itemImage = product.getItemImage();
		path = Paths
				.get("/Users/James/Documents/ajkartprojectworkspace/Ekart/src/main/webapp/WEB-INF/resources/img/img/productImages/"
						+ product.getId() + ".jpeg");

		if (itemImage != null && !itemImage.isEmpty()) {
			try {
				System.out.println("inside try");
				itemImage.transferTo(new File(path.toString()));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("product image saving failed.", e);
			}
		}

		return "redirect:/products";

	}

	@RequestMapping("/product/remove/{id}")
	public String removeProduct(@PathVariable("id") String id, ModelMap model) throws Exception {
		System.out.println("Hello.. I'm inside /products remove");
		try {
			productDAO.delete(id);
			model.addAttribute("message", "Successfully deleted");

			path = Paths
					.get("Users/James/Documents/ajkartprojectworkspace/Ekart/src/main/webapp/WEB-INF/resources/img/img/productImages/"
							+ id + ".jpeg");

			if (Files.exists(path)) {
				try {
					Files.delete(path);
					System.out.println("Image successfully deleted");
				} catch (IOException e) {
					System.out.println("Error in Image deletion");
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}

		// redirectAttrs.addFlashAttribute(arg0, arg1)
		return "redirect:/products";
	}

	@RequestMapping("/product/edit/{id}")
	public String editProduct(@PathVariable("id") String id, Model model) {
		model.addAttribute("isAdminClickedEditProducts", "true");
		System.out.println("Hello.. I'm inside /products edit");
		model.addAttribute("Category", new Category());
		model.addAttribute("Supplier", new Supplier());
		model.addAttribute("supplierList", this.supplierDAO.list());
		model.addAttribute("categoryList", this.categoryDAO.list());
		model.addAttribute("product", this.productDAO.get(id));
		// model.addAttribute("productList", this.productDAO.list());
		return "product";
	}

	/*
	 * @RequestMapping("/product/get/{id}") public String
	 * getProduct(@PathVariable("id") String id, Model model) {
	 * System.out.println("get Product"); model.addAttribute("Supplier",
	 * supplier); model.addAttribute("Category", category);
	 * model.addAttribute("supplierList", this.supplierDAO.list());
	 * model.addAttribute("categoryList", this.categoryDAO.list());
	 * product=productDAO.get(id); model.addAttribute("product",product);
	 * model.addAttribute("selectedProduct",
	 * this.productDAO.getByName(product.getName()));
	 * model.addAttribute("productList", this.productDAO.list()); //return
	 * "/iindex"; return "redirect:/"; }
	 */

	@RequestMapping("product/get/{id}")
	public String getSelectedProduct(@PathVariable("id") String id, Model model,
			RedirectAttributes redirectAttributes) {
		System.out.println("getSelectedProduct");

		model.addAttribute("productList", this.productDAO.list());

		// redirectAttributes.addFlashAttribute("selectedProduct",
		// this.productDAO.get(id));
		model.addAttribute("selectedProduct", this.productDAO.get(id));
		// model.addAttribute("categoryList", this.categoryDAO.list());
		return "productInfo";
	}
	
}
