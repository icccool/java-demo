package com.code.io.poi.importfile;

import java.io.File;
import java.io.InputStream;

public class AbstractInFile implements InFile {

	
	
	public String getFileName() {
		return null;
	}

	public String getFileSize() {
		return null;
	}

	public AbstractInFile(File file) {

	}

	public AbstractInFile(InputStream file) {
		
	}

	public AbstractInFile(String filePath) {
		
	}
	
	

}
