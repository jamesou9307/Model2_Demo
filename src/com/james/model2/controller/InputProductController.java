package com.james.model2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InputProductController implements GeneralController{//处理输入产品的controller

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        return "productForm.jsp";
    }
}
