package pokemon.startup;


import io.helidon.common.CollectionsHelper;
import io.helidon.microprofile.server.Server;
import pokemon.resources.PokemonResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("/pokemon")
public class PokemonStartup extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return CollectionsHelper.setOf(PokemonResource.class);
    }

    public static void main(String... args) {
        Server server = Server.builder()
                .addApplication(PokemonStartup.class)
                .port(9080)
                .build();
        server.start();
    }


}
