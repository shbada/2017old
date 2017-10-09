package com.flowershop.product.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flowershop.product.domain.ProductVo;
import com.flowershop.product.domain.SaleVo;
import com.flowershop.product.repository.ProductDao;
import com.flowershop.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Override
	public Map<String, Object> productList(ProductVo productVo) {
		List<ProductVo> list = productDao.productList(productVo); 
		
		Map<String, Object> map = new HashMap<String, Object>(); 
		
		map.put("list", list); 
		
		return map;
	}
	
	@Override
	public void insertProduct(ProductVo productVo) {
		productDao.insertProduct(productVo);
	}
	
	@Override
	public ProductVo productDetail(ProductVo productVo) {
		return productDao.productDetail(productVo);
	}
	
	@Override
	public void productUpdateSave(ProductVo productVo) {
		productDao.productUpdateSave(productVo);
	}
	
	@Override
	public String fileInfo(int product_no) {
		return productDao.fileInfo(product_no);
	}
	
	@Override
	public void productDelete(int product_no) {
		productDao.productDelete(product_no);
	}
	
	@Override
	public Map<String, Object> viewLowPrice(ProductVo productVo) {
		List<ProductVo> list = productDao.viewLowPrice(productVo); 
		
		Map<String, Object> map = new HashMap<String, Object>(); 
		
		map.put("list", list);
		
		return map;
	}
	
	@Override
	public Map<String, Object> viewHighPrice(ProductVo productVo) {
		List<ProductVo> list = productDao.viewHighPrice(productVo);
		
		Map<String, Object> map = new HashMap<String, Object>(); 
		
		map.put("list", list); 
		
		return map;
	}
	
	@Override
	public Map<String, Object> viewName(ProductVo productVo) {
		List<ProductVo> list = productDao.viewName(productVo); 
		
		Map<String, Object> map = new HashMap<String, Object>(); 
		
		map.put("list", list);
		
		return map;
	}

	@Override
	public int LikeSelect(ProductVo productVo) {
		return productDao.LikeSelect(productVo);
	}
	
	@Override
	public ProductVo LikeUpSelect(ProductVo productVo) {
		return productDao.LikeUpSelect(productVo);
	}

	@Override
	public void likeUpSave(ProductVo productVo) {
		productDao.likeUpSave(productVo);
	}
	
	@Override
	public void saleWriteSave(SaleVo saleVo) {
		productDao.saleWriteSave(saleVo);
	}

	@Override
	public void updateSaleYn(SaleVo saleVo) {
		productDao.updateSaleYn(saleVo);
	}

	@Override
	public Map<String, Object> productSaleList(ProductVo productVo) {
		
		List<ProductVo> list = productDao.productSaleList(productVo); 
		
		Map<String, Object> map = new HashMap<String, Object>(); 
		
		map.put("list", list); 
		
		return map;
	}

	@Override
	public void productSaleDelete(int product_no) {
		productDao.productSaleDelete(product_no);
	}

	@Override
	public void saleDelete(int product_no) {
		productDao.saleDelete(product_no);
	}

}
