package Blog;

import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by sparatan117 on 12/14/16.
 */
public class Main {
    static User user;
    static Post post;
    public static void main(String[] args) {
        Spark.init();
        Spark.get("/", ((request, response) -> {
            HashMap m = new HashMap();

            if (user == null){
                return new ModelAndView(m, "login.html");
            }
            else {
                m.put("user", user);
                return new ModelAndView(m, "home.html");
            }
        }), new MustacheTemplateEngine());

        ArrayList<Post> messages = new ArrayList<>();

        Spark.post("/home", ((request, response)->{
            String message = request.queryParams("message");
            post = new Post(message);
            messages.add(post);
            response.redirect("/");
            return "";
        }));

        Spark.post("/login", ((request, response)->{
            String name = request.queryParams("loginName");
            user = new User(name);
            response.redirect("/");
            return "";

        }));
    }
}
