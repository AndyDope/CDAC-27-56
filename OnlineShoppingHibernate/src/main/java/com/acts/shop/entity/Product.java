package com.acts.shop.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "Prod_ID")
    int prodID;
    
    @Column(name = "Prod_Name")
    String prodName;

    @Column(name = "Prod_price", precision = 10, scale = 2, nullable = false)
    BigDecimal prodPrice;

    @Column(name = "Prod_img_url")
    String imgUrl;

    @Column(name = "Cat_id")
    int catID;

    public Product() {
    }

    public Product(int prodID, String prodName, BigDecimal prodPrice, String imgUrl, int catID) {
        this.prodID = prodID;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
        this.imgUrl = imgUrl;
        this.catID = catID;
    }

    public int getProdID() {
        return prodID;
    }

    public void setProdID(int prodID) {
        this.prodID = prodID;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public BigDecimal getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(BigDecimal prodPrice) {
        this.prodPrice = prodPrice;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getCatID() {
        return catID;
    }

    public void setCatID(int catID) {
        this.catID = catID;
    }

    @Override
    public String toString() {
        return "Product [prodID=" + prodID + ", prodName=" + prodName + ", prodPrice=" + prodPrice + ", imgUrl="
                + imgUrl + ", catID=" + catID + "]";
    }

}
