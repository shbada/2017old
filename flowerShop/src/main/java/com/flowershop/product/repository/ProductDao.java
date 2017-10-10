package com.flowershop.product.repository;

import java.util.List;

import com.flowershop.product.domain.ProductVo;
import com.flowershop.product.domain.SaleVo;

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

	void saleWriteSave(SaleVo saleVo);

	void updateSaleYn(SaleVo saleVo);

	List<ProductVo> productSaleList(ProductVo productVo);

	void productSaleDelete(int product_no);

	void saleDelete(int product_no);

}
