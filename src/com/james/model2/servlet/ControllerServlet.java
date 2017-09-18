package com.james.model2.servlet;

import com.james.model2.entity.Product;
import com.james.model2.entity.ProductForm;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllerServlet",urlPatterns = {"/input.do","/save.do"})
public class ControllerServlet extends HttpServlet{

    private  static final long serialVersionUID=1579L;


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        String uri=request.getRequestURI();
        int lastIndex=uri.lastIndexOf("/");
        //获取请求要进行的操作
        String action=uri.substring(lastIndex+1);
        if (action.equals("input.do")){

        }else if(action.equals("save.do")){
            ProductForm productForm=new ProductForm();
            productForm.setProductName(request.getParameter("name"));
            productForm.setDescription(request.getParameter("description"));
            productForm.setPrice(request.getParameter("price"));

            Product product=new Product();
            product.setProductName(productForm.getProductName());
            product.setProductName(productForm.getDescription());
            try {
                product.setPrice(Float.parseFloat(productForm.getPrice()));
            }catch (NumberFormatException ne){
                ne.printStackTrace();
            }

            request.setAttribute("product",product);


        }
        String dispatchUrl=null;
        if (action.equals("input.do")){
            dispatchUrl="productForm.jsp";
        }
        else if(action.equals("save.do")){
            dispatchUrl="productDetails.jsp";
        }
        if (dispatchUrl!=null){
            RequestDispatcher rd=request.getRequestDispatcher(dispatchUrl);
            rd.forward(request,response);
        }
    }
}
