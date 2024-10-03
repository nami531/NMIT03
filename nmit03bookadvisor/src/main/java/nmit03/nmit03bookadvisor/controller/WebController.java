package nmit03.nmit03bookadvisor.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping({" ", "/", "/index"})
    public String showIndex(Model model){
        model.addAttribute("year", LocalDate.now().getYear()); 
        return "index"; 
    }

    @GetMapping("/about")
    public String showAbout(){
        return "about"; 
    }
}
