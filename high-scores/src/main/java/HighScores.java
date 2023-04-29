import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class HighScores {

    private final List<Integer> highScores;
    private final List<Integer> sortedScore;
    private final int getLastValue;
    private final int getPenultimateValue;
    private final int getAntepenultimateValue;

    public HighScores(List<Integer> highScores) {
        this.highScores = highScores;
        this.sortedScore = highScores.stream().sorted().toList();
        this.getLastValue = highScores.size()-1;
        this.getPenultimateValue = highScores.size()-2;
        this.getAntepenultimateValue = highScores.size()-3;
    }

    public List<Integer> scores() {
        return this.highScores;
    }

    public Integer latest() {
        return this.highScores.get(this.getLastValue);
    }

    public Integer personalBest() {
        return this.sortedScore.get(this.getLastValue);
    }

    public List<Integer> personalTopThree() {
        if (this.sortedScore.size() == 1)
            return Collections.singletonList(this.sortedScore.get(this.getLastValue));

        if (this.sortedScore.size() == 2)
            return Arrays.asList(
                    this.sortedScore.get(this.getLastValue),
                    this.sortedScore.get(this.getPenultimateValue)
            );

        return Arrays.asList(
                this.sortedScore.get(this.getLastValue),
                this.sortedScore.get(this.getPenultimateValue),
                this.sortedScore.get(this.getAntepenultimateValue)
        );
    }
}
