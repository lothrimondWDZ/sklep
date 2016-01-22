package view;

import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PantsView extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		try {
		    PantsView frame = new PantsView();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    public PantsView() {
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);

	JLabel lblGatki = new JLabel("Gatki");
	GroupLayout gl_contentPane = new GroupLayout(contentPane);
	gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	        .addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblGatki).addContainerGap(368, Short.MAX_VALUE)));
	gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	        .addGroup(gl_contentPane.createSequentialGroup().addGap(28).addComponent(lblGatki).addContainerGap(212, Short.MAX_VALUE)));
	contentPane.setLayout(gl_contentPane);
    }

}
