package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.lang3.math.NumberUtils;

import model.Gender;
import model.Tshirt;

public class TshirtView extends JFrame {

    private JPanel contentPane;
    private JTextField nameTextField;
    private JTextField priceTextField;
    private JTextField colorTextField;
    private JTextField brandTextField;
    private JTextField fabricTextField;
    private boolean addEditShow;
    private String actionName;
    private JTable tshirtTable;
    private TShirtList tshirtList;
    private BufferedImage image;

    /**
     * Create the frame.
     * 
     * @param tshirtList
     * @param tshirtTable
     */
    public TshirtView(boolean addEditShow, String actionName, JTable tshirtTable, TShirtList tshirtList) {
	this.tshirtList = tshirtList;
	this.tshirtTable = tshirtTable;
	int selectedRowIndex;
	if (tshirtTable.getSelectedRow() != -1) {
	    selectedRowIndex = tshirtTable.convertRowIndexToModel(tshirtTable.getSelectedRow());
	} else {
	    selectedRowIndex = tshirtTable.getSelectedRow();
	}
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
	genderComboBox.addItem(Gender.FEMALE);
	genderComboBox.addItem(Gender.MALE);
	genderComboBox.addItem(Gender.UNISEX);

	JPanel imagePanel = new JPanel();
	JLabel imageCanvas = new JLabel();
	imagePanel.add(imageCanvas);

	if (!(selectedRowIndex < 0)) {
	    Tshirt t = tshirtList.get(selectedRowIndex);
	    priceTextField.setText(t.getPrice() != null ? t.getPrice().toString() : "");
	    nameTextField.setText(t.getName() != null ? t.getName() : "");
	    colorTextField.setText(t.getColor() != null ? t.getColor() : "");
	    brandTextField.setText(t.getBrand() != null ? t.getBrand() : "");
	    fabricTextField.setText(t.getFabric() != null ? t.getFabric() : "");
	    genderComboBox.setSelectedItem(t.getGender());
	    if (t.getImage() != null) {
		ImageIcon icon = new ImageIcon(t.getImage());
		imageCanvas.setIcon(icon);

		Dimension imageSize = new Dimension(icon.getIconWidth(), icon.getIconHeight());
		imageCanvas.setPreferredSize(imageSize);

		imageCanvas.revalidate();
		imageCanvas.repaint();
	    }
	}

	JButton addImageButton = new JButton("Przegl\u0105daj");
	addImageButton.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		JFileChooser chooser = new JFileChooser();
		File file;
		chooser.showOpenDialog(null);
		file = chooser.getSelectedFile();

		try {
		    image = ImageIO.read(file);
		    ImageIcon icon = new ImageIcon(image);
		    imageCanvas.setIcon(icon);

		    Dimension imageSize = new Dimension(icon.getIconWidth(), icon.getIconHeight());
		    imageCanvas.setPreferredSize(imageSize);

		    imageCanvas.revalidate();
		    imageCanvas.repaint();
		} catch (IOException e1) {
		}
	    }

	});

	JButton cancelButton = new JButton("Anuluj");
	cancelButton.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		hide();
	    }
	});

	JButton saveButton = new JButton("Zapisz");
	saveButton.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		Tshirt t = selectedRowIndex == -1 ? new Tshirt() : tshirtList.get(selectedRowIndex);
		t.setBrand(!brandTextField.getText().isEmpty() ? brandTextField.getText() : null);
		t.setColor(!colorTextField.getText().isEmpty() ? colorTextField.getText() : null);
		t.setFabric(!fabricTextField.getText().isEmpty() ? fabricTextField.getText() : null);
		t.setName(!nameTextField.getText().isEmpty() ? nameTextField.getText() : null);
		t.setPrice(NumberUtils.createDouble(!priceTextField.getText().isEmpty() ? priceTextField.getText() : null));
		t.setGender((Gender) genderComboBox.getSelectedItem());
		t.setImage(image != null ? image : null);
		DefaultTableModel model = ((DefaultTableModel) tshirtTable.getModel());
		if (selectedRowIndex != -1) {
		    tshirtList.edit(t, selectedRowIndex);
		    model.setValueAt(t.getGender() != null ? t.getGender().toString() : "", selectedRowIndex, 0);
		    model.setValueAt(t.getName(), selectedRowIndex, 1);
		    model.setValueAt(t.getPrice() != null ? t.getPrice().toString() : "", selectedRowIndex, 2);
		    model.setValueAt(t.getColor(), selectedRowIndex, 3);
		    model.setValueAt(t.getBrand(), selectedRowIndex, 4);
		    hide();
		} else {
		    tshirtList.add(t);
		    model.addRow(new Object[] { t.getGender() != null ? t.getGender().toString() : "", t.getName(),
	                    t.getPrice() != null ? t.getPrice().toString() : "", t.getColor(), t.getBrand() });
		    hide();
		}
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
