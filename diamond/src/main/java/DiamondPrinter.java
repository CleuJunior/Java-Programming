import java.util.ArrayList;
import java.util.List;

class DiamondPrinter {

    private final String ABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public List<String> printToList(char a) {

        List<String> returnList = new ArrayList<>();
        StringBuilder stringA = new StringBuilder();
        String space = "";

        System.out.println(ABC.length());
        System.out.println(ABC.indexOf(a));

        for (int i = 0; i < ABC.indexOf(a); i++) {

            for (int j = 0; j < ABC.indexOf(a); j++) {
                space += " ";

                if(j == ABC.indexOf(a)-1) {
                    stringA.append(space).append(ABC.charAt(i));
                    stringA.append(space).append("\n");
                    returnList.add(stringA.toString());
                }

                stringA;
            }


        }

        System.out.println(stringA);

        return List.of();
    }

}
