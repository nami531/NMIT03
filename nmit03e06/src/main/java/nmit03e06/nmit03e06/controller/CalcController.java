package nmit03e06.nmit03e06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import nmit03e06.nmit03e06.service.MathService;





@Controller
public class CalcController {
    
    @Autowired
    private MathService s; 

    private boolean opadded=false; 

    @GetMapping({"/","/home", "/index", " "})
    public String showIndex() {
        return "index";
    }
    
    @GetMapping("/digit/{number}")
    public String addNumber(Model model, @PathVariable String number) { 
        if (!opadded){
            s.setOperand1(s.getOperand1() + number); 
            System.out.println(s.getOperand1()); 
            
        } else {
            s.setOperand2(s.getOperand2() + number); 
            
        }
        model.addAttribute("operand1", s.getOperand1());
        model.addAttribute("operand2", s.getOperand2());
        return "index";
    }

    @GetMapping("/addition")
    public String additionPressed(Model model) {
        opadded = true; 
        model.addAttribute("operand1", s.getOperand1());
        model.addAttribute("operand2", s.getOperand2());
        return "index";
    }
    
    @GetMapping("/clear")
    public String clearIndex(){
        s.setOperand1(""); 
        s.setOperand2(""); 
        opadded=false; 
        return "redirect:/index"; 
    }

    @GetMapping("/equals")
    public String showResult(Model model){
        int result = s.add(); 
        model.addAttribute("operand1", s.getOperand1());
        model.addAttribute("operand2", s.getOperand2());
        model.addAttribute("result", result); 
        return "index"; 
    }

}
