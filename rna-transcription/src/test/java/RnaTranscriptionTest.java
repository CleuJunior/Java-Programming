import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RnaTranscriptionTest {

    private RnaTranscription rnaTranscription;

    @BeforeEach
    public void setUp() {
        rnaTranscription = new RnaTranscription();
    }

    @Test
    public void testEmptyRnaSequence() {
        assertThat(rnaTranscription.transcribe("")).isEmpty();
    }

    @Test
    public void testRnaTranscriptionOfCytosineIsGuanine() {
        assertThat(rnaTranscription.transcribe("C")).isEqualTo("G");
    }

    @Test
    public void testRnaTranscriptionOfGuanineIsCytosine() {
        assertThat(rnaTranscription.transcribe("G")).isEqualTo("C");
    }

    @Test
    public void testRnaTranscriptionOfThymineIsAdenine() {
        assertThat(rnaTranscription.transcribe("T")).isEqualTo("A");
    }

    @Test
    public void testRnaTranscriptionOfAdenineIsUracil() {
        assertThat(rnaTranscription.transcribe("A")).isEqualTo("U");
    }

    @Test
    public void testRnaTranscription() {
        assertThat(rnaTranscription.transcribe("ACGTGGTCTTAA")).isEqualTo("UGCACCAGAAUU");
    }
}
