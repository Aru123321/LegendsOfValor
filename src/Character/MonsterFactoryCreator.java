package Character;

import InputAndReader.txtReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public interface MonsterFactoryCreator {


    Monster createMonster(String Line, String Type);

    Monster getMonster(Scanner sc, String Type) ;
    void initialMonsterList() throws FileNotFoundException;

}
