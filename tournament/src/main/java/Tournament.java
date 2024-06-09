import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

class Tournament {

    private static final String BASE_PANEL = "Team                           | MP |  W |  D |  L |  P\n";
    private StringBuilder appendResut = new StringBuilder();

    public String printTable() {
        return BASE_PANEL;
    }

    public void applyResults(String resultString) {
        var arr = teams(resultString);

//        Arrays.stream(arr).forEach( a -> {
//
//        });

        System.out.printf("");
    }

    private Set<String> teams(String resultString) {
        var arr = resultString
                .replace("win", "")
                .replace("loss", "")
                .replace("draw", "")
                .replace("\n", "")
                .split(";");

        return Arrays.stream(arr)
                .collect(Collectors.toSet());
    }
}
