package src.main.java;

import java.util.AbstractQueue;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;

public class MyTwoStackQueue<T> extends AbstractQueue<T> {

    private Stack<T> fistStack;
    private Stack<T> secondStack;

    public MyTwoStackQueue() {
        super();
        fistStack = new Stack<>();
        secondStack = new Stack<>();
    }

    @Override
    public Iterator<T> iterator() {
        transfer();
        Iterator<T> iterator = secondStack.iterator();
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public T next() {
                return iterator.next();
            }
        };
    }

    @Override
    public int size() {
        return fistStack.size() + secondStack.size();
    }


    @Override
    public boolean offer(T t) {
        return fistStack.add(t);
    }

    @Override
    public T poll() {
        if (secondStack.isEmpty()) {
            transfer();
        }
        try {
            return secondStack.pop();
        } catch (EmptyStackException e) {
            return null;
        }
    }

    @Override
    public T peek() {
        if (secondStack.isEmpty()) {
            transfer();
        }
        try {
            return secondStack.peek();
        } catch (EmptyStackException e) {
            return null;
        }
    }

    private void transfer() {
        while (!fistStack.isEmpty()) {
            secondStack.add(fistStack.pop());
        }
    }


}
