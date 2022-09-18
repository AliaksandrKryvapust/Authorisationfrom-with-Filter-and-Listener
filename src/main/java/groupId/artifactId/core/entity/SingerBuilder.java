package groupId.artifactId.core.entity;

public class SingerBuilder {
    private int id;
    private String name;
    private SingerBuilder(){}
    public static SingerBuilder create(){
        return new SingerBuilder();
    }
    public SingerBuilder setId(int id){
        this.id=id;
        return this;
    }
    public SingerBuilder setName(String name){
        this.name=name;
        return this;
    }
    public Singer build(){
        return new Singer(id, name);
    }
}
