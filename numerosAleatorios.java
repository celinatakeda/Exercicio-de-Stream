package com.kazue.collection.gft.collection.api.stream;

import java.util.*;
import java.util.stream.Collectors;

class exercicioStream{
    public static void main(String[] args) {
        List<String>numerosAleatorios = Arrays.asList("1", "0", "2","9", "3","4", "9", "2", "6", "5");

        System.out.println("Imprima todos os elementos dessa lista de String: ");
        numerosAleatorios.stream()
                .forEach(System.out::println);

        System.out.println("---------------------------------------");
        System.out.println("Pegue os 5 primeiros números e coloque dentro de um Set:");

        Set<String>cincoPrimeirosNumeros = numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet());
        System.out.println(cincoPrimeirosNumeros);

        System.out.println("---------------------------------------");
        System.out.println("Transforme esta lista de String em uma lista de números inteiros.");
        List<Integer> numerosAleatoriosInteger = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println(numerosAleatoriosInteger);

        System.out.println("---------------------------------------");
        System.out.print("Retirando os números repetidos da lista, quantos números ficam? " );
        long cont = numerosAleatorios.stream()
                .distinct()
                .count();
        System.out.println(cont);

        System.out.println("---------------------------------------");
        System.out.println("Pegue os números pares e maiores que 2 e coloque em uma lista:");
        numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(i -> i%2==0 && i >2)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("---------------------------------------");
        System.out.println("Mostre a média dos números: ");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);

        System.out.println("---------------------------------------");
        System.out.println("Remova os valores ímpares: ");
        numerosAleatoriosInteger.removeIf(i -> i % 2 != 0);
        System.out.println(numerosAleatoriosInteger);

        System.out.println("---------------------------------------");
        System.out.println("Ignore os 3 primeiros elementos da lista e imprima o restante:");
        numerosAleatorios.stream()
                .skip(3)
                .forEach(System.out::println);

        System.out.println("---------------------------------------");
        System.out.print("Mostre o menor valor da lista: ");
        numerosAleatoriosInteger.stream()
                .mapToInt(Integer::intValue)
                .min()
                .ifPresent(System.out::println);

        System.out.println("---------------------------------------");
        System.out.print("Mostre o maior valor da lista: ");
        numerosAleatoriosInteger.stream()
                .mapToInt(Integer::intValue)
                .max()
                .ifPresent(System.out::println);

        System.out.println("---------------------------------------");
        System.out.print("Pegue apenas os números pares e some: ");
        int somaDosNumerosPares = numerosAleatoriosInteger.stream()
                .filter (i -> i%2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(somaDosNumerosPares);

        System.out.println("---------------------------------------");
        System.out.println("Mostre a lista na ordem númerica: ");
        List<Integer>numeroOrdemNumerica = numerosAleatoriosInteger.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println(numeroOrdemNumerica);

        System.out.println("---------------------------------------");
        System.out.println("Agrupe os valores ímpares múltiplos de 3 ou de 5:");
        Map<Boolean, List<Integer>>multiplosTresCinco = numerosAleatoriosInteger.stream()
                .collect(Collectors.groupingBy(i -> i % 3 == 0 || i % 5 == 0));
        System.out.println(multiplosTresCinco);

    }
}
