package hu.petrik;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLClientInfoException;
import java.util.*;
public class Morze {
    private HashMap<String, String> morzeMap;
    private HashMap<String, String> betuMap;
    public Morze() {
        this.morzeMap = new HashMap<>();
        this.betuMap = new HashMap<>();
        Beolvasas();
        System.out.println("3.feladat: A morze abc " + betuMap.size() + " db karakter kódját tartalmazza.");;
        Bekeres();
    }

    public void Beolvasas() {


        try {

            BufferedReader br = new BufferedReader(new FileReader("morzeabc.txt"));
            br.readLine();

            String sor = br.readLine();
            while (sor != null) {
                String[] st = sor.split("\\t");
                String betu = st[0];
                String  morzekod = st[1];

                morzeMap.putIfAbsent(morzekod, betu);
                betuMap.putIfAbsent(betu, morzekod);

                sor = br.readLine();
            }
            br.close();
        }catch (IOException e) {
            e.getMessage();
        }


    }



    private void Bekeres() {

        Scanner bekeres = new Scanner(System.in);
        System.out.print("4. feladat: Kérek egy karaktert: ");
        String bekertBetu = bekeres.nextLine().toUpperCase();
        if (betuMap.containsKey(bekertBetu)) {
            System.out.printf("\t\t\tA(z) %s karakter morze kódja: %s\n", bekertBetu, betuMap.get(bekertBetu));
        } else {
            System.out.println("\t\t\tNem található a kódtárban ilyen karakter!");
        }
    }
}
