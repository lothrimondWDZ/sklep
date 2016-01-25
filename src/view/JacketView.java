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

public class JacketView extends JFrame {

    private JPanel contentPane;
    private JTextField nameTextField;
    private JTextField priceTextField;
    private JTextField colorTextField;
    private JTextField brandTextField;
    private JTextField fabricTextField;
    private boolean addEditShow;
    private String actionName;

    /**
     * Create the frame.
     */
    public JacketView(boolean addEditShow, String actionName) {
	this.addEditShow = addEditShow;
	this.actionName = actionName;
	setBounds(100, 100, 500, 433);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);

	JLabel lblKurtaki = new JLabel(this.actionName);
	lblKurtaki.setFont(new Font("Tahoma", Font.BOLD, 14));

	JLabel lblNazwa = new JLabel("Nazwa :");

	nameTextField = new JTextField();
	nameTextField.setColumns(10);

	JLabel lblCena = new JLabel("Cena :");

	priceTextField = new JTextField();
	priceTextField.setColumns(10);

	JLabel lblKolor = new JLabel("Kolor :");

	colorTextField = new JTextField();
	colorTextField.setColumns(10);

	JLabel lblMarka = new JLabel("Marka :");

	brandTextField = new JTextField();
	brandTextField.setColumns(10);

	JLabel lblRozmiar = new JLabel("Rozmiar :");

	JComboBox sizeComboBox = new JComboBox();

	JLabel lblZamknicie = new JLabel("Zamkni\u0119cie :");

	JComboBox jacketClosinComboBox = new JComboBox();

	JLabel lblMateria = new JLabel("Materia\u0142 :");

	fabricTextField = new JTextField();
	fabricTextField.setColumns(10);

	JLabel lblRodzaj = new JLabel("Rodzaj :");

	JComboBox genderComboBox = new JComboBox();

	JLabel lblOcieplanie = new JLabel("Ocieplanie :");

	JCheckBox paddedCheckBox = new JCheckBox("");

	JPanel panel = new JPanel();

	JButton addImageButton = new JButton("Przegl\u0105daj");

	JButton cancelButton = new JButton("Anuluj");
	cancelButton.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		hide();
	    }
	});

	JButton saveButton = new JButton("Zapisz");

	nameTextField.enable(this.addEditShow);
	priceTextField.enable(this.addEditShow);
	colorTextField.enable(this.addEditShow);
	brandTextField.enable(this.addEditShow);
	sizeComboBox.setEnabled(this.addEditShow);
	jacketClosinComboBox.setEnabled(this.addEditShow);
	fabricTextField.enable(this.addEditShow);
	genderComboBox.setEnabled(this.addEditShow);
	paddedCheckBox.setEnabled(this.addEditShow);
	addImageButton.show(this.addEditShow);
	cancelButton.show(this.addEditShow);
	saveButton.show(this.addEditShow);

	GroupLayout gl_contentPane = new GroupLayout(contentPane);
	gl_contentPane
	        .setHorizontalGroup(
	                gl_contentPane
	                        .createParallelGroup(
	                                Alignment.LEADING)
	                        .addGroup(gl_contentPane.createSequentialGroup().addGap(173).addComponent(lblKurtaki).addContainerGap(196,
	                                Short.MAX_VALUE))
	                        .addGroup(
	                                gl_contentPane.createSequentialGroup().addContainerGap()
	                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblZamknicie)
	                                                .addComponent(lblNazwa).addComponent(lblCena).addComponent(lblKolor).addComponent(lblMarka)
	                                                .addComponent(lblRozmiar).addComponent(lblMateria).addComponent(lblRodzaj)
	                                                .addComponent(lblOcieplanie))
	                                        .addGap(18)
	                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	                                                .addGroup(gl_contentPane.createSequentialGroup()
	                                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
	                                                                .addComponent(fabricTextField).addComponent(nameTextField)
	                                                                .addComponent(priceTextField).addComponent(colorTextField)
	                                                                .addComponent(jacketClosinComboBox, 0, GroupLayout.DEFAULT_SIZE,
	                                                                        Short.MAX_VALUE)
	                                                        .addComponent(sizeComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                                        .addComponent(brandTextField)
	                                                        .addComponent(genderComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                                                .addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE).addGroup(
	                                                        gl_contentPane.createParallelGroup(Alignment.TRAILING)
	                                                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 240,
	                                                                        GroupLayout.PREFERRED_SIZE)
	                                                                .addComponent(addImageButton)))
	                                                .addGroup(gl_contentPane.createSequentialGroup().addComponent(paddedCheckBox)
	                                                        .addPreferredGap(ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
	                                                        .addComponent(saveButton).addPreferredGap(ComponentPlacement.RELATED)
	                                                        .addComponent(cancelButton)))
	                                        .addGap(29)));
	gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	        .addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblKurtaki).addGap(18)
	                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	                        .addGroup(gl_contentPane.createSequentialGroup()
	                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNazwa).addComponent(
	                                        nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                        .addGap(18)
	                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblCena).addComponent(priceTextField,
	                                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                        .addGap(18)
	                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblKolor).addComponent(colorTextField,
	                                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                        .addGap(18)
	                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblMarka).addComponent(brandTextField,
	                                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                        .addGap(18)
	                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblRozmiar).addComponent(sizeComboBox,
	                                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                        .addGap(18)
	                        .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(lblZamknicie).addComponent(
	                                jacketClosinComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                        .addGap(18)
	                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblMateria).addComponent(
	                                fabricTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                        .addGap(18)
	                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblRodzaj).addComponent(genderComboBox,
	                                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                        .addGap(18)
	                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblOcieplanie)
	                                .addComponent(paddedCheckBox)))
	                .addGroup(gl_contentPane.createSequentialGroup()
	                        .addComponent(panel, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE).addGap(18)
	                        .addComponent(addImageButton)))
	                .addContainerGap(16, Short.MAX_VALUE))
	        .addGroup(Alignment.TRAILING,
	                gl_contentPane.createSequentialGroup().addContainerGap(353, Short.MAX_VALUE)
	                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(cancelButton).addComponent(saveButton))
	                        .addContainerGap()));
	contentPane.setLayout(gl_contentPane);
    }

}
