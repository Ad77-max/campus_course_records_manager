package edu.ccrm.util;

import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

/**
 * Utility to demonstrate a recursive method.
 */
public class DirectorySizeCalculator {
    public static long calculateSize(Path path) throws IOException {
        if (Files.isRegularFile(path)) {
            return Files.size(path); // Base case
        }
        try (Stream<Path> stream = Files.list(path)) {
            return stream.mapToLong(p -> { // Recursive step
                try {
                    return calculateSize(p);
                } catch (IOException e) {
                    return 0L;
                }
            }).sum();
        }
    }
}
