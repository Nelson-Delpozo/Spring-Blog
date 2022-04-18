package com.codeup.springblog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String hello() {
        return "This is the landing page!";
    }

    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String add(@PathVariable int num1, @PathVariable int num2) {
        return "Your total is: " + (num1 + num2);
    }

    @GetMapping("/subtract/{num1}/from/{num2}")
    @ResponseBody
    public String subtract(@PathVariable int num1, @PathVariable int num2) {
        return "Your result is: " + (num1 - num2);
    }

    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiply(@PathVariable int num1, @PathVariable int num2) {
        return "Your result is: " + (num1 * num2);
    }

    @GetMapping("/divide/{num1}/by/{num2}")
    @ResponseBody
    public String divide(@PathVariable int num1, @PathVariable int num2) {
        return "Your result is: " + (num1 / num2);
    }

    @GetMapping("/home")
    public String welcome() {
        return "home";
    }

    @GetMapping("/roll-dice")
    public String dice() {
        return "dice";
    }


}


