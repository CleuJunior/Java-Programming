import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

import static org.assertj.core.api.Assertions.assertThat;

class ResistorColorTrioTest {
    private ResistorColorTrio resistorColorTrio;

    @BeforeEach
    void setup() {
        resistorColorTrio = new ResistorColorTrio();
    }

    @Test
    void testOrangeAndOrangeAndBlack() {
        assertThat(
            resistorColorTrio.label(new String[]{"orange", "orange", "black"})
        ).isEqualTo("33 ohms");
    }
    
    @Test
    void testBlueAndGreyAndBrown() {
        assertThat(
            resistorColorTrio.label(new String[]{"blue", "grey", "brown"})
        ).isEqualTo("680 ohms");
    }
    
    @Test
    void testRedAndBlackAndRed() {
        assertThat(
            resistorColorTrio.label(new String[]{"red", "black", "red"})
        ).isEqualTo("2 kiloohms");
    }
    
    @Test
    void testGreenAndBrownAndOrange() {
        assertThat(
            resistorColorTrio.label(new String[]{"green", "brown", "orange"})
        ).isEqualTo("51 kiloohms");
    }
    
    @Test
    void testYellowAndVioletAndYellow() {
        assertThat(
            resistorColorTrio.label(new String[]{"yellow", "violet", "yellow"})
        ).isEqualTo("470 kiloohms");
    }
    
    @Test
    void testBlueAndVioletAndBlue() {
        assertThat(
            resistorColorTrio.label(new String[]{"blue", "violet", "blue"})
        ).isEqualTo("67 megaohms");
    }
    
    @Test
    void testBlackAndBlackAndBlack() {
        assertThat(
            resistorColorTrio.label(new String[]{"black", "black", "black"})
        ).isEqualTo("0 ohms");
    }

    @Test
    void testWhiteAndWhiteAndWhite() {
        assertThat(
            resistorColorTrio.label(new String[]{"white", "white", "white"})
        ).isEqualTo("99 gigaohms");
    }
    
    @Test
    void testFirstTwoColorsMakeAnInvalidOctalNumber() {
        assertThat(
            resistorColorTrio.label(new String[]{"black", "grey", "black"})
        ).isEqualTo("8 ohms");
    }

    @Test
    void testIgnoreExtraColors() {
        assertThat(
            resistorColorTrio.label(new String[]{"blue", "green", "yellow", "orange"})
        ).isEqualTo("650 kiloohms");
    }
}
