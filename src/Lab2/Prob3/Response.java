package Lab2.Prob3;

import java.util.ArrayList;

public class Response {
    private ArrayList<Comment> compliments;

    public Response(){
        compliments = new ArrayList<Comment>();
    }

    public ArrayList<Comment> getCompliments(){
        return compliments;
    }

    public void addCompliment(Comment compliment){
        compliments.add(compliment);
    }

}
