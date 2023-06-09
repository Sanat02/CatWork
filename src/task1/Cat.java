package task1;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// код можно менять только в особо отмеченном месте этого файла,
// так же возможно вам понадобится добавить что-то в 
// блок import и поменять имя пакета
// в остальных местах этого файла код менять не разрешается.

final class Cat {
    private static final Random r = new Random();
    private static final List<String> names = List.of("Peach", "Ginger", "Toby", "Seth", "Tibbles", "Tabby", "Poppy",
            "Millie", "Daisy", "Jasper", "Misty", "Minka");
    private final String name;
    private final int age;
    private final Breed breed;
    private final Color color;

    private Cat() {
        name = names.get(r.nextInt(names.size()));
        age = r.nextInt(10) + 1;
        breed = Breed.values()[r.nextInt(Breed.values().length)];
        color = Color.values()[r.nextInt(Color.values().length)];
    }

    public static final List<Cat> makeCats(int amount) {
        // это называется конвейерная обработка.
        // будем проходить на одном из занятий
        return Stream.generate(Cat::new)
                .limit(amount)
                .collect(Collectors.toList());
    }

    public final Color getColor() {
        return color;
    }

    public final String getName() {
        return name;
    }

    public final int getAge() {
        return age;
    }

    public final Breed getBreed() {
        return breed;
    }

    enum Color {
        TABBY, SILVER, GRAY, PEACH, GINGER, TORTIE
    }

    enum Breed {
        SPHINX, BRITAIN, SCOTTISH, VULGARIS, ORIENTAL
    }

    /*********/

    public static int byAge(Cat c1,Cat c2)
    {
        return c1.age- c2.age;
    }
    public static int byBreed(Cat c1,Cat c2)
    {
        String s= String.valueOf(c1.breed);
        String s2=String.valueOf(c2.breed);
        return s.compareTo(s2);
    }
    public static int byName(Cat c1,Cat c2)
    {
        return c1.name.compareTo(c2.name);
    }
    public boolean isColor(String inputColor)
    {
        return String.valueOf(color).equals(inputColor);
    }

    public boolean isEqual5()
    {
        return name.length()==5;
    }

    /*********/
}
