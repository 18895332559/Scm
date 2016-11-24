package com.lw.scm.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 初始化Servlet，用来初始化参数表
 * Created by lw on 2016/11/19.
 */
public class SysServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void init() throws ServletException {
        super.init();
        Map<String, Object> sysParamMap = new HashMap<String, Object>();
        Map<String, Object> supTypeMap = new HashMap<String, Object>();
        supTypeMap.put("1", "一级供应商");
        supTypeMap.put("2", "二级供应商");
        supTypeMap.put("3", "三级供应商");
        sysParamMap.put("supType", supTypeMap);
        Map<String, Object> goodsColorMap = new HashMap<String, Object>();
        this.getServletContext().setAttribute("sysParamMap", sysParamMap);
    }
}
