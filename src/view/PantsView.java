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
import model.Pants;

/**
 * 
 * Klasa przedstawiajaca widok formularza dodawania, edycji i przegladu spodni
 *
 */
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
    private JTable pantsTable;
    private PantsList pantsList;
    private BufferedImage image;
    private PromotionList promotionList;

    /**
     * Funkcja tworzaca widok formularza dodawania, edycji i przegl�du spodni
     * 
     * @param addEditShow
     *            parametr okreslajacy dla jakiej z trzech opcji(edycja, dodawaie, przeglad) widok ma zostal wyswietlony
     * @param actionName
     *            parametr okeslajacy nazwe danej akcji
     * @param pantsTable
     *            parametr zawierajacy tabele spodni z glownego widoku, w celu dokonania w niej zmian
     * @param pantsList
     *            parametr zawierajacy liste wszystkich spodni w aplikacji
     * @param promotionList
     *            parametr zwierajacy liste wszystkich promocji
     */
    public PantsView(boolean addEditShow, String actionName, JTable pantsTable, PantsList pantsList, PromotionList promotionList) {
	this.promotionList = promotionList;
	this.pantsTable = pantsTable;
	this.pantsList = pantsList;
	int selectedRowIndex;
	if (pantsTable.getSelectedRow() != -1) {
	    selectedRowIndex = pantsTable.convertRowIndexToModel(pantsTable.getSelectedRow());
	} else {
	    selectedRowIndex = pantsTable.getSelectedRow();
	}
	this.addEditShow = addEditShow;
	this.actionName = actionName;
	setBounds(100, 100, 509, 473);
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

	JLabel lblDugo = new JLabel("D�ugo�� :");

	lengthTextField = new JTextField();
	lengthTextField.setColumns(10);

	JLabel lblObwdPasa = new JLabel("Obw�d :");

	obwodTextField = new JTextField();
	obwodTextField.setColumns(10);

	JLabel lblRodzaj = new JLabel("Rodzaj :");

	JComboBox genderComboBox = new JComboBox();
	genderComboBox.addItem(Gender.FEMALE);
	genderComboBox.addItem(Gender.MALE);
	genderComboBox.addItem(Gender.UNISEX);

	JPanel imagePanel = new JPanel();
	JLabel imageCanvas = new JLabel();
	imagePanel.add(imageCanvas);
	JLabel lblPromocja = new JLabel("Promocja :");

	JComboBox promotionComboBox = new JComboBox();
	promotionComboBox.addItem(promotionList.get(0).getReduction());
	promotionComboBox.addItem(promotionList.get(1).getReduction());
	promotionComboBox.addItem(promotionList.get(2).getReduction());
	promotionComboBox.addItem(promotionList.get(3).getReduction());

	JLabel lblPromocjaTrwa = new JLabel("Czas trwania promocji  :");

	JLabel lblOd = new JLabel("Od :");

	JLabel labelStartDate = new JLabel("");

	JLabel lblDo = new JLabel("Do :");

	JLabel labelEndDate = new JLabel("");
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	/**
	 * Jezeli wczesniej wybrany byl wiersz tabeli, wowczas dla opcji edycji i przegladu zostana uzupelnione odpowiednie pola
	 */
	if (!(selectedRowIndex < 0)) {
	    Pants p = pantsList.get(selectedRowIndex);
	    priceTextField.setText(p.getPrice() != null ? p.getPrice().toString() : "");
	    nameTextField.setText(p.getName() != null ? p.getName() : "");
	    colorTextField.setText(p.getColor() != null ? p.getColor() : "");
	    brandTextField.setText(p.getBrand() != null ? p.getBrand() : "");
	    fabricTextField.setText(p.getFabric() != null ? p.getFabric() : "");
	    lengthTextField.setText(p.getLength() != null ? p.getLength().toString() : "");
	    obwodTextField.setText(p.getWaistSize() != null ? p.getWaistSize().toString() : "");
	    genderComboBox.setSelectedItem(p.getGender());
	    if (p.getPromotion().getReduction().equals("brak")) {
		labelStartDate.hide();
		labelEndDate.hide();
		lblPromocjaTrwa.hide();
		lblOd.hide();
		lblDo.hide();
	    }
	    promotionComboBox.setSelectedItem(p.getPromotion().getReduction());
	    labelStartDate.setText(sdf.format(p.getPromotion().getStartDate()));
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
	    labelStartDate.hide();
	    labelEndDate.hide();
	    lblPromocjaTrwa.hide();
	    lblOd.hide();
	    lblDo.hide();
	}

	JButton addImageButton = new JButton("Przegl\u0105daj");
	addImageButton.addMouseListener(new MouseAdapter() {
	    /**
	     * Funkcja wyswietlajaca okno wyboru obrazka i wczytujaca obrazek spodni
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
	     * Funkcja dodajaca nowe spodnie oraz zapisujaca spodnie edytowane w tabeli i liscie spodni
	     */
	    @Override
	    public void mouseClicked(MouseEvent e) {
		Pants p = selectedRowIndex == -1 ? new Pants() : pantsList.get(selectedRowIndex);
		p.setBrand(!brandTextField.getText().isEmpty() ? brandTextField.getText() : null);
		p.setColor(!colorTextField.getText().isEmpty() ? colorTextField.getText() : null);
		p.setFabric(!fabricTextField.getText().isEmpty() ? fabricTextField.getText() : null);
		p.setLength(NumberUtils.createInteger(!lengthTextField.getText().isEmpty() ? lengthTextField.getText() : null));
		p.setName(!nameTextField.getText().isEmpty() ? nameTextField.getText() : null);
		p.setPrice(NumberUtils.createDouble(!priceTextField.getText().isEmpty() ? priceTextField.getText() : null));
		p.setWaistSize(NumberUtils.createInteger(!obwodTextField.getText().isEmpty() ? obwodTextField.getText() : null));
		p.setGender((Gender) genderComboBox.getSelectedItem());
		p.setImage(image != null ? image : null);
		p.setPromotion(promotionList.get(promotionComboBox.getSelectedIndex()));
		DefaultTableModel model = ((DefaultTableModel) pantsTable.getModel());
		if (selectedRowIndex != -1) {
		    pantsList.edit(p, selectedRowIndex);
		    model.setValueAt(p.getGender() != null ? p.getGender().toString() : "", selectedRowIndex, 0);
		    model.setValueAt(p.getName(), selectedRowIndex, 1);
		    model.setValueAt(p.getPrice() != null ? p.getPrice().toString() : "", selectedRowIndex, 2);
		    model.setValueAt(p.getColor(), selectedRowIndex, 3);
		    model.setValueAt(p.getBrand(), selectedRowIndex, 4);
		    model.setValueAt(p.getWaistSize() != null ? p.getWaistSize().toString() : "", selectedRowIndex, 5);
		    model.setValueAt(p.getLength() != null ? p.getLength().toString() : "", selectedRowIndex, 6);
		    hide();
		} else {
		    pantsList.add(p);
		    model.addRow(new Object[] { p.getGender() != null ? p.getGender().toString() : "", p.getName(),
	                    p.getPrice() != null ? p.getPrice().toString() : "", p.getColor(), p.getBrand(),
	                    p.getWaistSize() != null ? p.getWaistSize().toString() : "", p.getLength() != null ? p.getLength().toString() : "" });
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
	lengthTextField.enable(this.addEditShow);
	obwodTextField.enable(this.addEditShow);
	genderComboBox.setEnabled(this.addEditShow);
	promotionComboBox.setEnabled(this.addEditShow);

	GroupLayout gl_contentPane = new GroupLayout(contentPane);
	gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	        .addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
	                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
	                        .addGroup(gl_contentPane.createSequentialGroup()
	                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblPromocjaTrwa)
	                                        .addGroup(gl_contentPane.createSequentialGroup().addComponent(lblOd)
	                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	                                                        .addGroup(gl_contentPane.createSequentialGroup()
	                                                                .addPreferredGap(ComponentPlacement.RELATED).addComponent(labelStartDate))
	                                        .addGroup(gl_contentPane.createSequentialGroup().addGap(83).addComponent(lblDo)))))
	                .addPreferredGap(ComponentPlacement.UNRELATED).addComponent(labelEndDate)
	                .addPreferredGap(ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
	                .addComponent(
	                        saveButton).addPreferredGap(
	                                ComponentPlacement.RELATED).addComponent(
	                                        cancelButton))
	                        .addGroup(gl_contentPane.createSequentialGroup()
	                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
	                                        .addGroup(gl_contentPane.createSequentialGroup()
	                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblNazwa)
	                                                        .addComponent(lblCena).addComponent(lblKolor).addComponent(lblMarka)
	                                                        .addComponent(lblMateria).addComponent(lblRodzaj).addComponent(lblDugo))
	                                        .addGap(28)
	                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	                                                .addComponent(lengthTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
	                                                        GroupLayout.PREFERRED_SIZE)
	                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
	                                                        .addComponent(genderComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                                        .addComponent(fabricTextField).addComponent(brandTextField)
	                                                        .addComponent(colorTextField).addComponent(priceTextField).addComponent(nameTextField)
	                                                        .addComponent(promotionComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
	                        .addGroup(gl_contentPane.createSequentialGroup().addComponent(lblObwdPasa)
	                                .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(
	                                        obwodTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
	                        .addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
	                        .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
	                                .addComponent(imagePanel, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
	                                .addComponent(addImageButton))))
	                .addGap(31))
	        .addGroup(gl_contentPane.createSequentialGroup().addGap(188).addComponent(lblSpodni).addContainerGap(295, Short.MAX_VALUE))
	        .addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblPromocja).addContainerGap(422, Short.MAX_VALUE)));
	gl_contentPane
	        .setVerticalGroup(
	                gl_contentPane.createParallelGroup(Alignment.LEADING)
	                        .addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblSpodni).addGap(18)
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
	                                .addPreferredGap(ComponentPlacement.RELATED)
	                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
	                                        .addComponent(obwodTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
	                                                GroupLayout.PREFERRED_SIZE)
	                                        .addComponent(lblObwdPasa))
	                                .addGap(14)
	                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblDugo).addComponent(
	                                        lengthTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                                .addPreferredGap(ComponentPlacement.RELATED)
	                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblRodzaj).addComponent(
	                                        genderComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
	        .addGroup(
	                gl_contentPane.createParallelGroup(Alignment.LEADING)
	                        .addGroup(gl_contentPane.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
	                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(cancelButton)
	                                        .addComponent(saveButton))
	                                .addContainerGap())
	                .addGroup(gl_contentPane.createSequentialGroup().addGap(18)
	                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblPromocja).addComponent(
	                                promotionComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                        .addGap(18).addComponent(lblPromocjaTrwa)
	                        .addPreferredGap(ComponentPlacement.UNRELATED).addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
	                                .addComponent(lblOd).addComponent(labelStartDate).addComponent(lblDo).addComponent(labelEndDate))
	                        .addGap(8)))));
	contentPane.setLayout(gl_contentPane);
    }
}
