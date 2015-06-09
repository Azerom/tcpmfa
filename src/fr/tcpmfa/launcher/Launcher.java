package fr.tcpmfa.launcher;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fr.tcpmfa.Main;

public class Launcher extends JFrame{
	

	private static final long serialVersionUID = -6523131672888748263L;
	private JPanel ButtonPanel;
	
	public Launcher(Frame parent){
		super("TCPMFA Launcher");

		this.setSize(500, 170);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		
		JButton launchBouton = new JButton("Launch");

		launchBouton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {        
				System.out.println("Lanchement ! Achtung !");
				Main.launch();
				setVisible(false);
				dispose(); 
			}  

		});
		
		
		JButton loadButton = new JButton("Load");
		loadButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Chargement de partie");
				int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Save ID :", JOptionPane.QUESTION_MESSAGE));
				System.out.println("Loading save n°" + id);
				Main.launch(id);
				setVisible(false);
				dispose(); 
			}
		});
		
		
		ButtonPanel = new JPanel();
		
		
		ButtonPanel.add(launchBouton);
		ButtonPanel.add(loadButton);
		
		this.add(ButtonPanel);
		
		
		this.setVisible(true);
	}
	
//	public void launchSaveAskDialog(){
//		new SaveAskDialog(this);
//	}
	
//	class SaveAskDialog extends JDialog implements ActionListener {
//		  public SaveAskDialog(JFrame parent) {
//		    super(parent, "Save Loading", true);
//		    this.setLocationRelativeTo(null);
//		    JPanel questionPanel = new JPanel();
//		    
//		    JFormattedTextField textField = new JFormattedTextField(NumberFormat.getIntegerInstance());
//		    textField.setPreferredSize(new Dimension(100, 25));
//		    questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.LINE_AXIS));
//		    questionPanel.add(new JLabel("Save ID :"));
//		    questionPanel.add(textField);
//		    
//		    getContentPane().add(questionPanel);
//		    JPanel buttonPanel = new JPanel();
//		    
//		    JButton button = new JButton("Launch"); 
//		    buttonPanel.add(button); 
//		    button.addActionListener(this);
//		    getContentPane().add(buttonPanel, BorderLayout.SOUTH);
//		    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//		    pack(); 
//		    setVisible(true);
//		  }
//		  public void actionPerformed(ActionEvent e) {
//			this.getParent().setVisible(false);
//			  
//		    setVisible(false); 
//		    dispose(); 
//		  }
//		}

}
