package pokemon.util;

import pokemon.pojo.Pokemon;

import java.util.concurrent.ThreadLocalRandom;

public class CreateUtil {

    public static Pokemon createBasePokemon() {
        Pokemon pokemon = new Pokemon();
        pokemon.setId(getRandomId());
        pokemon.setName(Constants.YELLOWNAME);
        pokemon.setType(Constants.TYPE);
        pokemon.setArge(getRandom());
        return pokemon;
    }

    private static int getRandom() {
        return ThreadLocalRandom.current().nextInt();
    }

    private static String getRandomId() {
        return String.valueOf(ThreadLocalRandom.current().nextInt());
    }
}
