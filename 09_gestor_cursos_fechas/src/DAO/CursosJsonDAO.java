package DAO;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Curso;
import serialización.DeserializadorFecha;

public class CursosJsonDAO {
	
	public Stream<Curso> getCursos(){
		String ruta = "c:\\temp\\cursosfecha.json";
		// Gson gson = new Gson();
		
		Gson gson = new GsonBuilder()	// Devuelve GsonBuilder, método alternativo para poder incluir el deserializador.
				.registerTypeAdapter(LocalDate.class, new DeserializadorFecha())
				// Devuelve otro GsonBuilder, se podrían añadir más métodos para darle más propiedades
				.create();	
		
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