package Item;

import InputAndReader.txtReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public interface itemFactoryCreator {

    Item createItem(String Line, String Type);
     Item getItem(Scanner sc, String type);
    void initialList() throws FileNotFoundException;
    void showWeaponsList() throws FileNotFoundException;
     void printItemList(String TypeName, String title, ArrayList<? extends Item> List) ;

}
