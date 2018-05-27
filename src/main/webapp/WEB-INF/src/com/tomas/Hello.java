package com.tomas;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Hello extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // Set the response message's MIME type.
        response.setContentType("text/html;charset=UTF-8");
        // Allocate a output writer to write the response message into the network socket.
        PrintWriter out = response.getWriter();

        // Write the response message, in an HTML document.
        try {
            out.println("<!DOCTYPE html>");  // HTML 5
            out.println("<html><head>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.println("<title>" + "First Tomca App" + "</title></head>");
            out.println("<body>");
            out.println("<h1>" + "Tomcat app" + "</h1>");  // Prints "Hello, world!"
            // Set a hyperlink image to refresh this page
            out.println("<a href='" + request.getRequestURI() + "'>url</a>");
            out.println("</body></html>");
        } finally {
            out.close();  // Always close the output writer
        }
    }
}