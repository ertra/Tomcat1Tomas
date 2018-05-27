package com.tomas;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Weather1 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // Set the response message's MIME type.
        response.setContentType("text/html;charset=UTF-8");
        // Allocate a output writer to write the response message into the network socket.
        PrintWriter out = response.getWriter();

        HttpResponse<JsonNode> jsonResponse = null;
        String URL = "http://localhost:8000/weather/cz/Prague";

        try {
           jsonResponse = Unirest.get(URL)
                    //.header("accept", "application/json")
                    //.queryString("apiKey", "123")
                    //.field("parameter", "value")
                    //.field("foo", "bar")
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        // Write the response message, in an HTML document.
        try {
            out.println("<!DOCTYPE html>");  // HTML 5
            out.println("<html><head>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.println("<title>" + "First Tomca App" + "</title></head>");
            out.println("<body>");
            out.println("<h1>" + "Tomcat app" + "</h1>");  // Prints "Hello, world!"
            // Set a hyperlink image to refresh this page
            out.println(jsonResponse.getBody().toString());
            out.println("</body></html>");
        } finally {
            out.close();  // Always close the output writer
        }
    }
}