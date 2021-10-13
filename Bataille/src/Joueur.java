import java.util.ArrayList;

public class Joueur {

    private String nom;
    private ArrayList<Carte> pioche;

    public Joueur(String nom, ArrayList<Carte> pioche) {
        this.nom = nom;
        this.pioche = pioche;
    }

    public Carte pioche(){
        Carte c = this.pioche.get(0);
        this.pioche.remove(0);
        return c;
    }

    public void gagne(ArrayList<Carte> tas) {
        for (Carte c : tas){
            this.pioche.add(c);
        }
    }

    public boolean peutJouer(){
        return this.pioche.size() > 0 ? true : false;
    }

    public int getPioche() {
        return this.pioche.size();
    }

    public void setPioche(ArrayList<Carte> pioche) {
        this.pioche = pioche;
    }

    @Override
    public String toString() {
        return "Joueur{" +
                " nom='" + nom + '\'' +
                ", pioche=" + pioche.size() +
                ", cartes=" + pioche.toString() +
                '}';
    }
}
