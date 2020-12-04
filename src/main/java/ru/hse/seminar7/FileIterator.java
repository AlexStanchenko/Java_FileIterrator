package ru.hse.seminar7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class FileIterator implements Iterator<String> {


    /**
     * Поле - элемент коллекции
     */
    private String line;
    /**
     * Поле - поток считывания файла
     */
    private final BufferedReader reader;

    /**
     * Создает объект класса
     *
     * @param fileName путь к файлу
     * @throws FileNotFoundException если файл не удалось найти по указанному пути
     */
    public FileIterator(String fileName) throws FileNotFoundException {
        FileReader fr = new FileReader(fileName);
        reader = new BufferedReader(fr);
    }


    /**
     * Определяет есть ли следующий элемент в итерируемой кллекции
     *
     * @return true, если есть, иначе false
     */
    @Override
    public boolean hasNext() {

        try {
            line = reader.readLine();
            if (line == null) {
                reader.close();
                return false;
            }
            return true;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    /**
     * Возвращает следующий элемент в коллекции
     *
     * @return элемент
     */
    @Override
    public String next() {
        return line;
    }

}
