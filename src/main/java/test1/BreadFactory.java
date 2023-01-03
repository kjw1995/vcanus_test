package test1;

import java.util.ArrayList;
import java.util.List;

public class BreadFactory {
	
	public Recipe getRecipe(String Type) {
		
		if(Type == null) {
			return null;
		}
		
		if(Type.equalsIgnoreCase("BREAD")) {
			return new Bread();
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		BreadFactory breadFactory = new BreadFactory();
		Recipe breadRecipe = breadFactory.getRecipe("bread");
		
		
		List<Recipe> breadRecipeList = new ArrayList<Recipe>();
		breadRecipeList.add(breadRecipe);
		breadRecipeList.get(0).info();
	}
		
}
