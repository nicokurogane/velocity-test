package com.nicomago.test.velocity.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.servlet.VelocityLayoutServlet;

import com.nicomago.test.velocity.model.*;
import com.nicomago.test.velocity.service.*;	


public class LayoutServlet extends VelocityLayoutServlet {
    private static final long serialVersionUID = 1L;
    UserService service = new UserService();

    @Override
    public Template handleRequest(HttpServletRequest request, HttpServletResponse response, Context context) {

        List < User > users = service.getUsers();

        context.put("users", users);

        Template template = null;

        try {
            template = getTemplate("templates/layoutdemo.vm");

            response.setHeader("Template Returned", "Success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return template;
    }
}