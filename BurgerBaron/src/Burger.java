/*
 * Homework Assignment 1 - Burger Baron 
 * 
 * @author Sally Ho 
 * @version March 28, 2018
 */
public class Burger {
	private MyStack<String> myCustom;
	private MyStack<String> myBaronBurger;
	private MyStack<String> myTempOrder;
	private MyStack<String> myIngredients; 
	private int myNumPatty; 
	private String myPattyType;
	//bun
	public static final String BOT_BUN = "Bottom Bun";
	public static final String TOP_BUN = "Top Bun";
	//patties
	public static final String BEEF = "Beef";
	public static final String VEGGIE = "Veggie";
	public static final String CHICKEN = "Chicken";
	//veggies 
	public static final String LETTUCE = "Lettuce";
	public static final String TOMATO = "Tomato";
	public static final String MUSHROOMS = "Mushrooms";
	public static final String ONION = "Onions";
	public static final String PICKLE = "Pickle";
	//sauces
	public static final String KETCHUP = "Ketchup";
	public static final String MUSTARD = "Mustard";
	public static final String BARON_SAUCE = "Baron Sauce";
	public static final String MAYO = "Mayonnaise";
	//cheese
	public static final String CHEDDAR = "Cheddar";
	public static final String MOZZARELLA = "Mozzarella";
	public static final String PEPPERJACK = "Pepperjack";
	
	/*
	 * Constructor 
	 */
	public Burger (boolean theWorks) {
		//the custom burger for the order 
		myCustom = new MyStack<String>();
		//baron burger for the baron burger. 
		myBaronBurger = new MyStack<String>();
		//temp stack to hold stuff to pop in and out
		myTempOrder = new MyStack<String>();
		//ingredients to check. 
		myIngredients = new MyStack<String>();
		//should initially start out with one patty. 
		myNumPatty = 1;
		//default patty is beef. 
		String myPatty = "Beef";
		
		myIngredients.push(BOT_BUN);
		myIngredients.push(myPatty);
		myIngredients.push(TOP_BUN);
		//this makes a baron burger  
		if(theWorks) {
			addCategory("Veggies");
			addCategory("Sauce");
			addCategory("Cheese");
		}
		remakeBaron();
		remakeBurger();
		
	}
		
	/*
	 * Changes the patties depending on given name. 
	 *
	 */
	public void changePatties(String pattyType) {
		myPattyType = pattyType;
		myIngredients.push(myPattyType);
		while(!myIngredients.isEmpty()) {
			if(myIngredients.peek() != BEEF || myIngredients.peek() != CHICKEN
					|| myIngredients.peek() != VEGGIE) {
				myTempOrder.push(myIngredients.pop());
			} else if (myIngredients.peek() == BEEF || myIngredients.peek() == CHICKEN
					|| myIngredients.peek() == VEGGIE){
				for(int i = 0; i < myNumPatty; i++) {
					myIngredients.pop();
					myTempOrder.push(pattyType);
				}
			}
		}
		
		while(!myTempOrder.isEmpty()) {
			myIngredients.push(myTempOrder.pop()); 
		}
	}
	
	/*
	 * Adds patty (up to 3)
	 */
	public void addPatty() {
		myNumPatty++;
		while(!myIngredients.isEmpty() && myNumPatty <= 3) {
			String checker = myIngredients.peek();
			if(checker != PEPPERJACK || checker != MOZZARELLA
					|| checker != CHEDDAR) {
				myTempOrder.push(myIngredients.pop());
			} else {
				myTempOrder.push(myPattyType);
				myTempOrder.push(CHEDDAR);
				myTempOrder.push(MOZZARELLA);
				myTempOrder.push(PEPPERJACK);
			}
		}
		while(!myTempOrder.isEmpty()) {
			myIngredients.push(myTempOrder.pop());
		}
	}
	
