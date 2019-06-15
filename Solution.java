
import java.util.Stack;

public class Solution {

    private static final char BRACE_OPEN = '{';
    private static final char BRACE_CLOSED = '}';

    private static final char PARENTHESIS_OPEN = '(';
    private static final char PARENTHESIS_CLOSED = ')';

    private static final char SQUARE_BRACKET_OPEN = '[';
    private static final char SQUARE_BRACKET_CLOSED = ']';

    private static final String NOT = "NO";
    private static final String YES = "YES";

    static String[] braces(String[] values) {
        String response[] = new String[values.length];

        for (int i = 0; i < values.length; i++) {
            Stack<Character> stack = new Stack<>();

            char poppedCharacter;
            for (char character : values[i].toCharArray()) {
                if (character == BRACE_OPEN || character == PARENTHESIS_OPEN || character == SQUARE_BRACKET_OPEN) {
                    stack.push(character);
                }

                if (character == BRACE_CLOSED) {
                    if (stack.isEmpty()) {
                        addNot(response, i);
                        break;
                    }
                    poppedCharacter = stack.pop();
                    if (poppedCharacter != BRACE_OPEN) {
                        addNot(response, i);
                        break;
                    }

                } else if (character == PARENTHESIS_CLOSED) {
                    if (stack.isEmpty()) {
                        addNot(response, i);
                        break;
                    }
                    poppedCharacter = stack.pop();
                    if (poppedCharacter != PARENTHESIS_OPEN) {
                        addNot(response, i);
                        break;
                    }
                } else if (character == SQUARE_BRACKET_CLOSED) {
                    if (stack.isEmpty()) {
                        addNot(response, i);
                        break;
                    }
                    poppedCharacter = stack.pop();
                    if (poppedCharacter != SQUARE_BRACKET_OPEN) {
                        addNot(response, i);
                        break;
                    }
                }
            }

            if (!stack.isEmpty()) {
                addNot(response, i);
            }

            response[i] = response[i] != NOT && stack.isEmpty() ? YES : NOT;

        }
        return response;

    }

    private static void addNot(String[] response, int i) {
        response[i] = NOT;
    }
}
