package view;

import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JacketView extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		try {
		    JacketView frame = new JacketView();
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
    public JacketView() {
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);

	JLabel lblKurtaki = new JLabel("Kurta\u0142ki");
	GroupLayout gl_contentPane = new GroupLayout(contentPane);
	gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	        .addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblKurtaki).addContainerGap(368, Short.MAX_VALUE)));
	gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	        .addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblKurtaki).addContainerGap(229, Short.MAX_VALUE)));
	contentPane.setLayout(gl_contentPane);
    }

}
