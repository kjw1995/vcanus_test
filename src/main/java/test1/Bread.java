package test1;

import java.io.FileReader;
import java.io.Reader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class Bread implements Recipe{
	
	@Override
	public void info() {
		
		JSONParser parser = new JSONParser();
		
		try {
			Reader reader = new FileReader("C:\\jsonfile\\bread.json");
			Object obj = parser.parse(reader);
			JSONArray jsonArr = (JSONArray)obj;
			for(int i = 0; i < jsonArr.size(); i++) {
				JSONObject jsonObj = (JSONObject)jsonArr.get(i);
				JSONObject recipeObj = (JSONObject)jsonObj.get("recipe");
				String breadType = (String)jsonObj.get("breadType");
				System.out.println("breadType : " + breadType);
				System.out.println("recipe");
				System.out.println("flour : " +  recipeObj.get("flour"));
				System.out.println("water : " +  recipeObj.get("water"));
				System.out.println(breadType + " : " +  recipeObj.get(breadType));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        
	}
	
	
}
