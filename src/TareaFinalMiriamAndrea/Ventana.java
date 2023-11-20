package TareaFinalMiriamAndrea;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Ventana extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;


	public Ventana() {
		setTitle("GESTION DE PROGRAMAS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(186, 12, 10, 10);
		contentPane.add(panel);
		
		JLabel img2 = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img\\notepad.png").getImage().getScaledInstance(84, 91,Image.SCALE_DEFAULT));
		img2.setIcon(imageIcon);
		img2.setBounds(211, 26, 84, 91);
		contentPane.add(img2);
		
		JLabel img1 = new JLabel("");
		ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("img\\vs.png").getImage().getScaledInstance(84, 91,Image.SCALE_DEFAULT));
		img1.setIcon(imageIcon2);
		img1.setBounds(73, 26, 84, 91);
		contentPane.add(img1);
		
		JLabel img3 = new JLabel("");
		ImageIcon imageIcon3 = new ImageIcon(new ImageIcon("img\\postman.png").getImage().getScaledInstance(84, 91,Image.SCALE_DEFAULT));
		img3.setIcon(imageIcon3);
		img3.setBounds(325, 26, 84, 91);
		contentPane.add(img3);
		
		JButton visualStudio = new JButton("VisualStudio");
		visualStudio.setBounds(73, 128, 89, 23);
		contentPane.add(visualStudio);
		
		JButton notepad = new JButton("Notepad");
		notepad.setBounds(201, 128, 89, 23);
		contentPane.add(notepad);
		
		JButton postman = new JButton("Postman");
		postman.setBounds(325, 128, 89, 23);
		contentPane.add(postman);
		
		textField = new JTextField();
		textField.setBounds(53, 181, 224, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton navegar = new JButton("NAVEGAR");
		navegar.setBounds(341, 180, 89, 23);
		contentPane.add(navegar);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(53, 228, 372, 136);
		contentPane.add(textPane);
		
		JLabel lupa = new JLabel("");
		ImageIcon imageIcon4 = new ImageIcon(new ImageIcon("img\\lupa.png").getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT));
		lupa.setIcon(imageIcon4);
		lupa.setBounds(295, 184, 20, 20);
		contentPane.add(lupa);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
