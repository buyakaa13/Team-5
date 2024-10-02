package Prob3;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Post post = new Post("MIU university dining hall", LocalDate.now());
        post.addFeedback();
        Response response = post.getFeedback();
        response.addCompliment(new Comment(123, "Argiro's food is so awful!!"));
        response.addCompliment(new Comment(124, "Why lecture class's screen being so dark!!"));
        System.out.println("Post: " + post.getName());
        System.out.println("Feedback: " + post.getFeedback().getCompliments().toString());
    }
}
