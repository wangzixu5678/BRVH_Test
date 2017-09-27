package com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_shopping;

/**
 * Created by FTKJ on 2017/9/22.
 */

public class Product {
    private String productName;
    private Integer productNumber;
    private boolean isChecked;
    private float productPrice;
    private int imageSrc;

    public Product(String productName, Integer productNumber,float productPrice,int imageSrc) {
        this.productName = productName;
        this.productNumber = productNumber;
        this.productPrice = productPrice;
        this.isChecked = false;
        this.imageSrc = imageSrc;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public int getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(int imageSrc) {
        this.imageSrc = imageSrc;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productNumber=" + productNumber +
                ", isChecked=" + isChecked +
                ", productPrice=" + productPrice +
                ", imageSrc=" + imageSrc +
                '}';
    }
}
