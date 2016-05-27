package com.ubl.servlet;

import com.ubl.service.TestingService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author edwin < edwinkun at gmail dot com >
 */
@WebServlet(name = "TestingServlet", urlPatterns = {"/TestingServlet"})
public class TestingServlet extends HttpServlet {

    private final TestingService testingService = new TestingService();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        
        // cek select all atau select one only, dengan parameter id
        if(request.getParameter("id") != null)
            // http://localhost:8084/materi-jwp-ubl-4/TestingServlet?id=1
            out.println(testingService.selectOne(Integer.parseInt(request.getParameter("id"))));
        else
            // http://localhost:8084/materi-jwp-ubl-4/TestingServlet
            out.println(testingService.selectAll());
        
        // closing
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        
        PrintWriter out = response.getWriter();

        // ambil parameter dari depan
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        
        // response
        out.println(testingService.insert(name, address));
        
        // closing
        out.flush();
        out.close();
    }
}
