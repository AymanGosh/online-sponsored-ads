package com.adstracker.onlinesponsoredads.repository;

import com.adstracker.onlinesponsoredads.model.entity.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ProductRepositoryTests {
    @Autowired
    private ProductRepo productRepo;
    @Test
    public void ProductRepository_Save_ReturnSavedProduct() {
        //Arrange
        Product product = Product.builder()
                .productName("MacBook Pro")
                .productCategory("Gaming")
                .productPrice(1999.9)
                .build();

        //Act
        Product savedproduct = productRepo.save(product);
        //Assert
        Assertions.assertThat(savedproduct).isNotNull();
        Assertions.assertThat(savedproduct.getProductId()).isGreaterThan(0);
    }
}
