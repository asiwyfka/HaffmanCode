import java.util.*;


public class Main {
    public static void main(String[] args) {

        // Создаем объект ValuesCounter
        ValuesCounter valuesCounter1 = new ValuesCounter();
        // Получаем отсортированную по количеству значений из текста файла библиотеку символов
        LinkedHashMap<Character, Integer> sortedLibraryLinkedHashMap1 = valuesCounter1.countSortValues("TextFile");

        // Создаем объект Coder
        Coder coder1 = new Coder();
        // Получаем закодированную codedLettersHashMap
        LinkedHashMap<Character, String> codedLettersHashMap1 = coder1.codeCharactersIntoLinkedHashMap(sortedLibraryLinkedHashMap1);
        // Читаем текст из файла и при помощи codedLettersHashMap представляем текст в бинарное число типа String
        String codedBinaryString1 = coder1.codeStringToBinaryString("TextFile", codedLettersHashMap1);
        // Выводим его на экран
        System.out.println();
        System.out.println("Текст в двоичной системе счисления.");
        System.out.println(codedBinaryString1);
        // Кодируем двоичное представление строки из текста в десятиричное в типе String
        String codedBinaryStringToDecimalString1 = coder1.codeBinaryStringToDecimalString(codedBinaryString1);
        System.out.println(codedBinaryStringToDecimalString1);
        // Записываем закодированную в десятиричном виде строку в файл CodedText
        coder1.writeCodedBinaryStringToFile(codedBinaryStringToDecimalString1, "CodedText");
        System.out.println("Сохраненный последний бит: " + coder1.getLastBinaryValueInCoder());


        Data writedData = new Data(codedLettersHashMap1, codedBinaryStringToDecimalString1, coder1.getLastBinaryValueInCoder());
        WriteReader.saveObjectToFile(writedData, "CodedFile");

        Data readedData = WriteReader.readObjectFromFile("CodedFile");

        // Выводим содержимое мапы
        if (readedData != null) {
            System.out.println("Содержимое мапы:");
            LinkedHashMap<Character, String> readMap = readedData.getCodedLettersHashMap();
            for (Map.Entry<Character, String> entry : readMap.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
            // Выводим зашифрованную текстовую строку
            System.out.println("Прочитанная строка из файла: " + readedData.getCodedText());

            // Выводим последний сохраненный бит
            System.out.println("Прочитанный последний бит из файла: " + readedData.getLastBinaryValueInCoder());


        }



    Decoder decoder1 = new Decoder();
    String deCodingString = decoder1.deCodeDecimalStringToBinaryString(readedData);
        System.out.println("Декодированная строка из файла из десятичной системы в двоичную: "+deCodingString);

        System.out.println();
        System.out.println("Выводим codedLettersHashMap1");
        System.out.println(readedData.getCodedLettersHashMap());
        System.out.println();

    String decodedString = decoder1.decodeBinaryStringToString(deCodingString, readedData.getCodedLettersHashMap());

        decoder1.writeDecodedStringToFile(decodedString,"DecodedText");
}


}
