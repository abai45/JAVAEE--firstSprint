package Classes;

import java.util.ArrayList;
import java.util.Iterator;

public class DBManager {

    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Long id = 5L;

    static {
        tasks.add(new Task(1L, "Math", "Our JavaScript regular expressions (regex) documentation is one of the most popular resources on MDN Web Docs. Thanks to the efforts of Joshua Chen, we now have dedicated pages for each feature with more comprehensive information about the syntax and semantics, with browser compatibility information included. Let's take a look at the new pages, how the information is organized, and how the new documentation can help you write regular expressions in JavaScript.", "2024-02-07", true));
        tasks.add(new Task(2L, "English", "Before this initiative, we started off with a regular expressions guide that explains what regular expressions are and how to use them in JavaScript. The guide has a few sub-pages that split out content into the following sections:", "2024-03-01", false));
        tasks.add(new Task(3L, "History", "These guides and the cheat sheet are great if you are new to regex or you need a refresher on the basic concepts. What we were missing were accelerators for readers who are already familiar with the basics and want to quickly look up the specific details of a language feature.", "2024-02-15", true));
        tasks.add(new Task(4L, "Geometry", "Having a reference for each feature means it appears more prominently in search results and is easier to locate. Additionally, each page is included in the sidebar navigation, so if you've landed on the documentation for a feature but meant to look up something else, you should be able to find it quickly.", "2024-02-05", true));

    }

    public static void addTask(Task task) {
        task.setId(id);
        task.setStatus(false);
        id++;
        tasks.add(task);
    }
    public static Task getTask(Long id) {
        Task task = new Task();
        for(Task t: tasks) {
            if (t.getId()== id) {
                task = t;
                break;
            } else {
                task = null;
            }
        }
        return task;
    }
    public static ArrayList getAllTasks() {
        return tasks;
    }
    public static void deleteTask(Long id) {
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getId().equals(id)) {
                iterator.remove();
            }
        }
    }

    public static void updateTask(Task task) {
        for (Task t : tasks) {
            if (t.getId() == task.getId()) {
                t.setName(task.getName());
                t.setDescription(task.getDescription());
                t.setDeadline(task.getDeadline());
                break;
            }
        }
    }
}
