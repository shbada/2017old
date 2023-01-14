package com.flowershop.product.service;

import java.util.Map;

import com.flowershop.product.domain.ProductVo;
import com.flowershop.product.domain.SaleVo;

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

	void saleWriteSave(SaleVo saleVo);

	void updateSaleYn(SaleVo saleVo);

	Map<String, Object> productSaleList(ProductVo productVo);

	void productSaleDelete(int product_no);

	void saleDelete(int product_no);

	SaleVo selectSaleInfo(ProductVo productVo);

}
