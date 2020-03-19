package Window;

import java.awt.EventQueue;

import javax.swing.JFrame;


import Polynomial.Interpreter;


import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Font;

public class GUI {

	public JFrame frame;
	public JTextField textField;
	public JTextField textField_1;
	public JButton btnNewButton;
	public JButton btnNewButton_1;
	public JButton btnNewButton_2;
	public JButton btnNewButton_3;
	public JButton btnNewButton_4;
	public JButton btnNewButton_5;
	public JTextField textField_2;
	public JTextPane txtpnInput;
	public JTextPane txtpnInput_2;
	public JTextPane txtpnInput_1;
	public JTextPane txtpnInput_3;
	public JTextField textField_3;
	public JTextField textField_4;
	public JButton btnInsertPolynom;
	public JTextPane txtpnInput_4;
	public JButton btnNewButton_6;
	public JButton btnNewButton_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
		update();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Polynomial Calculator");
		frame.setBounds(100, 100, 497, 384);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[10,grow][200px,grow][][86px][]", "[20px][][][][][][][][][][][]"));
		
		txtpnInput = new JTextPane();
		txtpnInput.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnInput.setEditable(false);
		txtpnInput.setText("Input 1");
		frame.getContentPane().add(txtpnInput, "cell 0 0,growx");
		
		textField = new JTextField();
		frame.getContentPane().add(textField, "cell 1 0,growx");
		textField.setColumns(10);
		
		btnNewButton = new JButton("Insert Polynom 1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(btnNewButton, "cell 3 0,growx");
		
		btnNewButton_1 = new JButton("Insert Polynom 2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		txtpnInput_2 = new JTextPane();
		txtpnInput_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnInput_2.setEditable(false);
		txtpnInput_2.setText("Input 2");
		frame.getContentPane().add(txtpnInput_2, "cell 0 1,growx");
		
		textField_1 = new JTextField();
		frame.getContentPane().add(textField_1, "cell 1 1,growx");
		textField_1.setColumns(10);
		frame.getContentPane().add(btnNewButton_1, "cell 3 1,growx");
		
		btnNewButton_2 = new JButton("+");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(btnNewButton_2, "flowx,cell 1 3,growx");
		
		btnNewButton_4 = new JButton("x");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnNewButton_3 = new JButton("-");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.getContentPane().add(btnNewButton_3, "cell 1 3,growx");
		frame.getContentPane().add(btnNewButton_4, "cell 1 3,growx");
		
		btnNewButton_5 = new JButton("/");
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.getContentPane().add(btnNewButton_5, "cell 1 3,growx");
		
		txtpnInput_1 = new JTextPane();
		txtpnInput_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnInput_1.setEditable(false);
		txtpnInput_1.setText("Output");
		frame.getContentPane().add(txtpnInput_1, "cell 0 5,growx");
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		frame.getContentPane().add(textField_2, "cell 1 5,growx");
		textField_2.setColumns(10);
		
		txtpnInput_3 = new JTextPane();
		txtpnInput_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnInput_3.setText("Input");
		txtpnInput_3.setEditable(false);
		frame.getContentPane().add(txtpnInput_3, "cell 0 8,growx");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		frame.getContentPane().add(textField_3, "cell 1 8,growx");
		
		btnInsertPolynom = new JButton("Insert Polynom ");
		frame.getContentPane().add(btnInsertPolynom, "cell 3 8,growx");
		
		btnNewButton_6 = new JButton("Derivation");
		frame.getContentPane().add(btnNewButton_6, "flowx,cell 1 9,growx");
		
		txtpnInput_4 = new JTextPane();
		txtpnInput_4.setText("Output");
		txtpnInput_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnInput_4.setEditable(false);
		frame.getContentPane().add(txtpnInput_4, "cell 0 10,growx");
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		frame.getContentPane().add(textField_4, "cell 1 10,growx");
		
		btnNewButton_7 = new JButton("Integration");
		frame.getContentPane().add(btnNewButton_7, "cell 1 9,growx");
	}
	
	public void update()
	{
		btnNewButton_2.addActionListener(new Interpreter(this));
		btnNewButton_3.addActionListener(new Interpreter(this));
		btnNewButton_4.addActionListener(new Interpreter(this));
		btnNewButton_5.addActionListener(new Interpreter(this));
		btnNewButton_6.addActionListener(new Interpreter(this));
		btnNewButton_7.addActionListener(new Interpreter(this));
		
	}

	

}
