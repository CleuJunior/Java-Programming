import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BracketCheckerTest {

    @Test
    void testPairedSquareBrackets() {
        BracketChecker bracketChecker = new BracketChecker("[]");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isTrue();
    }
    
    @Test
    void testEmptyString() {
        BracketChecker bracketChecker = new BracketChecker("");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isTrue();
    }

    @Test
    void testUnpairedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("[[");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }
    
    @Test
    void testWrongOrderedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("}{");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }
    
    @Test
    void testWrongClosingBracket() {
        BracketChecker bracketChecker = new BracketChecker("{]");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }
    
    @Test
    void testPairedWithWhitespace() {
        BracketChecker bracketChecker = new BracketChecker("{ }");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isTrue();
    }

    
    @Test
    void testPartiallyPairedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("{[])");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }

    @Test
    void testSimpleNestedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("{[]}");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isTrue();
    }

    @Test
    void testSeveralPairedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("{}[]");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isTrue();
    }
    
    @Test
    void testPairedAndNestedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("([{}({}[])])");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isTrue();
    }

    @Test
    void testUnopenedClosingBracket() {
        BracketChecker bracketChecker = new BracketChecker("{[)][]}");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }

    @Test
    void testUnpairedAndNestedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("([{])");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }

    @Test
    void testPairedAndWrongNestedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("[({]})");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }

    @Test
    void testPairedAndWrongNestedBracketsButInnermostAreCorrect() {
        BracketChecker bracketChecker = new BracketChecker("[({}])");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }

    @Test
    void testPairedAndIncompleteBrackets() {
        BracketChecker bracketChecker = new BracketChecker("{}[");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }

        @Test
    void testTooManyClosingBrackets() {
        BracketChecker bracketChecker = new BracketChecker("[]]");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }

        @Test
    void testEarlyUnexpectedBrackets() {
        BracketChecker bracketChecker = new BracketChecker(")()");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }

    @Test
    void testEarlyMismatchedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("{)()");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }

    @Test
    void testMathExpression() {
        BracketChecker bracketChecker = new BracketChecker("(((185 + 223.85) * 15) - 543)/2");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isTrue();
    }

    @Test
    void testComplexLatexExpression() {
        BracketChecker bracketChecker = new BracketChecker(
                "\\left(\\begin{array}{cc} \\frac{1}{3} & x\\\\ \\mathrm{e}^{x} &... x^2 \\end{array}\\right)");

        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isTrue();
    }
}