import be.technobel.adae.ConnectionFactory;
import be.technobel.adae.Livres;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.print.Book;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Year;
import java.util.ArrayList;
import java.util.Iterator;

@WebServlet("/book")
public class bookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {
        ArrayList<Livres> bookList = new ArrayList<>();

        System.out.println("Voici la liste des livres :");

        String requete = " SELECT * FROM book";

        try (Connection connection = ConnectionFactory.createConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(requete)) {
            while (rs.next()) {
                Livres l = new Livres();

                l.setNom(rs.getString("name"));
                l.setAnneePublication(Year.of(rs.getInt("publishingyear")));
                l.setISBN(rs.getString("isbn"));
                l.setAuteur(rs.getString("author"));
                l.setDispo(rs.getBoolean("dispo"));

                bookList.add(l);
            }


            req.setAttribute("book", bookList);
            req.getRequestDispatcher("/Livres.jsp").forward(req, resp);


        }catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
}


