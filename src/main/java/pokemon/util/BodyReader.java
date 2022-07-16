package pokemon.util;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import pokemon.pojo.BasePokemon;
import pokemon.pojo.Pokemon;

import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class BodyReader implements MessageBodyReader<Pokemon> {

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return type.equals(BasePokemon.class);
    }

    @Override
    public Pokemon readFrom(Class<Pokemon> type, Type genericType, Annotation[] annotations,
                            MediaType mediaType, MultivaluedMap<String, String> httpHeaders,
                            InputStream entityStream) throws WebApplicationException {
        return PokemonMapper.map(entityStream);
    }
}



