package com.example.learn.java8.streams;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.core.io.FileSystemResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SpringBootApplication
public class Java8StreamsApplication implements CommandLineRunner {

	private static Logger LOG = LoggerFactory.getLogger(Java8StreamsApplication.class);

	public static void main(String[] args) {

		LOG.info("STARTING THE APPLICATION");
		SpringApplication.run(Java8StreamsApplication.class, args);
		LOG.info("APPLICATION FINISHED");
	}

	@Override
	public void run(String... args) throws Exception, IOException {

		LOG.info("EXECUTING : command line runner");

		// 1. Integer Stream
		IntStream
				.range(1, 10)
				.forEach(System.out::println);
		System.out.println();

		// 2. Integer Stream with skip
		IntStream
				.range(1, 10)
				.skip(5)
				.forEach(x -> System.out.println(x));
		System.out.println();

		// 3. Integer Stream with sum
		System.out.println(
				IntStream
						.range(1, 5)
						.sum()
		);
		System.out.println();

		// 4. Stream.of, sorted and findFirst
		Stream.of("Ava", "Aneri", "Alberto")
				.sorted()
				.findFirst()
				.ifPresent(System.out::println);
		System.out.println();

		// 5. Stream from Array, sort, filter and print
		String[] names = {"Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah"};
		Arrays.stream(names)
				.filter(x -> x.startsWith("S"))
				.sorted()
				.forEach(System.out::println);
		System.out.println();

		// 6. average of squares of an int array
		Arrays.stream(new int[] {2, 4, 6, 8, 10})
				.map(x -> x * x)
				.average()
				.ifPresent(System.out::println);
		System.out.println();

		// 7. Stream from List, filter and print
		List<String> people = Arrays.asList("Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika",
				"Sarah");
		people.stream()
				.map(String::toLowerCase)
				.filter(x -> x.startsWith("a"))
				.forEach(System.out::println);
		System.out.println();


		// Application Root Path of Spring Boot application
		String path = new FileSystemResource("").getFile().getAbsolutePath();
		System.out.println(path);
		String path2 = System.getProperty("user.dir");
		System.out.println(path2);
		System.out.println();

		// 8. Stream rows from text file, sort, filter and print
		Stream<String> bands = Files.lines(Paths.get("bands.txt"));
		bands
				.filter(x -> x.length() > 13)
				.sorted()
				.forEach(System.out::println);
		bands.close();
		System.out.println();

		// 9. Stream rows from text file and save to List
		List<String> bands2 = Files.lines(Paths.get("bands.txt"))
				.map(String::toLowerCase)
				.filter(x -> x.contains("j"))
				.collect(Collectors.toList());
		bands2.forEach(System.out::println);
		System.out.println();

		// 10. Stream rows from CSV file and count
		Stream<String> rows1 = Files.lines(Paths.get("data.txt"));
		int rowCount = (int) rows1
				.map(x -> x.split(","))
				.filter(x -> x.length == 3)
				.count();
		System.out.println(rowCount + " rows.");
		rows1.close();
		System.out.println();

		// 11. Stream rows from CSV file, parse data from rows
		Stream<String> rows2 = Files.lines(Paths.get("data.txt"));
		rows2
				.map(x -> x.split(","))
				.filter(x -> x.length == 3)
				.filter(x -> Integer.parseInt(x[1]) > 15)
				.forEach(x -> System.out.println(x[0] + " " + x[1] + " " + x[2]));
		rows2.close();
		System.out.println();

		// 12. Stream rows from CSV file, store fields in HashMap
		Stream<String> rows3 = Files.lines(Paths.get("data.txt"));
		Map<String, Integer> map = new HashMap<>();
		map = rows3
				.map(x -> x.split(","))
				.filter(x -> x.length == 3)
				.filter(x -> Integer.parseInt(x[1]) > 15)
				.collect(Collectors.toMap(
						x -> x[0],
						x -> Integer.parseInt(x[1])
				));
		rows3.close();
		for (String key: map.keySet()) {
			System.out.println(key + " " + map.get(key));
		}
		System.out.println();

		// 13. Reduction - sum
		double total = Stream.of(7.3, 1.5, 4.8)
				.reduce(100.0, (Double a, Double b) -> a + b);
		System.out.println("Total = " + total);
		System.out.println();

		// 14. Reduction - summary statistics
		IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10)
				.summaryStatistics();
		System.out.println(summary);
		System.out.println();


	}
}
