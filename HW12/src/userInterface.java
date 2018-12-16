//String name = "Xiaoxiang Liu (Steven)";
//String netID = "xliu102";
//String assignment_number = "CSC_Homework_12"; 
//String lab_selection_ time = "MW 2:00PM - 3:15PM";
//String statement = "I did not collaborate with anyone on this assignment.";

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class userInterface extends JFrame implements ActionListener, ChangeListener, ItemListener{
	private static final long serialVersionUID = 1L;
	JButton button, button2;
	JLabel label;
	JTextField textField;
	JSlider slider;
	JCheckBox boxA, boxB;
	
	int counter = 0, counter2 = 0, counter3 = 0;
	
	public userInterface() {
		JFrame frame = new JFrame("Homework 12");
		
		//Question 1
		button = new JButton("Click me");
		button.addActionListener(this);
		frame.add(button);
		
		//Question 2
		label = new JLabel("0", JLabel.LEFT);
		frame.add(label);
		
		//Question 3
		button2 = new JButton("Off");
		button2.addActionListener(this);
		frame.add(button2);
		
		//Question 4
		Action action = new AbstractAction()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		        System.out.println("RETURN is pressed!");
		        label.setText(textField.getText());
		    }
		};
		textField = new JTextField(30);
		textField.addActionListener(action);
		frame.add(textField);
		
		//Question 5
		slider = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
		slider.setMajorTickSpacing(5);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setBorder(
        BorderFactory.createEmptyBorder(0,0,10,0));
		slider.addChangeListener(this);
		frame.add(slider);
		
		//Question 6
		boxA = new JCheckBox("checkbox 1");
		boxB = new JCheckBox("checkbox 2");
		boxA.addItemListener(this);
		boxB.addItemListener(this);
		frame.add(boxA);
		frame.add(boxB);
		
		//Frame
		frame.setLayout(new FlowLayout());
		frame.setSize(480, 480);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e);
		//event of click-number button
		if (e.getSource() == button) {
			counter++;
			label.setText("" + counter);
		}
		//event of on/off button
		else if (e.getSource() == button2){
			counter2++;
			if(counter2 % 2 == 1) {
				button2.setText("On");
			}
			else {
				button2.setText("Off");
			}
		}
	}
	
	//Slider event
	public void stateChanged(ChangeEvent e) {
        if (e.getSource() == slider) {
        	counter3 = slider.getValue();
            label.setText(String.valueOf(counter3));
        }
    }

	//Checkbox event
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == boxA) {
			System.out.println("checkbox 1 is changed.");
			if(boxA.isSelected()) {
				System.out.println("Status: selected");
			}
			else {
				System.out.println("Status: unselected");
			}
		}
		else {
			System.out.println("checkbox 2 is changed.");
			if(boxB.isSelected()) {
				System.out.println("Status: selected");
			}
			else {
				System.out.println("Status: unselected");
			}
		}
		// TODO Auto-generated method stub
		System.out.println();
	}
	
	public static void main(String[] args) {
		userInterface user = new userInterface();
	}
	
}