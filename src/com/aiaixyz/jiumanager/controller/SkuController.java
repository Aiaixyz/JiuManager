package com.aiaixyz.jiumanager.controller;

import com.aiaixyz.jiumanager.entity.po.Sku;
import com.aiaixyz.jiumanager.entity.vo.RespBean;
import com.aiaixyz.jiumanager.service.SkuService;
import com.aiaixyz.jiumanager.service.impl.SkuServiceImpl;
import com.aiaixyz.jiumanager.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/14
 */

@WebServlet("/SkuController")
public class SkuController extends BaseServlet {
    SkuService<Sku> skuService = new SkuServiceImpl();

    protected RespBean getList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return null;
    }
}
