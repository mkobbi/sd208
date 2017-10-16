import java.sql.*;
import java.io.*;


/**
 *  NOM, Prenom 1 :
 *  NOM, Prenom  *
 * La classe question5
 **/
public class question5 {

    /* Commentaire: */
    String url = "jdbc:h2:tcp://localhost/~/";
    String user = "sa";
    String password = "";


    String requete1 = "select b.nom, b.departement, b.population from Ville b where b.departement<20";
    //String requete2 = "select a.nom, a.ville, a.note from Visite a";

    Connection connexion1 = null;
    Connection connexion2 = null;
    public static PrintStream out = System.out;    // affichage des résulats à l'ecran

    /**
     * methode main: point d'entrée
     **/
    public static void main(String a[]) {

        /* Commentaire: */
        question5 c = new question5();

	c.traiteRequete();
    }

    /**
     * Constructeur : initialisation
     **/
    protected question5(){
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
            Statement lecture1 =  connexion1.createStatement();


	    //out.println("traite la requete: " + requete);
            ResultSet ville = lecture1.executeQuery(requete1);

            /* Commentaire: */
            while (ville.next()) {
              String requete2 = "select a.nom, a.ville, a.note from Visite a where a.nom = " + ville.getString(1);
              Statement lecture2 =  connexion2.createStatement();
              ResultSet visite = lecture2.executeQuery(requete2);
              while(visite.next()){
                //if(ville.getString(1).equals(visite.getString(2))){
                String tuple = visite.getString(1) + "\t" + visite.getString(2) + "\t" + visite.getString(3) + "\t" + ville.getString(3);
                out.println(tuple);
                }
              //}
              visite.close();
              lecture2.close();
              connexion2.close();

            }

            /* Commentaire: */
	    ville.close();
	    lecture1.close();
	    connexion1.close();
        }

        /* Commentaire: */
        catch(Exception e){
          Outil.gestionDesErreurs(connexion1, e);
          Outil.gestionDesErreurs(connexion2, e);
          }
    }
}
