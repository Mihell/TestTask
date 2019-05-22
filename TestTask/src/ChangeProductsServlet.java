import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/change")
public class ChangeProductsServlet extends HttpServlet {

    private static Products products = Products.getInstance();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sID = req.getParameter("id");
        if(sID == null) {
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            int price = Integer.parseInt(req.getParameter("price"));
            Product product = new Product(name, description, price);
            products.addProduct(product);
            resp.getWriter().println("<html><body><h1>New Product added</h1>" +
                    "<a href=\"/index.jsp\">To main menu</a></body></html>");
        } else{
            products.remove(Integer.parseInt(sID));
        }

        resp.getWriter().println("<html><body><h1>Product removed</h1>" +
                "<a href=\"/index.jsp\">To main menu</a></body></html>");

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String sPrice = req.getParameter("price");
        int price = 0;
        if(sPrice != "") {
            price = Integer.parseInt(sPrice);
        }
        Product product = products.find(id);
        System.out.println("price " + sPrice);
        System.out.println("id " + id);
        System.out.println("desc " + description);

        if(product == null){
            System.out.println("No such product");
        }
        if(name != null) {
            product.setName(name);
        }
        if(description != null) {
            product.setDescription(description);
        }
        if(price != 0) {
            product.setPrice(price);
        }
        resp.getWriter().println("<html><body><h1>Product changed</h1>" +
                "<a href=\"/index.jsp\">To main menu</a></body></html>");
    }
}
