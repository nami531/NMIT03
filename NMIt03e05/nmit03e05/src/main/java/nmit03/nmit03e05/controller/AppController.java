package nmit03.nmit03e05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import nmit03.nmit03e05.service.MovieService;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class AppController {
    
    @Autowired
    private MovieService service; 
    
    private boolean added = false; 
    
    @GetMapping({"/", " ", "/index"})
    public String showIndex(Model model) {   
        if (!added){
            service.addMovie("Avatar"); 
            service.addMovie("Bohemian-Rhapsody"); 
            service.addMovie("Star-Wars_The-force-awakes");
            added=true; 
        }    
        model.addAttribute("movies", service.getMovies()); 
        return "index";
    }

    @GetMapping("/vote/{name}")
    public String voteMovie(@PathVariable String name) {
        service.vote(name);
        return "redirect:/index";
    }

    
}
