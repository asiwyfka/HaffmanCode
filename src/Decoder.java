import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class Decoder {

    private StringBuilder decodedString = new StringBuilder();

    WriteStringToFile writeStringToFile = new WriteStringToFile();

    public StringBuilder getDecodedString() {
        return decodedString;
    }

    public void setDecodedString(StringBuilder decodedString) {
        this.decodedString = decodedString;
    }


    public String deCodeDecimalStringToBinaryString(Data data) {

            // Читаем закодированную строку
            String line = data.getCodedText();

            // Разделяем строку на отдельные цифры по пробелам и сохраняем в массив
            String[] digitsArray = line.split(" ");

            // Преобразуем каждую цифру в двоичное представление по байтам
            System.out.println();
            System.out.println("Длина массива " + digitsArray.length);
            System.out.println("Двоичные представления цифр из файла:");
            for (int i = 0; i < digitsArray.length; i++) {
                if ((i + 1 == digitsArray.length)&(digitsArray.length!=1)) {
                    int decimal = Integer.parseInt(digitsArray[i]);
                    String binary = data.getLastBinaryValueInCoder();
                    System.out.println("Десятичное: " + decimal + ", двоичное: " + binary);
                    decodedString.append(binary);
                    break;
                }
                int decimal = Integer.parseInt(digitsArray[i]);
                String binary = DecimalToBinary.decimalToBinary(decimal);
                System.out.println("Десятичное: " + decimal + ", двоичное: " + binary);
                decodedString.append(binary);
            }

        return decodedString.toString();
    }

    public String decodeBinaryStringToString(String input, Map<Character, String> codedLettersHashMap) {

        StringBuilder decodedString = new StringBuilder();
        int startIndex = 0;
        int endIndex = 1;
        while (endIndex <= input.length()) {
            String code = input.substring(startIndex, endIndex); // Берем очередной символ для декодирования
            for (Map.Entry<Character, String> entry : codedLettersHashMap.entrySet()) {
                if (entry.getValue().equals(code)) {
                    decodedString.append(entry.getKey()); // Получаем символ из мапы
                    startIndex = endIndex;
                    break;
                }
            }
            endIndex++;

        }
        return decodedString.toString();
    }

    public void writeDecodedStringToFile(String codedToBinaryString, String filename) {

        writeStringToFile.writeStringToFile(codedToBinaryString, filename);
    }


}
