package com.james.model2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface GeneralController {

    String handleRequest(HttpServletRequest request, HttpServletResponse response);
}
