package com.flowershop.product.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flowershop.cart.service.CartService;
import com.flowershop.login.domain.UserVo;
import com.flowershop.product.domain.ProductVo;
import com.flowershop.product.service.ProductService;

@Controller
public class ProductController {

	private Log log = LogFactory.getLog(ProductController.class);

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping(value="/productList", method={RequestMethod.GET, RequestMethod.POST})
	public String ProductList(@ModelAttribute("ProductVo") ProductVo productVo, Model model){
		
		/** 페이징 처리 */
		if(productVo.getPage_cnt() == null) productVo.setPageSize(5);
		else productVo.setPageSize(Integer.parseInt(productVo.getPage_cnt()));
		
		Map<String, Object> map = productService.productList(productVo); 
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@"+map.get("list"));
		/** 페이징 처리 */
		model.addAttribute("pageVO", productVo);
		
		model.addAttribute("list", map.get("list")); 
		log.info(productVo.getEndPageNo());
		return "product/productList";
	}
	
	@RequestMapping(value="/productWrite", method={RequestMethod.GET, RequestMethod.POST})
	public String ProductWrite(Model model){
		
		return "product/productWrite";
	}
	
	@RequestMapping(value="/productWriteSave", method={RequestMethod.GET, RequestMethod.POST})
	public String ProductWriteSave(@ModelAttribute ProductVo productVo, Model model){
		String filename = "";
        // 첨부파일(상품사진)이 있으면
        if(!productVo.getProduct_photo().isEmpty()){
            filename = productVo.getProduct_photo().getOriginalFilename();
            // 개발디렉토리 - 파일 업로드 경로
            //String path = "C:\\Users\\doubles\\Desktop\\workspace\\gitSpring\\"
            //                + "spring02\\src\\main\\webapp\\WEB-INF\\views\\images";
            // 배포디렉토리 - 파일 업로드 경로
            String path = "C:\\project\\ganadamart\\"
                    + ".metadata\\.plugins\\org.eclipse.wst.server.core\\"
                    + "tmp0\\wtpwebapps\\flowerShop\\resources\\img\\";

            try {
                new File(path).mkdirs(); // 디렉토리 생성
                // 임시디렉토리(서버)에 저장된 파일을 지정된 디렉토리로 전송
                productVo.getProduct_photo().transferTo(new File(path+filename));
            } catch (Exception e) {
                e.printStackTrace();
            }
            productVo.setProduct_url(filename); // 파일 경로를 Vo에 저장
            productService.insertProduct(productVo); // 상품을 등록
        }
        return "redirect:/productList.do";
	}
	
	@RequestMapping(value="/productDetail", method=RequestMethod.POST)
	public String ProductDetail(@ModelAttribute("ProductVo") ProductVo productVo, Model model, HttpSession session){
		
		ProductVo list = productService.productDetail(productVo); 
		int resultCnt = productService.LikeSelect(productVo); 
		model.addAttribute("like", resultCnt); 
		model.addAttribute("ProductVo", list); 
		model.addAttribute("pageVo", productVo);
		return "/product/productDetail";
	}
	
	@RequestMapping(value="/productUpdate", method=RequestMethod.POST)
	public String ProductUpdate(@ModelAttribute("ProductVo") ProductVo productVo, Model model, HttpSession session){
		ProductVo list = productService.productDetail(productVo);
		model.addAttribute("ProductVo", list); 
		return "/product/productUpdate";
	}
	
