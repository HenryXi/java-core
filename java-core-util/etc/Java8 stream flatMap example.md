# Java8 stream flatMap example
`map` method is used to handle the element of stream and output the stream. `flatMap` method is used to handle multiple stream and output new stream. Here is some easy examples. 

**1. show all characters in List<String>**

Every word in list will generate its own stream by invoking `split("")` method. In order to show the distinct characters 
we need to handle multiple stream and make them into a new stream.
```java
List<String> words = new ArrayList<>();
words.add("Hello");
words.add("World");
List<String> characters = words.stream().map(string -> string.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
System.out.println("characters:" + characters);
```
The output is like following.
```
characters:[H, e, l, o, W, r, d]
```

**2. show all pairs of two arrays**

In order to show all possible pairs we need handle every item of numbers2 in the stream of number1. There are multiple stream
when invoke `number2.stream()` method. So we need `flatMap` to handle multiple stream and put the result in a new stream.
```java
List<Integer> numbers1 = Arrays.asList(1, 2, 3);
List<Integer> numbers2 = Arrays.asList(6, 8);
List<int[]> pairs = numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[]{i, j})).collect(Collectors.toList());
for(int[] pair:pairs){
    System.out.println("pair:" + Arrays.toString(pair));
}
```
output
```
pair:[1, 6]
pair:[1, 8]
pair:[2, 6]
pair:[2, 8]
pair:[3, 6]
pair:[3, 8]
```

EOF