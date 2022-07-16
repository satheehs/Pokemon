package pokemon.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import pokemon.pojo.BasePokemon;
import pokemon.pojo.Pokemon;
import pokemon.repository.PokemonRepo;
import pokemon.util.CreateUtil;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Path("game")
@RequestScoped
public class PokemonResource {

    @Inject
    private PokemonRepo pokemonRepo;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPokemon(@PathParam("id") String id) {
        BasePokemon pokemon = pokemonRepo.getPokemon_id(id);
        return Response.ok(pokemon).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPokemon(BasePokemon basePokemon) {
        String id = pokemonRepo.addPokemon(basePokemon);
        return Response.created(
                        UriBuilder.fromResource(this.getClass()).path(id).build())
                .build();
    }

    @GET
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPokemon(){
        Pokemon pokemon = CreateUtil.createBasePokemon();
        pokemonRepo.addPokemon(pokemon);
        return Response.ok(pokemon).build();
    }
    @GET
    @Path("/maxArgePokemon")
    @Produces(MediaType.APPLICATION_JSON)
    public Response maxArgePokemon(){
        return Response.ok(pokemonRepo.maxArgePokemon()).build();
    }
    @GET
    @Path("/minArgePokemon")
    @Produces(MediaType.APPLICATION_JSON)
    public Response minArgePokemon(){
        return Response.ok(pokemonRepo.minArgePokemon()).build();
    }

    @GET
    @Path("/firstCharMatcher/{firstChar}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response firstCharMatcher(@PathParam("firstChar") Character character){
        return Response.ok(pokemonRepo.search(character)).build();
    }
}
