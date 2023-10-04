package be.technobel.adae;

import be.technobel.adae.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InitDB {

    public static void initialisation(){

        String requete = """
                
                
                DROP TABLE IF EXISTS utilisateurs;
                DROP TABLE IF EXISTS book; 
                DROP TABLE IF EXISTS address; 
                DROP TABLE IF EXISTS library; 
                DROP TABLE IF EXISTS borrow; 
                
                CREATE TABLE utilisateurs
                (
                utilisateursId SERIAL Primary Key NOT NULL,
                firstName VARCHAR(50),
                lastName VARCHAR(50),
                birthdate DATE,
                login VARCHAR(50),
                password VARCHAR(50),
                utilisateursRole VARCHAR(50)
                );
                
                INSERT INTO utilisateurs (utilisateursId, firstName, lastName, birthdate, login, password, utilisateursRole)
          
                VALUES (DEFAULT, 'John', 'Smith', '1985-03-15', 'josi', 'MotDePasse123', 'utilisateurs');
                
                INSERT INTO utilisateurs (utilisateursId, firstName, lastName, birthdate, login, password, utilisateursRole)
                
                VALUES ( DEFAULT, 'Sarah', 'Johnson', '1990-09-22', 'sajo', 'MotDePasse123', 'Admin' );
                
                INSERT INTO utilisateurs (utilisateursId, firstName, lastName, birthdate, login, password, utilisateursRole)
                
                VALUES (DEFAULT, 'Michael', 'Brown', '1982-06-10', 'mibro', 'MotDePasse123', 'user' );
                
                INSERT INTO utilisateurs (utilisateursId, firstName, lastName, birthdate, login, password, utilisateursRole)
                
                VALUES ( DEFAULT, 'Emily', 'Davis', '1995-12-05', 'emida', 'MotDePasse123', 'Admin' );
               
                                
                CREATE TABLE book (
                bookID SERIAL primary key  not null,
                name VARCHAR(50),
                publishingYear int,
                isbn VARCHAR(50),
                Author VARCHAR(50),
                Dispo BOOLEAN
                );
                
                
                INSERT INTO book(bookID, name, publishingYear, isbn, author, Dispo)
                VALUES (DEFAULT,'Le Secret du chateau', '2005', '978-1234567890', 'Jane Smith', true);
                
                INSERT INTO book(bookID, name, publishingYear, isbn, author, Dispo)
                VALUES ( DEFAULT,'L''Odyssée Interstellaire', '2010', '978-0987654321', 'John Doe', true);
                
                INSERT INTO book(bookID, name, publishingYear, isbn, author, Dispo)
                VALUES (DEFAULT,'Les Fleurs de Printemps', '2012', '978-5432109876', 'Emily Brown', false);
                
                INSERT INTO book(bookID, name, publishingYear, isbn, author, Dispo)
                VALUES (DEFAULT,'La Quête du Savoir', '2008', '978-1357924680', 'Michael Johnson', true);
                
                INSERT INTO book(bookID, name, publishingYear, isbn, author, Dispo)
                VALUES (DEFAULT,'L''Énigme de la Pyramide', '2015', '978-2468135790', 'Sarah Adams', false);
                
                INSERT INTO book(bookID,name, publishingYear, isbn, author, Dispo)
                VALUES (DEFAULT,'L''Énigme de la Pyramide', '2015', '978-2468135790', 'Sarah Adams', false);
                
                INSERT INTO book(bookID,name, publishingYear, isbn, author, Dispo)
                VALUES (DEFAULT,'Voyage dans le Temps', '2014', '978-9876543210', 'David White', true);
                
                INSERT INTO book(bookID,name, publishingYear, isbn, author,Dispo)
                VALUES (DEFAULT,'Les Secrets de l''Univers', '2019', '978-1122334455', 'Lisa Green', true);
                
                INSERT INTO book(bookID,name, publishingYear, isbn, author, Dispo)
                VALUES (DEFAULT,'La Magie de la Nature', '2007', '978-5678901234', 'Robert Clark', false);
                
                
                INSERT INTO book ( bookID, name, publishingYear, isbn, author, Dispo)
                VALUES (DEFAULT,'L''Art de la Cuisine', '2013', '978-8765432109', 'Maria Garcia', true);
                
           
                INSERT INTO book (bookID, name, publishingYear, isbn, author, Dispo)
                VALUES (DEFAULT,'Le Mystère du Cercle', '2011', '978-5555555555', 'James Anderson', false);
                
           
                INSERT INTO book (bookID, name, publishingYear, isbn, author, Dispo)
                VALUES (DEFAULT,'Les Chemins de la Liberté', '2009', '978-9999999999', 'Laura Wilson', false);
                
         
                INSERT INTO book (bookID,name, publishingYear, isbn, author, Dispo)
                VALUES (DEFAULT,'Le Voyage de la Vie', '2016', '978-4444444444', 'Daniel Brown', true);
                
                -- Livre 13
                INSERT INTO book (bookID,name, publishingYear, isbn, author, Dispo)
                VALUES (DEFAULT,'L''Évasion Imaginaire', '2017', '978-1231231231', 'Sarah Miller', true);
                
                -- Livre 14
                INSERT INTO book (bookID,name, publishingYear, isbn, author, Dispo)
                VALUES (DEFAULT,'La Quête de la Sagesse', '2018', '978-6666666666', 'William Jackson', false);
                
                -- Livre 15
                INSERT INTO book (bookID,name, publishingYear, isbn, author, Dispo)
                VALUES (DEFAULT,'Les Rêves d''Étoiles', '2006', '978-7777777777', 'Olivia Parker', true);
                
                -- Livre 16
                INSERT INTO book (bookID,name, publishingYear, isbn, author, Dispo)
                VALUES (DEFAULT,'Le Monde des Merveilles', '2015', '978-8888888888', 'Thomas Lee', true);
                
                -- Livre 17
                INSERT INTO book (bookID,name, publishingYear, isbn, author, Dispo)
                VALUES (DEFAULT,'La Légende de l''Épée', '2014', '978-1010101010', 'Sophie Martin', true);
                
                -- Livre 18
                INSERT INTO book (bookID,name, publishingYear, isbn, author, Dispo)
                VALUES (DEFAULT,'Le Mystère du Trésor', '2010', '978-1212121212', 'Kevin Davis', true);
                
                -- Livre 19
                INSERT INTO book (bookID,name, publishingYear, isbn, author, Dispo)
                VALUES (DEFAULT,'L''Amour Éternel', '2012', '978-1313131313', 'Jennifer Turner', true);
                
                -- Livre 20
                INSERT INTO book (bookID,name, publishingYear, isbn, author, Dispo)
                VALUES (DEFAULT,'Les Secrets du Passé', '2013', '978-1414141414', 'Mark Roberts', false);
                
                -- Livre 21
                INSERT INTO book (bookID,name, publishingYear, isbn, author, Dispo)
                VALUES (DEFAULT,'Le Pouvoir des Éléments', '2018', '978-1515151515', 'Rachel White', false);
                
                -- Livre 22
                INSERT INTO book (bookID,name, publishingYear, isbn, author, Dispo)
                VALUES (DEFAULT,'Le Chant des Oiseaux', '2008', '978-1616161616', 'David Martin', true);
                
                -- Livre 23
                INSERT INTO book (bookID,name, publishingYear, isbn, author, Dispo)
                VALUES (DEFAULT,'L''Éveil de la Magie', '2019', '978-1717171717', 'Emma Turner', true);
                
                -- Livre 24
                INSERT INTO book (bookID,name, publishingYear, isbn, author, Dispo)
                VALUES (DEFAULT,'Les Jardins du Paradis', '2011', '978-1818181818', 'Julia Evans', false);
                
                -- Livre 25
                INSERT INTO book (bookID,name, publishingYear, isbn, author, Dispo)
                VALUES (DEFAULT,'La Lueur de l''Aube', '2007', '978-1919191919', 'Andrew Scott', true);
                
      
                                
                CREATE TABLE address
                (
                adressId     SERIAL primary key not null,
                streetNumber VARCHAR(50),
                streetName   VARCHAR(50),
                zipCode      VARCHAR(50),
                city         VARCHAR(50)
                );
                
                INSERT INTO address( adressId ,streetNumber, streetName, zipCode, city)
                VALUES  (DEFAULT, 15, 'Rue du paradis', '6642', 'Vaux-Sur-Sûre');
                
                INSERT INTO address (adressId ,streetNumber, streetName, zipCode, city)
                VALUES (DEFAULT, 25, 'Avenue des Roses', '75001', 'Paris');
                
                -- Adresse 2
                INSERT INTO address (adressId ,streetNumber, streetName, zipCode, city)
                VALUES (DEFAULT, 10, 'Rue de la Libération', '69002', 'Lyon');
                
                -- Adresse 3
                INSERT INTO address (adressId ,streetNumber, streetName, zipCode, city)
                VALUES (DEFAULT, 5, 'Boulevard des Artistes', '13008', 'Marseille');
                
                -- Adresse 4
                INSERT INTO address (adressId ,streetNumber, streetName, zipCode, city)
                VALUES (DEFAULT, 30, 'Via Roma', '00100', 'Rome');
                
                -- Adresse 5
                INSERT INTO address (adressId ,streetNumber, streetName, zipCode, city)
                VALUES (DEFAULT, 18, 'Calle de la Luna', '28001', 'Madrid');
                
                -- Adresse 6
                INSERT INTO address (adressId ,streetNumber, streetName, zipCode, city)
                VALUES (DEFAULT, 7, 'Am Kurfürstendamm', '10719', 'Berlin');
                
                -- Adresse 7
                INSERT INTO address (adressId ,streetNumber, streetName, zipCode, city)
                VALUES (DEFAULT, 22, 'Broadway', '10007', 'New York');
                
                -- Adresse 8
                INSERT INTO address (adressId ,streetNumber, streetName, zipCode, city)
                VALUES (DEFAULT, 12, 'Baker Street', 'NW1 6XE', 'Londres');
                
                -- Adresse 9
                INSERT INTO address (adressId ,streetNumber, streetName, zipCode, city)
                VALUES (DEFAULT, 3, 'Rue de la Paix', '75002', 'Paris');
                
                -- Adresse 10
                INSERT INTO address (adressId ,streetNumber, streetName, zipCode, city)
                VALUES (DEFAULT, 15, 'Calle Mayor', '28013', 'Madrid');
                
                          
                
                
                CREATE TABLE library (
                libraryID SERIAL primary key  not null,
                name VARCHAR(50)
                );
                INSERT INTO library(LIBRARYID, NAME)
                VALUES (default, 'Librairie du Savoir');                
                
               
                
                CREATE TABLE borrow (
                    borrow_id serial PRIMARY KEY,
                    user_id INT NOT NULL,
                    book_id INT NOT NULL,
                    borrow_date DATE NOT NULL,
                    return_date DATE,
                    FOREIGN KEY (user_id) REFERENCES utilisateurs(utilisateursId) ,
                    FOREIGN KEY (book_id) REFERENCES book(bookid),
                    CHECK (return_date IS NULL OR return_date >= borrow_date)
                );
               
                                
                """;

        System.out.println("Initialisation en cours...");

        try(Connection connection = ConnectionFactory.createConnection();
            Statement statement = connection.createStatement()) {

            try{
                connection.setAutoCommit(false);
                System.out.println("Connection ... ok ");
                statement.execute(requete);
                System.out.println("Initialisation effectuée !");
                connection.commit();

            }catch (SQLException e){
                connection.rollback();
                throw new RuntimeException("error", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