	@RequestMapping(value="/productUpdateSave", method=RequestMethod.POST)
	public String ProductUpdateSave(@ModelAttribute("ProductVo") ProductVo productVo, Model model, HttpSession session){
		String filename = "";
        // 첨부파일(상품사진)이 변경되면
        if(!productVo.getProduct_photo().isEmpty()){
            filename = productVo.getProduct_photo().getOriginalFilename();
            
            String path = "C:\\project\\ganadamart\\"
                    + ".metadata\\.plugins\\org.eclipse.wst.server.core\\"
                    + "tmp0\\wtpwebapps\\flowerShop\\resources\\img\\";
            try {
                new File(path).mkdirs(); // 디렉토리 생성
                // 임시디렉토리(서버)에 저장된 파일을 지정된 디렉토리로 전송
                productVo.getProduct_photo().transferTo(new File(path+filename));
            } catch (Exception e) { //에러처리
                e.printStackTrace();
            }
            productVo.setProduct_url(filename);
        // 첨부파일이 변경되지 않으면
        } else {
            // 기존의 파일명
            ProductVo vo2 = productService.productDetail(productVo); 
            productVo.setProduct_url(vo2.getProduct_url()); 
        }
        productService.productUpdateSave(productVo);
        return "redirect:/productList.do";
	}
	
	
	@RequestMapping(value="/productDelete", method=RequestMethod.POST)
	public String ProductDelete(@RequestParam int product_no){
		 // 상품 이미지 정보
        String filename = productService.fileInfo(product_no);
        String path = "C:\\project\\ganadamart\\"
                + ".metadata\\.plugins\\org.eclipse.wst.server.core\\"
                + "tmp0\\wtpwebapps\\flowerShop\\resources\\img\\";
        // 상품 이미지 삭제
        if(filename != null){
            File file = new File(path+filename);
            // 파일이 존재하면
            if (file.exists()){ 
                file.delete(); // 파일 삭제
            }
        }
        cartService.cartDelete(product_no); 
        productService.productDelete(product_no); 
        return "redirect:productList.do";
    }
	
	
	@RequestMapping(value="/viewLowPrice", method={RequestMethod.GET, RequestMethod.POST})
	public String ViewLowPrice(@ModelAttribute ProductVo productVo, Model model){
		
		/** 페이징 처리 */
		if(productVo.getPage_cnt() == null) productVo.setPageSize(5);
		else productVo.setPageSize(Integer.parseInt(productVo.getPage_cnt()));
		
		Map<String, Object> map = productService.viewLowPrice(productVo); 
		
		/** 페이징 처리 */
		model.addAttribute("pageVO", productVo);
		
		model.addAttribute("list", map.get("list")); 
		log.info(productVo.getEndPageNo());
		return "product/productList";
	}
	
	@RequestMapping(value="/viewHighPrice", method={RequestMethod.GET, RequestMethod.POST})
	public String ViewHighPrice(@ModelAttribute ProductVo productVo, Model model){
		
		/** 페이징 처리 */
		if(productVo.getPage_cnt() == null) productVo.setPageSize(5);
		else productVo.setPageSize(Integer.parseInt(productVo.getPage_cnt()));
		
		Map<String, Object> map = productService.viewHighPrice(productVo); 
		
		/** 페이징 처리 */
		model.addAttribute("pageVO", productVo);
		
		model.addAttribute("list", map.get("list")); 
		log.info(productVo.getEndPageNo());
		return "product/productList";
	}
	
	@RequestMapping(value="/viewName", method={RequestMethod.GET, RequestMethod.POST})
	public String ViewName(@ModelAttribute ProductVo productVo, Model model){
		
		/** 페이징 처리 */
		if(productVo.getPage_cnt() == null) productVo.setPageSize(5);
		else productVo.setPageSize(Integer.parseInt(productVo.getPage_cnt()));
		
		Map<String, Object> map = productService.viewName(productVo); 
		
		/** 페이징 처리 */
		model.addAttribute("pageVO", productVo);
		
		model.addAttribute("list", map.get("list"));
		log.info(productVo.getEndPageNo());
		return "product/productList";
	}
	
	@RequestMapping(value="/likeUpSave", method=RequestMethod.POST)
	@ResponseBody
	public String LikeUpSave(@ModelAttribute ProductVo productVo, HttpSession session) throws IOException{
		
		System.out.println("@@@@1");
		
		Object obj = session.getAttribute("authUser");
		
		UserVo vo = (UserVo) obj;
		String user_id = vo.getUser_id();
		
		productVo.setUser_id(user_id);
		
		ProductVo productLike= productService.LikeUpSelect(productVo);
		
		if(productLike == null){
			productService.likeUpSave(productVo); 
			return "ok";
		}
		else return "fal";
	}
}
