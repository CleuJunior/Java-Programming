import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class SimpleLinkedListTest {

    @Test
    void aNewListIsEmpty() {
        var list = new SimpleLinkedList<>();
        assertThat(list.size()).isZero();
    }

    @Test
    void canCreateFromArray() {
        var values = new Character[]{'1', '2', '3'};
        var list = new SimpleLinkedList<>(values);
        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    void popOnEmptyListWillThrow() {
        var list = new SimpleLinkedList<String>();

        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(list::pop);
    }

    @Test
    void popReturnsLastAddedElement() {
        var list = new SimpleLinkedList<Integer>();
        list.push(9);
        list.push(8);
        assertThat(list.size()).isEqualTo(2);
        assertThat(list.pop()).isEqualTo(8);
        assertThat(list.pop()).isEqualTo(9);
        assertThat(list.size()).isZero();
    }

    @Test
    void reverseReversesList() {
        var list = new SimpleLinkedList<String>();
        list.push("9");
        list.push("8");
        list.push("7");
        list.push("6");
        list.push("5");
        list.reverse();
        assertThat(list.pop()).isEqualTo("9");
        assertThat(list.pop()).isEqualTo("8");
        assertThat(list.pop()).isEqualTo("7");
        assertThat(list.pop()).isEqualTo("6");
        assertThat(list.pop()).isEqualTo("5");
    }

    @Test
    void canReturnListAsArray() {
        var list = new SimpleLinkedList<Character>();
        list.push('9');
        list.push('8');
        list.push('7');
        list.push('6');
        list.push('5');
        Character[] expected = {'5', '6', '7', '8', '9'};
        assertThat(list.asArray(Character.class)).isEqualTo(expected);
    }

    @Test
    void canReturnEmptyListAsEmptyArray() {
        var list = new SimpleLinkedList<>();
        Object[] expected = {};
        assertThat(list.asArray(Object.class)).isEqualTo(expected);
    }
}
