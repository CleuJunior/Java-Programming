import java.util.HashMap;
import java.util.Map;

public class RomanNumerals
{
    private final int[] intRomanValue = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    private final String[] romanLetter = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
    private int number;
    StringBuilder stringBuilderRoman = new StringBuilder();
    public RomanNumerals(int number){ this.number = number; }
    public String getRomanNumeral(){

        for(int i = 0; i< intRomanValue.length; i++){

            while(number >= intRomanValue[i]){
                number-= intRomanValue[i];
                stringBuilderRoman.append(romanLetter[i]);
            }

        }
        return stringBuilderRoman.toString();
    }
}