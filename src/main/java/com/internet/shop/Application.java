package com.internet.shop;

import com.internet.shop.lib.Injector;
import com.internet.shop.model.Product;
import com.internet.shop.service.ProductService;

public class Application {
    private static Injector injector = Injector.getInstance("com.internet.shop");

    public static void main(String[] args) {
        ProductService productService = (ProductService) injector.getInstance(ProductService.class);

        productService.create(new Product("iPhoneX", 1000));
        productService.create(new Product("MacBook", 2000));
        productService.create(new Product("iMac", 1800));

        productService.delete(0L);
    }
}
