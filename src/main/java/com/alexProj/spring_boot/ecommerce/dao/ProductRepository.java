package com.alexProj.spring_boot.ecommerce.dao;

import com.alexProj.spring_boot.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins="http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> {


}
