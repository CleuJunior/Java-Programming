import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class HighScoresTest {

    @Test
    public void shouldReturnListOfScores() {
        HighScores highScores = new HighScores(Arrays.asList(30, 50, 20, 70));
        assertThat(Arrays.asList(30, 50, 20, 70)).isEqualTo(highScores.scores());
    }

    @Test
    public void shouldReturnLatestAddedScore() {
        HighScores highScores = new HighScores(Arrays.asList(100, 0, 90, 30));
        assertThat(30).isEqualTo(highScores.latest());
    }

    @Test
    public void shouldReturnPersonalBest() {
        HighScores highScores = new HighScores(Arrays.asList(40, 100, 70));
        assertThat(100).isEqualTo(highScores.personalBest());
    }

    @Test
    public void shouldReturnPersonalTopThreeFromListOfScores() {
        HighScores highScores = new HighScores(Arrays.asList(10, 30, 90, 30, 100, 20, 10, 0, 30, 40, 40, 70, 70));
        assertThat(Arrays.asList(100, 90, 70)).isEqualTo( highScores.personalTopThree());
    }

    @Test
    public void shouldReturnPersonalTopThreeSortedHighestToLowest() {
        HighScores highScores = new HighScores(Arrays.asList(20, 10, 30));
        assertThat(Arrays.asList(30, 20, 10)).isEqualTo(highScores.personalTopThree());
    }

    @Test
    public void shouldReturnPersonalTopThreeWhenThereIsATie() {
        HighScores highScores = new HighScores(Arrays.asList(40, 20, 40, 30));
        assertThat(Arrays.asList(40, 40, 30)).isEqualTo(highScores.personalTopThree());
    }

    @Test
    public void shouldReturnPersonalTopWhenThereIsLessThanThreeScores() {
        HighScores highScores = new HighScores(Arrays.asList(30, 70));
        assertThat(Arrays.asList(70, 30)).isEqualTo(highScores.personalTopThree());
    }

    @Test
    public void shouldReturnPersonalTopWhenThereIsOnlyOneScore() {
        HighScores highScores = new HighScores(Arrays.asList(40));
        assertThat(Arrays.asList(40)).isEqualTo(highScores.personalTopThree());
    }

    @Test
    public void callingLatestAfterPersonalTopThree() {
        HighScores highScores = new HighScores(Arrays.asList(70, 50, 20, 30));
        highScores.personalTopThree();
        assertThat(30).isEqualTo(highScores.latest());
    }

    @Test
    public void callingScoresAfterPersonalTopThree() {
        HighScores highScores = new HighScores(Arrays.asList(30, 50, 20, 70));
        highScores.personalTopThree();
        assertThat(Arrays.asList(30, 50, 20, 70)).isEqualTo(highScores.scores());
    }

    @Test
    public void callingLatestAfterPersonalBest() {
        HighScores highScores = new HighScores(Arrays.asList(20, 70, 15, 25, 30));
        highScores.personalBest();
        assertThat(30).isEqualTo(highScores.latest());
    }

    @Test
    public void callingScoresAfterPersonalBest() {
        HighScores highScores = new HighScores(Arrays.asList(20, 70, 15, 25, 30));
        highScores.personalBest();
        assertThat(Arrays.asList(20, 70, 15, 25, 30)).isEqualTo(highScores.scores());
    }
}
