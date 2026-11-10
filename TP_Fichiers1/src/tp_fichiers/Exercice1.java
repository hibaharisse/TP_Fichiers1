package tp_fichiers;


	import java.io.*;

	public class Exercice1 {

	    public static void main(String[] args) throws IOException {

	    
	        File dossier = new File("C:/tp_fichiers");

	        
	        if (!dossier.exists()) {
	            dossier.mkdir();
	        }
	            System.out.println(dossier.getAbsolutePath());
	        

	        File a = new File(dossier, "a.txt");
	        File b = new File(dossier, "b.txt");
	        File archives = new File(dossier, "archives");

	        a.createNewFile();
	        b.createNewFile();
	        archives.mkdir();

	       
	        String[] elements = dossier.list();

	        int nbFichiers = 0;
	        int nbRepertoires = 0;

	        for (String nom : elements) {

	            File f = new File(dossier, nom);

	            if (f.isDirectory()) {
	                System.out.println("[REP] " + nom);
	                nbRepertoires++;
	            } else {
	                System.out.println("[FICHIER] " + nom
	                        + " (" + f.length() + " octets)");
	                nbFichiers++;
	            }
	        }

	       
	        System.out.println(nbFichiers + " fichier(s), "
	                + nbRepertoires + " répertoire(s)");
	    }
	}

