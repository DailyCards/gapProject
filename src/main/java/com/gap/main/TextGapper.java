package com.gap.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import HackHack.HackHack.some.Question;
import edu.stanford.nlp.simple.Document;
import edu.stanford.nlp.simple.Sentence;

public class TextGapper {

	static final String GAP_CHAR = "_";
	static final int MAX_QUESTIONS = 9;
	static Random rand = new Random();
	static HashSet<Integer> visitedIndexes = new HashSet<>();
	static final String[] SET_VALUES = new String[] { "one", "the","two","first","second","current"
			,"zero","daily","A","a","about","this","that","current","currently","-","\\","/",
			"-LRB-","-RRB-","\\\\","\\","present","previous","past","CC-BY","years","days","today","tommorow",
			"once","_","__","LRB","RRB","One"};
	public static final Set<String> MY_SET = new HashSet<String>(Arrays.asList(SET_VALUES));


	

	public List<Question> getQuestions(String inputText) {
		
		ArrayList<Question> questions = new ArrayList<>();

		Document inputDoc = new Document(inputText);

		List<Sentence> sentences = new ArrayList<Sentence>(inputDoc.sentences());
		int totalSentences = sentences.size();
		int counter = 0;
		int randIndex = 0;

		while (counter <= MAX_QUESTIONS) {

			if (visitedIndexes.size() == totalSentences) {
				break;
			}
			randIndex = rand.nextInt(totalSentences);

			if (visitedIndexes.contains(randIndex)) {
				continue;
			}
			visitedIndexes.add(randIndex);

			Sentence sentence = sentences.get(randIndex);

			List<String> list = new ArrayList<>(sentence.words());
			List<String> tags = new ArrayList<>(sentence.nerTags());
			Question q = new Question();

			for (int i = 0; i < tags.size(); i++) {
				int num = 0;
				if (!tags.get(i).equals("O") && !MY_SET.contains(list.get(i))) {
					q.setAnswer(list.get(i));
					System.out.println("tag: " + tags.get(i));
					if (tags.get(i).equals("DATE")) {
						System.out.println(list.get(i));
						try {
							num = Integer.parseInt(list.get(i));

							for (int j = 0; j < q.getOptions().length; j++) {
								int option = rand.nextInt(((num + 10) - (num - 10)) + 1) + (num - 10);
								System.out.println("option: " + option);
								q.addOption(j, option);
							}

						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					list.set(i, new String(new char[list.get(i).length()]).replace("\0", GAP_CHAR));

					Sentence sent = new Sentence(list);
					q.setText(sent.text());

					questions.add(q);
					counter++;
					break;
				}
			}
		}

		return questions;
	}
}
