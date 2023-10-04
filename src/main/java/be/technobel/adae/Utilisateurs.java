package be.technobel.adae;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data

public class Utilisateurs extends Bibliotheque {
    int id;
    String nom;
    String prenom;
    String login;
    String password;
    Boolean role;
}
