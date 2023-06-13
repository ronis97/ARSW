package edu.escuelaing.arsw.react.interactivewhiteboard.Controller;


import edu.escuelaing.arsw.react.interactivewhiteboard.Entities.*;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class InteractiveWhiteBoardController {

    @Resource
    private HttpServletRequest request;

    @GetMapping("/setname")
    public String stringRequest(@RequestParam(value = "name", defaultValue = "World") String name){
        request.getSession().setAttribute("name", name);
        User user = new User(name);
        Board.getInstance().addUser(user);
        return String.format("Hello %s!", name);
    }

    @PostMapping("/drawpoints")
    public void addPoints(@RequestBody Point point){
        Board.getInstance().addPoint(point);
    }

    @GetMapping("/drawpoints")
    public List<Point> getAllPoints(){
        return Board.getInstance().getPointList();
    }

    @PostMapping("/restart")
    public void restart(){
        Board.getInstance().restart();
    }

    @GetMapping("/getusercolor")
    public Color getUserColor(){
        String name = (String) request.getSession().getAttribute("name");
        return Board.getInstance().getUserColor(name);
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 35000;
    }
}
