package object;

public class Food {
	private String foodName;
	private double portionSize;
	private double carb;
	private double protein;
	private double fat;
	private double natrium;
	private double sugar;
	private double calories;
	
	
	public Food() {
		super();
	}
	public Food(String foodName, double portionSize, double carb, double protein, double fat, double natrium, double sugar,
			double calories) {
		super();
		this.foodName = foodName;
		this.portionSize = portionSize;
		this.carb = carb;
		this.protein = protein;
		this.fat = fat;
		this.natrium = natrium;
		this.sugar = sugar;
		this.calories = calories;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public double getPortionSize() {
		return portionSize;
	}
	public void setPortionSize(int portionSize) {
		this.portionSize = portionSize;
	}
	public double getCarb() {
		return carb;
	}
	public void setCarb(double carb) {
		this.carb = carb;
	}
	public double getProtein() {
		return protein;
	}
	public void setProtein(double protein) {
		this.protein = protein;
	}
	public double getFat() {
		return fat;
	}
	public void setFat(double fat) {
		this.fat = fat;
	}
	public double getNatrium() {
		return natrium;
	}
	public void setNatrium(double natrium) {
		this.natrium = natrium;
	}
	public double getSugar() {
		return sugar;
	}
	public void setSugar(double sugar) {
		this.sugar = sugar;
	}
	public double getCalories() {
		return calories;
	}
	public void setCalories(double calories) {
		this.calories = calories;
	}

}
