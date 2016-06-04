package com.gap.main;

import java.util.ArrayList;
import java.util.List;

import HackHack.HackHack.some.Question;
import edu.stanford.nlp.simple.*;

public class TextGapper {
	
	static final String GAP_CHAR = "_";
	
	public ArrayList<Question> getQuestions(String inputText) {
		ArrayList<Question> questions = new ArrayList<>();
		
		Document inputDoc = new Document(inputText);

        List<Sentence> sentences = inputDoc.sentences();

        for (Sentence sentence : sentences) {

            List<String> list = new ArrayList<>(sentence.words());
            List<String> tags = new ArrayList<>(sentence.nerTags());

            for (int i = 0; i < tags.size(); i++) {
                if (!tags.get(i).equals("O")) {
                    list.set(i, new String(new char[list.get(i).length()]).replace("\0", GAP_CHAR));
                    break;
                }
            }
            Sentence sent = new Sentence(list);
            Question q = new Question();
            q.setText(sent.text());
            
            questions.add(q);
        }
		
		return questions;
	}
}
