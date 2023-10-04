package be.technobel.adae;


import java.sql.*;
import java.sql.Date;
import java.time.Year;
import java.util.*;

public class Bibliotheque {
    private static Bibliotheque instance;
    Scanner scanner;
    Boolean roleConnect = false;
    private List<Livres> livres;
    private List<Utilisateurs> utilisateurs;

    private int userConnecte;

    public Bibliotheque() {
        this.scanner = new Scanner(System.in);
        this.livres = new ArrayList();
        this.utilisateurs = new ArrayList();
    }

    public static Bibliotheque getInstance(){
        if(instance == null){
            instance = new Bibliotheque();
        }
        return  instance;
    }

    public void ajouter(Livres livre) {
        this.livres.add(livre);
    }

    public void afficher() {

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

                livres.add(l);
            }
            Iterator var1 = this.livres.iterator();

            while (var1.hasNext()) {
                Livres livre = (Livres) var1.next();

                System.out.println("Titre " + livre.nom);
                System.out.println("Auteur " + livre.auteur);
                System.out.println("Année de publication " + livre.anneePublication);
                System.out.println("ISBN " + livre.ISBN);

                System.out.println("-------------------------");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void afficherDispo() {
        System.out.println("Voici la liste des livres disponibles:");

        String requete = " SELECT * FROM book WHERE dispo = TRUE";

        try (Connection connection = ConnectionFactory.createConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(requete)) {

            while (rs.next()) {
                Livres l = new Livres();

                l.setNom(rs.getString("name"));
                l.setAnneePublication(Year.of(rs.getInt("publishingyear")));
                l.setISBN(rs.getString("isbn"));
                l.setAuteur(rs.getString("author"));

                livres.add(l);
            }
            Iterator var1 = this.livres.iterator();

            while (var1.hasNext()) {
                Livres livre = (Livres) var1.next();

                System.out.println("Titre " + livre.nom);
                System.out.println("Auteur " + livre.auteur);
                System.out.println("Année de publication " + livre.anneePublication);
                System.out.println("ISBN " + livre.ISBN);

                System.out.println("-------------------------");
            }

        } catch (SQLException e) {
            throw new RuntimeException("create error", e);
        }

    }

    public Boolean login( ) {

        boolean authentificationOK = false;

        while (!authentificationOK) {
            System.out.println("Entrez votre login");
            String loginInput = this.scanner.nextLine();

            System.out.println("Entrez votre password");
            String passwordInput = this.scanner.nextLine();

            String requete = "SELECT * from utilisateurs WHERE login = ? AND password = ?";

            try (Connection connection = ConnectionFactory.createConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(requete)) {
                preparedStatement.setString(1, loginInput);
                preparedStatement.setString(2, passwordInput);
                ResultSet rs = preparedStatement.executeQuery();

                if (rs.next()) {
                    System.out.println("Vous êtes connecté");
                    authentificationOK = true;
                    userConnecte = rs.getInt("utilisateursid");
                    if (rs.getString("utilisateursrole").equals("Admin")) {
                        roleConnect = true;
                    } else {
                        roleConnect = false;
                    }
                    menu();
                    return authentificationOK;
                } else {
                    System.out.println("Authentification échouée");
                    authentificationOK  = false;
                    return authentificationOK;
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return authentificationOK;
    }

    public void ajouterUser(Utilisateurs utilisateur) {
        this.utilisateurs.add(utilisateur);
    }

    public void ajouterLivre() {

        if (roleConnect) {
            System.out.println("Quel est le titre du livre que vous souhaitez ajouter ? ");
            String livreNom = this.scanner.nextLine();
            System.out.println("Quel est l'auteur du livre ? ");
            String livreAuteur = this.scanner.nextLine();
            System.out.println("En quelle année a été publié le livre ?");
            String livrePubStr = this.scanner.nextLine();
            int livrePubInt = Integer.parseInt(livrePubStr);
            Year livrePub = Year.of(livrePubInt);
            System.out.println("Entrez le ISBN");

            String livreISBN = this.scanner.nextLine();

            String requete = "INSERT INTO BOOK (name, publishingyear, isbn, author, dispo) VALUES (?, ?, ?, ?, ?)";
            try (Connection connection = ConnectionFactory.createConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(requete)) {

                preparedStatement.setString(1, livreNom);
                preparedStatement.setLong(2, livrePubInt);
                preparedStatement.setString(3, livreISBN);
                preparedStatement.setString(4, livreAuteur);
                preparedStatement.setBoolean(5, true);

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Votre livre a bien été ajouté");
        }
    }

    public boolean updateDispo(String bookName){
        boolean bookDispo = true;
        String requete = "UPDATE book set dispo = ? where name = ? ";
        try (Connection connection = ConnectionFactory.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(requete)) {

            preparedStatement.setBoolean(1, false);
            preparedStatement.setString(2, bookName);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return  bookDispo;
    }
    public int getBookIdByName(String bookName) {
        int bookId = -1; // Une valeur négative peut être utilisée pour indiquer qu'aucun livre correspondant n'a été trouvé
        String query = "SELECT bookid FROM book WHERE name = ?";

        try (Connection connection = ConnectionFactory.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, bookName);
            ResultSet resultSet = preparedStatement.executeQuery();
            updateDispo(bookName);
            if (resultSet.next()) {
                bookId = resultSet.getInt("bookid");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookId;
    }

    public void emprunter() {
        System.out.println("Saisissez le nom du livre que vous souhaitez emprunter ? ");
        afficherDispo();
        String nomLivre = scanner.nextLine();

        int bookID = getBookIdByName(nomLivre);
        int userid = userConnecte;

        Calendar calendar = Calendar.getInstance();
        Date dateDuJour = new Date(calendar.getTimeInMillis());
        // Ajoutez 15 jours à la date actuelle
        calendar.add(Calendar.DAY_OF_MONTH, 15);

        // Obtenez la date résultante
        Date dateDans15Jours = new Date(calendar.getTimeInMillis());

        String requete = "INSERT INTO borrow (user_id, book_id, borrow_date, return_date) VALUES (?, ?,?,? )";

        try(Connection connection = ConnectionFactory.createConnection();
        PreparedStatement preparedStatement =  connection.prepareStatement(requete)) {

            preparedStatement.setLong(1,userid);
            preparedStatement.setLong(2,bookID);
            preparedStatement.setDate(3, dateDuJour);
            preparedStatement.setDate(4, dateDans15Jours);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void afficherPasDispo() {
        System.out.println("Voici la liste des livres disponibles:");
        Iterator var1 = this.livres.iterator();

        while (var1.hasNext()) {
            Livres livre = (Livres) var1.next();
            if (!livre.dispo) {
                System.out.println("Titre " + livre.nom);
                System.out.println("Auteur " + livre.auteur);
                System.out.println("Année de publication " + String.valueOf(livre.anneePublication));
                System.out.println("ISBN " + livre.ISBN);
                System.out.println("Disponible " + livre.dispo);
                System.out.println("-------------------------");
            }
        }

    }

    public void rendre() {
        System.out.println("Saisissez le nom du livre que vous souhaitez emprunter ? ");
        this.afficherPasDispo();
        String inputChoose = this.scanner.nextLine();
        Iterator var2 = this.livres.iterator();

        while (var2.hasNext()) {
            Livres livre = (Livres) var2.next();
            if (Objects.equals(inputChoose, livre.getNom())) {
                livre.setDispo(true);
                System.out.println("Merci d'avoir rendu " + livre.getNom());

                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException var5) {
                    throw new RuntimeException(var5);
                }

                this.afficherPasDispo();
            }
        }
        menu();
    }

    public void infosLivre() {

        System.out.println("Quel livre cherchez-vous ?  ");
        String inputChoose = this.scanner.nextLine();

        String requete = "SELECT * FROM book WHERE name = ?";

        try (Connection connection = ConnectionFactory.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(requete)
        ) {
            preparedStatement.setString(1, inputChoose);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    Livres l = new Livres();

                    l.setNom(rs.getString("name"));
                    l.setAnneePublication(Year.of(rs.getInt("publishingyear")));
                    l.setISBN(rs.getString("isbn"));
                    l.setAuteur(rs.getString("author"));
                    l.setDispo(rs.getBoolean("dispo"));

                    livres.add(l);
                }
            }

            Iterator var2 = this.livres.iterator();

            while (var2.hasNext()) {
                Livres livre = (Livres) var2.next();
                System.out.println("Voici les infos du livre " + livre.getNom());
                System.out.println("Auteur " + livre.getAuteur());
                System.out.println("Année de publication " + String.valueOf(livre.getAnneePublication()));
                System.out.println("ISBN " + livre.ISBN);
                if (livre.dispo) {
                    System.out.println("Est disponible ");
                } else {
                    System.out.println("N'est pas disponible");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        this.menu();
    }

    public void supprimerLivre() {
        if (roleConnect) {

            afficher();

            System.out.println("Quel livre souhaitez-vous supprimer ? ");
            String inputChoose = this.scanner.nextLine();

            String requete = "DELETE FROM book WHERE name = ?";
            try (Connection connection = ConnectionFactory.createConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(requete)) {
                preparedStatement.setString(1, inputChoose);
                preparedStatement.executeUpdate();

                System.out.println("Le livre  a bien été supprimé");

                afficher();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("ACCES DENIED !");
        }

    }

    public void modifInfos() {

        // NE FONCTIONNE PAS !!!!!!
        if (roleConnect) {

            System.out.println("Quel livre souhaitez-vous modifier ? ");

            this.afficher();
            String inputChoose = this.scanner.nextLine();
            System.out.println("Quel information souhaitez vous modifier ? 1. Le titre  2. l'année de publication 3. ISBN  4. Auteur ");
            String choixModif = scanner.nextLine();


            Livres livreActuel = null;
            for (Livres livre : this.livres) {
                if (livre.getNom().equals(inputChoose)) {
                    livreActuel = livre;
                    break;
                    }
            }

            if (livreActuel == null) {
                    System.out.println("Livre introuvable.");
                    return;
            }

            String requete = "UPDATE book SET name = ?, publishingyear = ?, isbn = ?, author = ? WHERE name = ?";

            try (Connection connection = ConnectionFactory.createConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(requete)) {

                        preparedStatement.setString(1, choixModif.equals("1") ? this.scanner.nextLine() : livreActuel.getNom());
                      //  preparedStatement.setInt(2, choixModif.equals("2") ? Integer.parseInt(this.scanner.nextLine()) : livreActuel.getAnneePublication());
                        preparedStatement.setString(3, choixModif.equals("3") ? this.scanner.nextLine() : livreActuel.getISBN());
                        preparedStatement.setString(4, choixModif.equals("4") ? this.scanner.nextLine() : livreActuel.getAuteur());
                        preparedStatement.setString(5, inputChoose);

                        int rowsUpdated = preparedStatement.executeUpdate();

                        if (rowsUpdated > 0) {
                            System.out.println("Les informations du livre ont été mises à jour avec succès.");
                        } else {
                            System.out.println("Aucune modification n'a été effectuée.");
                        }

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }
        menu();
    }


    public void menu() {
            System.out.println("Que souhaitez-vous faire ? ");
            System.out.println("1. Afficher la liste des livres disponibles ");
            System.out.println("2. Ajouter un livre");
            System.out.println("3. Emprunter un livre");
            System.out.println("4. Rendre un livre");
            System.out.println("5. Rechercher un livre par son titre");
            System.out.println("6. Supprimer un livre");
            System.out.println("7. Modifier un livre");
            switch (this.scanner.nextLine()) {
                case "1":
                    this.afficherDispo();
                    menu();
                    break;
                case "2":
                    this.ajouterLivre();
                    break;
                case "3":
                    this.emprunter();
                    break;
                case "4":
                    this.rendre();
                    break;
                case "5":
                    this.infosLivre();
                    break;
                case "6":
                    this.supprimerLivre();
                    break;
                case "7":
                    this.modifInfos();
                case "8":
                    this.afficher();
            }
    }
}


// TODO: 26-09-23
// Methode afficher dispo DONE
// Ajouter un livre ADMIN DONE
// Emprunter un livre DONE
// Rendre un livre
// Choisir et afficher les infos d'un livre DONE
// Supprimer un livre ADMIN DONE
// modif les infos ADMIN  A CORRIGER NE FONCTIONNE PAS !!!!!
// LOGIN DONE