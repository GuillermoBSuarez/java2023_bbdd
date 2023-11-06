package DAO;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.Gson;

import model.Curso;

public class CursosJsonDAO {
	
	public Stream<Curso> getCursos(){
		String ruta = "c:\\temp\\cursos.json";
		Gson gson = new Gson();
		
		try ( FileReader fr = new FileReader(ruta); ){
			Curso[] cursos = gson.fromJson(fr, Curso[].class);
			return Arrays.stream(cursos);
		} catch (IOException ex) {
			ex.printStackTrace();
			return Stream.empty();
		}
	}
	
	public List<Curso> cursos() {
		return getCursos().collect(Collectors.toList());
	}
	
}