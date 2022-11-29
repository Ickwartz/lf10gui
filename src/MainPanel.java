import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JFrame{
    private Toolbar toolbar;
    private TextPanel textPanel;
    private FormPanel formPanel;
    private JButton clickmebutton;

    public MainPanel() {
        super("Mitarbeiterverwaltung");
        setSize(500, 400);

        setLayout(new BorderLayout());

        textPanel = new TextPanel();
        toolbar = new Toolbar();

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

        setVisible(true);
    }
}
