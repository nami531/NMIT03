package nmi.nmit02e03.controller;

import java.time.LocalDate;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class WebController {
    
    private HashMap<String, String[]> achievements=new HashMap<>(); 

    @GetMapping({"/index", " ", "/", "/home"})
    public String showIndex(Model model) {
        model.addAttribute("year", LocalDate.now().getYear());
        return "indexView";
    }
    
    @GetMapping("/{user}")
    public String showNameUse(Model model , @PathVariable String user) {
        model.addAttribute("year", LocalDate.now().getYear());
        model.addAttribute("user", user);
        return "indexView";
    }
    

    @GetMapping("/team")
    public String showTeam(Model model) {
        achievements.put("Copa del Rey Runners-up", new String[] {"1947–48 (lost against Sevilla)", "1993–94 (lost against Real Zaragoza)", "2000–01 (lost against Real Zaragoza)"  }); 
        achievements.put("Participation in UEFA Champions League", new String[] {"2003–04 (eliminated in Round of 16 by Arsenal)"}); 
        achievements.put("Qualifications in UEFA Europa League", new String[] {"1998–99 (Quarter-finals)", "1999–2000 (Round of 16)", "2000–01 (Quarter-finals)", "2006–07 (Round of 32)", "2016–17 (Semi-finals, eliminated by Manchester United)"});
        achievements.put("Champion of the Spanish Second Division", new String[] {"1935–36", "1980–81", "1991–92"});
        model.addAttribute("achievements", achievements);
        return "teamView";
    }

    @GetMapping("/photos-gallery")
    public String showGallery() {
        return "photos-galleryView";
    }
    
    
}
