package com.swedbank.javagyk.collections.poem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class Poem {

    private List<String> poemLines;

    public Poem(List<String> lines) {
        poemLines = lines;
    }

    public static void main(String[] args) throws IOException {

        File poemFile = Paths.get(System.getProperty("user.dir"), "poem.txt").toFile();
        Reader reader = new Reader(poemFile);

        Poem poem = new Poem(reader.read());
        poem.print();

    }

    // implement this
    public void print() {
        for(String poemLine: poemLines){
            System.out.println(poemLine);
        }

    }



}
