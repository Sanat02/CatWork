package task1;

import java.util.List;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        var cats = Cat.makeCats(10);
        List<Cat> duplicateList=cats;
        Printer.print(cats);

        // А сюда добавьте код, который будет сортировать коллекцию котов
        // используйте лямбда-выражения и ссылки на методы
        // cats.sort(?);
        // Printer.print(cats);
        System.out.println("Sorted by Breed:");
        cats.sort(Cat::byBreed);
        Printer.print(cats);
        System.out.println("Sorted by Age:");
        cats.sort(Cat::byAge);
        Printer.print(cats);
        System.out.println("Sorted by Name:");
        cats.sort(Cat::byName);
        Printer.print(cats);
        System.out.println("Deleted by Color:");
        String c="GINGER";
        cats.removeIf(Cat-> Cat.isColor(c.toUpperCase(Locale.ROOT)));
        Printer.print(cats);
        System.out.println("Deleted by length==5:");
        duplicateList.removeIf(Cat::isEqual5);
        Printer.print(cats);
    }

}
