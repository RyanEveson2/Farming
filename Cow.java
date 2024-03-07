package P3;

import java.io.Serializable;

public class Cow extends Animal implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 7130060907455188194L;
	private static int id;
	public Cow() {
		setName("Cow" + ++id);
		setMealAmount(20);
	}
	public void sound(){
		if(isAlive()) System.out.println("Moo!");
	}
	public void milk(){
		if(isAlive()) System.out.println("We can milk cows as following:...!");
	}	
}
