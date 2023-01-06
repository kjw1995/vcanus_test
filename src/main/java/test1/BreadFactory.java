package test1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BreadFactory {
	
	public Map<String,Bread> getRecipe(String breadType) throws Exception {
		
		Class<?> bread = Class.forName("test1." + breadType);
		Constructor<?> con = bread.getDeclaredConstructor();
		Bread br = (Bread)con.newInstance();
		Map<String,Bread> recipe = new HashMap<String,Bread>();
		recipe.put(breadType, br);
		
		
		return recipe;
	}
	
	public static void main(String[] args) throws Exception {
		
		BreadFactory bf = new BreadFactory();
		List<Bread> br = new ArrayList<Bread>();
		br.add(bf.getRecipe("Sugar").get("Sugar"));
		br.add(bf.getRecipe("Cream").get("Cream"));
		br.add(bf.getRecipe("Butter").get("Butter"));
		
		for(int i = 0; i < br.size(); i++) {
			br.get(i).recipe();
		}
		
		
		
	}
		
}
