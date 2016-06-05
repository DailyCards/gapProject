package com.gap.main;

import edu.stanford.nlp.simple.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static String input;
    static final String GAP_CHAR = "_";
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {

            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            input = sb.toString();
        } catch (IOException ex) {
            System.err.println(ex);
        }

        Document inputDoc = new Document(input);

        List<Sentence> sentences = inputDoc.sentences();

        for (Sentence sentence : sentences) {
            System.out.println(sentence);
            List<String> list = new ArrayList<>(sentence.posTags());
            List<String> tags = new ArrayList<>(sentence.nerTags());

            for (int i = 0; i < tags.size(); i++) {
                if (!tags.get(i).equals("O")) {
                    list.set(i, new String(new char[list.get(i).length()]).replace("\0", GAP_CHAR));
                    break;
                }
            }
            Sentence sent = new Sentence(list);
            System.out.println(sent);
            System.out.println(tags);
            System.out.println();
        }
    }
}

