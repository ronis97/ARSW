package edu.escuelaing.arsw.picasyfamas.Controller;

import edu.escuelaing.arsw.picasyfamas.Entities.Game;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("game")
public class PicasyFamasController {

    private Game game;

    @GetMapping("/")
    public String getIndex(Model model){
        game = new Game();
        model.addAttribute("game",game);
        return "index";
    }

    @GetMapping("/picasyfamas")
    public String showGame(Model model){
        game.prepareRandomNumber();
        if(game.getNumber()!= 0){
            if(!game.playing() && game.isState()){
                System.out.println("Sigue intentando");
            }
            else if(!game.playing() && !game.isState()){
                System.out.println("Perdiste");
            }
            else if (game.playing() && game.isState()){
                game.setState(false);
                System.out.println("Ganaste");
            }
        }
        model.addAttribute("guess",game.getRandomNumber());
        model.addAttribute("game",game);
        model.addAttribute("number",game.getNumber());
        return "picasyfamas";
    }

    @PostMapping("/picasyfamas")
    public String readDigits(@Validated Game game, BindingResult result, Model model){
        model.addAttribute("game",game);
        return "redirect:picasyfamas";
    }
}
