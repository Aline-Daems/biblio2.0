//import be.technobel.adae.ConnectionFactory;
//import be.technobel.adae.Livres;
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.postgresql.core.Parser;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.time.Year;
//
//@WebServlet("/add")
//public class addServlet extends HttpServlet {
//@Override
//    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    String nom = req.getParameter("name");
//    int annee = Integer.parseInt(req.getParameter("annee"));
//    String auteur = req.getParameter("auteur");
//    String isbn = req.getParameter("isbn");
//    Boolean dispo = Boolean.valueOf(req.getParameter("dispo"));
//
//    Livres livre = new Livres(nom, auteur,Year.of(annee) , isbn, dispo);
//    ajouter(livre);
//
//
//    RequestDispatcher dispatcher = req.getRequestDispatcher("/ajouter.jsp");
//    dispatcher.forward(req, resp);
//
//    }
//
//    private Livres ajouter(Livres livre){
//
//        String requete = "INSERT INTO BOOK (name, publishingyear, isbn, author, dispo) VALUES (?, ?, ?, ?, ?)";
//        try (Connection connection = ConnectionFactory.createConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(requete)) {
//
//
//            preparedStatement.setString(1, livre.getNom());
//            //preparedStatement.setInt(2, Year.of(livre.getAnneePublication()));
//            preparedStatement.setString(3, livre.getISBN());
//            preparedStatement.setString(4, livre.getAuteur());
//            preparedStatement.setBoolean(5, livre.getDispo());
//
//
//
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        return null;
//    }
//}
//
//
//
