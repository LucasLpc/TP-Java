import java.util.*;

public class Paquet {
    private ArrayList<Carte> tas;
    private ArrayList<Carte> paquetJoueur1;
    private ArrayList<Carte> paquetJoueur2;

    public Paquet() {
        this.tas = new ArrayList<Carte>();
        for (Couleur c : Couleur.values()) {
            for (Valeur v : Valeur.values()) {
                Carte carte = new Carte(c, v);
                tas.add(carte);
            }
        }
        this.paquetJoueur1 = new ArrayList<Carte>();
        this.paquetJoueur2 = new ArrayList<Carte>();
        Random random = new Random();
        for (int i = this.tas.size(); i > 0; i--) {
            int randomIndexToSwap = random.nextInt(this.tas.size());
            Carte c = this.tas.get(randomIndexToSwap);
            this.tas.remove(c);
            if (i % 2 == 0) this.paquetJoueur1.add(c);
            else this.paquetJoueur2.add(c);
        }
        this.tas = new ArrayList<Carte>();
    }

    public void addCarte(Carte c) {
        this.tas.add(c);
    }

    public ArrayList<Carte> getTas() {
        ArrayList<Carte> temp = new ArrayList<Carte>();
        for (Carte c :
                this.tas) {
            temp.add(c);
        }
        this.tas = new ArrayList<Carte>();
        return temp;
    }

    public ArrayList<Carte> getPaquetJoueur1() {
        return this.paquetJoueur1;
    }

    public ArrayList<Carte> getPaquetJoueur2() {
        return this.paquetJoueur2;
    }

    @Override
    public String toString() {
        return "Paquet{" +
                "tas=" + tas +
                '}';
    }
}
