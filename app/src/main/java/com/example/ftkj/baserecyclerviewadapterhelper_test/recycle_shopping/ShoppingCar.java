package com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_shopping;

import java.util.List;

/**
 * Created by FTKJ on 2017/9/22.
 */

public class ShoppingCar {
    private List<Product> products;
    private boolean isEdit;

    public ShoppingCar(List<Product> products, boolean isEdit) {
        this.products = products;
        this.isEdit = isEdit;
    }


    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public boolean isEdit() {
        return isEdit;
    }

    public void setEdit(boolean edit) {
        isEdit = edit;
    }

    @Override
    public String toString() {
        return "ShoppingCar{" +
                ", products=" + products +
                ", isEdit=" + isEdit +
                '}';
    }

    public float getTotlePrice() {

        float totlePrice = 0;

        for (Product product : products) {
            if (product.isChecked()) {
                totlePrice += product.getProductPrice() * product.getProductNumber();
            }
        }
        return totlePrice;
    }
}
