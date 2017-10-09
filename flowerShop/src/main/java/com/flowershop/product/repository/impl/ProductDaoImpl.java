package com.flowershop.product.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flowershop.product.domain.ProductVo;
import com.flowershop.product.domain.SaleVo;
import com.flowershop.product.repository.ProductDao;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	private SqlSession session;
	
	public List<ProductVo> productList(ProductVo productVo) {
		return session.selectList("product.productList", productVo);
	}
	
	public int productListCount(ProductVo productVo) {
		return (int)session.selectOne("product.productListCount", productVo);
	}
	
	public void insertProduct(ProductVo productVo) {
		session.insert("product.insertProduct", productVo);
	}
	
	public ProductVo productDetail(ProductVo productVo) {
		return (ProductVo)session.selectOne("product.productDetail", productVo);
	}
	
	public void productUpdateSave(ProductVo productVo) {
		session.update("product.productUpdateSave", productVo);
	}
	
	public String fileInfo(int product_no) {
		return (String)session.selectOne("product.fileInfo",product_no);
	}
	
	public void productDelete(int product_no) {
		session.delete("product.productDelete", product_no);
	}
	
	public List<ProductVo> viewLowPrice(ProductVo productVo) {
		return session.selectList("product.viewLowPrice", productVo);
	}
	
	public List<ProductVo> viewHighPrice(ProductVo productVo) {
		return session.selectList("product.viewHighPrice", productVo);
	}
	
	public List<ProductVo> viewName(ProductVo productVo) {
		return session.selectList("product.viewName", productVo);
	}

	@Override
	public int LikeSelect(ProductVo productVo) {
		return session.selectOne("like.LikeSelect", productVo);
	}
	
	@Override
	public ProductVo LikeUpSelect(ProductVo productVo) {
		return (ProductVo) session.selectOne("like.LikeUpSelect", productVo);
	}

	@Override
	public void likeUpSave(ProductVo productVo) {
		session.insert("like.likeUpSave", productVo);
	}

	@Override
	public void saleWriteSave(SaleVo saleVo) {
		session.insert("product.saleWriteSave", saleVo);
	}

	@Override
	public void updateSaleYn(SaleVo saleVo) {
		session.update("product.updateSaleYn", saleVo);
	}

	@Override
	public List<ProductVo> productSaleList(ProductVo productVo) {
		return session.selectList("product.productSaleList", productVo);
	}

	@Override
	public void productSaleDelete(int product_no) {
		session.update("product.productSaleDelete", product_no);
	}

	@Override
	public void saleDelete(int product_no) {
		session.delete("product.saleDelete", product_no);
	}

}
