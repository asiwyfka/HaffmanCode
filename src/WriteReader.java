import java.io.*;

public class WriteReader {


    public static void saveObjectToFile(Data data, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            // Сериализуем объект в файл
            oos.writeObject(data);
            System.out.println("Объект успешно сохранен в файл " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении объекта в файл: " + e.getMessage());
        }
    }

    public static Data readObjectFromFile(String filename) {
        Data data = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            // Десериализуем объект из файла
            data = (Data) ois.readObject();
            System.out.println("Объект успешно прочитан из файла " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при чтении объекта из файла: " + e.getMessage());
        }
        return data;
    }

}
