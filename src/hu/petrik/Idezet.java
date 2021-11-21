package hu.petrik;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Idezet {
    public HashMap<String,String> idezetMap;
    public Idezet() {
        idezetMap = Beolvas();
        Morze2Szoveg();
    }

    public HashMap<String, String> Beolvas() {
        HashMap<String,String> idezetBeolvas = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("morze.txt"));
            String sor = br.readLine();

            while (sor != null) {
                String[] adatok = sor.split(";");
                String szerzo = adatok[0];
                szerzo = szerzo.replace("      ", " ");
                szerzo = szerzo.replace("   ", " ");
                szerzo = szerzo.substring(szerzo.length()-1);
                String idezet = adatok[1];
                idezet = idezet.replace("      ", " ");
                idezet = idezet.replace("   ", " ");
                idezetBeolvas.put(szerzo, idezet);
                sor = br.readLine();
            }
            br.close();
        }catch (IOException e) {
            e.getMessage();
        }
        return idezetBeolvas;
    }

    public void Morze2Szoveg() {
        
    }
}
