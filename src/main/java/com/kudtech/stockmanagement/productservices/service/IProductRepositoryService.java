package com.kudtech.stockmanagement.productservices.service;

import com.kudtech.stockmanagement.productservices.enums.Language;
import com.kudtech.stockmanagement.productservices.repository.entity.Product;
import com.kudtech.stockmanagement.productservices.request.ProductCreateRequest;
import com.kudtech.stockmanagement.productservices.request.ProductUpdateRequest;

import java.util.List;


public interface IProductRepositoryService {
    Product  createProduct(Language language , ProductCreateRequest productCreateRequest); // bu metoda language create reqıest vericez o da bize procuct donucek

    Product getProduct  (Language language , Long productId); // tüm productları dönmek için
    // tüm kayıtları dönmesi lazım onun için bir metod lazım
    List<Product> getProducts(Language language);

    Product updateProduct(Language language , Long productId , ProductUpdateRequest productUpdateRequest);
    Product deleteProduct(Language language , Long productId);
}
