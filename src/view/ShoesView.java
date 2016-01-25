package view;

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

public class ShoesView extends JFrame {

    private JPanel contentPane;
    private JTextField nameTextField;
    private JTextField priceTextField;
    private JTextField sizeTextField;
    private JTextField colorTextField;
    private JTextField brandTextField;
    private JTextField genderTextField;
    private boolean addEditShow;
    private String actionName;

    /**
     * Create the frame.
     */
    public ShoesView(boolean addEditShow, String actionName) {
	this.addEditShow = addEditShow;
	this.actionName = actionName;
	setBounds(100, 100, 510, 420);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);

	JLabel lblButki = new JLabel(this.actionName);
	lblButki.setFont(new Font("Tahoma", Font.BOLD, 14));

	JLabel lblNazwa = new JLabel("Nazwa :");

	nameTextField = new JTextField();
	nameTextField.setColumns(10);

	JLabel lblNewLabel = new JLabel("Cena :");

	priceTextField = new JTextField();
	priceTextField.setColumns(10);

	JLabel lblRozmiar = new JLabel("Rozmiar :");

	sizeTextField = new JTextField();
	sizeTextField.setColumns(10);

	JLabel lblKolor = new JLabel("Kolor :");

	colorTextField = new JTextField();
	colorTextField.setColumns(10);

	JLabel lblMarka = new JLabel("Marka :");

	brandTextField = new JTextField();
	brandTextField.setColumns(10);

	JLabel lblRodzaj = new JLabel("Rodzaj :");

	genderTextField = new JTextField();
	genderTextField.setColumns(10);

	JLabel lblObcas = new JLabel("Obcas :");

	JCheckBox heelCheckBox = new JCheckBox("");

	JLabel lblPromocja = new JLabel("Promocja :");

	JComboBox promotionComboBox = new JComboBox();

	JPanel panel = new JPanel();

	JButton addImageButton = new JButton("Przegl\u0105daj");

	JButton cancelButton = new JButton("Anuluj");

	JButton saveButton = new JButton("Zapisz");

	nameTextField.enable(this.addEditShow);
	priceTextField.enable(this.addEditShow);
	sizeTextField.enable(this.addEditShow);
	colorTextField.enable(this.addEditShow);
	brandTextField.enable(this.addEditShow);
	genderTextField.enable(this.addEditShow);
	heelCheckBox.setEnabled(this.addEditShow);
	promotionComboBox.setEnabled(this.addEditShow);
	addImageButton.show(this.addEditShow);
	cancelButton.show(this.addEditShow);
	saveButton.show(this.addEditShow);

	GroupLayout gl_contentPane = new GroupLayout(contentPane);
	gl_contentPane
	        .setHorizontalGroup(
	                gl_contentPane
	                        .createParallelGroup(
	                                Alignment.LEADING)
	                        .addGroup(gl_contentPane.createSequentialGroup()
	                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	                                        .addGroup(gl_contentPane.createSequentialGroup()
	                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblNazwa)
	                                                        .addComponent(lblNewLabel).addComponent(lblRozmiar).addComponent(lblKolor)
	                                                        .addComponent(lblMarka).addComponent(lblRodzaj).addComponent(lblObcas)
	                                                        .addComponent(lblPromocja))
	                                                .addGap(25)
	                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
	                                                        .addComponent(promotionComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                                        .addComponent(heelCheckBox).addComponent(genderTextField).addComponent(brandTextField)
	                                                        .addComponent(colorTextField).addComponent(sizeTextField).addComponent(priceTextField)
	                                                        .addComponent(nameTextField))
	                .addGap(31)
	                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(addImageButton)
	                        .addComponent(panel, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
	                        .addGroup(gl_contentPane.createSequentialGroup().addComponent(saveButton).addPreferredGap(ComponentPlacement.RELATED)
	                                .addComponent(cancelButton))))
	                .addGroup(gl_contentPane.createSequentialGroup().addGap(210).addComponent(lblButki))).addContainerGap(51, Short.MAX_VALUE)));
	gl_contentPane
	        .setVerticalGroup(
	                gl_contentPane.createParallelGroup(Alignment.LEADING)
	                        .addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblButki).addGap(12)
	                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
	                                        .addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
	                                                GroupLayout.PREFERRED_SIZE)
	                                        .addComponent(lblNazwa))
	        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	                .addGroup(gl_contentPane.createSequentialGroup().addGap(18)
	                        .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(lblNewLabel).addComponent(
	                                priceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addGap(18)
	                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(lblRozmiar).addComponent(sizeTextField,
	                        GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addGap(18)
	                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblKolor).addComponent(colorTextField,
	                        GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addGap(18)
	                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblMarka).addComponent(brandTextField,
	                        GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addGap(18)
	                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblRodzaj).addComponent(genderTextField,
	                        GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGap(18)
	                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblObcas).addComponent(heelCheckBox)).addGap(18)
	                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblPromocja).addComponent(promotionComboBox,
	                        GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
	                .addGroup(gl_contentPane.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
	                        .addComponent(panel, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE).addGap(18)
	                        .addComponent(addImageButton))).addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(cancelButton).addComponent(saveButton))
	        .addContainerGap()));
	contentPane.setLayout(gl_contentPane);
    }
}
