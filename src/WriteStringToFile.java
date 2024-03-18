import java.io.FileWriter;
import java.io.IOException;

public class WriteStringToFile {
    public void writeStringToFile(String codedBinaryStringToDecimalString1, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            // Записываем строку в файл
            fileWriter.write(String.valueOf(codedBinaryStringToDecimalString1));
            System.out.println("Строка успешно записана в файл.");
        } catch (IOException e) {
            // Обработка ошибок ввода-вывода
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
