package Servlet;

import Classes.DBManager;
import Classes.Task;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.http.HttpClient;
import java.util.ArrayList;

@WebServlet(value = "/home")
public class FirstSpringServlet  extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Task> tasks = DBManager.getAllTasks();
        req.setAttribute("tasksArray", tasks);
        req.getRequestDispatcher("/WEB-CONTENT/task.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("taskName");
        String desc = req.getParameter("taskDesc");
        String deadline = req.getParameter("taskDeadline");

        Task task = new Task();
        task.setName(name);
        task.setDescription(desc);
        task.setDeadline(deadline);

        DBManager.addTask(task);
        resp.sendRedirect("/home");

    }
}
