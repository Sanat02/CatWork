package task3bonus;

import java.util.List;

// код можно менять только в особо отмеченном месте этого файла,
// так же возможно вам понадобится добавить что-то в 
// блок import и поменять имя пакета
// в остальных местах этого файла код менять не разрешается.

public final class Printer {
    private static final void printHeader() {
        System.out.println(String.format("%1$10.10s | %1$3.4s | %1$-10.10s | %1$-10.10s |%1$s", "--------------"));
        System.out.println(String.format("%10.10s | %3.6s | %-10.10s | %-10.10s |%s", "Name", "Year", "Director", "Descrip.","Cast"));
        System.out.println(String.format("%1$10.10s | %1$3.4s | %1$-10.10s | %1$-10.10s |%1$s", "--------------"));
    }

    static final void printCat(Movies movie) {
        System.out.println(String.format("%10.10s | %3.5s | %-10.10s | %-10.10s |%s", movie.getName(), movie.getYear(),
                movie.getDierctorName(),movie.getDescription(),movie.listPrint()));
    }

    public static  void print(List<Movies> movies) {
        printHeader();
        movies.forEach(Printer::printCat);
        System.out.println();
    }
}
