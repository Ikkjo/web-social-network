package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonDatabase{
	public static void save(File jsonFile, Object data) {
		try (FileWriter fw = new FileWriter(jsonFile)) {
			
			Gson json = new GsonBuilder().setPrettyPrinting().create();
			String jsonStr = json.toJson(data);
			
			fw.write(jsonStr);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static Object load(File jsonFile) {
			try (BufferedReader br = new BufferedReader(new FileReader(jsonFile))) {
			
			Gson json = new Gson();

			return (Object) json.fromJson(br, Object.class);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
