/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
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
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
    
}
