package Files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public abstract class Fichier implements LecteurFichier{

    private BufferedReader bufferedReader;

    public Fichier(String file) {
        try {
            this.bufferedReader = new BufferedReader(new FileReader(new File(file)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public abstract void lireFichier();

    @Override
    public abstract void lireFichierReverse();

    @Override
    public abstract void lireFichierPalyndrome();

    @Override
    public abstract void diff(BufferedReader bufferedReader);

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }
}
