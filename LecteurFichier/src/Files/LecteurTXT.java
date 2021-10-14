package Files;

import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LecteurTXT extends Fichier{

    public LecteurTXT(String file) {
        super(file);
    }

    @Override
    public void lireFichier() {
        String line = null;
        while (true){
            try {
                if (!((line = this.getBufferedReader().readLine()) != null)) break;
                System.out.println(line);
            } catch (IOException e) {
                e.getMessage();
            }

        }
    }

    @Override
    public void lireFichierReverse() {
        String line = null;
        while (true){
            try {
                if (!((line = this.getBufferedReader().readLine()) != null)) break;
                char[] chars = line.toCharArray();
                for (int i = 0; i < chars.length/2; i++) {
                    char temp = chars[i];
                    chars[i] = chars[(chars.length - 1) - i];
                    chars[(chars.length - 1) - i] = temp;
                }
                System.out.println(new String(chars));
            } catch (IOException e) {
                e.getMessage();
            }

        }
    }

    @Override
    public void lireFichierPalyndrome() {
        String line = null;
        while (true){
            try {
                if (!((line = this.getBufferedReader().readLine()) != null)) break;
                if (line.contains(" ")){
                    String finalLine = "";
                    String[] strings = line.split(" ");
                    for (int i = 0; i < strings.length; i++) {
                        char[] chars = strings[i].toCharArray();
                        for (int j = 0; j < chars.length/2; j++) {
                            char temp = chars[j];
                            chars[j] = chars[(chars.length - 1) - j];
                            chars[(chars.length - 1) - j] = temp;
                        }
                        finalLine += new String(chars);
                        if (i < strings.length - 1) finalLine += " ";
                    }
                    System.out.println(finalLine);
                } else {
                    char[] chars = line.toCharArray();
                    for (int i = 0; i < chars.length/2; i++) {
                        char temp = chars[i];
                        chars[i] = chars[(chars.length - 1) - i];
                        chars[(chars.length - 1) - i] = temp;
                    }
                    System.out.println(new String(chars));
                }
            } catch (IOException e) {
                e.getMessage();
            }

        }
    }

    @Override
    public void diff(BufferedReader bufferedReaderToCompare) {
        String line = null;
        String lineBis = null;
        int index = 1;
        boolean same = true;
        while (true){
            try {
                line = this.getBufferedReader().readLine();
                lineBis = bufferedReaderToCompare.readLine();
                if (line == null && lineBis == null) {
                    break;
                } else if (line == null && lineBis != null) {
                    System.out.println("Premier fichier l" + index + ": " + line);
                    System.out.println("Deuxieme fichier l" + index + ": " + lineBis);
                    System.out.println("l" + index + ": Du premier fichier est vide");
                    same = false;
                    break;
                } else if (line != null && lineBis == null) {
                    System.out.println("Premier fichier l" + index + ": " + line);
                    System.out.println("Deuxieme fichier l" + index + ": " + lineBis);
                    System.out.println("l" + index + ": Du deuxieme fichier est vide");
                    same = false;
                    break;
                }
                if (line.compareTo(lineBis) != 0){
                    System.out.println("Premier fichier l" + index + ": " + line.replace(" ", "_"));
                    System.out.println("Deuxieme fichier l" + index + ": " + lineBis.replace(" ", "_"));
                    System.out.println("l" + index + ": Les lignes sont differentes");
                    same = false;
                    break;
                }
                index++;
            } catch (IOException e) {
                e.getMessage();
            }
        }
        if (same)System.out.println("Le contenu des fichiers est identique");
    }
}
