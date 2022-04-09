package main;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

import com.google.zxing.WriterException;

// Java program to create a blank text field with a
// given initial text and given number of columns
public class TextField extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1;

	// JTextField
	static JTextField t;

	// JFrame
	static JFrame f;

	// JButton
	static JButton b;

	// label to display text
	static JLabel l;

	static String txt;

	// default constructor
	TextField() {
	}

	// main class
	public static void mainTextField() {
		// create a new frame to store text field and button
		f = new JFrame("textfield");

		// create a label to display text
		l = new JLabel("nothing entered");

		// create a new button
		b = new JButton("submit");

		txt = new String("");

		// create a object of the text class
		TextField te = new TextField();

		// addActionListener to button
		b.addActionListener(te);

		// create a object of JTextField with 16 columns and a given initial text
		t = new JTextField("enter the text", 16);

		// create a panel to add buttons and textfield
		JPanel p = new JPanel();

		// add buttons and textfield to panel
		p.add(t);
		p.add(b);
		p.add(l);

		// add panel to frame
		f.add(p);

		// set the size of frame
		f.setSize(300, 300);

		f.setVisible(true);
	}

	// if the button is pressed
	public void actionPerformed(ActionEvent ae) {
		String s = ae.getActionCommand();
		if (s.equals("submit")) {
			// set the text of the label to the text of the field
			txt = t.getText();
			String filePath = "JD.png";
			int size = 125;
			String fileType = "png";
			String qrCodeText = txt;
			File qrFile = new File(filePath);
			try {
				Generator.createQRImage(qrFile, qrCodeText, size, fileType);
			} catch (WriterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// set the text of field to blank
			t.setText(" ");
		}
	}
}
