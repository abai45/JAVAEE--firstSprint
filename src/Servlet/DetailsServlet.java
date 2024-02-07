package Servlet;

import Classes.DBManager;
import Classes.Task;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(value = "/details")
public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        Task task = DBManager.getTask(id);

        req.setAttribute("taskArray", task);

        req.getRequestDispatcher("/WEB-CONTENT/details.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean save =  req.getParameter("taskSave") !=null;
        boolean delete = req.getParameter("taskDelete") !=null;

        Long id  = Long.valueOf(req.getParameter("taskId"));
//        Long id = null;
//        if (idParam != null && !idParam.isEmpty()) {
//            id = Long.valueOf(idParam);
//        }
        ArrayList<Task> tasks = DBManager.getAllTasks();
        if(save) {
            String name = req.getParameter("taskName");
            String desc = req.getParameter("taskDesc");
            String deadline = req.getParameter("taskDeadline");

            Task task = new Task();
            task.setId(id);
            task.setName(name);
            task.setDescription(desc);
            task.setDeadline(deadline);

            DBManager.updateTask(task);

            for (Task t: tasks) {
                System.out.println(t.getId()+ t.getName() + t.getDescription() + t.getDeadline());
                System.out.println("------------------------");
            }
            resp.sendRedirect("/home");
        }
        if(delete) {
            DBManager.deleteTask(id);

            resp.sendRedirect("/home");
        }
    }
}
