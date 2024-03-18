public class BinaryToDecimal {
    private static String lastBinaryValue; // сохраняем в переменную последнее двоичное число (которое может состоять не из 8 бит),
    // полученное при шифровании из текста в бинарное число, чтобы его потом использовать в декодере при расшифровании последнего десятичного числа,
    // которое в обычном случае всегда представлено 8 битами


    public String getLastBinaryValue() {
        return lastBinaryValue;
    }

    public void setLastBinaryValue(String lastBinaryValue) {
        this.lastBinaryValue = lastBinaryValue;
    }

    public String convert(String binaryString) {
        StringBuilder decimalString = new StringBuilder();
        String remainingByte = ""; // Переменная для хранения последнего неполного байта
        // Разбиваем строку на байты (по 8 символов)
        for (int i = 0; i < binaryString.length(); i += 8) {
            String byteString = binaryString.substring(i, Math.min(i + 8, binaryString.length()));
            // Если байт не полный, сохраняем его
            if (byteString.length() < 8) {
                BinaryToDecimal.lastBinaryValue=byteString;
                int decimalValue = Integer.parseInt(BinaryToDecimal.lastBinaryValue, 2);
                System.out.println("Двоичное число " + BinaryToDecimal.lastBinaryValue + " в десятичной системе: " + decimalValue);
                decimalString.append(decimalValue).append(" ");
                System.out.println("Последнее двоичное число: " + BinaryToDecimal.lastBinaryValue);
                break;
            }

            // Преобразуем каждый байт из двоичного в десятичное число
            int decimalValue = Integer.parseInt(byteString, 2);
            System.out.println("Двоичное число " + byteString + " в десятичной системе: " + decimalValue);
            decimalString.append(decimalValue).append(" ");

        }
        return decimalString.toString();
    }
}