	/*
	 * Adds a whole category of ingredients
	 */
	public void addCategory(String type) {		
		//checking for vegetable category
		if(type.equals("Veggies")) {
			myIngredients.push(LETTUCE);
			myIngredients.push(TOMATO);
			myIngredients.push(ONION);
			myIngredients.push(PICKLE);
			myIngredients.push(MUSHROOMS);
		} 
		//checking for cheese category
		if(type.equals("Cheese")) {
			myIngredients.push(CHEDDAR);
			myIngredients.push(MOZZARELLA);
			myIngredients.push(PEPPERJACK);
		}
		//checking for sauce category. this is for sure wrong lol  
		if(type.equals("Sauce")) {
			myIngredients.push(BARON_SAUCE);
			myIngredients.push(KETCHUP);
			myIngredients.push(MUSTARD);
			myIngredients.push(MAYO);
		}
	}
	
	public void removeCategory (String type) {
		if(type.equals("Cheese")) {
			removeIngredient(CHEDDAR);
			removeIngredient(MOZZARELLA);
			removeIngredient(PEPPERJACK);
		}
		if(type.equals("Sauce")) {
			removeIngredient(KETCHUP);
			removeIngredient(MUSTARD);
			removeIngredient(MAYO);
			removeIngredient(BARON_SAUCE);
		}
		if(type.equals("Veggies")) {
			removeIngredient(MUSHROOMS);
			removeIngredient(LETTUCE);
			removeIngredient(TOMATO);
			removeIngredient(ONION);
			removeIngredient(PICKLE);
		}
	}
	
	public void addIngredient(String type) {
		if (!hasIngredients(type)) {
			myIngredients.push(type);			
		}

	}
	
	public void removeIngredient(String type) {
		if(hasIngredients(type)) {
			myIngredients.pop();
		}
	}
	
	@Override
	public String toString() {
		String s = "";
		s += "[";
		while(!myCustom.isEmpty()) {
			s += myCustom.pop();
			s += " ";
		}
		s += "]";
		return s;
		
	}
	
	/*
	 * remakes the burger itself.  (helper method)
	 */
	private void remakeBaron() {
		while(!myBaronBurger.isEmpty()) {
			myBaronBurger.pop();
		}
		myBaronBurger.push(BOT_BUN);
		myBaronBurger.push(KETCHUP);
		myBaronBurger.push(MUSTARD);
		myBaronBurger.push(MUSHROOMS);
		myBaronBurger.push(BEEF); //assignment says patty???
		myBaronBurger.push(CHEDDAR);
		myBaronBurger.push(MOZZARELLA);
		myBaronBurger.push(PEPPERJACK);
		if(myNumPatty > 1) {
			for(int i = 0; i < myNumPatty; i++) {
				myBaronBurger.push(myPattyType);
			}
		}
		myBaronBurger.push(ONION);
		myBaronBurger.push(TOMATO);
		myBaronBurger.push(LETTUCE);
		myBaronBurger.push(BARON_SAUCE);
		myBaronBurger.push(MAYO);
		myBaronBurger.push(TOP_BUN);
		myBaronBurger.push(PICKLE);
	}
	
	private void remakeBurger() {
		while(!myBaronBurger.isEmpty()) {
			if(hasIngredients(myBaronBurger.peek())) {
				myCustom.push(myBaronBurger.pop());
			} else {
				myBaronBurger.pop();
			}
		}
		remakeBaron();
	}
	
	// ^ these two methods compare baron burger to the ingredients. 
	
	private boolean hasIngredients (String ingredients) {
		boolean includes = false; 
		//while the list of ingredients aren't empty loop through
		while(!myIngredients.isEmpty()) {
			//if the ingredients being passed in is at the top
			//pop it and then break out of loop
			if(ingredients.equals(myIngredients.peek())) {
				includes = true; 			
				break;
			}
			myTempOrder.push(myIngredients.pop());
		}
		//while the temp stack isn't empty push the ingredients back into ingred stack.
		while (!myTempOrder.isEmpty()) {
			myIngredients.push(myTempOrder.pop());
		}
		return includes;
	}
}
