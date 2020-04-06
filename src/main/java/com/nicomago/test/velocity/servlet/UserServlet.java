package com.nicomago.test.velocity.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.servlet.VelocityViewServlet;

import com.nicomago.test.velocity.model.User;
import com.nicomago.test.velocity.service.UserService;	

public class UserServlet extends VelocityViewServlet {
	private static final long serialVersionUID =  102831973239L;

    UserService service = new UserService();

    @Override
    public Template handleRequest(HttpServletRequest request, HttpServletResponse response, Context context) {
    	
    	List < User > users = service.getUsers();
    	
    	context.put("users", users);
    	
    	Template template = null;
    	
        try {
            template = getTemplate("templates/index.vm");
            response.setHeader("Template Returned", "Success");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return template;
    }

}