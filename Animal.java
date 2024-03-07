package P3;

import java.io.Serializable;

public abstract class Animal implements Cloneable, Comparable<Animal>,Serializable{

	/* Q: why it makes sense that Animal should be abstract?
	 * A: Animal should be abstract to prevent creating animals of unknown types (i.e. that are not Cows, Llamas, or Chicken). 
	 *    Animal just provides a base for its subclasses which inherit the implemented methods and are forced to implement the abstract methods.
	 */
	private String name;
	private double energy, mealAmount, x, y, speedX=1, speedY=1;
	private boolean alive;
	public Animal() {
		setEnergy(100);
	}
	public void speak(String msg){
		if (isAlive()) System.out.println(getName() + " says: " + msg);
	}
	public double eat(){
		if (isAlive()) {
			double amount = Math.round((100-getEnergy())*100)/100.0;
			if (amount >= mealAmount) {
				System.out.println(getName() + " ate " + mealAmount + " units");
				setEnergy(getEnergy() + mealAmount);
				return mealAmount;
			} else if (amount > 0) {
				System.out.println(getName() + " ate " + amount + " units. Now it is full!");
				setEnergy(100);
				return amount;
			} else {
				System.out.println(getName() + " didn't eat. It is full!");
				return 0;
			}
		} else {
			System.out.println(getName() + " is dead!");
			return 0;
		}
	}
	public void move() {
		if(isAlive()){
			x += speedX;
			y += speedY;
			setEnergy(getEnergy() - 0.1);
		}else
			System.out.println(getName() + "can't move. It is dead!");
	}	
	public abstract void sound();
	/* Q: why it makes sense for sound() to be be abstract?
	 * Since we don't have unknown animals with unknown sounds, it doesn't make sense to implement 'sound()' in Animal
	 * why not just delete it from Animal? 
	 * (a) we want to force all subclasses to include a sound method. 
	 * (b) having sound() defined in the superclass will allow calling it using a superclass reference (polymorphism)
	 */

	//compareTo, clone
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	public int compareTo(Animal otherAnimal){
		if(this.energy < otherAnimal.energy) return -1;
		else if(this.energy > otherAnimal.energy) return 1;
		else return 0;
		/*  Another solution (50% of the mark only):
			return (int)(this.energy - otherAnimal.energy);
			//code above is ok but gets only 50% of the mark - since casting will lose precision (e.g. if difference is < 0.5, method will return 0 indicating the two energies are the same)
		*/
	}
	//setters, getters, toString
	public String getName() {
		return name;
	}
	public double getEnergy() {
		return energy;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEnergy(double energy) {
		if(energy>0 && energy <=100) 
			this.energy = energy;
		if(this.energy <= 17 ) 
			System.out.println(getName() + " says: I'm STARVING");
		else if(this.energy <= 50) 
			System.out.println(getName() + " says: I'm hungry");
		this.alive = (energy > 0); 	
	}
	public double getMealAmount() {
		return mealAmount;
	}
	public void setMealAmount(double mealAmount) {
		if(mealAmount>0 && mealAmount<100) this.mealAmount = mealAmount;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getSpeedX() {
		return speedX;
	}
	public void setSpeedX(double speedX) {
		this.speedX = speedX;
	}
	public double getSpeedY() {
		return speedY;
	}
	public void setSpeedY(double speedY) {
		this.speedY = speedY;
	}
	public boolean isAlive() {
		return alive;
	}
	public String toString(){
		//return String.format("Alive:%b Name:%-10sEnergy:%-7.1fLocation:(%-2.1f,%-2.1f)", isAlive(), name, energy,x,y); 
		return String.format("%-8s: %-5s at (%-2.1f,%-2.1f) Energy=%-7.1f", name, isAlive()?"alive":"dead",x,y,energy); 
	}
}