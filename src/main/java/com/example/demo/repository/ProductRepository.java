package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long>
{
   List<Product> findByAccountingCode(int accountingCode);
   List<Product> findByPaymentCode(int paymentcode);
}

