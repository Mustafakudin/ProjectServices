package com.kudtech.stockmanagement.productservices.service.impl;

import com.kudtech.stockmanagement.productservices.enums.Language;
import com.kudtech.stockmanagement.productservices.exception.enums.FriendlyMessageCode;
import com.kudtech.stockmanagement.productservices.exception.exceptions.ProductNotCreatedException;
import com.kudtech.stockmanagement.productservices.repository.entity.Product;
import com.kudtech.stockmanagement.productservices.repository.entity.ProductRepository;
import com.kudtech.stockmanagement.productservices.request.ProductCreateRequest;
import com.kudtech.stockmanagement.productservices.request.ProductUpdateRequest;
import com.kudtech.stockmanagement.productservices.service.IProductRepositoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
// methodların içindeki olusan hataları vs terminolojiden izleyebilmek için log ekliyecegiz s4flj yazdıgımızda istedigimiz yere log ekleyebiliyoruz

// 5 tane log var biri tresh = izlemek istedigimiz loglar için kullanır
@Slf4j
@Service
@RequiredArgsConstructor
public class ProductRepositoryServiceImpl implements IProductRepositoryService {

    private final ProductRepository productRepository;
    @Override
    public Product createProduct(Language language, ProductCreateRequest productCreateRequest) {
        log.debug("[{}] [createProduct] -> request: {}", this.getClass().getSimpleName() ,productCreateRequest);
        try{
            Product product= Product.builder()
                    .productName(productCreateRequest.getProductName())
                    .quantity(productCreateRequest.getQuantity())
                    .price(productCreateRequest.getPrice())
                    .deleted(false)
                    .build();
            Product productResponse = productRepository.save(product);
            log.debug("[{}][create product] -> response : {} ", this.getClass().getSimpleName(), productResponse);
            return productResponse;
        }
        catch (Exception exception){
            throw new ProductNotCreatedException(language, FriendlyMessageCode.PRODUCT_NOT_CREATED_EXCEPTION,"product request:"+productCreateRequest.toString());
        }

    }



    @Override
    public Product getProduct(Language language, Long productId) {
        return null;
    }

    @Override
    public List<Product> getProducts(Language language) {
        return null;
    }

    @Override
    public Product updateProduct(Language language, Long productId, ProductUpdateRequest productUpdateRequest) {
        return null;
    }

    @Override
    public Product deleteProduct(Language language, Long productId) {
        return null;
    }
}
