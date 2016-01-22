package view;

import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ShirtView extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		try {
		    ShirtView frame = new ShirtView();
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
    public ShirtView() {
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);

	JLabel lblKoszulki = new JLabel("Koszulki");
	GroupLayout gl_contentPane = new GroupLayout(contentPane);
	gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	        .addGroup(gl_contentPane.createSequentialGroup().addGap(30).addComponent(lblKoszulki).addContainerGap(348, Short.MAX_VALUE)));
	gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	        .addGroup(gl_contentPane.createSequentialGroup().addGap(19).addComponent(lblKoszulki).addContainerGap(221, Short.MAX_VALUE)));
	contentPane.setLayout(gl_contentPane);
    }

}
