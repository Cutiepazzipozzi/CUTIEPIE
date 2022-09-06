package jpa.practice.order;

import jpa.practice.controller.ProductForm;
import jpa.practice.product.Product;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Table(name="order_product")
// 상품 종류마다 하나의 객체가 되어 주문서에 들어갈 준비를 마치는 것!
public class OrderProduct {

    @Id
    @GeneratedValue
    @Column(name="order_product_id")
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="order_id")
    private Order order;

    private int price;
    private int count;

    public void cancel() {
        getProduct().addStock(count);
    }

    public void addProduct() {
        getProduct().addStock(count);
    }

    public int total() {
        return getCount()*getPrice();
    }
}
