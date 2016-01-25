package view;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class TshirtView extends JFrame {

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
    public TshirtView(boolean addEditShow, String actionName) {
	this.addEditShow = addEditShow;
	this.actionName = actionName;
	setBounds(100, 100, 509, 400);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);

	JLabel lblKoszulki = new JLabel(this.actionName);
	lblKoszulki.setFont(new Font("Tahoma", Font.BOLD, 14));

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

	JLabel lblMateria = new JLabel("Materia\u0142 :");

	fabricTextField = new JTextField();
	fabricTextField.setColumns(10);

	JLabel lblRozmiar = new JLabel("Rozmiar :");

	JComboBox sizeComboBox = new JComboBox();

	JLabel lblRodzaj = new JLabel("Rodzaj :");

	JComboBox genderComboBox = new JComboBox();

	JPanel imagePanel = new JPanel();

	JButton addImageButton = new JButton("Przegl\u0105daj");

	JButton cancelButton = new JButton("Anuluj");
	cancelButton.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		hide();
	    }
	});

	JButton saveButton = new JButton("Zapisz");

	addImageButton.show(this.addEditShow);
	cancelButton.show(this.addEditShow);
	saveButton.show(this.addEditShow);
	nameTextField.enable(this.addEditShow);
	priceTextField.enable(this.addEditShow);
	colorTextField.enable(this.addEditShow);
	brandTextField.enable(this.addEditShow);
	fabricTextField.enable(this.addEditShow);
	sizeComboBox.setEnabled(this.addEditShow);
	genderComboBox.setEnabled(this.addEditShow);

	GroupLayout gl_contentPane = new GroupLayout(contentPane);
	gl_contentPane
	        .setHorizontalGroup(
	                gl_contentPane
	                        .createParallelGroup(
	                                Alignment.TRAILING)
	                        .addGroup(
	                                gl_contentPane.createSequentialGroup().addContainerGap()
	                                        .addGroup(
	                                                gl_contentPane.createParallelGroup(Alignment.TRAILING)
	                                                        .addGroup(
	                                                                gl_contentPane.createSequentialGroup().addComponent(saveButton)
	                                                                        .addPreferredGap(
	                                                                                ComponentPlacement.RELATED)
	                                                                        .addComponent(
	                                                                                cancelButton))
	                                                        .addGroup(gl_contentPane.createSequentialGroup()
	                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	                                                                        .addComponent(lblNazwa).addComponent(lblCena).addComponent(lblKolor)
	                                                                        .addComponent(lblMarka).addComponent(lblMateria)
	                                                                        .addComponent(lblRozmiar).addComponent(lblRodzaj))
	                                                        .addGap(28)
	                                                        .addGroup(
	                                                                gl_contentPane.createParallelGroup(Alignment.LEADING, false)
	                                                                        .addComponent(genderComboBox, 0, GroupLayout.DEFAULT_SIZE,
	                                                                                Short.MAX_VALUE)
	                                                                        .addComponent(fabricTextField).addComponent(brandTextField)
	                                                                        .addComponent(colorTextField).addComponent(priceTextField)
	                                                                        .addComponent(nameTextField).addComponent(sizeComboBox, 0,
	                                                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                        .addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
	                        .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
	                                .addComponent(imagePanel, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
	                                .addComponent(addImageButton)))).addGap(31))
	        .addGroup(Alignment.LEADING,
	                gl_contentPane.createSequentialGroup().addGap(188).addComponent(lblKoszulki).addContainerGap(258, Short.MAX_VALUE)));
	gl_contentPane
	        .setVerticalGroup(
	                gl_contentPane.createParallelGroup(Alignment.LEADING)
	                        .addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblKoszulki).addGap(18)
	                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	                                        .addGroup(gl_contentPane.createSequentialGroup()
	                                                .addComponent(imagePanel, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
	                                                .addGap(18).addComponent(addImageButton))
	                        .addGroup(gl_contentPane.createSequentialGroup()
	                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNazwa).addComponent(
	                                        nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                                .addGap(18)
	                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblCena).addComponent(
	                                        priceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                                .addGap(18)
	                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblKolor).addComponent(
	                                        colorTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                                .addGap(18)
	                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblMarka).addComponent(
	                                        brandTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                                .addGap(18)
	                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblMateria).addComponent(
	                                        fabricTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                                .addGap(18)
	                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblRozmiar).addComponent(
	                                        sizeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                                .addGap(18)
	                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblRodzaj).addComponent(
	                                        genderComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
	        .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(cancelButton).addComponent(saveButton))
	        .addContainerGap()));
	contentPane.setLayout(gl_contentPane);
    }

}
