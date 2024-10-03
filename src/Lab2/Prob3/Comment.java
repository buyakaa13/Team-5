package Lab2.Prob3;

public class Comment {
    private int id;
    private String description;

    public Comment(int id, String description){
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Id: " + id + " Desc: " + description;
    }
}
