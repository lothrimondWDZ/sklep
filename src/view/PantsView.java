package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Gender;
import model.Pants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantsView extends JFrame {

	private JPanel contentPane;
    private JTextField nameTextField;
    private JTextField priceTextField;
    private JTextField colorTextField;
    private JTextField brandTextField;
    private JTextField fabricTextField;
    private boolean addEditShow;
    private String actionName;
    private JTextField lengthTextField;
    private JTextField obwodTextField;

    /**
     * Create the frame.
     */
    public PantsView(boolean addEditShow, String actionName) {
    	this.addEditShow = addEditShow;
    	this.actionName = actionName;
    	setBounds(100, 100, 509, 400);
    	contentPane = new JPanel();
    	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    	setContentPane(contentPane);

    	JLabel lblSpodni = new JLabel(this.actionName);
    	lblSpodni.setFont(new Font("Tahoma", Font.BOLD, 14));

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

    	JLabel lblDugo = new JLabel("Długość :");
    	
    	lengthTextField = new JTextField();
    	lengthTextField.setColumns(10);
    	
    	JLabel lblObwdPasa = new JLabel("Obwód :");

    	obwodTextField = new JTextField();
    	obwodTextField.setColumns(10);
    	
    	JLabel lblRodzaj = new JLabel("Rodzaj :");

    	JComboBox genderComboBox = new JComboBox();

    	JPanel imagePanel = new JPanel();

    	JButton addImageButton = new JButton("Przegl\u0105daj");

    	JButton cancelButton = new JButton("Anuluj");

    	JButton saveButton = new JButton("Zapisz");
    	saveButton.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent e) {
    			Pants p = new Pants();
    			p.setBrand(brandTextField.getText());
    			p.setColor(colorTextField.getText());
    			p.setFabric(fabricTextField.getText());
    			p.setLength(Integer.valueOf(lengthTextField.getText()));
    			p.setName(nameTextField.getText());
    			p.setPrice(Double.valueOf(priceTextField.getText()));
    			p.setWaistSize(Integer.valueOf(obwodTextField.getText()));
    			System.out.println("Zapisuje: " + p);
    		}
    	});

    	addImageButton.show(this.addEditShow);
    	cancelButton.show(this.addEditShow);
    	saveButton.show(this.addEditShow);
    	nameTextField.enable(this.addEditShow);
    	priceTextField.enable(this.addEditShow);
    	colorTextField.enable(this.addEditShow);
    	brandTextField.enable(this.addEditShow);
    	fabricTextField.enable(this.addEditShow);
    	lengthTextField.enable(this.addEditShow);
    	obwodTextField.enable(this.addEditShow);
    	genderComboBox.setEnabled(this.addEditShow);
    	
    	GroupLayout gl_contentPane = new GroupLayout(contentPane);
    	gl_contentPane.setHorizontalGroup(
    		gl_contentPane.createParallelGroup(Alignment.LEADING)
    			.addGroup(gl_contentPane.createSequentialGroup()
    				.addContainerGap()
    				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
    					.addGroup(gl_contentPane.createSequentialGroup()
    						.addComponent(saveButton)
    						.addPreferredGap(ComponentPlacement.RELATED)
    						.addComponent(cancelButton))
    					.addGroup(gl_contentPane.createSequentialGroup()
    						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
    							.addGroup(gl_contentPane.createSequentialGroup()
    								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
    									.addComponent(lblNazwa)
    									.addComponent(lblCena)
    									.addComponent(lblKolor)
    									.addComponent(lblMarka)
    									.addComponent(lblMateria)
    									.addComponent(lblRodzaj)
    									.addComponent(lblDugo))
    								.addGap(28)
    								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
    									.addComponent(lengthTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
    										.addComponent(genderComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    										.addComponent(fabricTextField)
    										.addComponent(brandTextField)
    										.addComponent(colorTextField)
    										.addComponent(priceTextField)
    										.addComponent(nameTextField))))
    							.addGroup(gl_contentPane.createSequentialGroup()
    								.addComponent(lblObwdPasa)
    								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    								.addComponent(obwodTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
    						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
    							.addComponent(imagePanel, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
    							.addComponent(addImageButton))))
    				.addGap(31))
    			.addGroup(gl_contentPane.createSequentialGroup()
    				.addGap(188)
    				.addComponent(lblSpodni)
    				.addContainerGap(311, Short.MAX_VALUE))
    	);
    	gl_contentPane.setVerticalGroup(
    		gl_contentPane.createParallelGroup(Alignment.LEADING)
    			.addGroup(gl_contentPane.createSequentialGroup()
    				.addContainerGap()
    				.addComponent(lblSpodni)
    				.addGap(18)
    				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
    					.addGroup(gl_contentPane.createSequentialGroup()
    						.addComponent(imagePanel, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
    						.addGap(18)
    						.addComponent(addImageButton))
    					.addGroup(gl_contentPane.createSequentialGroup()
    						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    							.addComponent(lblNazwa)
    							.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    						.addGap(18)
    						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    							.addComponent(lblCena)
    							.addComponent(priceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    						.addGap(18)
    						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    							.addComponent(lblKolor)
    							.addComponent(colorTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    						.addGap(18)
    						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    							.addComponent(lblMarka)
    							.addComponent(brandTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    						.addGap(18)
    						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    							.addComponent(lblMateria)
    							.addComponent(fabricTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    						.addPreferredGap(ComponentPlacement.RELATED)
    						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    							.addComponent(obwodTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    							.addComponent(lblObwdPasa))
    						.addGap(14)
    						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    							.addComponent(lblDugo)
    							.addComponent(lengthTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    						.addPreferredGap(ComponentPlacement.RELATED)
    						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    							.addComponent(lblRodzaj)
    							.addComponent(genderComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
    				.addPreferredGap(ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
    				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    					.addComponent(cancelButton)
    					.addComponent(saveButton))
    				.addContainerGap())
    	);
    	contentPane.setLayout(gl_contentPane);
    }
}
