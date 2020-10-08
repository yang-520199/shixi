package com.example.shixi.test;

import javax.swing.*;
import java.awt.*;

public class mainClass {
    public static  void main(String args[]){
        JFrame frame=new JFrame("设计图");
        frame.setLayout(new GridLayout(2,2,10,10));
        frame.add(new BarChart().getChartPanel());
        frame.setVisible(true);
    }
}
