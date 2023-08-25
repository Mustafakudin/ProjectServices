package com.kudtech.stockmanagement.productservices.controller;

import com.kudtech.stockmanagement.productservices.enums.Language;
import com.kudtech.stockmanagement.productservices.exception.enums.FriendlyMessageCode;
import com.kudtech.stockmanagement.productservices.exception.enums.utils.FriendlyMessageUtils;
import com.kudtech.stockmanagement.productservices.repository.entity.Product;
import com.kudtech.stockmanagement.productservices.request.ProductCreateRequest;
import com.kudtech.stockmanagement.productservices.response.FriendlyMessage;
import com.kudtech.stockmanagement.productservices.response.InternalApiResponse;
import com.kudtech.stockmanagement.productservices.response.ProductResponse;
import com.kudtech.stockmanagement.productservices.service.IProductRepositoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j // Acıklamasını methodların içindeki olusan hataları vs terminolojiden izleyebilmek için log ekliyecegiz s4flj yazdıgımızda istedigimiz yere log ekleyebiliyoruz
// sl4j eklemek yani bir yerlerde log kullanıcaz demek
@RestController //bir jaava clasıın bir restful servisi işlevini kullanıcaını soyler ttüm metodların http isteklerini cevap vericek sekilde yapılandırır
@RequestMapping (value = "/api/1.0/product")// bir url istek yapıldıgında o url nasıl işleyecegini belirtmek için kullanılır
@RequiredArgsConstructor
class ProductController { // productResponse alıyoruz
    private final IProductRepositoryService productRepositoryService;

                                                                                //requestbody = bir web service yapılan isteklerin içerigini algılanması ve işlenmesini sağlar
    @ResponseStatus(HttpStatus.CREATED) // web servisin döndürügü yanıtın http durum koduun belirtmek için kullanılır 200 vs vs yani
    @PostMapping (value="/{language}/create")// bir web servisin bir url yapılan https post isteklerini algılamasını ve bu isteklerin ve işlemesini saglar
    public InternalApiResponse<ProductResponse> createProduct(@PathVariable("language")Language language, @RequestBody ProductCreateRequest productCreateRequest) {  // path varaiable anatasyonu bir web servisin url algılaması ve bu degiskenlere ulabilmesini saglıyor
        log.debug("[{}] [createProduct] -> request : {}" , this.getClass().getSimpleName(),productCreateRequest);
        Product product = productRepositoryService.createProduct(language,productCreateRequest);
        ProductResponse productResponse = convertProductResponse(product);
        log.debug("[{}][createProduct]->response: {}",this.getClass().getSimpleName(),productResponse);
        return InternalApiResponse.<ProductResponse>builder()
                .friendlyMessage(FriendlyMessage.builder()
                        .title(FriendlyMessageUtils.getFriendlyMessage(language, FriendlyMessageCode.SUCCES))
                        .description(FriendlyMessageUtils.getFriendlyMessage(language,FriendlyMessageCode.PRODUCT_SUCCESSFULLY_CREATED))
                        .build())
                .httpStatus(HttpStatus.CREATED)
                .hasError(false)
                .payload(productResponse)
                .build();
    }

    private static ProductResponse convertProductResponse(Product product) {
        return ProductResponse.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .quantity(product.getQuantity())
                .price(product.getPrice())
                .productCreateDate(product.getProductCreatedDate().getTime())
                .productUpdateDate(product.getProductUpdatedDate().getTime())
                .build();
    }

}

