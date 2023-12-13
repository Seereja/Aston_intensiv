package ru.shilo.servletManyToMany;




import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.shilo.config.DBConfig;
import ru.shilo.mapper.ChildMapper;
import ru.shilo.model.Child;
import ru.shilo.repository.ChildDAO;
import ru.shilo.service.ChildDAOImpl;

import java.io.IOException;
import java.util.List;

public class ChildController extends HttpServlet {

    private final ChildDAOImpl childDAOimpl;

    public ChildController() {
        this.childDAOimpl = new ChildDAOImpl(new ChildDAO(new DBConfig(), new ChildMapper()));
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        int id = Integer.parseInt(req.getParameter("id"));
        List<Child> children = null;
        children = childDAOimpl.getChildrenForSectionId(1);
        req.setAttribute("child", children);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
        super.doGet(req, resp);
    }
}
