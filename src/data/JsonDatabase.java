package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

public class JsonDatabase implements Database{
	
	protected Object data;
	protected File jsonFile;
	
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
	public void Save() {
		try (FileWriter fw = new FileWriter(this.jsonFile)) {
			
			Gson json = new Gson();
			String jsonStr = json.toJson(this.data);
			
			fw.write(jsonStr);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Object Load() {
			try (BufferedReader br = new BufferedReader(new FileReader(this.jsonFile))) {
			
			Gson json = new Gson();
			
			data = (Object) json.fromJson(br, Object.class);
			
			return data;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
