package nmit03e06.nmit03e06.service;

import org.springframework.stereotype.Service;

import lombok.Data;

@Data

@Service
public class MathService {
    private String operand1; 
    private String operand2; 

    public MathService(){
        this.operand1 = ""; 
        this.operand2 = ""; 
    }

    public String concatNumberOne(String num){
        return operand1 + num ;
    }

    public String concatNumberTwo(String num){
        return operand2 + num;
    }

    public int add(){
        int op1 = Integer.parseInt(operand1); 
        int op2 = Integer.parseInt(operand2); 
        return op1 + op2; 
    }
}
