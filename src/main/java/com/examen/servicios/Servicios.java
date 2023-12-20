package com.examen.servicios;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;


public class Servicios {

	private static final String FILE_DIRCTORY = "";
	
	private final Path rootLocation = Paths.get(FILE_DIRCTORY);
	
	public void storeFile(MultipartFile file, String ubicacion) throws IOException{
		Path filePath = Paths.get(FILE_DIRCTORY + "/" + ubicacion + "/" + file.getOriginalFilename());
		
		Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
	}
	
	public Resource loadFile(String filename, String ubicacion) {
	    try {
	      Path file = rootLocation.resolve(ubicacion+"/"+filename);
	      System.out.println(file.toString());
	      Resource resource = new UrlResource(file.toUri());
	      if (resource.exists() || resource.isReadable()) {
	        return resource;
	      } else {
	        throw new RuntimeException("FAIL!");
	      }
	    } catch (MalformedURLException e) {
	      throw new RuntimeException("FAIL!");
	    }
	  }
}