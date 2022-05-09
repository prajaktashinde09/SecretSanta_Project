package com.hof.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hof.domain.Category;
import com.hof.domain.Giftfor;
import com.hof.domain.Occasion;
import com.hof.domain.Product;
public interface ProductRepository extends JpaRepository<Product, Integer>{
	

	public List<Product> findAll();
	
	public Product findByproductId(Integer id);
	
	@Transactional
	@Query(value = "Select * from Product prod where prod.category_id  = :category And prod.giftfor_id = :gf And prod.occasion_id  = :oc", nativeQuery = true)
	public List<Product> findByGiftforAndOccasionAndCategory(@Param("category")Category category, @Param("gf") Giftfor gf, @Param("oc")Occasion oc);

	
	 @Modifying
	 @Transactional
	 @Query(value ="UPDATE Product p SET p.visibility = 0 WHERE p.product_id = :id", nativeQuery=true)
	  public void deleteProduct(@Param("id") Long pid);
	 


}
