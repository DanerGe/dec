package app.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @Value("${dec-name}")
    private String name;

    @GetMapping("/index")
    @ResponseBody
    public String index(){
        return name;
    }
}
