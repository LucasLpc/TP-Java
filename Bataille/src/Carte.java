public class Carte {
    private final Couleur couleur;
    private final Valeur valeur;

    public Carte(Couleur couleur, Valeur valeur) {
        this.couleur = couleur;
        this.valeur = valeur;
    }

    public int compare(Carte carte){
       if (carte.valeur.compareTo(this.valeur) < 0) return 1;
       else if (carte.valeur.compareTo(this.valeur) == 0) return 0;
       else return -1;
    }

    @Override
    public String toString() {
        return "Carte = " + valeur +
                " de " + couleur;
    }
}
