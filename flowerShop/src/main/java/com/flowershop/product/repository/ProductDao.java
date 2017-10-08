package com.flowershop.product.repository;

import java.util.List;

import com.flowershop.product.domain.ProductVo;

public interface ProductDao {

	int productListCount(ProductVo productVo);

	List<ProductVo> productList(ProductVo productVo);

	void insertProduct(ProductVo productVo);

	ProductVo productDetail(ProductVo productVo);

	void productUpdateSave(ProductVo productVo);

	String fileInfo(int product_no);

	void productDelete(int product_no);

	List<ProductVo> viewLowPrice(ProductVo productVo);

	List<ProductVo> viewHighPrice(ProductVo productVo);

	List<ProductVo> viewName(ProductVo productVo);

	int LikeSelect(ProductVo productVo);
	
	ProductVo LikeUpSelect(ProductVo productVo);
	
	void likeUpSave(ProductVo productVo);

}
