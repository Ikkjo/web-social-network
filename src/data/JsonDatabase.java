package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

public class JsonDatabase<T> implements Database{
	
	private File jsonFile;
	
	public JsonDatabase() {
		
	}
	
	public JsonDatabase(String filePath) throws IOException{
		
		File f = new File(filePath);
		
		if (!isFileValid(f)) {
			throw new IOException("File does not exist, or can't be read or written to!");
		}
		
		this.jsonFile = f;
		
	}
	
	public JsonDatabase(File jsonFile) {
		this.jsonFile = jsonFile;
	}

	private static boolean isFileValid(File f) {
		
		boolean valid = (f.exists() && f.canRead() && f.canWrite()) ? true : false;
		
		return valid;
	}
	
	
	public File getJsonFile() {
		return jsonFile;
	}

	public void setJsonFile(File jsonFile) throws IOException {
		if (!isFileValid(jsonFile)) {
			throw new IOException("File does not exist, or can't be read or written to!");
		}
		
		this.jsonFile = jsonFile;
	}

	@Override
	public void Save(Object obj) {
		try (FileWriter fw = new FileWriter(this.jsonFile)) {
			
			Gson json = new Gson();
			String jsonStr = json.toJson(obj);
			
			fw.write(jsonStr);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Object Load() {
			try (BufferedReader br = new BufferedReader(new FileReader(this.jsonFile))) {
			
			Gson json = new Gson();
			
			return json.fromJson(br, Object.class);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
