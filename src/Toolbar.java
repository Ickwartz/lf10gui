import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener{
	private JButton btnLogin;
	private JButton btnLogout;
	private StringListener sListener;
	
	private TextPanel textPanel;
	
	public Toolbar() {
		btnLogin = new JButton("Login");
		btnLogout = new JButton("Logout");

		btnLogin.addActionListener(this);
		btnLogout.addActionListener(this);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(btnLogin);
		add(btnLogout);
	}

	public void setSListener(StringListener sListener) {
		this.sListener = sListener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton) e.getSource();
		if (clickedButton == btnLogin)
			sListener.textTransmit("Login\n");
		else
			sListener.textTransmit("Logout\n");
	}

}
