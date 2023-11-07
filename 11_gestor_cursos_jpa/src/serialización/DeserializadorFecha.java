package serialización;

import java.lang.reflect.Type;
import java.time.LocalDate;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class DeserializadorFecha implements JsonDeserializer<LocalDate>{
	// https://javadoc.io/doc/com.google.code.gson/gson/latest/com.google.gson/com/google/gson/JsonDeserializer.html

	// Al crear la clase y añadir el implements aparece un error. En la ayuda de ese error ofrece crera este método.
	@Override
	public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		return LocalDate.parse(json.getAsString());
			// Coge el parámetro json como una cadena y lo devuelve como LocalDate en formato ISO.
	}
}
