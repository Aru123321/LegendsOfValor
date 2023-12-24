package InputAndReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class txtReader {
    private final String basePath = "LegendsGame/Legends_Monsters_and_Heroes/";



    public Scanner openFile(String filename) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(basePath + filename));
        sc.nextLine();
        return sc;
    }
}
