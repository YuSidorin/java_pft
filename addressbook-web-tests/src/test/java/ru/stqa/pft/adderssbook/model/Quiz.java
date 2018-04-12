package ru.stqa.pft.adderssbook.model;

import java.util.stream.Stream;

/**
 * Created by ysidorin on 06.04.2018.
 */
public class Quiz {
    public static void main(String[] args){
        Stream<String> stream =
                Stream.of("A", "B");
        System.out.print("1");
        stream.peek(System.out::print);
        System.out.print(2);
        stream.forEach(System.out::print);
    }
}
