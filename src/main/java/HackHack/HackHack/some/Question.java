package HackHack.HackHack.some;

public class Question {
	String text;
	String answer;
	int[] options;
	
	public Question() {
		this.options = new int[4];
	}
	
	public int[] getOptions() {
		return options;
	}

	public void setOptions(int[] options) {
		this.options = options;
	}
	
	public void addOption(int index, int option) {
		this.options[index] = option;
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
