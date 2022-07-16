package pokemon.util;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import pokemon.pojo.Pokemon;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class BodyWritter implements MessageBodyWriter<Pokemon> {
    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return type.equals(Pokemon.class);
    }

    @Override
    public void writeTo(Pokemon pokemon, Class<?> type, Type genericType, Annotation[] annotations,
                        MediaType mediaType, MultivaluedMap<String, Object> httpHeaders,
                        OutputStream entityStream) throws WebApplicationException {
        JsonWriter jsonWriter = Json.createWriter(entityStream);
        JsonObject jsonObject = PokemonMapper.map(pokemon);
        jsonWriter.writeObject(jsonObject);
        jsonWriter.close();
    }

}
