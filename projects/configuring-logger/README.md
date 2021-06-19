**Note:** The previous article was [hello-reactive-spring-boot](../hello-reactive-spring-boot/). If you are unable to understand something, you can mail me at: [mainuls18@gmail.com](mailto:mainuls18@gmail.com). We will not repeat the same things again and again.

# Configuration
To configure the logging support for spring boot, we have to add the following properties in the application.properties file.

```
logging.level.org.springframework=INFO
logging.level.com.mainul35=ERROR
logging.file.name=logs/application.log
logging.file.max-size=10MB
logging.pattern.rolling-file-name=logs/application-%d{yyyy-MM-dd}.%i.log
logging.pattern.file=%d{yyyy-MMM-dd HH:mm:ss.SSS} %-5level [%thread] %logger{15} - %msg%n
```

# Controller
We have a simple controller, which just receives a GET request and responds with a message. To identify the class as a controller class we need to annotate it with @RestController annotation. This controller class has currently only one method, ``hello()``, which will intercept the GET request on the base path. To make this work, we had to annotate the method with ``@GetMapping`` annotation. In return, we are responding with a message: **Hello world** in Mono. 

```
@RestController
public class HelloController {
	
	@GetMapping({"", "/"})
	public Mono<String> hello() {
        return Mono.just("Hello world.");
    }

}
```
# Run Application
If your system has already maven in class path, then open terminal / PowerShell inside your project folder and run the following maven command.

```
mvn spring-boot:run
```
![Figure below shows the example.](../images/run-app.png)

You will see the application running on port 8080. However, if you are not familiar enough with terminal / PowerShell, then you can also run it from your favorite IDE. 



# Try with Postman
If you are excited to test your application, go to postman do a GET request to ``http://localhost:8080/``. If you see the response like the following screenshot, you have successfully created your very first reactive application.
![](../images/hello-world-response.png)
