package task3bonus;

import com.google.gson.annotations.SerializedName;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Movies {
    private final String name;
    private final String year;
    private final String description;
    @SerializedName("director")
    private final Director director;
    @SerializedName("cast")
    private List<Cast> cast;
    private String dierctorName;
    private static Set<String> st=new HashSet<>();

    public Movies(String name, String year, String description, Director director, List<Cast> cast,String dierctorName) {
        this.name = name;
        this.year = year;
        this.description = description;
        this.director = director;
        this.cast = cast;
        this.dierctorName=director.getFullName();

    }

    public String listPrint() {
        String res="";
        for(int i=0;i<cast.size();i++)
        {
            res+="{fullName:"+cast.get(i).getFullName()+",role:+"+cast.get(i).getRole()+"}";
        }
        return res;
    }

    public List<Cast> getCast() {
        return cast;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getDescription() {
        return description;
    }

    public String getDierctorName() {
        return director.getFullName();
    }


    public static int sortByDate(Movies m1,Movies m2)
    {
        return m1.year.compareTo(m2.year);
    }
    public static int sortByName(Movies m1,Movies m2){return m1.name.compareTo(m2.name);}
    public static int sortByDirector(Movies m1,Movies m2){return m1.director.getFullName().compareTo(m2.director.getFullName());}

    public boolean getActor(String name)
    {
        for(int i=0;i<cast.size();i++)
        {
            if(name.equals(cast.get(i).getFullName()))
            {
                return false;
            }
        }
        return true;
    }
    public boolean getByDirector(String directorI)
    {
        if(directorI.equals(director.getFullName()))
        {
                return false;
        }
        return true;
    }
    public boolean getByDate(String date)
    {
        if(date.equals(year))
        {
            return false;
        }
        return true;
    }




}