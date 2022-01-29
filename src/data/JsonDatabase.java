package data;

import java.io.File;

public class JsonDatabase<T> implements Database{
	
	private File jsonFile;
	
	public JsonDatabase() {
		
	}
	
	public JsonDatabase(String filePath) {
		
	}
	
	public JsonDatabase(File jsonFile) {
		this.jsonFile = jsonFile;
	}

	private static boolean isFileValid(String filepath) {
		boolean valid = true;
		
		return valid;
	}
	
	@Override
	public void Save(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object Load() {
		// TODO Auto-generated method stub
		return null;
	}

}
