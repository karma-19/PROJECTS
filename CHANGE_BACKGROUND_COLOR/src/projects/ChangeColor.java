package projects;
import java.util.Random;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChangeColor extends Frame implements ActionListener {
	//this project changes color when button is clicked
	public static void main(String args[]){
		JFrame f = new JFrame("CHANGING BACKGROUND COLOR");
		JButton btn = new JButton("Click to Change Background Color");
		btn.setBounds(50, 100, 250, 30);
		f.add(btn);
		JLabel lbl = new JLabel("Color will be showing here");
		lbl.setBounds(50, 200, 190, 30);
		lbl.setOpaque(true);
		lbl.setBackground(Color.WHITE);
		f.add(lbl);
		
		btn.addActionListener( new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String b = btn.getText();
				Random rand = new Random();
				Color c;
				if(b=="Click to Change Background Color"){
					int red = rand.nextInt(255);
					int green = rand.nextInt(255);
					int blue = rand.nextInt(255);
					f.getContentPane().setBackground(new Color(red, green, blue));
					lbl.setText("Color is : RGB(" + red +", " + green + ", " +blue +")");
				}
			}
			
		});
		
		f.setSize(500, 500);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
