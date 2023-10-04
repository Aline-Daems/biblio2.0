import be.technobel.adae.ConnectionFactory;
import be.technobel.adae.Livres;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.time.Year;
import java.util.ArrayList;

@WebServlet("/search")
public class searchServlet extends HttpServlet {

    @Override
    protected  void doGet(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException, ServletException {
        String name = req.getParameter("name");

        if(search(name) != null){
            req.setAttribute("livre", search(name));
            req.getRequestDispatcher("/BookInfo.jsp").forward(req,resp);

        }else{
            req.setAttribute("message", "Livre non trouvé");

        }
    }

    private Livres search(String name) {
        ArrayList<Livres> bookList = new ArrayList<>();
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        }catch (SQLException e ){
            System.out.println(e);
        }

        if(name != null){
            String requete = "SELECT * FROM book WHERE name = ?";
            try (Connection connection = ConnectionFactory.createConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(requete)
            ) {
                preparedStatement.setString(1, name);
                try (ResultSet rs = preparedStatement.executeQuery()) {
                    while (rs.next()) {
                        Livres l = new Livres();

                        l.setNom(rs.getString("name"));
                        l.setAnneePublication(Year.of(rs.getInt("publishingyear")));
                        l.setISBN(rs.getString("isbn"));
                        l.setAuteur(rs.getString("author"));
                        l.setDispo(rs.getBoolean("dispo"));


                        return l;
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

        return null;
    }

}


