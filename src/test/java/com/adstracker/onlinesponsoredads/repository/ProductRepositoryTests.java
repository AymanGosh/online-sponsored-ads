package com.adstracker.onlinesponsoredads.repository;

import com.adstracker.onlinesponsoredads.model.entity.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ProductRepositoryTests {
    @Autowired
    private ProductRepo productRepo;
    @Test
    public void ProductRepository_Save_ReturnSavedProduct() {
        //Arrange
        Product product = saveNewProduct("MacBook Pro","Gaming",1999.99);
        //Act
        Product savedproduct = productRepo.save(product);
        //Assert
        Assertions.assertThat(savedproduct).isNotNull();
        Assertions.assertThat(savedproduct.getProductId()).isGreaterThan(0);
    }
    @Test
    public void ProductRepository_GetAll_ReturnMoreThenOneProduct() {
        //Arrange
        Product product1 = saveNewProduct("MacBook Pro","Gaming",1999.99);
        Product product2 = saveNewProduct("Canon EOS 5D Mark IV", "Electronics", 2499.99);
        //Act
        productRepo.save(product1);
        productRepo.save(product2);
        List<Product> productList = productRepo.findAll();
        //Assert
        Assertions.assertThat(productList).isNotNull();
        //When the server was initiated, a total of 26 products were successfully preserved(from data.sql).
        Assertions.assertThat(productList.size()).isEqualTo(28);
    }
    public Product saveNewProduct(String productName , String ProductCategory , Double productPrice){
        Product product = Product.builder()
                .productName(productName)
                .productCategory(ProductCategory)
                .productPrice(productPrice)
                .build();
        return product;
    }
}
