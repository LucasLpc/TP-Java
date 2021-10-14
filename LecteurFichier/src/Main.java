import Files.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Extension du fichier :\t");
        String type = scanner.nextLine();
        System.out.print("Chemin du fichier :\t");
        String file = scanner.nextLine();
        System.out.print("Méthode de lecture :\n1 - Normal\n2 - A l'envers (ligne)\n3 - Palyndrome\n4 - Comparer\nVotre choix (ecrire numero): ");
        String methode = scanner.nextLine();
        Fichier lecteur = null;
        switch (type){
            case "txt":
                lecteur = new LecteurTXT(file);
                break;
            default:
                System.out.println("Extension inconnue");
                break;
        }
        if (lecteur != null) {
            switch (methode) {
                case "1":
                    System.out.println("Contenu :");
                    lecteur.lireFichier();
                    break;
                case "2":
                    System.out.println("Contenu (a l'envers) :");
                    lecteur.lireFichierReverse();
                    break;
                case "3":
                    System.out.println("Contenu (palyndrme) :");
                    lecteur.lireFichierPalyndrome();
                    break;
                case "4":
                    System.out.print("Chemin du fichier a comparer :\t");
                    String fileToCompare = scanner.nextLine();
                    try {
                        BufferedReader bufferedReaderToCompare = new BufferedReader(new FileReader(new File(fileToCompare)));
                        System.out.println("Compare :");
                        lecteur.diff(bufferedReaderToCompare);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Methode inconnue");
                    break;
            }
        }
    }
}
