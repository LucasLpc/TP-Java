package Files;

import java.io.BufferedReader;

public interface LecteurFichier {
    public void lireFichier();
    public void lireFichierReverse();
    public void lireFichierPalyndrome();
    public void diff(BufferedReader bufferedReader);
}
