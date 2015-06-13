/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

import java.util.Observable;

/**
 * The model class of the calculator application.
 */
public class Calculator extends Observable{
    private String mData = "", mData2 = "";
    
    /**
     * The available operators of the calculator.
     */
    public enum Operator {
        CLEAR,       // C
        CLEAR_ENTRY, // CE
        BACKSPACE,   // ⌫
        EQUAL,       // =
        PLUS,        // +
        MINUS,       // -
        TIMES,       // ×
        OVER,        // ⁄
        PLUS_MINUS,  // ±
        RECIPROCAL,  // 1/x
        PERCENT,     // %
        SQRT,        // √
        MEM_CLEAR,   // MC
        MEM_SET,     // MS
        MEM_PLUS,    // M+
        MEM_MINUS,   // M-
        MEM_RECALL   // MR
    }
    
    public void appendDigit(int digit) {
        // TODO code application logic here
        mData += String.valueOf(digit);
        getDisplay();
    }
    
    public void appendDot() {
        // TODO code application logic here
        mData += ".";
        getDisplay();
    }
    
    public void performOperation(Operator operator) {
        // TODO code application logic here
        switch(operator)
        {
            case PLUS:
                break;
            case MINUS:
                break;
            case TIMES:
                break;
            case OVER:
                break;
            case SQRT:
                break;
            case PERCENT:
                break;
            case CLEAR:
                break;
            case EQUAL:
                break;
        }
        getDisplay();
    }
    
    public String getDisplay() {
        // TODO code application logic here
        setChanged();
        notifyObservers(mData);
        return null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    }

}
