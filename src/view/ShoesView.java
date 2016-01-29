package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

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
import model.Shoes;

/**
 * 
 * Klasa przedstawiajaca widok formularza dodawania, edycji i przeglady butow
 *
 */
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
    private JTable shoesTable;
    private ShoesList shoesList;
    private BufferedImage image;
    private PromotionList promotionList;
    private JLabel lblOd;

    /**
     * Funkcja tworzaca widok formularza dodawania, edycji i przegladu butow
     * 
     * @param addEditShow
     *            parametr okreslajacy dla jakiej z trzech opcji(edycja, dodawaie, przeglad) widok ma zostac wyswietlony
     * @param actionName
     *            parametr okreslajacy nazwe danej akcji
     * @param shoesTable
     *            parametr zawierajacy tabele butow z glownego widoku, w celu dokonania w niej zmian
     * @param shoesList
     *            parametr zawierajacy liste wszystkich butow w aplikacji
     * @param promotionList
     *            parametr zawierajacy liste wszystkich promocji
     */
    public ShoesView(boolean addEditShow, String actionName, JTable shoesTable, ShoesList shoesList, PromotionList promotionList) {
	this.promotionList = promotionList;
	this.shoesTable = shoesTable;
	this.shoesList = shoesList;
	int selectedRowIndex;
	if (shoesTable.getSelectedRow() != -1) {
	    selectedRowIndex = shoesTable.convertRowIndexToModel(shoesTable.getSelectedRow());
	} else {
	    selectedRowIndex = shoesTable.getSelectedRow();
	}
	this.addEditShow = addEditShow;
	this.actionName = actionName;
	setBounds(100, 100, 510, 454);
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

	JComboBox genderTextField = new JComboBox();
	genderTextField.addItem(Gender.FEMALE);
	genderTextField.addItem(Gender.MALE);
	genderTextField.addItem(Gender.UNISEX);

	JLabel lblObcas = new JLabel("Obcas :");

	JCheckBox heelCheckBox = new JCheckBox("");

	JLabel lblPromocja = new JLabel("Promocja :");

	JComboBox promotionComboBox = new JComboBox();
	promotionComboBox.addItem(promotionList.get(0).getReduction());
	promotionComboBox.addItem(promotionList.get(1).getReduction());
	promotionComboBox.addItem(promotionList.get(2).getReduction());
	promotionComboBox.addItem(promotionList.get(3).getReduction());

	JPanel panel = new JPanel();
	JLabel imageCanvas = new JLabel();
	panel.add(imageCanvas);
	JLabel lblCzasTrwaniaPromocji = new JLabel("Czas trwania promocji :");

	lblOd = new JLabel("od :");

	JLabel lblStartDate = new JLabel("");

	JLabel lblDo = new JLabel("do :");

	JLabel labelEndDate = new JLabel("");
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	/**
	 * Jezeli wczesniej wybrany byl wiersz tabeli, wowczas dla opcji edycji i przegladu zostana uzupelnione odpowiednie pola
	 */
	if (!(selectedRowIndex < 0)) {
	    Shoes p = shoesList.get(selectedRowIndex);
	    priceTextField.setText(p.getPrice() != null ? p.getPrice().toString() : "");
	    nameTextField.setText(p.getName() != null ? p.getName() : "");
	    colorTextField.setText(p.getColor() != null ? p.getColor() : "");
	    brandTextField.setText(p.getBrand() != null ? p.getBrand() : "");
	    sizeTextField.setText(p.getSize() != null ? p.getSize().toString() : "");
	    genderTextField.setSelectedItem(p.getGender());
	    heelCheckBox.setSelected(p.hasHeel());
	    if (p.getPromotion().getReduction().equals("brak")) {
		lblStartDate.hide();
		labelEndDate.hide();
		lblCzasTrwaniaPromocji.hide();
		lblOd.hide();
		lblDo.hide();
	    }
	    promotionComboBox.setSelectedItem(p.getPromotion().getReduction());
	    lblStartDate.setText(sdf.format(p.getPromotion().getStartDate()));
	    labelEndDate.setText(sdf.format(p.getPromotion().getEndDate()));
	    if (p.getImage() != null) {
		ImageIcon icon = new ImageIcon(p.getImage());
		imageCanvas.setIcon(icon);

		Dimension imageSize = new Dimension(icon.getIconWidth(), icon.getIconHeight());
		imageCanvas.setPreferredSize(imageSize);

		imageCanvas.revalidate();
		imageCanvas.repaint();
	    }
	} else {
	    lblStartDate.hide();
	    labelEndDate.hide();
	    lblCzasTrwaniaPromocji.hide();
	    lblOd.hide();
	    lblDo.hide();
	}
	JButton addImageButton = new JButton("Przegl\u0105daj");
	addImageButton.addMouseListener(new MouseAdapter() {
	    /**
	     * Funkcja wyswietlajaca okno wyboru obrazka i wczytujaca obrazek butow
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
	     * Funkcja dodajaca nowe buty oraz zapisujaca buty edytowane w tabeli i liscie butow
	     */
	    @Override
	    public void mouseClicked(MouseEvent e) {
		Shoes s = selectedRowIndex == -1 ? new Shoes() : shoesList.get(selectedRowIndex);
		s.setBrand(!brandTextField.getText().isEmpty() ? brandTextField.getText() : null);
		s.setColor(!colorTextField.getText().isEmpty() ? colorTextField.getText() : null);
		s.setSize(NumberUtils.createInteger(!sizeTextField.getText().isEmpty() ? sizeTextField.getText() : null));
		s.setName(!nameTextField.getText().isEmpty() ? nameTextField.getText() : null);
		s.setPrice(NumberUtils.createDouble(!priceTextField.getText().isEmpty() ? priceTextField.getText() : null));
		s.setGender((Gender) genderTextField.getSelectedItem());
		s.setImage(image != null ? image : null);
		s.setHeel(heelCheckBox.isSelected() ? true : false);
		s.setPromotion(promotionList.get(promotionComboBox.getSelectedIndex()));
		DefaultTableModel model = ((DefaultTableModel) shoesTable.getModel());
		if (selectedRowIndex != -1) {
		    shoesList.edit(s, selectedRowIndex);
		    model.setValueAt(s.getGender() != null ? s.getGender().toString() : "", selectedRowIndex, 0);
		    model.setValueAt(s.getName(), selectedRowIndex, 1);
		    model.setValueAt(s.getPrice() != null ? s.getPrice().toString() : "", selectedRowIndex, 2);
		    model.setValueAt(s.getColor(), selectedRowIndex, 3);
		    model.setValueAt(s.getBrand(), selectedRowIndex, 4);
		    model.setValueAt(s.getSize() != null ? s.getSize().toString() : "", selectedRowIndex, 5);
		    hide();
		} else {
		    shoesList.add(s);
		    model.addRow(new Object[] { s.getGender() != null ? s.getGender().toString() : "", s.getName(),
	                    s.getPrice() != null ? s.getPrice().toString() : "", s.getColor(), s.getBrand(),
	                    s.getSize() != null ? s.getSize().toString() : "" });
		    hide();
		}
	    }
	});

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
	                gl_contentPane.createParallelGroup(Alignment.LEADING)
	                        .addGroup(
	                                gl_contentPane.createSequentialGroup()
	                                        .addGroup(gl_contentPane
	                                                .createParallelGroup(
	                                                        Alignment.LEADING)
	                                                .addGroup(
	                                                        gl_contentPane.createSequentialGroup()
	                                                                .addGroup(
	                                                                        gl_contentPane
	                                                                                .createParallelGroup(
	                                                                                        Alignment.LEADING)
	                                                                                .addGroup(
	                                                                                        gl_contentPane.createSequentialGroup()
	                                                                                                .addGroup(gl_contentPane
	                                                                                                        .createParallelGroup(
	                                                                                                                Alignment.LEADING)
	                                                                                                        .addComponent(lblNazwa)
	                                                                                                        .addComponent(lblNewLabel)
	                                                                                                        .addComponent(lblRozmiar)
	                                                                                                        .addComponent(lblKolor)
	                                                                                                        .addComponent(lblMarka)
	                                                                                                        .addComponent(lblRodzaj)
	                                                                                                        .addComponent(
	                                                                                                                lblObcas)
	                                                .addComponent(lblPromocja)).addGap(
	                                                        25).addGroup(
	                                                                gl_contentPane.createParallelGroup(Alignment.LEADING, false)
	                                                                        .addComponent(promotionComboBox, 0, GroupLayout.DEFAULT_SIZE,
	                                                                                Short.MAX_VALUE)
	                                                                .addComponent(heelCheckBox)
	                                                                .addComponent(genderTextField, GroupLayout.PREFERRED_SIZE,
	                                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                                        .addComponent(brandTextField).addComponent(colorTextField).addComponent(sizeTextField)
	                                        .addComponent(priceTextField).addComponent(nameTextField)))
	                        .addComponent(lblCzasTrwaniaPromocji)
	                        .addGroup(gl_contentPane.createSequentialGroup().addComponent(lblOd)
	                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	                                        .addGroup(gl_contentPane.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED)
	                                                .addComponent(lblStartDate))
	                                .addGroup(gl_contentPane.createSequentialGroup().addGap(89).addComponent(lblDo)
	                                        .addPreferredGap(ComponentPlacement.RELATED).addComponent(labelEndDate)))))
	                .addGap(14)
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
	                        .addComponent(addImageButton)))
	        .addGroup(
	                gl_contentPane.createParallelGroup(Alignment.LEADING)
	                        .addGroup(gl_contentPane.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
	                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(cancelButton)
	                                        .addComponent(saveButton))
	                                .addContainerGap())
	                .addGroup(gl_contentPane.createSequentialGroup().addGap(18)
	                        .addComponent(lblCzasTrwaniaPromocji).addGap(7).addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
	                                .addComponent(lblOd).addComponent(lblStartDate).addComponent(lblDo).addComponent(labelEndDate))
	                        .addContainerGap()))));
	contentPane.setLayout(gl_contentPane);
    }
}
