import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;

@WebServlet("/list")
public class ListServlet extends HttpServlet {

    private static Products products = Products.getInstance();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = "<html><head><title>Products</title></head>" +
                "<body>" +
                "<table border=\"1\"><tr>" +
                "<td>ID</td>" +
                "<td>NAME</td>" +
                "<td>DESCRIPTION</td>" +
                "<td>PRICE</td></tr>";
        for(Product p : products.getList()){
            code += "<tr><td>" + p.getId() + "</td>" +
                    "<td>" + p.getName() + "</td>" +
                    "<td>" + p.getDescription() + "</td>" +
                    "<td>" + p.getPrice() + "</td></tr>";
        }
        String form = "<form action=\"/list\" method=\"post\">\n" +
                "Sorting parameter(name, id, description, price): <input type=\"text\" name=\"parameter\"><br>" +
                "<input type=\"submit\" value=\"choose parameter\">" +
                "</form><br><br>";
        resp.getWriter().println(code + form + "\"<a href=\"/index.jsp\">To main menu</a></body></html>");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter("parameter");
        switch (parameter) {
            case "name": Products.getList().sort((p1,p2) -> p1.getName().compareTo(p2.getName()));break;
            case "description": Products.getList().sort((p1,p2) -> p1.getDescription().compareTo(p2.getDescription()));break;
            case "price": Products.getList().sort((p1,p2) -> (p1.getPrice() - p2.getPrice()));break;
            case "id": Products.getList().sort((p1,p2) -> (p1.getId() - p2.getId()));break;
        }
        doGet(req, resp);
    }

}
