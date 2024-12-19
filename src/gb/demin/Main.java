package gb.demin;
/**
 * Задание 1:
 * Разработайте класс Student с полями String name, int age7 transient double GPA (средний балл).
 * Обеспечьте поддержку сериализации для этого класса.
 * Создайте объект класса Student и инициализируйте его данными.
 * Сериализируйте этот объект в файл.
 * Десериализируйте объект обратно в программу из файла.
 * Выведите все поля объекта, включая GPA, и обсудите почему значение GPA не было сохранено/восстановлено.
 *
 * Задание 2 (не обязательно):
 * ** Выполнить задачу 1 используя другие типы сериализаторов (в xml и json документов).
 */



import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student("Dmitriy", 40, 3.4);

        try(FileOutputStream fileOutputStream = new FileOutputStream("studentdata.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(student);
            System.out.println("Объект Student сериализован.");
        }

        try(FileInputStream fileInputStream = new FileInputStream("studentdata.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            student = (Student)objectInputStream.readObject();
            System.out.println("Объект Student десериализован.");
        }

        System.out.println("Имя: " + student.getName());
        System.out.println("Возраст: " + student.getAge());
        System.out.println("Средний бал: " + student.getGPA());


    }
}
