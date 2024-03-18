import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Coder {

    private String code = "0";
    private StringBuilder codedString = new StringBuilder();

    private String lastBinaryValueInCoder;

    public String getLastBinaryValueInCoder() {
        return lastBinaryValueInCoder;
    }

    public void setLastBinaryValueInCoder(String lastBinaryValue) {
        this.lastBinaryValueInCoder = getBinaryToDecimal().getLastBinaryValue();
    }

    private static LinkedHashMap<Character, String> codedLettersHashMap = new LinkedHashMap<>();

    private static BinaryToDecimal binaryToDecimal = new BinaryToDecimal();

    private WriteStringToFile writeStringToFile = new WriteStringToFile();

    public BinaryToDecimal getBinaryToDecimal() {
        return binaryToDecimal;
    }

    public void setBinaryToDecimal(BinaryToDecimal binaryToDecimal) {
        this.binaryToDecimal = binaryToDecimal;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public StringBuilder getCodedString() {
        return codedString;
    }

    public void setCodedString(StringBuilder codedString) {
        this.codedString = codedString;
    }

    public LinkedHashMap<Character, String> getHashMap() {
        return codedLettersHashMap;
    }

    public void setHashMap(LinkedHashMap<Character, String> hashMap) {
        this.codedLettersHashMap = hashMap;
    }

    private void saveLastBinaryValueInCoder() {
        String lastBinaryValue = getBinaryToDecimal().getLastBinaryValue();
        setLastBinaryValueInCoder(lastBinaryValue);
    }

    // Кодирование символов отсортированной библиотеки в отдельную мапу закодированных символов
    public LinkedHashMap<Character, String> codeCharactersIntoLinkedHashMap(LinkedHashMap<Character, Integer> sortedLibraryLinkedHashMap) {

        int count = 1;

        for (Map.Entry<Character, Integer> entry : sortedLibraryLinkedHashMap.entrySet()) {
            if (count == 1) {
                Character key = entry.getKey();
                Coder.codedLettersHashMap.put(key, this.code);
            } else if (count == sortedLibraryLinkedHashMap.size()) {
                Character key = entry.getKey();
                this.code = this.code.replace("0", "1");
                Coder.codedLettersHashMap.put(key, this.code);
            } else {
                this.code = "1" + this.code;
                Character key = entry.getKey();
                Coder.codedLettersHashMap.put(key, this.code);
            }
            System.out.println(count + " итерация.");
            System.out.println(this.codedLettersHashMap);
            count++;
        }
        return this.codedLettersHashMap;
    }

    // Кодирование строки из файла при помощи мапы закодированных символов
    public String codeStringToBinaryString(String fileName, LinkedHashMap<Character, String> codedLettersHashMap) {
        String stringFromFile = null;

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                stringFromFile = scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (char c : stringFromFile.toCharArray()) {
            // Ищем соответствие символа в мапе кодов
            for (Map.Entry<Character, String> entry : codedLettersHashMap.entrySet()) {
                if (entry.getKey().equals(c)) {
                    codedString.append(entry.getValue()); // Добавляем символ в закодированную строку
                    break;
                }
            }
        }
        return codedString.toString();
    }

    public String codeBinaryStringToDecimalString(String codedToBinaryString) {
        return binaryToDecimal.convert(codedToBinaryString);
    }

    public void writeCodedBinaryStringToFile(String codedToBinaryString, String filename) {
        saveLastBinaryValueInCoder();
        writeStringToFile.writeStringToFile(codedToBinaryString, filename);
    }

}