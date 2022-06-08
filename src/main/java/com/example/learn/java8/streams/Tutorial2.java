package com.example.learn.java8.streams;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.*;

@Component
public class Tutorial2 {

    private long counter;

    private void wasCalled() {
        counter++;
    }

    public void run() throws IOException {

        System.out.println("\n***********************************");
        System.out.println("https://baeldung.com/java-8-streams");
        System.out.println("***********************************\n");


//        //  stream of collection
//        Collection<String> collection = Arrays.asList("a", "b", "c");
//        Stream<String> streamOfCollection = collection.stream();
//
//        // stream of array
//        Stream<String> streamOfArray = Stream.of("a", "b", "c");
//
//        String[] arr1 = new String[]{"a", "b", "c"};
//        Stream<String> streamOfArrayFull = Arrays.stream(arr1);
//        Stream<String> streamOfArrayPart = Arrays.stream(arr1, 1, 3);
//
//        // stream builder
//        Stream<String> streamBuilder =
//                Stream.<String>builder().add("a").add("b").add("c").build();
//
//        // stream generate
//        Stream<String> streamGenerated = Stream.generate(() -> "element").limit(10);
//
//        // stream iterate
//        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
//
//        // stream of primitives
//        IntStream intStream = IntStream.range(1, 3);
//        LongStream longStream = LongStream.rangeClosed(1, 3);
//        DoubleStream doubleStream = DoubleStream.of(1.2, 1.3, 1.4);
//
//        Random random = new Random();
//        DoubleStream doubleStream1 = random.doubles(3);
//
//        // stream of string
//        IntStream streamOfChars = "abc".chars();
//
//        Stream<String> streamOfString =
//                Pattern.compile(", ").splitAsStream("a, b, c");
//
//
//        // stream of file
//        Path path = Paths.get("/home/robin/Desktop/temp/file.txt");
//        Stream<String> streamOfStrings = Files.lines(path);
//        Stream<String> streamWithCharset =
//                Files.lines(path, Charset.forName("UTF-8"));
//
//        // referencing a stream
//        Stream<String> stream =
//                Stream.of("a", "b", "c").filter(element -> element.contains("b"));
//        Optional<String> anyElement = stream.findAny();
//
//        // will throw IllegalStateException
//        Optional<String> firstElement = stream.findFirst();
//
//        // correct way for the above code to work properly
//        List<String> elements =
//                Stream.of("a", "b", "c")
//                        .filter(el -> el.contains("b"))
//                        .collect(Collectors.toList());
//        Optional<String> anyElement1 = elements.stream().findAny();
//        Optional<String> firstElement1 = elements.stream().findFirst();
//
//        // stream pipeline
//        // source.op1.op2.op3...opn.terminate
//        Stream<String> onceModifiedStream =
//                Stream.of("abcd", "bbcd", "cbcd").skip(1);
//
//        Stream<String> twiceModifiedStream =
//                stream.skip(1)
//                        .map(el -> el.substring(0, 3));
//
//        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
//        long size = list.stream().skip(1)
//                .map(el -> el.substring(0, 3))
//                .sorted()
//                .count();
//
//
//        // lazy invocation
//        List<String> list1 = Arrays.asList("abc1", "abc2", "abc3");
//        counter = 0;
//        Stream<String> stream1 = list1.stream().filter(el -> {
//            wasCalled();
//            return el.contains("2");
//        });
//
//        Optional<String> stream2 = list.stream().filter(element -> {
//            System.out.println("filter() was called");
//            return element.contains("2");
//        }).map(element -> {
//            System.out.println("map() was called");
//            return element.toUpperCase();
//        }).findFirst();
//
//        // order of execution
//        long size1 = list.stream().map(el -> {
//            wasCalled();
//            return el.substring(0, 3);
//        }).skip(2).count();
//
//        long size2 = list.stream().skip(2)
//                .map(el -> {
//                    wasCalled();
//                    return el.substring(0, 3);
//                }).count();

//        // stream reduction

//        //  the reduce() method
//        OptionalInt reduced =
//                IntStream.range(1, 4)
//                        .reduce((a, b) -> a + b);
//        System.out.println(reduced.getAsInt());

//        int reducedTwoParams =
//                IntStream.range(1, 4).reduce(10, (a,b) -> a + b);
//        System.out.println(reducedTwoParams);

//        int reducedParams = Stream.of(1, 2, 3)
//                .reduce(10, (a, b) -> a + b, (a, b) -> {
//                    System.out.println("combiner was called");
//                    return a + b;
//                });
//        System.out.println(reducedParams);

//        // identity, accumulator and combiner
//        int reducedParallel = Arrays.asList(1, 2, 3).parallelStream()
//                .reduce(10, (a, b) -> a + b, (a, b) -> {
//                    System.out.println("combiner was called");
//                    return a + b;
//                });
//        System.out.println(reducedParallel);
//

        // the collect() method

        List<Product> productList = Arrays.asList(
                new Product(23, "potatoes"),
                new Product(14, "orange"),
                new Product(13, "lemon"),
                new Product(23, "bread"),
                new Product(13, "sugar")
        );

//        // reducing to collection (collection, list, set)
//        List<Integer> collectorCollection =
//                productList.stream().map(Product::getProductCount).collect(Collectors.toList());
//        System.out.println(collectorCollection);

//        // reducing to string
//        String listToString =
//                productList.stream().map(Product::getProductName)
//                        .collect(Collectors.joining(", ", "[", "]"));
//        System.out.println(listToString);

//        // processing the average value of all numeric elements of the stream
//        double averagePrice = productList.stream()
//                .collect(Collectors.averagingInt(Product::getProductCount));
//        System.out.println(averagePrice);

//        // processing the sum of all numeric elements of the stream
//        int summingPrice = productList.stream()
//                .collect(Collectors.summingInt(Product::getProductCount));
//        System.out.println(summingPrice);

//        // collecting statistical information about stream's elements
//        IntSummaryStatistics statistics = productList.stream()
//                .collect(Collectors.summarizingInt(Product::getProductCount));
//        System.out.println(statistics.toString());

//        // grouping of stream's elements according to the specified function
//        Map<Integer, List<Product>> collectorMapOfLists = productList.stream()
//                .collect(Collectors.groupingBy(Product::getProductCount));
//
//        for (Integer key: collectorMapOfLists.keySet()) {
//            System.out.print(key + ": ");
//            collectorMapOfLists.get(key).stream().forEach(v -> System.out.print(v.getProductName() + ", "));
//            System.out.println();
//        }

//        // dividing stream's elements into groups according to some predicate
//        Map<Boolean, List<Product>> mapPartioned = productList.stream()
//                .collect(Collectors.partitioningBy(el -> el.getProductCount() > 15));
//        for (Boolean key: mapPartioned.keySet()) {
//            System.out.print(key + ": ");
//            mapPartioned.get(key).stream().forEach(v -> System.out.print(v.getProductName() + ", "));
//            System.out.println();
//        }

//        // pushing the collector to perform additional transformation
//        Set<Product> unmodifiableSet = productList.stream()
//                .collect(Collectors.collectingAndThen(Collectors.toSet(),
//                        Collections::unmodifiableSet));

//        // custom collector
//        Collector<Product, LinkedList<Product>, LinkedList<Product>> toLinkedList = Collector.of(
//                LinkedList::new,
//                LinkedList::add,
//                (first, second) -> {
//                    first.addAll(second);
//                    return first;
//                }
//        );
//
//        LinkedList<Product> linkedListOfProducts = productList.stream().collect(toLinkedList);
//        linkedListOfProducts.forEach(p -> System.out.println(p.getProductName()));


        // parallel streams
        // use parallelStream() for stream of collection/array
        Stream<Product> streamOfCollection = productList.parallelStream();
        boolean isParallel = streamOfCollection.isParallel();
        System.out.println(isParallel);
        boolean bigCount = streamOfCollection.map(product -> product.getProductCount() * 12)
                .anyMatch(count -> count > 200);
        System.out.println(bigCount);

        // use parallel() method otherwise
        IntStream intStreamParallel = IntStream.range(1, 150).parallel();
        boolean isParallel1 = intStreamParallel.isParallel();
        System.out.println("isParallel1: " + isParallel1);


        // convert from parallel mode to sequential mode
        IntStream intStreamSequential = intStreamParallel.sequential();
        boolean isParallel2 = intStreamSequential.isParallel();
        System.out.println("isParallel2: " + isParallel2);

    }

    // empty stream
    public Stream<String> streamOf(List<String> list) {
        return list.isEmpty() ? Stream.empty() : list.stream();
    }
}

class  Product {
    public Integer productCount;
    public String productName;

    public Product(Integer productCount, String productName) {
        this.productCount = productCount;
        this.productName = productName;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
