package P3;

import java.io.Serializable;

public class Llama extends Animal implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5562124209243754978L;
	private static int id;
	public Llama() {
		setName("Llama" + ++id);
		setMealAmount(9);
	}
	public void sound(){
		if(isAlive()) System.out.println("Hmmm!");
	}
	public void jump(){
		if(isAlive()) System.out.println("Llamas can jump as following:...!");
	}
}
