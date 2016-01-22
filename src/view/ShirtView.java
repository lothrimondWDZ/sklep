package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class ShirtView extends JFrame {

    private JPanel contentPane;
    private JTextField nameTextField;
    private JTextField priceTextField;
    private JTextField colorTextField;
    private JTextField brandTextField;
    private JTextField fabricTextField;
    private JTextField colarSizeTextField;

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
	setBounds(100, 100, 505, 401);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);

	JLabel lblKoszulki = new JLabel("Koszulki");
	lblKoszulki.setFont(new Font("Tahoma", Font.BOLD, 14));

	nameTextField = new JTextField();
	nameTextField.setColumns(10);

	JLabel label = new JLabel("Nazwa :");

	JLabel label_1 = new JLabel("Cena :");

	priceTextField = new JTextField();
	priceTextField.setColumns(10);

	colorTextField = new JTextField();
	colorTextField.setColumns(10);

	JLabel label_2 = new JLabel("Kolor :");

	JLabel label_3 = new JLabel("Marka :");

	brandTextField = new JTextField();
	brandTextField.setColumns(10);

	fabricTextField = new JTextField();
	fabricTextField.setColumns(10);

	JLabel label_4 = new JLabel("Materia\u0142 :");

	JLabel label_5 = new JLabel("Rozmiar :");

	JComboBox sizeComboBox = new JComboBox();
	sizeComboBox.setEnabled(false);

	JComboBox genderComboBox = new JComboBox();
	genderComboBox.setEnabled(false);

	JLabel label_6 = new JLabel("Rodzaj :");

	JPanel imagePanel = new JPanel();

	JLabel lblKonierzyk = new JLabel("Ko\u0142nierzyk :");

	colarSizeTextField = new JTextField();
	colarSizeTextField.setColumns(10);

	JLabel lblKrawat = new JLabel("Krawat :");

	JCheckBox tieIncludedCheckBox = new JCheckBox("");

	JButton addImageButton = new JButton("Przegl\u0105daj");

	JButton cancelButton = new JButton("Anuluj");

	JButton saveButton = new JButton("Zapisz");
	GroupLayout gl_contentPane = new GroupLayout(contentPane);
	gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	        .addGroup(gl_contentPane.createSequentialGroup().addGap(205).addComponent(lblKoszulki).addContainerGap(237, Short.MAX_VALUE))
	        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup().addContainerGap()
	                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
	                        .addGroup(Alignment.LEADING,
	                                gl_contentPane.createSequentialGroup()
	                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblKonierzyk)
	                                                .addComponent(lblKrawat))
	                                .addGap(18)
	                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(tieIncludedCheckBox)
	                                        .addGroup(gl_contentPane.createSequentialGroup()
	                                                .addComponent(colarSizeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
	                                                        GroupLayout.PREFERRED_SIZE)
	                                                .addPreferredGap(ComponentPlacement.RELATED, 131, Short.MAX_VALUE).addComponent(saveButton)
	                                                .addPreferredGap(ComponentPlacement.RELATED).addComponent(cancelButton))))
	                        .addGroup(
	                                gl_contentPane.createParallelGroup(Alignment.LEADING)
	                                        .addGroup(gl_contentPane.createSequentialGroup()
	                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	                                                        .addGroup(gl_contentPane.createSequentialGroup()
	                                                                .addComponent(label, GroupLayout.PREFERRED_SIZE, 39,
	                                                                        GroupLayout.PREFERRED_SIZE)
	                                                                .addGap(35).addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, 86,
	                                                                        GroupLayout.PREFERRED_SIZE))
	                                        .addGroup(gl_contentPane.createSequentialGroup()
	                                                .addComponent(label_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE).addGap(42)
	                                                .addComponent(priceTextField, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
	                                        .addGroup(gl_contentPane.createSequentialGroup()
	                                                .addComponent(label_2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE).addGap(43)
	                                                .addComponent(colorTextField, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
	                                        .addGroup(gl_contentPane.createSequentialGroup()
	                                                .addComponent(label_3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE).addGap(38)
	                                                .addComponent(brandTextField, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
	                                        .addGroup(gl_contentPane.createSequentialGroup().addComponent(label_4).addGap(28)
	                                                .addComponent(fabricTextField, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
	                                .addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
	                                .addComponent(imagePanel, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
	                                .addGroup(gl_contentPane.createSequentialGroup()
	                                        .addComponent(label_6, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE).addGap(34)
	                                        .addComponent(genderComboBox, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)).addGroup(
	                                                Alignment.TRAILING,
	                                                gl_contentPane.createSequentialGroup()
	                                                        .addComponent(label_5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
	                                                        .addGap(29)
	                                                        .addComponent(sizeComboBox, GroupLayout.PREFERRED_SIZE, 86,
	                                                                GroupLayout.PREFERRED_SIZE)
	                                        .addPreferredGap(ComponentPlacement.RELATED, 200, Short.MAX_VALUE).addComponent(addImageButton))))
	                .addGap(20)));
	gl_contentPane
	        .setVerticalGroup(
	                gl_contentPane.createParallelGroup(Alignment.LEADING)
	                        .addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblKoszulki).addGap(0)
	                                .addGroup(gl_contentPane
	                                        .createParallelGroup(
	                                                Alignment.LEADING)
	                                        .addGroup(
	                                                gl_contentPane.createSequentialGroup()
	                                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	                                                                .addGroup(
	                                                                        gl_contentPane.createSequentialGroup().addGap(3).addComponent(label))
	                                                        .addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
	                                                                GroupLayout.PREFERRED_SIZE))
	                        .addGap(18)
	                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	                                .addGroup(gl_contentPane.createSequentialGroup().addGap(3).addComponent(label_1)).addComponent(priceTextField,
	                                        GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                        .addGap(18)
	                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	                                .addGroup(gl_contentPane.createSequentialGroup().addGap(3).addComponent(label_2)).addComponent(colorTextField,
	                                        GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                        .addGap(18)
	                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	                                .addGroup(gl_contentPane.createSequentialGroup().addGap(3).addComponent(label_3)).addComponent(brandTextField,
	                                        GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                        .addGap(18)
	                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	                                .addGroup(gl_contentPane.createSequentialGroup().addGap(3).addComponent(label_4)).addComponent(
	                                        fabricTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                        .addGap(18)
	                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	                                .addGroup(gl_contentPane.createSequentialGroup().addGap(3).addComponent(label_5))
	                                .addComponent(sizeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                        .addGap(18)
	                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	                                .addGroup(gl_contentPane.createSequentialGroup().addGap(3).addComponent(label_6)).addComponent(genderComboBox,
	                                        GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
	                .addGroup(gl_contentPane.createSequentialGroup()
	                        .addComponent(imagePanel, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE).addGap(18)
	                        .addComponent(addImageButton)))
	        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	                .addGroup(gl_contentPane.createSequentialGroup().addGap(18)
	                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblKonierzyk).addComponent(
	                                colarSizeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addGap(18)
	                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblKrawat).addComponent(tieIncludedCheckBox)))
	                .addGroup(gl_contentPane.createSequentialGroup().addGap(29).addGroup(
	                        gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(cancelButton).addComponent(saveButton))))
	        .addContainerGap(109, Short.MAX_VALUE)));
	contentPane.setLayout(gl_contentPane);
    }
}
