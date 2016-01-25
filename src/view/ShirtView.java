package view;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    private boolean addEditShow;
    private String actionName;

    /**
     * Create the frame.
     */
    public ShirtView(boolean addEditShow, String actionName) {
	this.addEditShow = addEditShow;
	this.actionName = actionName;
	setBounds(100, 100, 505, 417);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);

	JLabel lblKoszulki = new JLabel(this.actionName);
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

	JLabel lblKrawat = new JLabel("Krawat :");

	JCheckBox tieIncludedCheckBox = new JCheckBox("");

	JButton addImageButton = new JButton("Przegl\u0105daj");

	JButton cancelButton = new JButton("Anuluj");
	cancelButton.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		hide();
	    }
	});

	JButton saveButton = new JButton("Zapisz");

	colarSizeTextField = new JTextField();
	colarSizeTextField.setColumns(10);

	addImageButton.show(this.addEditShow);
	cancelButton.show(this.addEditShow);
	saveButton.show(this.addEditShow);
	nameTextField.enable(this.addEditShow);
	priceTextField.enable(this.addEditShow);
	colorTextField.enable(this.addEditShow);
	brandTextField.enable(this.addEditShow);
	fabricTextField.enable(this.addEditShow);
	colarSizeTextField.enable(this.addEditShow);
	sizeComboBox.setEnabled(this.addEditShow);
	genderComboBox.setEnabled(this.addEditShow);
	tieIncludedCheckBox.setEnabled(this.addEditShow);

	GroupLayout gl_contentPane = new GroupLayout(contentPane);
	gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
	        .addGroup(gl_contentPane.createSequentialGroup().addGap(205).addComponent(lblKoszulki).addContainerGap(218, Short.MAX_VALUE))
	        .addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
	                .addGroup(gl_contentPane
	                        .createParallelGroup(
	                                Alignment.LEADING)
	                        .addGroup(gl_contentPane.createSequentialGroup()
	                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
	                                        .addComponent(lblKrawat, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                        .addComponent(lblKonierzyk, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
	                                .addGap(18).addComponent(tieIncludedCheckBox)
	                                .addPreferredGap(ComponentPlacement.RELATED, 222, Short.MAX_VALUE).addComponent(saveButton)
	                                .addPreferredGap(ComponentPlacement.RELATED).addComponent(cancelButton))
	                        .addGroup(gl_contentPane.createSequentialGroup()
	                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
	                                        .addComponent(label_6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                        .addComponent(label_5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
	                                                Short.MAX_VALUE)
	                                .addComponent(label_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                .addComponent(label_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                .addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                .addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(
	                                        label_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                                .addGap(28)
	                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
	                                        .createSequentialGroup()
	                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
	                                                .addComponent(fabricTextField, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
	                                                .addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
	                                                .addComponent(priceTextField, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
	                                                .addComponent(colorTextField, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
	                                                .addComponent(brandTextField, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
	                                        .addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
	                                        .addComponent(imagePanel, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
	                                        .addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
	                                                .createParallelGroup(Alignment.TRAILING)
	                                                .addComponent(sizeComboBox, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
	                                                .addComponent(genderComboBox, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
	                                                .addComponent(colarSizeTextField, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
	                                                .addPreferredGap(ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
	                                                .addComponent(addImageButton)))))
	                .addGap(20)));
	gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	        .addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblKoszulki).addGap(0)
	                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	                        .addGroup(gl_contentPane.createSequentialGroup()
	                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	                                        .addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
	                                                GroupLayout.PREFERRED_SIZE)
	                                .addGroup(gl_contentPane.createSequentialGroup().addGap(3).addComponent(label)))
	                        .addGap(18)
	                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	                                .addComponent(priceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
	                                        GroupLayout.PREFERRED_SIZE)
	                                .addGroup(gl_contentPane.createSequentialGroup().addGap(3).addComponent(label_1)))
	                        .addGap(18)
	                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	                                .addComponent(colorTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
	                                        GroupLayout.PREFERRED_SIZE)
	                                .addGroup(gl_contentPane.createSequentialGroup().addGap(3).addComponent(label_2)))
	                        .addGap(18)
	                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	                                .addComponent(brandTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
	                                        GroupLayout.PREFERRED_SIZE)
	                                .addGroup(gl_contentPane.createSequentialGroup().addGap(3).addComponent(label_3)))
	                        .addGap(18)
	                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	                                .addComponent(fabricTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
	                                        GroupLayout.PREFERRED_SIZE)
	                                .addGroup(gl_contentPane.createSequentialGroup().addGap(3).addComponent(label_4)))
	                        .addGap(18)
	                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	                                .addComponent(sizeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                                .addGroup(gl_contentPane.createSequentialGroup().addGap(3).addComponent(label_5).addGap(18)
	                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(label_6).addComponent(
	                                                genderComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
	                                                GroupLayout.PREFERRED_SIZE)))))
	                        .addGroup(gl_contentPane.createSequentialGroup()
	                                .addComponent(imagePanel, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE).addGap(
	                                        18)
	                                .addComponent(addImageButton)))
	        .addGap(9)
	        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	                .addGroup(gl_contentPane.createSequentialGroup().addGap(18)
	                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblKonierzyk).addComponent(
	                                colarSizeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addGap(11)
	                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(lblKrawat).addComponent(tieIncludedCheckBox)))
	                .addGroup(gl_contentPane.createSequentialGroup().addGap(29).addGroup(
	                        gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(cancelButton).addComponent(saveButton))))
	        .addContainerGap(19, Short.MAX_VALUE)));
	contentPane.setLayout(gl_contentPane);
    }
}
