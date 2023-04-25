package task3bonus;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args){
     String json=readFile();
     HashMap<String,List<Movies>> hp=new HashMap<>();
     Map<String,List<Movies>> dup1=new HashMap<>();
     Map<String,List<Movies>> dup2=new HashMap<>();
     Map<String,List<Movies>> dup3=new HashMap<>();
     Map<String,List<Movies>> dup4=new HashMap<>();
        Type medicineListType = new TypeToken< HashMap<String,List<Movies>>>() {}.getType();
        hp=new Gson().fromJson(json,medicineListType);
        dup1=new Gson().fromJson(json,medicineListType);
        dup2=new Gson().fromJson(json,medicineListType);
        dup3=new Gson().fromJson(json,medicineListType);
        Printer.print(hp.get("movies"));
        System.out.println("Sort by YEAR");
        hp.get("movies").sort(Movies::sortByDate);
        Printer.print(hp.get("movies"));
        Collections.reverse(hp.get("movies"));
        Printer.print(hp.get("movies"));
        System.out.println("Sort by NAME");
        hp.get("movies").sort(Movies::sortByName);
        Printer.print(hp.get("movies"));
        Collections.reverse(hp.get("movies"));
        Printer.print(hp.get("movies"));
        System.out.println("Sort by Director");
        hp.get("movies").sort(Movies::sortByDirector);
        Printer.print(hp.get("movies"));
        Collections.reverse(hp.get("movies"));
        Printer.print(hp.get("movies"));
        Printer.print(hp.get("movies"));
        System.out.println("Все фильмы,в которых снимался данный актер:");
        String c="David Tennant";
        dup1.get("movies").removeIf(Movies->Movies.getActor(c));
        Printer.print(dup1.get("movies"));
        System.out.println("Все фильмы,который снимал данный режиссер:");
        String c2="Douglas Mackinnon";
        dup2.get("movies").removeIf(Movies->Movies.getByDirector(c2));
        Printer.print(dup2.get("movies"));


        System.out.println("Все фильмы,которые снимались в одном и том же году:");
        String c3="2005";
        dup3.get("movies").removeIf(Movies->Movies.getByDate(c3));
        Printer.print(dup3.get("movies"));
    }

    public static String readFile()
    {
        String json="";
        try{
            Path path= Paths.get("practice.json");
            json= Files.readString(path);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        return  json;
    }
}
