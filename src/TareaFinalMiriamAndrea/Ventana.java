package TareaFinalMiriamAndrea;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;

public class Ventana extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	// Creamos una variable de la clase gestión para poder usar sus métodos
	GestionURL gestion;

	// CAMPOS DE TEXTO
	private JTextField textField;
	private JTextPane textPane;

	// BOTONES
	private JButton notepad;
	private JButton postman;
	private JButton visualStudio;
	private JButton navegar;
	private JButton abrirArchivoVS;
	
	private JFileChooser fileChooser;

	public Ventana() {
		setTitle("GESTION DE PROGRAMAS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 508);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		gestion = new GestionURL(); // Inicializamos gestión
		// Cargamos las URLs que tenemos en el fichero.
		gestion.cargarUrlsDesdeArchivo();

		inicializarComponentes();
		// Seteamos el textPane con la URLs
		for (String url : gestion.listaUrlsVisitadas) {
			textPane.setText(textPane.getText() + url + "\n");
		}
		
		// Inicializamos el JFileChooser
        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setDialogTitle("Abrir archivo");
	}

	private void inicializarComponentes() {

		JLabel img2 = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(
				new ImageIcon("img\\notepad.png").getImage().getScaledInstance(84, 91, Image.SCALE_DEFAULT));
		img2.setIcon(imageIcon);
		img2.setBounds(211, 26, 84, 91);
		contentPane.add(img2);

		JLabel img1 = new JLabel("");
		ImageIcon imageIcon2 = new ImageIcon(
				new ImageIcon("img\\vs.png").getImage().getScaledInstance(84, 91, Image.SCALE_DEFAULT));
		img1.setIcon(imageIcon2);
		img1.setBounds(73, 26, 84, 91);
		contentPane.add(img1);

		JLabel img3 = new JLabel("");
		ImageIcon imageIcon3 = new ImageIcon(
				new ImageIcon("img\\postman.png").getImage().getScaledInstance(84, 91, Image.SCALE_DEFAULT));
		img3.setIcon(imageIcon3);
		img3.setBounds(325, 26, 84, 91);
		contentPane.add(img3);

		visualStudio = new JButton("VisualStudio");
		visualStudio.setForeground(new Color(255, 248, 220));
		visualStudio.setBackground(new Color(255, 127, 80));
		visualStudio.setBounds(62, 128, 109, 23);
		visualStudio.addActionListener(this);
		contentPane.add(visualStudio);

		notepad = new JButton("Notepad");
		notepad.setBackground(new Color(255, 127, 80));
		notepad.setForeground(new Color(255, 248, 220));
		notepad.setBounds(201, 128, 89, 23);
		notepad.addActionListener(this);
		contentPane.add(notepad);

		postman = new JButton("Postman");
		postman.setForeground(new Color(255, 248, 220));
		postman.setBackground(new Color(255, 127, 80));
		postman.setBounds(325, 128, 89, 23);
		postman.addActionListener(this);
		contentPane.add(postman);

		textField = new JTextField();
		textField.setBounds(53, 181, 224, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		navegar = new JButton("NAVEGAR");
		navegar.setForeground(new Color(255, 255, 255));
		navegar.setBackground(new Color(100, 149, 237));
		navegar.setBounds(341, 180, 89, 23);
		navegar.addActionListener(this);
		contentPane.add(navegar);

		textPane = new JTextPane();
		textPane.setBackground(new Color(255, 248, 220));
		JScrollPane scrollPane = new JScrollPane(textPane);
		scrollPane.setBounds(53, 228, 372, 136);
		// Añadimos un MouseListener para poder escuchar desde el textPane el clic del
		// ratón
		textPane.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				enlaceClicado(evt);
			}
		});
		contentPane.add(scrollPane);

		JLabel lupa = new JLabel("");
		ImageIcon imageIcon4 = new ImageIcon(
				new ImageIcon("img\\lupa.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		lupa.setIcon(imageIcon4);
		lupa.setBounds(295, 184, 20, 20);
		contentPane.add(lupa);
		
		// Botón para abrir archivos con VisualStudio
		abrirArchivoVS = new JButton("Abrir archivo con VS");
		abrirArchivoVS.setBackground(new Color(255, 127, 80));
		abrirArchivoVS.setForeground(new Color(255, 248, 220));
		abrirArchivoVS.setBounds(140, 386, 210, 23);
		abrirArchivoVS.addActionListener(this); // Establecemos el listener para el botón
		contentPane.add(abrirArchivoVS);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == notepad) {
			ProcessBuilder pb = new ProcessBuilder("NOTEPAD");
			// Se crea una instancia de ProcessBuilder configurada para ejecutar el comando
			// "NOTEPAD". Esto significa que cuando se inicia el programa, se abrirá el Bloc
			// de notas.

			try {
				Process p = pb.start();
				// Se intenta iniciar el proceso utilizando pb.start(). Esto ejecutará el
				// comando configurado en ProcessBuilder. Si el proceso se inicia con éxito, se
				// obtendrá una instancia de Process que puede usarse para interactuar con el
				// proceso, aunque en este caso, no se hace nada con esta instancia.
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}

		if (e.getSource() == postman) {
			ProcessBuilder pb = new ProcessBuilder("C:\\ProgramData\\AndreaBlazquezMartin\\Postman\\Postman.exe");

			try {
				pb.start();

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		if (e.getSource() == visualStudio) {
			ProcessBuilder pb = new ProcessBuilder(
					"C:\\Users\\AndreaBlazquezMartin\\AppData\\Local\\Programs\\Microsoft VS Code\\Code.exe");

			try {
				pb.start();

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		if (e.getSource() == navegar) {
			// Código para navegar a la URL especificada por el usuario
			String url = textField.getText().trim();
			if (!url.isEmpty()) {
				if (Pattern.matches("^(http|https)?://[a-zA-Z0-9-.]+\\.[a-zA-Z]{2,6}(?::\\d{1,5})?$", url)) {
					gestion.abrirNavegadorConUrl(url);
					textField.setText("");
					textPane.setText("");
					gestion.guardarUrlsEnArchivo();

					for (String storedUrl : gestion.listaUrlsVisitadas) {
						textPane.setText(textPane.getText() + storedUrl + "\n");
					}
				} else {
					JOptionPane.showMessageDialog(null,"Debes introducir una URL válida");
					textField.setText("");
				}
				
			}

		}
		
		 if (e.getSource() == abrirArchivoVS) {
	            // Abrimos el cuadro de diálogo de selección de archivos
	            int resultado = fileChooser.showOpenDialog(this);

	            // Si el usuario seleccionó un archivo
	            if (resultado == JFileChooser.APPROVE_OPTION) {
	                // Obtenemos el archivo seleccionado
	                File archivoSeleccionado = fileChooser.getSelectedFile();
	                String archivo = archivoSeleccionado.getAbsolutePath();

	    	        ProcessBuilder pb = new ProcessBuilder("C:\\Users\\AndreaBlazquezMartin\\AppData\\Local\\Programs\\Microsoft VS Code\\Code.exe", archivo);
	    	        try {
	    	            pb.start();
	    	        } catch (IOException e2) {
	    	            e2.printStackTrace();
	    	        }
	               
	            }
	        }
		
	}

	// Añadimos esto para poder acceder a los links pinchado sobre ellos
	private void enlaceClicado(java.awt.event.MouseEvent evt) {

		// Nos dice desde que JtextPane se hico click
		JTextPane textPane = (JTextPane) evt.getSource();

		// Nos dice en qué parte de text pane se hizo click
		int offset = textPane.viewToModel(evt.getPoint());

		// Obtenemos el contenido de TextPane
		String contenido = textPane.getText();

		// Encontramos el inicio y fin de la url en la que se hizo clic
		int inicio = inicio(contenido, offset);
		int fin = fin(contenido, offset);

		// Verificamos si se encontró una url (inicio y fin no son -1)
		if (inicio != -1 && fin != -1) {

			// Obtenemos la URL que en se hizo clic
			String urlClicada = contenido.substring(inicio, fin);

			// Abrimos la URL en el navegador
			gestion.abrirNavegadorConUrl(urlClicada);
			textField.setText(urlClicada);
		}
	}

	// Creamos un método para encontrar el inicio de laURL en la posición dada
	private int inicio(String text, int pos) {

		// Nos movemos hacia atrás hasta encontrar un espacio en blanco o el inicio del
		// texto
		while (pos > 0 && !Character.isWhitespace(text.charAt(pos - 1))) {
			pos--;
		}
		return pos;
	}

	// Cremos un método para encontrar el final de laURL
	private int fin(String text, int pos) {
		int length = text.length();

		// Nos movemos hacia adelante hasta encontrar un espacio en blanco o el final
		// del texto
		while (pos < length && !Character.isWhitespace(text.charAt(pos))) {
			pos++;
		}
		return pos;
	}
	

}
