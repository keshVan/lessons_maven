package ru.kornilaev.stack;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
    List<T> stack;

    public Stack(T... elements) {
        stack = new ArrayList<>(List.of(elements));
    }

    public Stack(){
        stack = new ArrayList<>();
    }

    public void push(T element) {
        stack.add(element);
    }

    public T pop() {
        int lastIndex = stack.size() - 1;
        T tmp = stack.get(lastIndex);
        stack.remove(lastIndex);
        return tmp;
    }

    public T peek() {
        return stack.get(stack.size() - 1);
    }
}
