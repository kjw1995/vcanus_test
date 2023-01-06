package test1;

import java.io.FileReader;
import java.io.Reader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Sugar extends Bread{
	
	@Override
	public void recipe() {
		try {
			JSONParser parser = new JSONParser();
			Reader reader = new FileReader("C:\\jsonfile\\bread.json");
			JSONArray jsonArr = (JSONArray)parser.parse(reader);
			
			for(int i = 0; i < jsonArr.size(); i++) {
				JSONObject jsonObj = (JSONObject)jsonArr.get(i);
				String breadType = (String)jsonObj.get("breadType");
				if(breadType.equals("sugar")) {
					System.out.println("breadType : " + jsonObj.get("breadType"));
					System.out.println("recipe : ");
					System.out.println(jsonObj.get("recipe"));
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

}
