package seminars.seminar6.i;

import java.util.*;

public class InterfaceSegregationMain {

    public static void main(String[] args) {
        listMethod(new LinkedList<>());
        listMethod(new ArrayList<>());

        queueMethod(new LinkedList<>());
        queueMethod(new ArrayDeque<>());
    }

    private static void listMethod(List<Integer> list) {

    }

    private static void queueMethod(Queue<Integer> queue) {

    }

}
