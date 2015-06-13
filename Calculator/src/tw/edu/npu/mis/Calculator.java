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
    private String mData = "", mData2 = "", mE = "";
    
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
                mData2 = mData;
                mE = "+";
                mData = "";
                break;
            case MINUS:
                mData2 = mData;
                mE = "-";
                mData = "";
                break;
            case TIMES:
                mData2 = mData;
                mE = "*";
                mData = "";
                break;
            case OVER:
                mData2 = mData;
                mE = "/";
                mData = "";
                break;
            case SQRT:
                mData = String.valueOf(Math.sqrt(Double.valueOf(mData)));
                break;
            case PERCENT:
                if(!mData2.equals("") && !mData.equals("")) mData = String.valueOf((Double.valueOf(mData) * Double.valueOf(mData2))/100);
                break;
            case CLEAR:
                mData = "";
                mData2 = "";
                mE = "";
                break;
            case EQUAL:
                switch(mE)
                {
                    case "":
                        return;
                    case "+":
                        mData = String.valueOf(Double.valueOf(mData2) + Double.valueOf(mData));
                        break;
                    case "-":
                        mData = String.valueOf(Double.valueOf(mData2) - Double.valueOf(mData));
                        break;
                    case "*":
                        mData = String.valueOf(Double.valueOf(mData2) * Double.valueOf(mData));
                        break;
                    case "/":
                        mData = String.valueOf(Double.valueOf(mData2) / Double.valueOf(mData));
                        break;
                }
                break;
        }
        if(mData.length() > 1)if(mData.substring(mData.length()-2, mData.length()).equals(".0")) mData = mData.substring(0, mData.length() - 2);
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
        Calculator myModel = new Calculator();
        CalculatorUI myView = new CalculatorUI();
        Controller myController = new Controller(myModel, myView);
        myModel.addObserver(myView);
        myView.setController(myController);
    }

}
