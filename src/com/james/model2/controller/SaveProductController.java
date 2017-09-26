package com.james.model2.controller;

import com.james.model2.entity.Product;
import com.james.model2.entity.ProductForm;
import com.james.model2.validator.ProductValidator;
import com.sun.org.apache.xalan.internal.xsltc.runtime.ErrorMessages_pt_BR;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SaveProductController implements GeneralController{//处理保存产品的controller


    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        ProductForm productForm=new ProductForm();

        String dispatcherUrl=null;
        productForm.setProductName(request.getParameter("name"));
        productForm.setDescription(request.getParameter("description"));
        productForm.setPrice(request.getParameter("price"));

        ProductValidator validator=new ProductValidator();//创建一个校验器，校验用户的输入是否合格

        List<String> errors=validator.validate(productForm);

        if (errors.isEmpty()){//如果包含错误信息的列表为空,则说明用户输入符合要求

            Product product=new Product();

            product.setProductName(productForm.getProductName());
            product.setDescription(productForm.getDescription());
            try{
                product.setPrice(Float.parseFloat(productForm.getPrice()));
            }catch (NumberFormatException ne){
                ne.printStackTrace();
            }
            request.setAttribute("product",product);

            dispatcherUrl="productDetails.jsp";

        }
        else{//输入的信息不合法,将跳转到输入界面重新输入

            request.setAttribute("errors",errors);
            request.setAttribute("productForm",productForm);
            dispatcherUrl="productForm.jsp";
        }

        return dispatcherUrl;
    }
}
