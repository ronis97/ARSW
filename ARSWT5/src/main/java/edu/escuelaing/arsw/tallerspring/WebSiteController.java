package edu.escuelaing.arsw.tallerspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Todas las anotaciones son metadata :)
@SpringBootApplication
@RestController
public class WebSiteController {
    public static void main(String[] args) {
        SpringApplication.run(WebSiteController.class, args);
        Singleton.getInstance().getNumber();
    }

    @RequestMapping(
            value = "/status",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public String status() {
        return "{\"status\":\"Greetings from Spring Boot. "
                + java.time.LocalDate.now() + ", "
                + java.time.LocalTime.now()
                + ". " + "The server is Runnig!\"}";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @PostMapping("/helloPost")
    public String helloPost(@RequestParam(value = "postname", defaultValue = "World") String postname) {
        return String.format("Hello %s!", postname);
    }
}
