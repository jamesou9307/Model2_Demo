package com.james.model2.servlet;

import com.james.model2.controller.InputProductController;
import com.james.model2.controller.SaveProductController;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dispatcherServlet",urlPatterns = {"/input.do","/save.do"})
public class DispatcherServlet extends HttpServlet{
    //相比起上一个controllerServelt,dispatcherServlet仅是一个请求转发器,实现了业务逻辑解耦

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uri=req.getRequestURI();
        int index=uri.lastIndexOf("/");
        String action=uri.substring(index+1);//获取请求的动作
        String dispatcherUrl=null;
        /*根据不同的转发请求交给不同的controller处理*/
        if(action.equals("input.do")){
            InputProductController inputProductController=new InputProductController();
            dispatcherUrl=inputProductController.handleRequest(req,resp);
        }
        else if(action.equals("save.do")){
            SaveProductController saveProductController=new SaveProductController();
            dispatcherUrl=saveProductController.handleRequest(req,resp);
        }
        if(dispatcherUrl!=null){
            RequestDispatcher requestDispatcher=req.getRequestDispatcher(dispatcherUrl);
            requestDispatcher.forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
