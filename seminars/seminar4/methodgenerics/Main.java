package seminars.seminar4.methodgenerics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Integer x = 5;
        // Double xDouble = foo0(x); // ошибка
        // Integer xDouble1 = foo0(x); // ок

        List<Integer> integers = new ArrayList<>();
        Comparator<Object> integerComparator = null;

        //  List<T>, Comparator<? super T>
        //  List<Integer>, Comparator<? super Integer>
        Collections.sort(integers, integerComparator);

        // A <- B <- C <- D <- E
        // List<A> aList = new ArrayList<>();
        // List<B> bList = new ArrayList<>();
        // List<C> cList = new ArrayList<>();
        List<D> dList = new ArrayList<>();
        List<E> eList = new ArrayList<>();

        // <T extends B, S extends T, R extends S> List<S> foo(List<B> list)
        // List<A> abList = foo(bList);
        // List<B> bbList = foo(bList);
        // List<C> cbList = foo(bList);
        // List<D> dbList = foo(bList);
        // List<E> ebList = foo(bList);

        // <T extends B, S extends T, R extends S> List<S> foo(List<C> list)
        // List<A> acList = foo(cList);
        // List<B> bcList = foo(cList);
        // List<C> ccList = foo(cList);
        // List<D> dcList = foo(cList);
        // List<E> ecList = foo(cList);

        foo(dList);
        foo(eList);

        List<Number> numbers = new ArrayList<>();
        List<Integer> integers1 = new ArrayList<>();
    
        numbers.addAll(integers1); // number consumer, integer producer
        // integers1.addAll(numbers);



    }

    // PECS
    public static <T extends Number> T foo0(T num) {
        return num;
    }

    public static <T extends B, S extends T, R extends S> List<S> foo(List<R> list) {
        throw new IllegalStateException();
    }

    // PECS Producer - Extends, Consumer - Super



    class A {

    }

    class B extends A {

    }

    class C extends B {

    }

    class D extends C {

    }

    class E extends D {

    }

}
