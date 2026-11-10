package tp_fichiers;

import java.io.*;

public class Exercice3 {

    public static void copierAvecNumeros(String source, String dest)
            throws IOException {

        BufferedReader br = new BufferedReader(
                new FileReader(source));

        BufferedWriter bw = new BufferedWriter(
                new FileWriter(dest));

        String ligne;
        int numero = 1;

        while ((ligne = br.readLine()) != null) {

            bw.write(numero + ": " + ligne);
            bw.newLine();

            numero++;
        }

        br.close();
        bw.close();
    }

    public static long copierBinaire(String source, String dest)
            throws IOException {

        FileInputStream fis = new FileInputStream(source);
        FileOutputStream fos = new FileOutputStream(dest);

        int octet;
        long compteur = 0;

        while ((octet = fis.read()) != -1) {

            fos.write(octet);
            compteur++;
        }

        fis.close();
        fos.close();

        return compteur;
    }

    public static void main(String[] args) throws IOException {
                  
        String source = "tp_fichiers/produits.txt";
        File archives = new File("tp_fichiers/archives");

        if (!archives.exists()) {
            archives.mkdir();
        }
        copierAvecNumeros(source,"tp_fichiers/produits_num.txt");

        long taille = copierBinaire( source,"tp_fichiers/archives/produits_copie.txt" );

        System.out.println("Octets copiés : " + taille);

        File original = new File(source);

        File copie = new File(
                "tp_fichiers/archives/produits_copie.txt");

        System.out.println("Taille original : " + original.length());
        System.out.println("Taille copie : " + copie.length());

        System.out.println( "Même taille : " +(original.length() == copie.length()));
    }
}
