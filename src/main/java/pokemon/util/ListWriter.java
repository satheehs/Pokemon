package pokemon.util;

import pokemon.pojo.Pokemon;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonWriter;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class ListWriter implements MessageBodyWriter<List<Pokemon>> {

    @Override
    public boolean isWriteable(Class<?> clazz, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return true;
    }

    @Override
    public long getSize(List<Pokemon> pokemon, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return 0;
    }

    @Override
    public void writeTo(List<Pokemon> pokemonList, Class<?> type, Type genericType, Annotation[] annotations,
                        MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
            throws WebApplicationException {
        JsonWriter jsonWriter = Json.createWriter(entityStream);
        JsonArray jsonArray = PokemonMapper.map(pokemonList);
        jsonWriter.writeArray(jsonArray);
        jsonWriter.close();
    }
}



