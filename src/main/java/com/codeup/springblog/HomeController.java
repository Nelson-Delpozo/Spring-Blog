package com.codeup.springblog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
class HomeController {

    @GetMapping("/landing")
    @ResponseBody
    public String hello() {
        return "This is the landing page!";
    }

    @GetMapping("/home")
    public String welcome() {
        return "home";
    }

    @GetMapping("/roll-dice")
    public String dice() {
        return "dice";
    }
    @GetMapping("/roll-dice/{num}")
    public String diceRoll(@PathVariable int num, Model model) {
        String result;
        int roll = (int) Math.floor(Math.random() * 6 + 1);

        if(num == roll){
            result = "You got it!";
        }else{
            result = "Sorry try again";
        }
        model.addAttribute("guess", num);
        model.addAttribute("roll",roll);
        model.addAttribute("result", result);
        return "dice";
    }

    @GetMapping("/space")
    @ResponseBody
    public String space() {
        return "you are in space!";
    }

    @GetMapping("/knuckle")
    @ResponseBody
    public String knuckle() {
        return "you are a knucklehead!";
    }
}


