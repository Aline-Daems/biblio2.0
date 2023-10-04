import be.technobel.adae.Bibliotheque;
import be.technobel.adae.ConnectionFactory;
import be.technobel.adae.Utilisateurs;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (authentification(login, password)) {
            resp.sendRedirect("/biblio2_0_war_exploded/Authentificationok.jsp");
        } else {
            req.setAttribute("message", "Authentification échouée. Veuillez réessayer.");
            req.getRequestDispatcher("/biblio2_0_war_exploded/login.jsp").forward(req, resp);
        }
    }

    private boolean authentification(String login, String password){
        Boolean authentificationOK;
       try {
           DriverManager.registerDriver(new org.postgresql.Driver());
       }catch (SQLException e ){
           System.out.println(e);
       }
        if (login != null && password != null) {
            try (Connection connection = ConnectionFactory.createConnection()) {
                String requete = "SELECT * from utilisateurs WHERE login = ? AND password = ?";

                PreparedStatement preparedStatement = connection.prepareStatement(requete);

                preparedStatement.setString(1, login);
                preparedStatement.setString(2, password);
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    Utilisateurs utilisateurs = new Utilisateurs();

                    utilisateurs.setLogin(rs.getString("login"));
                    utilisateurs.setPassword(rs.getString("password"));

                    System.out.println("ok");
                    authentificationOK = true;
                    return authentificationOK;

                } else {
                    System.out.println("Authentification échouée");
                    authentificationOK = false;

                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            return authentificationOK;
        }
        return false;

    }

}


