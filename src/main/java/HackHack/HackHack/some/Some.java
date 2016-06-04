package HackHack.HackHack.some;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Some {

	String name;
	int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Some getNameAndAge(){
		Some some = new Some();
		some.setAge(25);
		some.setName("Ian");
		return some;
	}
}

