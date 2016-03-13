package cafetcraftteam.rpgsoftware.gui;

import java.util.ArrayList;

/**
 * Created by defig on 24.02.2016.
 */
public class Personne {
    public final static int MASCULIN = 1;
    public final static int FEMININ = 2;

    public String nom;
    public String prenom;
    public int genre;

    public Personne(String aNom, String aPrenom, int aGenre) {
        nom = aNom;
        prenom = aPrenom;
        genre = aGenre;
    }

    /**
     * Initialise une liste de personnes
     * @return une liste de "Personne"
     */
    public static ArrayList<Personne> getAListOfPersonne() {
        ArrayList<Personne> listPers = new ArrayList<Personne>();

        listPers.add(new Personne("Nom1", "Prenom1", FEMININ));
        listPers.add(new Personne("Nom2", "Prenom2", MASCULIN));
        listPers.add(new Personne("Nom3", "Prenom3", MASCULIN));
        listPers.add(new Personne("Nom4", "Prenom4", FEMININ));
        listPers.add(new Personne("Nom5", "Prenom5", FEMININ));
        listPers.add(new Personne("Nom6", "Prenom6", MASCULIN));
        listPers.add(new Personne("Nom7", "Prenom7", FEMININ));
        listPers.add(new Personne("Nom8", "Prenom8", MASCULIN));
        listPers.add(new Personne("Nom9", "Prenom9", MASCULIN));
        listPers.add(new Personne("Nom10", "Prenom10", FEMININ));
        listPers.add(new Personne("Nom11", "Prenom11", MASCULIN));
        listPers.add(new Personne("Nom12", "Prenom12", MASCULIN));
        listPers.add(new Personne("Nom13", "Prenom13", FEMININ));
        listPers.add(new Personne("Nom14", "Prenom14", MASCULIN));
        listPers.add(new Personne("Nom1", "Prenom1", FEMININ));
        listPers.add(new Personne("Nom2", "Prenom2", MASCULIN));
        listPers.add(new Personne("Nom3", "Prenom3", MASCULIN));
        listPers.add(new Personne("Nom4", "Prenom4", FEMININ));
        listPers.add(new Personne("Nom5", "Prenom5", FEMININ));
        listPers.add(new Personne("Nom6", "Prenom6", MASCULIN));
        listPers.add(new Personne("Nom7", "Prenom7", FEMININ));
        listPers.add(new Personne("Nom8", "Prenom8", MASCULIN));
        listPers.add(new Personne("Nom9", "Prenom9", MASCULIN));
        listPers.add(new Personne("Nom10", "Prenom10", FEMININ));
        listPers.add(new Personne("Nom11", "Prenom11", MASCULIN));
        listPers.add(new Personne("Nom12", "Prenom12", MASCULIN));
        listPers.add(new Personne("Nom13", "Prenom13", FEMININ));
        listPers.add(new Personne("Nom14", "Prenom14", MASCULIN));
        listPers.add(new Personne("Nom1", "Prenom1", FEMININ));
        listPers.add(new Personne("Nom2", "Prenom2", MASCULIN));
        listPers.add(new Personne("Nom3", "Prenom3", MASCULIN));
        listPers.add(new Personne("Nom4", "Prenom4", FEMININ));
        listPers.add(new Personne("Nom5", "Prenom5", FEMININ));
        listPers.add(new Personne("Nom6", "Prenom6", MASCULIN));
        listPers.add(new Personne("Nom7", "Prenom7", FEMININ));
        listPers.add(new Personne("Nom8", "Prenom8", MASCULIN));
        listPers.add(new Personne("Nom9", "Prenom9", MASCULIN));
        listPers.add(new Personne("Nom10", "Prenom10", FEMININ));
        listPers.add(new Personne("Nom11", "Prenom11", MASCULIN));
        listPers.add(new Personne("Nom12", "Prenom12", MASCULIN));
        listPers.add(new Personne("Nom13", "Prenom13", FEMININ));
        listPers.add(new Personne("Nom14", "Prenom14", MASCULIN));
        return listPers;
    }

}
