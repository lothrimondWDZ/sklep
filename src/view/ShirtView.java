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
import javax.swing.JCheckBox;
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
import model.Shirt;
import model.TshirtSize;

/**
 * 
 * Klasa przedstawiaj¹ca widok formularza dodawania, edycji i przegl¹dy koszul formalnych
 *
 */
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
    private JTable shirtTable;
    private ShirtList shirtList;
    private BufferedImage image;

    /**
     * Funkcja tworzaca widok formularza dodawania, edycji i przegl¹du koszul
     * 
     * @param addEditShow
     *            parametr okreœlaj¹cy dla jakiej z trzech opcji(edycja, dodawaie, przegl¹d) widok ma zostaæ wyœwietlony
     * @param actionName
     *            parametr okeœlajacy nazwê danej akcji
     * @param shirtTable
     *            parametr zawieraj¹cy tabelê koszul z g³ównego widoku, w celu dokonania w niej zmian
     * @param shirtList
     *            parametr zawieraj¹cy listê wszystkich koszul w aplikacji
     */
    public ShirtView(boolean addEditShow, String actionName, JTable shirtTable, ShirtList shirtList) {
	this.shirtList = shirtList;
	this.shirtTable = shirtTable;
	int selectedRowIndex;
	if (shirtTable.getSelectedRow() != -1) {
	    selectedRowIndex = shirtTable.convertRowIndexToModel(shirtTable.getSelectedRow());
	} else {
	    selectedRowIndex = shirtTable.getSelectedRow();
	}
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
	sizeComboBox.addItem(TshirtSize.L);
	sizeComboBox.addItem(TshirtSize.M);
	sizeComboBox.addItem(TshirtSize.S);
	sizeComboBox.addItem(TshirtSize.XL);
	sizeComboBox.addItem(TshirtSize.XS);
	sizeComboBox.addItem(TshirtSize.XXL);

	JComboBox genderComboBox = new JComboBox();
	genderComboBox.addItem(Gender.FEMALE);
	genderComboBox.addItem(Gender.MALE);
	genderComboBox.addItem(Gender.UNISEX);

	JLabel label_6 = new JLabel("Rodzaj :");

	JPanel imagePanel = new JPanel();
	JLabel imageCanvas = new JLabel();
	imagePanel.add(imageCanvas);

	colarSizeTextField = new JTextField();
	colarSizeTextField.setColumns(10);

	JCheckBox tieIncludedCheckBox = new JCheckBox("");
	/**
	 * Je¿eli wczeœniej wybrany by³ wiersz tabeli, wówczas dla opcji edycji i przegl¹du zostan¹ uzupe³nione odpowiednie pola
	 */
	if (!(selectedRowIndex < 0)) {
	    Shirt s = shirtList.get(selectedRowIndex);
	    priceTextField.setText(s.getPrice() != null ? s.getPrice().toString() : "");
	    nameTextField.setText(s.getName() != null ? s.getName() : "");
	    colorTextField.setText(s.getColor() != null ? s.getColor() : "");
	    brandTextField.setText(s.getBrand() != null ? s.getBrand() : "");
	    fabricTextField.setText(s.getFabric() != null ? s.getFabric() : "");
	    genderComboBox.setSelectedItem(s.getGender());
	    sizeComboBox.setSelectedItem(s.getSize());
	    tieIncludedCheckBox.setSelected(s.getTieIncluded());
	    colarSizeTextField.setText(s.getColarSize() != null ? s.getColarSize().toString() : "");
	    if (s.getImage() != null) {
		ImageIcon icon = new ImageIcon(s.getImage());
		imageCanvas.setIcon(icon);

		Dimension imageSize = new Dimension(icon.getIconWidth(), icon.getIconHeight());
		imageCanvas.setPreferredSize(imageSize);

		imageCanvas.revalidate();
		imageCanvas.repaint();
	    }
	}

	JLabel lblKonierzyk = new JLabel("Ko\u0142nierzyk :");

	JLabel lblKrawat = new JLabel("Krawat :");

	JButton addImageButton = new JButton("Przegl\u0105daj");
	addImageButton.addMouseListener(new MouseAdapter() {
	    /**
	     * Funkcja wyswietlaj¹ca okno wyboru obrazka i wczytuj¹ca obrazek koszuli
	     */
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
	    /**
	     * Funkcja zamykajace okno bez zapisywania zmian
	     */
	    @Override
	    public void mouseClicked(MouseEvent e) {
		hide();
	    }
	});

	JButton saveButton = new JButton("Zapisz");
	saveButton.addMouseListener(new MouseAdapter() {
	    /**
	     * Funkcja dodaj¹ca now¹ koszulê oraz zapisuj¹ca koszulê edytowan¹ w tabeli i liœcie koszul
	     */
	    @Override
	    public void mouseClicked(MouseEvent e) {
		Shirt s = selectedRowIndex == -1 ? new Shirt() : shirtList.get(selectedRowIndex);
		s.setBrand(!brandTextField.getText().isEmpty() ? brandTextField.getText() : null);
		s.setColor(!colorTextField.getText().isEmpty() ? colorTextField.getText() : null);
		s.setFabric(!fabricTextField.getText().isEmpty() ? fabricTextField.getText() : null);
		s.setName(!nameTextField.getText().isEmpty() ? nameTextField.getText() : null);
		s.setPrice(NumberUtils.createDouble(!priceTextField.getText().isEmpty() ? priceTextField.getText() : null));
		s.setGender((Gender) genderComboBox.getSelectedItem());
		s.setImage(image != null ? image : null);
		s.setSize((TshirtSize) sizeComboBox.getSelectedItem());
		s.setColarSize(NumberUtils.createInteger(!colarSizeTextField.getText().isEmpty() ? colarSizeTextField.getText() : null));
		DefaultTableModel model = ((DefaultTableModel) shirtTable.getModel());
		s.setTieIncluded(tieIncludedCheckBox.isSelected() ? true : false);
		if (selectedRowIndex != -1) {
		    shirtList.edit(s, selectedRowIndex);
		    model.setValueAt(s.getGender() != null ? s.getGender().toString() : "", selectedRowIndex, 0);
		    model.setValueAt(s.getName(), selectedRowIndex, 1);
		    model.setValueAt(s.getPrice() != null ? s.getPrice().toString() : "", selectedRowIndex, 2);
		    model.setValueAt(s.getColor(), selectedRowIndex, 3);
		    model.setValueAt(s.getBrand(), selectedRowIndex, 4);
		    hide();
		} else {
		    shirtList.add(s);
		    model.addRow(new Object[] { s.getGender() != null ? s.getGender().toString() : "", s.getName(),
	                    s.getPrice() != null ? s.getPrice().toString() : "", s.getColor(), s.getBrand() });
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
