package com.henryxi.core.util.collection.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class StreamFlatMapClient {
    public static void main(String[] args) {
        showAllCharacters();
        showAllPair();
    }

    private static void showAllCharacters() {
        List<String> words = new ArrayList<>();
        words.add("Hello");
        words.add("World");
        List<String> characters = words.stream().map(string -> string.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        System.out.println("characters:" + characters);
    }

    private static void showAllPair() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(6, 8);
        List<int[]> pairs = numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[]{i, j})).collect(Collectors.toList());
        for(int[] pair:pairs){
            System.out.println("pair:" + Arrays.toString(pair));
        }
    }
}

