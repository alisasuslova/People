public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);
        System.out.println();

        try {
            Person person1 = new PersonBuilder()
                    .setName("Виктория")
                    .setSurname("Городецкая")
                    .build();
            System.out.println(person1);
            System.out.println(person1.hasAge());
            System.out.println(person1.hasAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();


        try {
            Person person2 = new PersonBuilder()
                    .build();
            System.out.println(person2);
            System.out.println(person2.getName());
            System.out.println(person2.getSurname());
            System.out.println(person2.hasAge());
            System.out.println(person2.hasAddress());

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();


        try {
            // Не хватает обяхательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        System.out.println();

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

    }
}
