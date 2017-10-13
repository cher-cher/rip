package com.srccodes.example;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import com.srccodes.example.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/BooksList")
public class BooksList extends HttpServlet {

    private ArrayList<Book> books = new ArrayList<Book>();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html; charset=windows-1251");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML>");
        out.println("<form action=\"\" method=\"GET\">");
        out.println("<p>Book: <input type=\"text\" name=\"book\"></p>");
        out.println("<p>Author: <input type=\"text\" name=\"author\"></p>");
        out.println("<p>Year of publish: <input type=\"number\" name=\"year\"></p>");

        out.println("<input type=\"submit\" value=\"Submit\" />");
        out.println("</form>");

        out.println("<form action=\"\" method=\"POST\">");
        out.println("<input type=\"submit\" style=\"\n" + "margin-top: 25px;margin-bottom: 15px;" + "\" value=\"My books\" />");
        out.println("</form>");

        request.setAttribute("books", books);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException
    {
        doGet(request, response);
        PrintWriter out = response.getWriter();
        
        Book book = new Book();
        book.setName((String) request.getParameter("book"));
        book.setAuthor((String) request.getParameter("author"));
        book.setYear(Integer.parseInt(request.getParameter("year")));

        books.add(book);
        
        for (Book myBook:books)
        {
        	out.println("Book: " + myBook.getName() + "\n<br />");
        	out.println("Author: " + myBook.getAuthor() + "\n<br />");
        	out.println("Year of publish: " + myBook.getYear() + "\n<br />");
        	out.println("\n<br />");
        }
    }
}
