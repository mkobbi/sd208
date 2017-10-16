import java.sql.*;
import java.io.*;


/**
 *  NOM, Prenom 1 :
 *  NOM, Prenom  *
 * La classe Acces
 **/
public class Acces {

    /* Commentaire: */
    String url = "jdbc:h2:tcp://localhost/~/";
    String user = "sa";
    String password = "";


    String requete = "select nom from Ville order by nom";

    Connection connexion = null;
    public static PrintStream out = System.out;    // affichage des résulats à l'ecran

    /**
     * methode main: point d'entrée
     **/
    public static void main(String a[]) {

        /* Commentaire: */
        Acces c = new Acces();

	c.traiteRequete();
    }

    /**
     * Constructeur : initialisation
     **/
    protected Acces(){
        try {
            /* Chargement du pilote JDBC */
	    Class.forName("org.h2.Driver");
        }
        catch(Exception e) {
            Outil.erreurInit(e);
        }
    }

    /**
     *  La methode traiteRequete
     *
     *  Commentaire :
     *
     */
    public void traiteRequete() {
        try {

            /* Commentaire: */
            connexion = DriverManager.getConnection(url + "site1", user, password);

            /* Commentaire: */
            Statement lecture =  connexion.createStatement();

	    out.println("traite la requete: " + requete);
            ResultSet resultat = lecture.executeQuery(requete);

            /* Commentaire: */
            while (resultat.next()) {
                String tuple = resultat.getString(1);
                out.println(tuple);
            }

            /* Commentaire: */
	    resultat.close();
	    lecture.close();
	    connexion.close();
        }

        /* Commentaire: */
        catch(Exception e){ Outil.gestionDesErreurs(connexion, e);}
    }
}
