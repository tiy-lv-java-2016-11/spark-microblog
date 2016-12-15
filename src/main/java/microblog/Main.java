package microblog;

import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by melmo on 12/14/16.
 */
public class Main {
    static User user;
    static ArrayList<Message> messages = new ArrayList<>();


    public static void main(String[] args) {
        user = new User("melody", "ted");
        messages.add(new Message("tux is alreigth", user));
        messages.add(new Message("ted is better", user));
        messages.add(new Message("ginger is annoying, sometimes", new User("chiara", "olivia")));
        Spark.init();

        Spark.get("/", ((request, response) -> {
            HashMap m = new HashMap();
            m.put("user", user);
            m.put("messages", messages);

            return new ModelAndView(m,"index.html");
        }), new MustacheTemplateEngine());

        Spark.get("/messages.html", ((request, response) -> {
            HashMap m = new HashMap();
            ArrayList<Message> userMessages = new ArrayList<Message>();
            for (Message message : messages){
                if (message.getUser() == user){
                    userMessages.add(message);
                }
            }
            m.put("user", user);
            m.put("messages", userMessages);

            return new ModelAndView(m,"messages.html");
        }), new MustacheTemplateEngine());

        Spark.post("/create-user", ((request, response) -> {
            String name = request.queryParams("loginName");
            String pass = request.queryParams("password");
            if (user != null && user.getLoginName().equals(name)){
                if (!user.getPassword().equals(pass)){
                    throw new Exception("You entered the wrong password");
                }
                else {
                    response.redirect("/messages.html");
                }
            }
            else {
                user = new User(name, pass);
                response.redirect("/messages.html");
            }
            return "";
        }));

        Spark.post("/create-message", ((request, response) -> {
            String message = request.queryParams("message");
            messages.add(new Message(message, user));
            response.redirect("/messages.html");
            return "";
        }));
    }
}
