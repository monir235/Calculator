import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class UpperCaseConverter extends JFrame implements ActionListener {

	
	JLabel l,r;
	JTextArea t1,t2;
	JButton B;
	Font customf;
	
	public UpperCaseConverter()
	{
		super("UPPER CASE CONVERTER");
		l=new JLabel("Give a Text : ");
		
		r=new JLabel ("TEXT IN UPPER CASE : ");
		t1=new JTextArea(7,45);
		t2 = new JTextArea(7,45);
		B = new JButton("CONVERT");
		customf = new Font("Arial", Font.PLAIN,25);
		setLayout(new FlowLayout(FlowLayout.LEFT,150,30));
		add(l);
		add(t1);
		add(r);
		add(t2);
		add(B);
		t1.setBackground(Color.blue);
		t1.setForeground(Color.white);
		t1.setFont(customf);
		t2.setBackground(Color.blue);
		t2.setForeground(Color.white);
		t2.setFont(customf);
		B.addActionListener(this);
		B.setBackground(Color.blue);
		B.setForeground(Color.white);
		l.setFont(customf);
		r.setFont(customf);
		
		
		setSize(1300,1300);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		String s = t1.getText();
		String s1 = s.toUpperCase();
		t2.setText(s1);
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UpperCaseConverter();

	}

}
