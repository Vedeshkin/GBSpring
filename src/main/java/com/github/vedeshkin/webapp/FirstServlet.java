package com.github.vedeshkin.webapp;

import com.github.vedeshkin.webapp.dto.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@WebServlet(name = "FirstServlet", urlPatterns = "/app")
public class FirstServlet extends HttpServlet {

    private List<Product> productList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().printf("<html><body><ul>");
        for (Product product : productList) {
            resp.getWriter().printf("<li>");
            resp.getWriter().printf(product.getId() + "-" + product.getTitle() + "-" + product.getCost());
            resp.getWriter().printf("</li>");
        }
        resp.getWriter().printf("</ul></body></html>");
        resp.getOutputStream().close();
    }

    @Override
    public void init() throws ServletException {
        for (int i = 0; i <= 10; i++) {
            productList.add(new Product(i, "Test " + i, ThreadLocalRandom.current().nextDouble(0, 100)));
        }
    }
}
