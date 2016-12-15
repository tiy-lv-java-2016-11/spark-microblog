package sparkmicroblog;

import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.HashMap;

/**
 * Created by darionmoore on 12/14/16.
 */
public class Main {
    static User user;
    static Post post;

    public static void main(String[] args) {
        Spark.init();

//        Create a GET route for "/" and a POST route for "/create-user" and "/create-message".
        Spark.get("/",((request, response) -> {
            HashMap model = new HashMap();
            model.put(user, post);
            return new ModelAndView(model, "index.html");
        }) , new MustacheTemplateEngine());

        Spark.post("/create-user", ((request, response) -> {
            String createUser = request.queryParams("userName");
            user = new User();

            response.redirect("/");
            return "";
        }));

        Spark.post("/create-post", ((request, response) -> {
            String createPost = request.queryParams("New Post");
            post = new Post();
            response.redirect("/create-post.html");
            return "";
        }));



    }
}