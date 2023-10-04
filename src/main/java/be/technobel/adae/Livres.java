package be.technobel.adae;

import lombok.AllArgsConstructor;
import lombok.Data;


import java.time.Year;
 @Data

public class Livres {

    String nom;
    String auteur;
    Year anneePublication;
    String ISBN;
    Boolean dispo;
}
