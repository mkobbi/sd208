import java.sql.*;
import java.io.*;


/**
 *  NOM, Prenom 1 :
 *  NOM, Prenom  *
 * La classe Acces2
 **/
public class Acces2 {
    
    /* Commentaire: */
    String url = "jdbc:h2:tcp://localhost/~/";
    String user = "sa";
    String password = "";
    
    
    String requete = "select nom, ville, age from Pers where age >=20";

    Connection connexion1 = null;
    Connection connexion2 = null;
    public static PrintStream out = System.out;    // affichage des résulats à l'ecran
    
    /**
     * methode main: point d'entrée
     **/
    public static void main(String a[]) {

        /* Commentaire: */
        Acces2 c = new Acces2();
        
	c.traiteRequete();
    }
    
    /**
     * Constructeur : initialisation
     **/
    protected Acces2(){
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
            connexion1 = DriverManager.getConnection(url + "site1", user, password);
            connexion2 = DriverManager.getConnection(url + "site2", user, password);
            
            /* Commentaire: */
            Statement lecture =  connexion.createStatement();
            
	    out.println("traite la requete: " + requete);
            ResultSet resultat = lecture.executeQuery(requete);
            
            /* Commentaire: */
            while (resultat.next()) {
                String tuple = resultat.getString(1) + "\t" + resultat.getString(2) + "\t" + resultat.getString(3);
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
