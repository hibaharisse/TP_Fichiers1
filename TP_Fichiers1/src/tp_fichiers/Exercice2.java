package tp_fichiers;

import java.io.*;

public class Exercice2 {

    public static void main(String[] args) throws IOException {

        File dossier = new File("tp_fichiers");

        if (!dossier.exists()) {
            dossier.mkdir();
        }

        File fichier = new File(dossier, "produits.txt");


        PrintWriter pw = new PrintWriter(new FileWriter(fichier));

        pw.println("1;Ordinateur;5600.0");
        pw.println("2;Imprimante;1200.5");
        pw.println("3;Clavier;150.0");
        pw.println("4;Ecran;1800.0");

        pw.close();

        BufferedReader br = new BufferedReader(
                new FileReader(fichier));

        String ligne;
 
        int nombre = 0;
        double total = 0;
        double prixMax = 0;
        String produitCher = "";

        while ((ligne = br.readLine()) != null) {

            String[] tab = ligne.split(";");

            int num = Integer.parseInt(tab[0]);
            String designation = tab[1];
            double prix = Double.parseDouble(tab[2]);

            System.out.println(num + " -- " + designation
                    + " -- " + prix + " DH.");

            nombre++;
            total += prix;

            if (prix > prixMax) {
                prixMax = prix;
                produitCher = designation;
            }
        }

        br.close();

        System.out.println("Nombre de produits : " + nombre);
        System.out.println("Prix total : " + total);
        System.out.println("Produit le plus cher : " + produitCher);

        

        FileWriter fw = new FileWriter(fichier, true);

        fw.write("5;Souris;80.0" + System.lineSeparator());

        fw.close();

       

        FileReader fr = new FileReader(fichier);

        int c;
        int nbCaracteres = 0;
        int nbLignes = 0;

        while ((c = fr.read()) != -1) {

            nbCaracteres++;

            if (c == '\n') {
                nbLignes++;
            }
        }

        fr.close();

        System.out.println("Nombre de caractères : " + nbCaracteres);
        System.out.println("Nombre de lignes : " + nbLignes);
    }
}