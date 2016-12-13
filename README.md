# Microblog

## Description

Make a web application that allows you write short messages. When you click "Submit", it will refresh and show a list of messages you wrote.

## Requirements

* Create a maven project
* Add both spark and spark mustache to your pom file.  The two should go in the `<dependencies>` tag like in previous projects.

```xml
<dependency>
    <groupId>com.sparkjava</groupId>
    <artifactId>spark-core</artifactId>
    <version>2.3</version>
</dependency>
<dependency>
    <groupId>com.sparkjava</groupId>
    <artifactId>spark-template-mustache</artifactId>
    <version>2.3</version>
</dependency>
```

* Create a `templates` folder inside of the main resources folder.
* Create `resources/templates/index.html` which looks like in the first screenshot below.
* Create a GET route for "/" and a POST route for "/create-user" and "/create-message".
* When the user hits submit in "index.html", it should post the name to "/create-user" which saves it in a user object and redirects to "/".
* Create `resources/templates/messages.html` which looks like the second screenshot below. It must display the name given by the user, and use Mustache templating to list the messages written by the user.
* When the user hits submit in "messages.html", it should post the text to "/create-message" which saves it in an `ArrayList<Message>` and redirects to "/" (i.e. refreshes the page).

![microblog screenshot1.png](https://tiy-learn-content.s3.amazonaws.com/b9a93c4b-microblog%20screenshot1.png)

![microblog screenshot2.png](https://tiy-learn-content.s3.amazonaws.com/574828f1-microblog%20screenshot2.png)


## Hard Mode
* In "index.html", add a password field. If the user doesn't exist, have it behave like usual; if it does exist, then check the password and return an error if it is wrong.

## Nightmare Mode
* If your messages are simple strings then make them an object
* Add a username to the object
* Only pass back the messages that user has created.  Given this assignment you might need to create a few message objects at the beginning of main since the user can't realy log out.

## Resources
* [Github Repo](https://github.com/tiy-lv-java-2016-06/Microblog)
* [Spark Documentation](http://sparkjava.com/documentation.html)
* [Mustache Documentation](https://mustache.github.io/mustache.5.html)
