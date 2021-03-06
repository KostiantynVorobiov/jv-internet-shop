package com.internet.shop.controllers.product;

import com.internet.shop.lib.Injector;
import com.internet.shop.model.Product;
import com.internet.shop.service.ProductService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddProductController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("com.internet.shop");
    private ProductService productService =
            (ProductService) injector.getInstance(ProductService.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        Double price = Double.valueOf(req.getParameter("price"));
        if (name.length() == 0) {
            req.setAttribute("message", "Please fill all required fields again!");
            req.getRequestDispatcher("/WEB-INF/views/products/newProduct.jsp").forward(req, resp);
        }
        Product product = new Product(name, price);
        productService.create(product);
        req.setAttribute("message", "Your product was created successfully! You can add new one!");
        req.getRequestDispatcher("/WEB-INF/views/products/newProduct.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/products/newProduct.jsp").forward(req, resp);
    }
}
