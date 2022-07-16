package pokemon.util;


import pokemon.pojo.Pokemon;

import javax.json.*;
import java.io.InputStream;
import java.util.List;

public class PokemonMapper {

    public static JsonObject map(Pokemon pokemon) {
        JsonObjectBuilder builder = Json.createObjectBuilder();
        addValue(builder, "id", pokemon.getId());
        addValue(builder, "name", pokemon.getName());
        addValue(builder, "type", pokemon.getType());
        addValue(builder, "arge", pokemon.getArge());
        return builder.build();
    }

    private static void addValue(JsonObjectBuilder builder, String key, Object value) {
        if (value != null) {
            builder.add(key, value.toString());
        } else {
            builder.addNull(key);
        }
    }

    public static Pokemon map(InputStream is) {
        try (JsonReader jsonReader = Json.createReader(is)) {
            JsonObject jsonObject = jsonReader.readObject();
            Pokemon pokemon = new Pokemon();
            pokemon.setName(getStringFromJson("name", jsonObject));
            pokemon.setType(getStringFromJson("type", jsonObject));
            pokemon.setArge(getIntFromJson("arge", jsonObject));
            return pokemon;
        }
    }

    private static String getStringFromJson(String key, JsonObject json) {
        String returnedString = null;
        if (json.containsKey(key)) {
            JsonString value = json.getJsonString(key);
            if (value != null) {
                returnedString = value.getString();
            }
        }
        return returnedString;
    }

    private static Integer getIntFromJson(String key, JsonObject json) {
        Integer returnedValue = null;
        if (json.containsKey(key)) {
            JsonNumber value = json.getJsonNumber(key);
            if (value != null) {
                returnedValue = value.intValue();
            }
        }
        return returnedValue;
    }

    public static JsonArray map(List<Pokemon> pokemonList) {
        final JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        pokemonList.forEach(pokemon -> {
            JsonObject jsonObject = map(pokemon);
            arrayBuilder.add(jsonObject);
        });
        return arrayBuilder.build();
    }
}

