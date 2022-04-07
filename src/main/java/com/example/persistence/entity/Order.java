package com.example.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order", schema = "sch_order")
@SequenceGenerator(name = "seq_order", sequenceName = "seq_order", schema = "sch_order")
public class Order {

    @Id
    @GeneratedValue(generator = "seq_order", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "BUYER_ID", nullable = false)
    private Long buyerId;

    @Column(name = "PRODUCT_ID", nullable = false)
    private Long productId;

    @Column(name = "PRODUCT_FIELD1")
    private String productField1;

    @Column(name = "PRODUCT_FIELD2")
    private String productField2;

    @Column(name = "SELLER_ID", nullable = false)
    private Long sellerId;

    @Column(name = "SELLER_FIELD1")
    private String sellerField1;

    @Column(name = "SELLER_FIELD2")
    private String sellerField2;

    @Column(name = "ORDER_FIELD1")
    private String orderField1;

    @Column(name = "ORDER_FIELD2")
    private String orderField2;

    @Column(name = "QUANTITY")
    private int quantity;

}
