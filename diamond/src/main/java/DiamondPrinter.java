import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DiamondPrinter {
    public List<String> printToList(char a) {
        char[] letter = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        int numberLetter = 0;

        for(int i = 0; i < letter.length; i++)
            if(letter[i] == a)
                numberLetter = i;


        String[][] result = new String[numberLetter * 2 + 1][numberLetter * 2 + 1];

        for(int x = 0; x <= numberLetter * 2; x++) {
            for(int y = 0; y <= numberLetter * 2; y++) {
                result[x][y] = " ";
            }
        }

        for(int i = 0; i <= numberLetter; i++) {
            result[numberLetter - i][i] = Character.toString(letter[i]);
            result[numberLetter + i][i] = Character.toString(letter[i]);
            result[numberLetter - i][numberLetter * 2 - i] = Character.toString(letter[i]);
            result[numberLetter + i][numberLetter * 2 - i] = Character.toString(letter[i]);
        }

        String[] resultFinish = new String[numberLetter * 2 + 1];

        for(int x = 0; x < numberLetter * 2 + 1; x++)
            resultFinish[x] = "";

        for(int x = 0; x < numberLetter * 2 + 1; x++) {
            for(int y = 0; y < numberLetter * 2 + 1; y++) {
                resultFinish[x] = resultFinish[x] + result[y][x];
            }
        }

        return new ArrayList<>(Arrays.asList(resultFinish).subList(0, numberLetter * 2 + 1));
    }
}