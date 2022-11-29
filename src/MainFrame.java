import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainFrame extends JFrame{
	private JButton btn;
	private TextPanel textPanel; 
	private Toolbar  toolbar;
	private FormPanel formPanel;
	
	public MainFrame(String titel) {
		super(titel);
		
		setLayout(new BorderLayout());
		
		toolbar = new Toolbar();
		textPanel = new TextPanel();
		btn = new JButton("Click me");
		formPanel = new FormPanel();
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textPanel.appendText("Click \n");
			}		
		});

		toolbar.setSListener(new StringListener() {
			@Override
			public void textTransmit(String text) {
				textPanel.appendText(text);
			}
		});

		formPanel.setSListener(new StringListener() {
			@Override
			public void textTransmit(String text) {
				textPanel.appendText(text);
			}
		});

		add(toolbar, BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);
		add(formPanel, BorderLayout.WEST);
		
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
