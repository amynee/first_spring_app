package com.example.demo;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Product;
import com.example.demo.repos.ProductRepository;

@SpringBootTest
class ProductsApplicationTests {

	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void createProductTest() {
		Product prod = new Product("PC HP", 2200.500, new Date());
		productRepository.save(prod);
	}
	
	@Test
	public void findProductTest() {
		Product prod = productRepository.findById(1L).get();
		System.out.println(prod);
	}
	
	@Test
	public void updateProductTest() {
		Product prod = productRepository.findById(1L).get();
		prod.setProductPrice(2000.00);
		productRepository.save(prod);
		System.out.println(prod);
	}
	
	@Test
	public void deleteProductTest() {
		productRepository.deleteById(1L);
	}
	
	@Test
	public void listProductsTest() {
		List<Product> products = productRepository.findAll();
		for (Product product: products) {
			System.out.println(product);
		}
	}
	
}
