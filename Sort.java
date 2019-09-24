import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;


public class Sort extends SortingProg {

	/*
	 * Bryan Justo
	 * Sorting program
	 * Java
	 * https://github.com/BryanJusto
	 * https://www.linkedin.com/in/bryan-justo/
	 */
	
	private JFrame frame;
	private JTextField nm1;
	private JTextField nm2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
					try {
					Sort window = new Sort();
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
	public Sort() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		SortingProg tp = new SortingProg();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 509, 369);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		nm1 = new JTextField();
		nm1.setColumns(10);
		nm1.setBounds(10, 68, 473, 20);
		frame.getContentPane().add(nm1);
		
		JTextArea equals = new JTextArea();
		equals.setEditable(false);
		equals.setBounds(42, 10, 280, 31);
		frame.getContentPane().add(equals);
		
		JButton Quickbtn = new JButton("Quick");
		Quickbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equals.setText("");
				tp.delete();
				String[] parts = nm1.getText().split(" ");
				int[] n11 = new int[parts.length];
				for(int n = 0; n < parts.length; n++) {
				   n11[n] = Integer.parseInt(parts[n]);
				}
				int x1 = n11.length-1;
				
				nm2.setText(Arrays.toString(tp.quickSort(n11, 0, x1)));
				try {
					tp.prevReceipt();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					System.out.println("File not found?");
				}
				equals.setText(tp.rece.toString());
				tp.rece.setLength(0);
			}
		});
		Quickbtn.setBounds(211, 34, 89, 23);
		frame.getContentPane().add(Quickbtn);
		
		JButton Mergebtn = new JButton("Merge");
		Mergebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equals.setText("");
				tp.delete();
				String[] parts = nm1.getText().split(" ");
				int[] n11 = new int[parts.length];
				for(int n = 0; n < parts.length; n++) {
				   n11[n] = Integer.parseInt(parts[n]);
				}
				tp.sort(n11);		
				try {
					tp.prevReceipt();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				nm2.setText(Arrays.toString(n11));
				
				equals.setText(tp.rece.toString());
				tp.rece.setLength(0);
				
			}
		});
		Mergebtn.setBounds(310, 34, 89, 23);
		frame.getContentPane().add(Mergebtn);
		
		JButton Bubblebtn = new JButton("Bubble");
		Bubblebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				equals.setText("");
				tp.delete();
				nm2.setText(Arrays.toString(tp.bubble(nm1.getText())));
				try {
					tp.prevReceipt();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				equals.setText(tp.rece.toString());
				tp.rece.setLength(0);
			}
		});
		Bubblebtn.setBounds(112, 34, 89, 23);
		frame.getContentPane().add(Bubblebtn);
		
		nm2 = new JTextField();
		nm2.setEditable(false);
		nm2.setBounds(22, 276, 461, 43);
		frame.getContentPane().add(nm2);
		nm2.setColumns(10);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tp.delete();
			}
		});
		btnNewButton.setBounds(211, 11, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane(equals,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 99, 473, 166);
		frame.getContentPane().add(scrollPane);
	}
}
