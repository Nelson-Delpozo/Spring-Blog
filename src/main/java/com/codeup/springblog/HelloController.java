package com.codeup.springblog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello from Spring!";
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number) {
        return number + " plus one is " + (number + 1) + "!";
    }

    @GetMapping("/bam")
    @ResponseBody
    public String bam() {
        return "bam bam, bam bam bam!";
    }

}
