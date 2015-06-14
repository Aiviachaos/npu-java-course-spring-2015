/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *　CalculatorUI　Calculator類別
 * @author Administrator
 */
public class Controller implements ActionListener{
    private CalculatorUI mView;
    private Calculator mModel;
    
    public Controller(Calculator model, CalculatorUI view)
    {
        mModel = model;
        mView = view;
    }
    
    /**
     * 運算子事件設定
     * @param ae 
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        String s = ae.getSource().toString().substring(ae.getSource().toString().indexOf("text=")+5, ae.getSource().toString().lastIndexOf(","));
        switch(s)
        {
            case "+":
                mModel.performOperation(Calculator.Operator.PLUS);
                break;
            case "-":
                mModel.performOperation(Calculator.Operator.MINUS);
                break;
            case "*":
                mModel.performOperation(Calculator.Operator.TIMES);
                break;
            case "/":
                mModel.performOperation(Calculator.Operator.OVER);
                break;
            case "√":
                mModel.performOperation(Calculator.Operator.SQRT);
                break;
            case "%":
                mModel.performOperation(Calculator.Operator.PERCENT);
                break;
            case "C":
                mModel.performOperation(Calculator.Operator.CLEAR);
                break;
            case "=":
                mModel.performOperation(Calculator.Operator.EQUAL);
                break;
            case ".":
                mModel.appendDot();
                break;
            default:
                mModel.appendDigit(Integer.valueOf(s));
                break;
        }
    }
    
}
