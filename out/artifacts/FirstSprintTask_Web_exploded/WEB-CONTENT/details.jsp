<%@ page import="Classes.Task" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
    <%@include file="./components/header.jsp"%>
</head>
<body>
    <%@include file="./components/navBar.jsp"%>

    <%
        Task task = (Task) request.getAttribute("taskArray");
    %>
    <div class="mainContent">
        <div class="detalsBlock">
            <form action="/details" method="post">
                <%
                    if(task!=null) {
                %>
                <input type="hidden" value="<%=task.getId()%>" name="taskId">
                <div class="popup__text">
                    Наименование:
                </div>
                <input type="text" value="<%=task.getName()%>" class="popup__inputTitle" name="taskName">
                <div class="popup__text">
                    Описание:
                </div>
                <textarea type="text" class="popup__inputArea" name="taskDesc"><%=task.getDescription()%></textarea>
                <div class="popup__text">
                    Крайний срок:
                </div>
                <input type="date" value="<%=task.getDeadline()%>"class="popup__inputDeadline" name="taskDeadline">
                <div class="popup_buttons">
                    <button type="submit" class="popup__delete" name="taskDelete">Удалить</button>
                    <button type="submit" class="popup__save" name="taskSave">Сохранить</button>
                </div>
                <%
                    }
                %>
            </form>
        </div>
    </div>
</body>
</html>
