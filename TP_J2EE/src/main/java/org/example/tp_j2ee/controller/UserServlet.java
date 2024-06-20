package org.example.tp_j2ee.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.tp_j2ee.model.User;
import org.example.tp_j2ee.service.UserService;

import java.io.IOException;

@WebServlet(name = "userServlet",value = "/user/*")
public class UserServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        switch (path) {
            case "/pagesignup":
                signUpPage(req,resp);
                break;
            case "/signup":
                signUp(req,resp);
                break;
            case "/pagesignin":
                signinPage(req,resp);
                break;
            case "/signin":
                signIn(req,resp);
                break;
            default:
                resp.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    private void signUpPage(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/signup.jsp").forward(request,response);
    }

    private void signUp(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
        String username = request.getParameter("inputUsername");
        String password = request.getParameter("inputPassword");
        userService.signUp(username,password);
        response.sendRedirect("pagesignin");

    }

    private void signinPage(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/signin.jsp").forward(request,response);
    }

    private void signIn(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
        String username = request.getParameter("inputUsername");
        String password = request.getParameter("inputPassword");

        User user = userService.signIn(username,password);
        if(user != null){
            HttpSession session = request.getSession();
            session.setAttribute("isLogged",true);
            session.setAttribute("user",user);
            // dispatch vers la liste des patients
            response.sendRedirect(getServletContext().getContextPath()+"/patient/list");

        }else {
            response.sendRedirect("index.jsp");
        }
    }
}
