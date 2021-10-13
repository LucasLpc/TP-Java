import java.util.ArrayList;
import java.util.Random;

/*
* @author Lucas Laplanche
*
* Le main du TP ou le jeu est lancé, soit l'un des joueurs gagne
* soit il y a bataille et les 2 joueurs deposent une carte dans le tas.
*
* La partie se termine quand l'un des deux joueurs ne peut plus jouer.
* */

public class Bataille {
    public static void main(String[] args) {
        //Le paquet est constitue du tas, du paquet du joueur 1 et du paquet du joueur 2;
        Paquet paquet = new Paquet();
        //Un joueur a un nom et un paquet
        Joueur joueur1 = new Joueur("Joueur 1", paquet.getPaquetJoueur1()),
                joueur2 = new Joueur("Joueur 2", paquet.getPaquetJoueur2());
        boolean play = true;
        while (play) {
            if (joueur1.peutJouer() && joueur2.peutJouer()) {
                //Chaque joueur pioche et met la carte sur le tas
                Carte c1 = joueur1.pioche();
                paquet.addCarte(c1);
                Carte c2 = joueur2.pioche();
                paquet.addCarte(c2);
                System.out.println("Joueur 1: " + c1 + " | Joueur 2: " + c2);
                //Si la carte du joueur 1 est plus forte que celle du joueur 2 alors le joueur 1 remporte le tas
                if (c1.compare(c2) == 1 && c2.compare(c1) == -1) {
                    System.out.println("Joueur 1 gagne");
                    joueur1.gagne(paquet.getTas());
                    //Et le tas est remis a zero
                } else if (c1.compare(c2) == -1 && c2.compare(c1) == 1) {
                    System.out.println("Joueur 2 gagne");
                    joueur2.gagne(paquet.getTas());
                } else if (c1.compare(c2) == 0 && c2.compare(c1) == 0) {
                    //Ici quand les deux cartes sont de meme force chaque joueur depose une carte dans le tas
                    if (joueur1.peutJouer() && joueur2.peutJouer()) {
                        System.out.println("Bataille");
                        paquet.addCarte(joueur1.pioche());
                        paquet.addCarte(joueur2.pioche());
                    }
                }
                System.out.println("Joueur 1: " + joueur1.getPioche() + " | Joueur 2: " + joueur2.getPioche());
            } else {
                if (joueur1.peutJouer()) System.out.println("Joueur 1 a gagne la partie");
                if (joueur2.peutJouer()) System.out.println("Joueur 2 a gagne la partie");
                play = false;
            }
        }
    }
}
