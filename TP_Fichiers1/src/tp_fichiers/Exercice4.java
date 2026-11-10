package tp_fichiers;

import java.io.*;
import java.util.ArrayList;

public class Exercice4 {

    public static ArrayList<Produit> lireProduits(String nom)throws IOException {

        ArrayList<Produit> liste = new ArrayList<>();

        BufferedReader br = new BufferedReader(
                new FileReader(nom));

        String ligne;

        while ((ligne = br.readLine()) != null) {

            String[] tab = ligne.split(";");

            int num = Integer.parseInt(tab[0]);
            String designation = tab[1];
            float prix = Float.parseFloat(tab[2]);

            Produit p = new Produit(num, designation, prix);

            liste.add(p);
        }

        br.close();

        return liste;
    }

    public static void sauvegarder(
            ArrayList<Produit> liste, String nom)
            throws IOException {

        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(nom));

        oos.writeObject(liste);

        oos.close();
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Produit> charger(String nom)
            throws IOException, ClassNotFoundException {

        File fichier = new File(nom);

        if (!fichier.exists()) {
            return new ArrayList<>();
        }

        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(fichier));

        ArrayList<Produit> liste =
                (ArrayList<Produit>) ois.readObject();

        ois.close();

        return liste;
    }

    public static void main(String[] args) {

        String fichier = "tp_fichiers/produits.txt";
        String stock = "tp_fichiers/stock.dat";

        try {
            ArrayList<Produit> liste = lireProduits(fichier);
            sauvegarder(liste, stock);

            System.out.println(liste.size() + " produits sauvegardés" );

            liste = charger(stock);
            Produit p = new Produit(6, "Webcam", 350);

            liste.add(p);
            sauvegarder(liste, stock);
            liste = charger(stock);

            for (Produit produit : liste) {
                System.out.println(produit);
            }

        } catch (FileNotFoundException e) {

            System.out.println("Fichier introuvable : " + e.getMessage());

        } catch (IOException e) {

            System.out.println("Erreur : " + e.getMessage());

        } catch (ClassNotFoundException e) {

            System.out.println("Classe introuvable : " + e.getMessage());
           
        }
    }
}
