import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

import static java.lang.reflect.Array.newInstance;
import static java.util.Arrays.stream;

class SimpleLinkedList<T> {
    private final List<T> list = new LinkedList<>();

    public SimpleLinkedList() {
    }

    public SimpleLinkedList(T[] values) {
        list.addAll(List.of(values));
    }

    public void push(T value) {
        list.add(value);
    }

    public T pop() {
        var lastIndex = list.size() - 1;

        if (lastIndex < 0) {
            throw new NoSuchElementException();
        }

        return list.remove(lastIndex);
    }

    public void reverse() {
        var pointerList = new LinkedList<>(list);

        list.clear();

        IntStream.range(0, pointerList.size())
                .mapToObj(i -> pointerList.get(pointerList.size() - 1 - i))
                .forEach(list::add);
    }

    @SuppressWarnings("unchecked")
    public T[] asArray(Class<T> clazz) {
        var array = (T[]) newInstance(clazz, list.size());

        return stream(list.toArray(array))
                .sorted()
                .toList()
                .toArray(array);
    }

    public int size() {
        return list.size();
    }
}
