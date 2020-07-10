package kr.co.sol.admin.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sol.admin.service.ProductMgrService;
import kr.co.sol.shop.dto.ProductDTO;

@Controller
public class ProcutMgrController {

	@Autowired
	ProductMgrService productMgrService;
	
	 @RequestMapping("/productMgr")
	 public String productMgr(HttpServletRequest request,
			  HttpServletResponse response,
			  ProductDTO pdto, Model model) {
		 List<ProductDTO> pdtoList = productMgrService.getProducts(pdto);
				 model.addAttribute("pdtoList",pdtoList);
		return "admin/ProductMgr";
		 
	 }
	 
	 @RequestMapping("/productInsert")
	 public String productInsert() {
		 return "admin/ProductInsert";
	 }
}
