package com.kudtech.stockmanagement.productservices.repository.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product" , schema = "stock_management") //yani database stockmanagement semasında product isminde bir tablo olusturacak
public class Product {
    @Id
    @Column(name="product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    @Column(name="product_name")
    private String productName;

    @Column(name="quantity")
    private int quantity; // bu alan ürünün miktarının tutacak

    @Column(name="price")
    private double price;

    // bu kaydın en son ne zaman guncellendigini öğrenebilmek için

    @Builder.Default // Bunun anlamı su constructorda default olarak her zaman parametre olarak gecicek demek oluyor
    @Column(name="product_updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date productUpdatedDate=new Date();

    // birde tabloda kaydın ne zaman olustgunun tutabilmek için
    @Builder.Default // Bunun anlamı su constructorda default olarak her zaman parametre olarak gecicek demek oluyor
    @Column(name="product_creaded_date")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date productCreatedDate=new Date();

    @Column(name="is_deleted")
    private boolean deleted; // yani bu alandan hiçbir şey silememiş olıcaz true cekip
}
