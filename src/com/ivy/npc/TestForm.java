package com.ivy.npc;
import java.awt.*;
import java.awt.List;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import javax.swing.*;

public class TestForm {
	JButton button;
	JButton button1;
	JTextField txtnum1 , txtNum2;
	JLabel label1 , label2;
	JRadioButton add;
	JRadioButton sub;
	JRadioButton multiply;
	JRadioButton divide;
	JTextArea ta; 
	JPasswordField pf;
	
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		CreateShowForm();
		
		ArrayList<String> s = new ArrayList<String>();
		s.add("Goodluck");
		s.add("Sa exam");
		writeFile("C:\\Users\\Ruiz\\Documents\\output.txt", s);
		
		readFile("C:\\Users\\Ruiz\\Documents\\output.txt");
	}
	private void WriteToFile(String fileName)
	{
		//Panel panel = new Panel();
		//ButtonGroup bg = new ButtonGroup();
		//bg.add(add);
		//bg.add(sub);
		//bg.add(multiply);
		//bg.add(divide);
		//container.add(bg);
		//panel.add(bg);
		String message = ta.getText().toString();
		try
		{
			FileWriter pw = new FileWriter(fileName + "txt");
			pw.append(message);
			pw.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		String path = "";
		//for(String lines : Files.readAllLines(Paths.get(path));
		//{
			//do something in lines
		//}
	
	}
	public TestForm(){
		
		button = new JButton("Compute");
		button1 = new JButton("ClickMe");
		txtnum1 = new JTextField();
		txtNum2 = new JTextField();
		label1 = new JLabel("Enter First Number:");
		label2 = new JLabel("Enter Second Number:");
		add = new JRadioButton("+");
		sub = new JRadioButton("-");
		multiply = new JRadioButton("*");
		divide = new JRadioButton("/");
		ta = new JTextArea();
		pf = new JPasswordField();
	}
	public void AddControlToForm(Container container){
		container.setLayout(null);
		button.setBounds(300, 100, 100, 30); //x,y, width, height
		container.add(button);//button1
		button.addActionListener(new ButtonEventHandler());
		
		button1.setBounds(300, 135, 100, 30);
		container.add(button1);//button2
		button1.addActionListener(new ButtonEventHandler());
		
		txtnum1.setBounds(210, 50, 100, 20);
		container.add(txtnum1);
		txtNum2.setBounds(210 , 75 , 100, 20);
		container.add(txtNum2);
		
		label1.setBounds(50, 50, 150, 20);
		container.add(label1);
		label2.setBounds(50, 75, 150, 20);
		container.add(label2);
		
		add.setBounds(50, 100, 100, 20);
		sub.setBounds(50, 120,100 ,20);
		multiply.setBounds(50,140, 100, 20);
		divide.setBounds(50,160 ,100,20);
		container.add(add);
		container.add(sub);
		container.add(multiply);
		container.add(divide);
		
		ta.setBounds(50,200, 100, 50);
		ta.setColumns(10);
		ta.setRows(50);
		container.add(ta);
		
		pf.setBounds(100,300, 100, 20);
		container.add(pf);
		
	
	}
	public static void CreateShowForm(){
		JFrame frame = new JFrame("Ivy");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TestForm form = new TestForm();
		form.AddControlToForm(frame.getContentPane());
		frame.setSize(500 , 500);
		//frame.setLocation(300, 300);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	public void compute(){
		
		int num1 = Integer.parseInt(txtnum1.getText().toString());
		int num2 = Integer.parseInt(txtNum2.getText().toString());
		int sum = 0;
		
		//JOptionPane.showMessageDialog(null, "The Sum is ");
		if(add.isSelected())
			sum = num1 + num2;
		else if(sub.isSelected())
			sum = num1 - num2;
		else if(multiply.isSelected())
			sum = num1 * num2;
		else if(divide.isSelected())
			sum = num1 / num2;
		
		JOptionPane.showMessageDialog(null, "The Sum is " + sum);
	}
	private class ButtonEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			//Button b = (Button)e;
			if(e.getSource() == button)
			
				compute();
				//	JOptionPane.showMessageDialog(null, "Saranghae<3");
			else if(e.getSource() == button1)
				WriteToFile("C:\\Users\\Ruiz\\Documents\\bwi");
			//JOptionPane.showMessageDialog(arg0, arg1);
			
		}
	}
	public static void readFile(String fileName) throws IOException{
		Path path = Paths.get(fileName);
		try(BufferedReader reader  = Files.newBufferedReader(path)){
			String line = null;
			while((line = reader.readLine()) != null)
			{
				System.out.println(line);
				
			}
		}
	}
	private static void writeFile(String fileName, ArrayList<String>lines) throws IOException{
		Path path = Paths.get(fileName);
		try(BufferedWriter writer = Files.newBufferedWriter(path)){
			for(String line : lines)
			{
				writer.append(line);
				writer.newLine();
			}
		}
	}

}
