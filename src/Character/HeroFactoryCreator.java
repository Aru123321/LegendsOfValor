package Character;

import InputAndReader.txtReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public interface HeroFactoryCreator {


    Hero createHero(String heroLine, String HeroType);
    Hero getHero(Scanner sc, String heroType) ;


    void initialHeroList() throws FileNotFoundException;


    ArrayList getWarriorsList();
    ArrayList getSorcererList();
    ArrayList getPaladinsList();

    void showHeroList() throws FileNotFoundException;




}
