package pokemon.pojo;

public class SearchCriteria {

    String name;
    String type;
    String id;
    boolean minArgePokemon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isMinArgePokemon() {
        return minArgePokemon;
    }

    public void setMinArgePokemon(boolean minArgePokemon) {
        this.minArgePokemon = minArgePokemon;
    }

    public boolean isMaxArgePokemon() {
        return maxArgePokemon;
    }

    public void setMaxArgePokemon(boolean maxArgePokemon) {
        this.maxArgePokemon = maxArgePokemon;
    }

    boolean maxArgePokemon;


}
