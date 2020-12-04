package ru.hse.seminar07;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.hse.seminar7.FileIterator;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class TestFileIterator {

    private FileIterator iterator;

    @Test
    public void hasNextTest1() {
        try {
            iterator = new FileIterator("test2.txt");
            Assertions.assertFalse(iterator.hasNext());
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void hasNextTest2() {
        try {
            iterator = new FileIterator("test2.txt");
            Assertions.assertFalse(iterator.hasNext());
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void FileNotFoundTest() {
        Assertions.assertThrows(FileNotFoundException.class,
                () -> iterator = new FileIterator("test0.txt"));
    }

    @Test
    public void nextTest() {
        try {
            iterator = new FileIterator("test1.txt");
            iterator.hasNext();
            Assertions.assertEquals("123", iterator.next());
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void IteratorTest() {
        try {
            List<String> actual = new ArrayList<>();
            iterator = new FileIterator("test1.txt");
            for (FileIterator it = iterator; it.hasNext(); ) {
                String line = it.next();
                actual.add(line);
            }
            List<String> expected = new ArrayList<>();
            expected.add("123");
            expected.add("123");
            expected.add("");
            expected.add("43");
            expected.add("23");
            Assertions.assertArrayEquals(expected.toArray(), actual.toArray());
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
