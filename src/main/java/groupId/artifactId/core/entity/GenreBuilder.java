package groupId.artifactId.core.entity;

public class GenreBuilder {
    private int id;
    private String name;
    private GenreBuilder(){}
    public static GenreBuilder create(){
        return new GenreBuilder();
    }
    public GenreBuilder setId(int id){
        this.id=id;
        return this;
    }
    public GenreBuilder setName(String name){
        this.name=name;
        return this;
    }
    public Genre build(){
        return new Genre(id,name);
    }
}
