package com.acts.shop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @Column(name = "Cat_ID")
    int catID;

    @Column(name = "Cat_Name")
    String catName;

    @Column(name = "Cat_img_url")
    String imgUrl;

    @Column(name = "Cat_description")
    String catDescription;

    public Category() {
    }

    public Category(int catID, String catName, String img_url, String catDescription) {
        this.catID = catID;
        this.catName = catName;
        this.imgUrl = img_url;
        this.catDescription = catDescription;
    }

    public int getCatID() {
        return catID;
    }

    public void setCatID(int catID) {
        this.catID = catID;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getImg_url() {
        return imgUrl;
    }

    public void setImgUrl(String img_url) {
        this.imgUrl = img_url;
    }

    public String getCatDescription() {
        return catDescription;
    }

    public void setCatDescription(String catDescription) {
        this.catDescription = catDescription;
    }

    @Override
    public String toString() {
        return "Category [catID=" + catID + ", catName=" + catName + ", img_url=" + imgUrl + ", catDescription="
                + catDescription + "]";
    }
    
}
