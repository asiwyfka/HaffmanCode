import java.io.Serializable;
import java.util.LinkedHashMap;

public class Data implements Serializable {
    private LinkedHashMap<Character, String> codedLettersHashMap;
    private String codedText;

    private String lastBinaryValueInCoder;

    public Data(LinkedHashMap<Character, String> codedLettersHashMap, String codedText, String lastBinaryValueInCoder) {
        this.codedLettersHashMap = codedLettersHashMap;
        this.codedText = codedText;
        this.lastBinaryValueInCoder = lastBinaryValueInCoder;
    }

    public LinkedHashMap<Character, String> getCodedLettersHashMap() {
        return codedLettersHashMap;
    }

    public String getCodedText() {
        return codedText;
    }

    public String getLastBinaryValueInCoder() {
        return lastBinaryValueInCoder;
    }





}