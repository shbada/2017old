package com.flowershop.product.service;

import java.util.Map;

import com.flowershop.product.domain.ProductVo;

public interface ProductService {

	Map<String, Object> productList(ProductVo productVo);

	void insertProduct(ProductVo productVo);

	ProductVo productDetail(ProductVo productVo);

	void productUpdateSave(ProductVo productVo);

	String fileInfo(int product_no);

	void productDelete(int product_no);

	Map<String, Object> viewLowPrice(ProductVo productVo);

	Map<String, Object> viewHighPrice(ProductVo productVo);

	Map<String, Object> viewName(ProductVo productVo);

	int LikeSelect(ProductVo productVo);
	
	ProductVo LikeUpSelect(ProductVo productVo);
	
	void likeUpSave(ProductVo productVo);

}
