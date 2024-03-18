public class DecimalToBinary {

    public static String decimalToBinary(int decimal) {
        StringBuilder binaryString = new StringBuilder();

        // Преобразуем десятичное число в двоичное по байтам
        for (int i = 7; i >= 0; i--) {
            // Получаем i-й бит путем сдвига числа decimal на i позиций вправо и применяем побитовое "И" с 1
            int bit = (decimal >> i) & 1;
            // Добавляем бит к строке
            binaryString.append(bit);
        }

        return binaryString.toString();
    }

//    public static String removeLeadingZeros(String binaryString) {
//        // Ищем позицию первой единицы
//        int index = binaryString.indexOf('1');
//        // Если первая единица найдена, возвращаем подстроку, начиная с этой позиции
//        if (index != -1) {
//            return binaryString.substring(index);
//        }
//        // Если единица не найдена, возвращаем пустую строку
//        return "";
//    }


}
