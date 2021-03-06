package com.bfmzdx.csp.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bfmzdx.csp.BaseTest;
import com.bfmzdx.csp.dto.ImageHolder;
import com.bfmzdx.csp.dto.ProductExecution;
import com.bfmzdx.csp.entity.Product;
import com.bfmzdx.csp.entity.ProductCategory;
import com.bfmzdx.csp.entity.Shop;
import com.bfmzdx.csp.enums.ProductStateEnum;
import com.bfmzdx.csp.exceptions.ShopOperationException;

public class ProductServiceTest extends BaseTest {
	@Autowired
	private ProductService productService;

	@Test
	public void testAddProduct() throws ShopOperationException, FileNotFoundException {
		// 创建shopId为1且productCategoryId为1的商品实例并给其成员变量赋值
		Product product = new Product();
		Shop shop = new Shop();
		shop.setShopId(28L);
		ProductCategory pc = new ProductCategory();
		pc.setProductCategoryId(9L);
		product.setShop(shop);
		product.setProductCategory(pc);
		product.setProductName("测试商品1");
		product.setProductDesc("测试商品1");
		product.setPriority(20);
		product.setCreateTime(new Date());
		product.setEnableStatus(ProductStateEnum.SUCCESS.getState());
		// 创建缩略图文件流
		File thumbnailFile = new File("C:/Users/75442/Pictures/u=200987110,409871336&fm=27&gp=0.jpg");
		InputStream is = new FileInputStream(thumbnailFile);
		ImageHolder thumbnail = new ImageHolder(thumbnailFile.getName(), is);
		// 创建两个商品详情图文件流并将他们添加到详情图列表中
		File productImg1 = new File("C:/Users/75442/Pictures/u=611116088,4106962857&fm=27&gp=0.jpg");
		InputStream is1 = new FileInputStream(productImg1);
		File productImg2 = new File("C:/Users/75442/Pictures/u=959182375,3644419818&fm=200&gp=0.jpg");
		InputStream is2 = new FileInputStream(productImg2);
		List<ImageHolder> productImgList = new ArrayList<ImageHolder>();
		productImgList.add(new ImageHolder(productImg1.getName(), is1));
		productImgList.add(new ImageHolder(productImg2.getName(), is2));
		// 添加商品并验证
		ProductExecution pe = productService.addProduct(product, thumbnail, productImgList);
		assertEquals(ProductStateEnum.SUCCESS.getState(), pe.getState());
	}

	@Test
	public void testModifyProduct() throws ShopOperationException, FileNotFoundException {
		// 创建shopId为1且productCategoryId为1的商品实例并给其成员变量赋值
		Product product = new Product();
		Shop shop = new Shop();
		shop.setShopId(28L);
		ProductCategory pc = new ProductCategory();
		pc.setProductCategoryId(5L);
		product.setProductId(7L);
		product.setShop(shop);
		product.setProductCategory(pc);
		product.setProductName("正式的商品");
		product.setProductDesc("正式的商品");
		// 创建缩略图文件流
		File thumbnailFile = new File("C:/Users/75442/Pictures/u=200987110,409871336&fm=27&gp=0.jpg");
		InputStream is = new FileInputStream(thumbnailFile);
		ImageHolder thumbnail = new ImageHolder(thumbnailFile.getName(), is);
		// 创建两个商品详情图文件流并将他们添加到详情图列表中
		File productImg1 = new File("C:/Users/75442/Pictures/u=611116088,4106962857&fm=27&gp=0.jpg");
		InputStream is1 = new FileInputStream(productImg1);
		File productImg2 = new File("C:/Users/75442/Pictures/u=959182375,3644419818&fm=200&gp=0.jpg");
		InputStream is2 = new FileInputStream(productImg2);
		List<ImageHolder> productImgList = new ArrayList<ImageHolder>();
		productImgList.add(new ImageHolder(productImg1.getName(), is1));
		productImgList.add(new ImageHolder(productImg2.getName(), is2));
		// 添加商品并验证
		ProductExecution pe = productService.modifyProduct(product, thumbnail, productImgList);
		assertEquals(ProductStateEnum.SUCCESS.getState(), pe.getState());
	}

}
