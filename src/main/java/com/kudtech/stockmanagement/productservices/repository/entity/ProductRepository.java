package com.kudtech.stockmanagement.productservices.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product getByProductIdAndDeletedFalse(Long productId); //  parametro olarak verilen product ıd ile database git ve isdeleted false ise kaydı getir demek istedik
    List<Product> getAllByDeletedFalse();// bu da isdeleted false olan data ları databaseden cekicek
}
