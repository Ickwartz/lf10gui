import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPanel extends JPanel implements ActionListener{

    private JTextField nameInput;
    private JTextField pwInput;
    private JButton confirm;
    private StringListener sListener;

    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        Border insideBorder = BorderFactory.createTitledBorder("Mitarbeiterdaten: ");
        Border outsideBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));

        //name input
        JLabel nameLabel = new JLabel();
        nameInput = new JTextField(20);
        nameLabel.setText("Name: ");

        //password input
        JLabel pwLabel = new JLabel();
        pwInput = new JTextField(20);
        pwLabel.setText("Password: ");

        //confirm button
        confirm = new JButton("OK");

        this.add(nameLabel);
        this.add(nameInput);
        this.add(pwLabel);
        this.add(pwInput);
        this.add(confirm);

        confirm.addActionListener(this);

    }

    public void setSListener(StringListener sListener) {
        this.sListener = sListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        if (clickedButton == confirm) {
            sListener.textTransmit(String.format("Name: %s\n", nameInput.getText()));
            sListener.textTransmit(String.format("Password: %s\n", pwInput.getText()));
        }
    }

}
