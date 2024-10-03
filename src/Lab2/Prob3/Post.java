package Lab2.Prob3;

import java.time.LocalDate;

public class Post {
    private String name;
    private LocalDate establishDate;
    private Response feedback;

    public Post(String name, LocalDate establishDate){
        this.name = name;
        this.establishDate = establishDate;
    }

    public String getName(){
        return this.name;
    }

    public void addFeedback(){
        if(feedback == null)
            feedback = new Response();
    }

    public Response getFeedback(){
        return feedback;
    }
}
