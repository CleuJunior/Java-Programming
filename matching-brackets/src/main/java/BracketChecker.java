import java.util.ArrayDeque;
import java.util.Map;

class BracketChecker {

    private final String expression;

    BracketChecker(String expression) {
        this.expression = expression;
    }

    boolean areBracketsMatchedAndNestedCorrectly() {
        var stack = new ArrayDeque<>();
        var closeToOpen = Map.of(')', '(', ']', '[', '}', '{');

        for (var c : expression.toCharArray()) {
            if (!checkOpenClose(c)) {
                continue;
            }

            if (closeToOpen.containsKey(c)) {

                if (closeToOpen.get(c).equals(stack.peek())) {
                    stack.pop();

                } else
                    return false;

            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    private boolean checkOpenClose(Character c) {
        return c.equals('(') ||
                c.equals(')') ||
                c.equals('[') ||
                c.equals(']') ||
                c.equals('{') ||
                c.equals('}');
    }
}