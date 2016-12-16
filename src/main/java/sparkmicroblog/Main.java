package sparkmicroblog;

import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by darionmoore on 12/14/16.
 */
public class Main {
    static User userName;
    static ArrayList<String> messages = new ArrayList();




    public static void main(String[] args) {
        Spark.init();

//        Create a GET route for "/" and a POST route for "/create-user" and "/create-message".
        Spark.get("/",((request, response) -> {
            HashMap model = new HashMap();
            if(userName == null){
                return new ModelAndView(model, "Index.html");
            } else {
                model.put("userName", userName);
                model.put("messages", messages);
                return new ModelAndView(model, "messages.html");
            }
        }) , new MustacheTemplateEngine());

        Spark.post("/Index", ((request, response) -> {
            String createUser = request.queryParams("userName");
            userName = new User(createUser);
            response.redirect("/");
            return "";
        }));

        Spark.post("/messages", ((request, response) -> {
            String createPost = request.queryParams("messages");
            messages.add(createPost);
            response.redirect("/");
            return "";
        }));



    }
}