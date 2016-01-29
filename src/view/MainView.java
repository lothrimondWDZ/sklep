package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import org.apache.commons.lang3.StringUtils;

import model.Gender;
import model.Jacket;
import model.Pants;
import model.Shirt;
import model.Shoes;
import model.Tshirt;
import model.TshirtSize;

public class MainView {

    private JFrame frame;
    private TshirtView tshirtFrame;
    private ShirtView shirtFrame;
    private PantsView pantsFrame;
    private JacketView jacketFrame;
    private ShoesView shoesFrame;
    private JTable pantsTable;
    private JTextField filterPantsTextField;
    private DefaultTableModel tableShirtModel, tableTShirtModel, tableShoesModel;
    private DefaultTableModel tablePantsModel, tableJacketModel;
    private JTable jacketTable;
    private JTextField filstrJacketTextField;
    private JTable shirtTable;
    private JTextField filtrShirtTextField;
    private JTable tshirtTable;
    private JTextField filtrTshirtTextField;
    private JTable shoesTable;
    private JTextField filtrShoesTextField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		try {
		    MainView window = new MainView();
		    window.frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the application.
     */
    public MainView() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setBounds(100, 100, 532, 350);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JPanel masterPanel = new JPanel();
	frame.getContentPane().add(masterPanel, BorderLayout.CENTER);
	PromotionList promotionList = new PromotionList();
	promotionList.fileList();
	JTabbedPane mainTabbedPane = new JTabbedPane(JTabbedPane.TOP);
	GroupLayout gl_masterPanel = new GroupLayout(masterPanel);
	gl_masterPanel.setHorizontalGroup(gl_masterPanel.createParallelGroup(Alignment.LEADING).addComponent(mainTabbedPane, Alignment.TRAILING,
	        GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE));
	gl_masterPanel.setVerticalGroup(gl_masterPanel.createParallelGroup(Alignment.LEADING).addComponent(mainTabbedPane, Alignment.TRAILING,
	        GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE));

	JPanel jacketPanel = new JPanel();
	JacketList jacketList = new JacketList();
	mainTabbedPane.addTab("Kurtki", null, jacketPanel, null);
	JScrollPane jacketTableScrollPane = new JScrollPane();
	String[] jakcetHeaders = { "Rodzaj", "Nazwa", "Cena", "Kolor", "Marka", "Rozmiar" };
	tableJacketModel = new DefaultTableModel(new Object[][] {}, jakcetHeaders);
	jacketTable = new JTable(tableJacketModel);
	jacketTableScrollPane.setViewportView(jacketTable);

	JButton jacketDodaj = new JButton("Dodaj");
	jacketDodaj.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		jacketTable.getSelectionModel().clearSelection();
		jacketFrame = new JacketView(true, "Dodaj kurtke", jacketTable, jacketList);
		jacketFrame.show();
	    }
	});

	JButton jacketEdytuj = new JButton("Edytuj");
	jacketEdytuj.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		if (jacketTable.getSelectedRow() != -1) {
		    jacketFrame = new JacketView(true, "Edytuj kurtke", jacketTable, jacketList);
		    jacketFrame.show();
		}
	    }
	});

	JButton jacketUsun = new JButton("Usu\u0144");
	jacketUsun.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		if (jacketTable.getSelectedRow() != -1) {
		    Jacket p = new Jacket();
		    p.setGender(
	                    Gender.getByName(((DefaultTableModel) jacketTable.getModel()).getValueAt(jacketTable.getSelectedRow(), 0).toString()));
		    Object name = ((DefaultTableModel) jacketTable.getModel()).getValueAt(jacketTable.getSelectedRow(), 1);
		    if (name != null) {
			p.setName(name.toString());
		    }
		    String price = ((DefaultTableModel) jacketTable.getModel()).getValueAt(jacketTable.getSelectedRow(), 2).toString();
		    if (!StringUtils.isBlank(price)) {
			p.setPrice(new Double(price));
		    }
		    Object color = ((DefaultTableModel) jacketTable.getModel()).getValueAt(jacketTable.getSelectedRow(), 3);
		    if (color != null) {
			p.setColor(color.toString());
		    }
		    Object brand = ((DefaultTableModel) jacketTable.getModel()).getValueAt(jacketTable.getSelectedRow(), 4);
		    if (brand != null) {
			p.setBrand(brand.toString());
		    }
		    p.setSize(
	                    TshirtSize.valueOf(((DefaultTableModel) jacketTable.getModel()).getValueAt(jacketTable.getSelectedRow(), 5).toString()));

		    jacketList.remove(p);
		    ((DefaultTableModel) jacketTable.getModel()).removeRow(jacketTable.convertRowIndexToModel(jacketTable.getSelectedRow()));
		}
	    }
	});

	JButton jacketPokaz = new JButton("Poka\u017C");
	jacketPokaz.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		if (jacketTable.getSelectedRow() != -1) {
		    jacketFrame = new JacketView(false, "Przeglï¿½daj kurtke", jacketTable, jacketList);
		    jacketFrame.show();
		}
	    }
	});

	JLabel lblFiltr_1 = new JLabel("Filtr :");

	filstrJacketTextField = new JTextField();
	filstrJacketTextField.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyReleased(KeyEvent e) {
		String query = filstrJacketTextField.getText().toLowerCase();
		filter(query, tableJacketModel, jacketTable);
	    }
	});
	filstrJacketTextField.setColumns(10);
	GroupLayout gl_jacketPanel = new GroupLayout(jacketPanel);
	gl_jacketPanel.setHorizontalGroup(gl_jacketPanel.createParallelGroup(Alignment.LEADING)
	        .addGroup(gl_jacketPanel.createSequentialGroup().addContainerGap()
	                .addGroup(gl_jacketPanel.createParallelGroup(Alignment.LEADING)
	                        .addComponent(jacketTableScrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
	                        .addGroup(gl_jacketPanel.createSequentialGroup().addComponent(jacketDodaj).addPreferredGap(ComponentPlacement.RELATED)
	                                .addComponent(jacketEdytuj).addPreferredGap(ComponentPlacement.RELATED).addComponent(jacketUsun)
	                                .addPreferredGap(ComponentPlacement.RELATED).addComponent(jacketPokaz))
	                .addGroup(gl_jacketPanel.createSequentialGroup().addComponent(lblFiltr_1).addGap(29).addComponent(filstrJacketTextField,
	                        GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap()));
	gl_jacketPanel.setVerticalGroup(gl_jacketPanel.createParallelGroup(Alignment.LEADING)
	        .addGroup(gl_jacketPanel.createSequentialGroup().addContainerGap()
	                .addGroup(gl_jacketPanel.createParallelGroup(Alignment.BASELINE).addComponent(jacketDodaj).addComponent(jacketEdytuj)
	                        .addComponent(jacketUsun).addComponent(jacketPokaz))
	        .addGap(12)
	        .addGroup(gl_jacketPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblFiltr_1).addComponent(filstrJacketTextField,
	                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.RELATED)
	        .addComponent(jacketTableScrollPane, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE).addContainerGap()));

	jacketPanel.setLayout(gl_jacketPanel);

	JPanel shirtPanel = new JPanel();
	JScrollPane shirtTableScrollPane = new JScrollPane();
	String[] shirtHeaders = { "Rodzaj", "Nazwa", "Cena", "Kolor", "Marka" };
	tableShirtModel = new DefaultTableModel(new Object[][] {}, shirtHeaders);
	shirtTable = new JTable(tableShirtModel);
	shirtTableScrollPane.setViewportView(shirtTable);
	ShirtList shirtList = new ShirtList();
	mainTabbedPane.addTab("Koszule", null, shirtPanel, null);

	JButton shirtEdytuj = new JButton("Edytuj");
	shirtEdytuj.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		if (shirtTable.getSelectedRow() != -1) {
		    shirtFrame = new ShirtView(true, "Edytuj Koszule", shirtTable, shirtList);
		    shirtFrame.show();
		}
	    }
	});

	JButton shirtDodaj = new JButton("Dodaj");
	shirtDodaj.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		shirtTable.getSelectionModel().clearSelection();
		shirtFrame = new ShirtView(true, "Dodaj Koszule", shirtTable, shirtList);
		shirtFrame.show();
	    }
	});

	JButton shirtUsun = new JButton("Usu\u0144");
	shirtUsun.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		if (shirtTable.getSelectedRow() != -1) {
		    Shirt s = new Shirt();
		    s.setGender(Gender.getByName(((DefaultTableModel) shirtTable.getModel()).getValueAt(shirtTable.getSelectedRow(), 0).toString()));
		    Object name = ((DefaultTableModel) shirtTable.getModel()).getValueAt(shirtTable.getSelectedRow(), 1);
		    if (name != null) {
			s.setName(name.toString());
		    }
		    String price = ((DefaultTableModel) shirtTable.getModel()).getValueAt(shirtTable.getSelectedRow(), 2).toString();
		    if (!StringUtils.isBlank(price)) {
			s.setPrice(new Double(price));
		    }
		    Object color = ((DefaultTableModel) shirtTable.getModel()).getValueAt(shirtTable.getSelectedRow(), 3);
		    if (color != null) {
			s.setColor(color.toString());
		    }
		    Object brand = ((DefaultTableModel) shirtTable.getModel()).getValueAt(shirtTable.getSelectedRow(), 4);
		    if (brand != null) {
			s.setBrand(brand.toString());
		    }
		    shirtList.remove(s);
		    ((DefaultTableModel) shirtTable.getModel()).removeRow(shirtTable.convertRowIndexToModel(shirtTable.getSelectedRow()));
		}
	    }
	});

	JButton shirtPokaz = new JButton("Poka\u017C");
	shirtPokaz.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		shirtFrame = new ShirtView(false, "Przeglï¿½daj Koszule", shirtTable, shirtList);
		shirtFrame.show();
	    }
	});

	JLabel lblFiltr_2 = new JLabel("Filtr :");
	filtrShirtTextField = new JTextField();
	filtrShirtTextField.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyReleased(KeyEvent e) {
		String query = filtrShirtTextField.getText().toLowerCase();
		filter(query, tableShirtModel, shirtTable);
	    }
	});
	filtrShirtTextField.setColumns(10);

	GroupLayout gl_shirtPanel = new GroupLayout(shirtPanel);
	gl_shirtPanel.setHorizontalGroup(gl_shirtPanel.createParallelGroup(Alignment.LEADING)
	        .addGroup(gl_shirtPanel.createSequentialGroup().addContainerGap()
	                .addGroup(gl_shirtPanel.createParallelGroup(Alignment.LEADING)
	                        .addComponent(shirtTableScrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
	                        .addGroup(gl_shirtPanel.createSequentialGroup().addComponent(shirtDodaj).addPreferredGap(ComponentPlacement.RELATED)
	                                .addComponent(shirtEdytuj).addPreferredGap(ComponentPlacement.RELATED).addComponent(shirtUsun)
	                                .addPreferredGap(ComponentPlacement.RELATED).addComponent(shirtPokaz))
	                .addGroup(gl_shirtPanel.createSequentialGroup().addComponent(lblFiltr_2).addGap(34).addComponent(filtrShirtTextField,
	                        GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap()));
	gl_shirtPanel
	        .setVerticalGroup(
	                gl_shirtPanel.createParallelGroup(Alignment.LEADING)
	                        .addGroup(gl_shirtPanel.createSequentialGroup().addContainerGap()
	                                .addGroup(gl_shirtPanel.createParallelGroup(Alignment.BASELINE).addComponent(shirtEdytuj)
	                                        .addComponent(shirtDodaj).addComponent(shirtUsun).addComponent(shirtPokaz))
	                        .addPreferredGap(ComponentPlacement.UNRELATED)
	                        .addGroup(gl_shirtPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblFiltr_2).addComponent(
	                                filtrShirtTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	        .addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
	        .addComponent(shirtTableScrollPane, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE).addContainerGap()));

	shirtPanel.setLayout(gl_shirtPanel);

	JPanel tshirtPanel = new JPanel();
	String[] tshirtHeaders = { "Rodzaj", "Nazwa", "Cena", "Kolor", "Marka" };
	tableTShirtModel = new DefaultTableModel(new Object[][] {}, tshirtHeaders);
	tshirtTable = new JTable(tableTShirtModel);
	JScrollPane tshirtTableScrollPane = new JScrollPane();
	tshirtTableScrollPane.setViewportView(tshirtTable);
	TShirtList tshirtList = new TShirtList();
	mainTabbedPane.addTab("T-shirt", null, tshirtPanel, null);

	JButton tshirtDodaj = new JButton("Dodaj");
	tshirtDodaj.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		tshirtTable.getSelectionModel().clearSelection();
		tshirtFrame = new TshirtView(true, "Dodaj T-shirt", tshirtTable, tshirtList);
		tshirtFrame.show();
	    }
	});

	JButton tshirtEdytuj = new JButton("Edytuj");
	tshirtEdytuj.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		if (tshirtTable.getSelectedRow() != -1) {
		    tshirtFrame = new TshirtView(true, "Edytuj T-shirt", tshirtTable, tshirtList);
		    tshirtFrame.show();
		}
	    }
	});

	JButton tshirtUsun = new JButton("Usu\u0144");
	tshirtUsun.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		if (tshirtTable.getSelectedRow() != -1) {
		    Tshirt t = new Tshirt();
		    t.setGender(
	                    Gender.getByName(((DefaultTableModel) tshirtTable.getModel()).getValueAt(tshirtTable.getSelectedRow(), 0).toString()));
		    Object name = ((DefaultTableModel) tshirtTable.getModel()).getValueAt(tshirtTable.getSelectedRow(), 1);
		    if (name != null) {
			t.setName(name.toString());
		    }
		    String price = ((DefaultTableModel) tshirtTable.getModel()).getValueAt(tshirtTable.getSelectedRow(), 2).toString();
		    if (!StringUtils.isBlank(price)) {
			t.setPrice(new Double(price));
		    }
		    Object color = ((DefaultTableModel) tshirtTable.getModel()).getValueAt(tshirtTable.getSelectedRow(), 3);
		    if (color != null) {
			t.setColor(color.toString());
		    }
		    Object brand = ((DefaultTableModel) tshirtTable.getModel()).getValueAt(tshirtTable.getSelectedRow(), 4);
		    if (brand != null) {
			t.setBrand(brand.toString());
		    }
		    tshirtList.remove(t);
		    ((DefaultTableModel) tshirtTable.getModel()).removeRow(tshirtTable.convertRowIndexToModel(tshirtTable.getSelectedRow()));
		}
	    }
	});

	JButton tshirtPokaz = new JButton("Poka\u017C");
	tshirtPokaz.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		tshirtFrame = new TshirtView(false, "Przeglï¿½daj T-shirt", tshirtTable, tshirtList);
		tshirtFrame.show();
	    }
	});

	JLabel lblFiltr_3 = new JLabel("Filtr :");
	filtrTshirtTextField = new JTextField();
	filtrTshirtTextField.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyReleased(KeyEvent e) {
		String query = filtrTshirtTextField.getText().toLowerCase();
		filter(query, tableTShirtModel, tshirtTable);
	    }
	});
	filtrTshirtTextField.setColumns(10);

	GroupLayout gl_tshirtPanel = new GroupLayout(tshirtPanel);
	gl_tshirtPanel.setHorizontalGroup(gl_tshirtPanel.createParallelGroup(Alignment.LEADING)
	        .addGroup(gl_tshirtPanel.createSequentialGroup().addContainerGap()
	                .addGroup(gl_tshirtPanel.createParallelGroup(Alignment.LEADING)
	                        .addComponent(tshirtTableScrollPane, GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
	                        .addGroup(gl_tshirtPanel.createSequentialGroup().addComponent(tshirtDodaj).addPreferredGap(ComponentPlacement.RELATED)
	                                .addComponent(tshirtEdytuj).addPreferredGap(ComponentPlacement.RELATED).addComponent(tshirtUsun)
	                                .addPreferredGap(ComponentPlacement.RELATED).addComponent(tshirtPokaz))
	                .addGroup(gl_tshirtPanel.createSequentialGroup().addComponent(lblFiltr_3).addGap(32).addComponent(filtrTshirtTextField,
	                        GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap()));
	gl_tshirtPanel
	        .setVerticalGroup(
	                gl_tshirtPanel.createParallelGroup(Alignment.LEADING)
	                        .addGroup(gl_tshirtPanel.createSequentialGroup().addContainerGap()
	                                .addGroup(gl_tshirtPanel.createParallelGroup(Alignment.BASELINE).addComponent(tshirtDodaj)
	                                        .addComponent(tshirtEdytuj).addComponent(tshirtUsun).addComponent(tshirtPokaz))
	                        .addPreferredGap(ComponentPlacement.UNRELATED)
	                        .addGroup(gl_tshirtPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblFiltr_3).addComponent(
	                                filtrTshirtTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	        .addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
	        .addComponent(tshirtTableScrollPane, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE).addContainerGap()));

	tshirtPanel.setLayout(gl_tshirtPanel);

	JPanel pantsPanel = new JPanel();
	PantsList pantsList = new PantsList();
	mainTabbedPane.addTab("Spodnie", null, pantsPanel, null);
	JScrollPane pantsTableScrollPane = new JScrollPane();
	String[] pantsHeaders = { "Rodzaj", "Nazwa", "Cena", "Kolor", "Marka", "Pas", "Dï¿½ugoï¿½ï¿½" };
	tablePantsModel = new DefaultTableModel(new Object[][] {}, pantsHeaders);
	pantsTable = new JTable(tablePantsModel);
	pantsTableScrollPane.setViewportView(pantsTable);
	JButton pantsUsun = new JButton("Usu\u0144");
	pantsUsun.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		if (pantsTable.getSelectedRow() != -1) {
		    Pants p = new Pants();
		    p.setGender(Gender.getByName(((DefaultTableModel) pantsTable.getModel()).getValueAt(pantsTable.getSelectedRow(), 0).toString()));
		    Object name = ((DefaultTableModel) pantsTable.getModel()).getValueAt(pantsTable.getSelectedRow(), 1);
		    if (name != null) {
			p.setName(name.toString());
		    }
		    String price = ((DefaultTableModel) pantsTable.getModel()).getValueAt(pantsTable.getSelectedRow(), 2).toString();
		    if (!StringUtils.isBlank(price)) {
			p.setPrice(new Double(price));
		    }
		    Object color = ((DefaultTableModel) pantsTable.getModel()).getValueAt(pantsTable.getSelectedRow(), 3);
		    if (color != null) {
			p.setColor(color.toString());
		    }
		    Object brand = ((DefaultTableModel) pantsTable.getModel()).getValueAt(pantsTable.getSelectedRow(), 4);
		    if (brand != null) {
			p.setBrand(brand.toString());
		    }
		    String waistSize = ((DefaultTableModel) pantsTable.getModel()).getValueAt(pantsTable.getSelectedRow(), 5).toString();
		    if (!StringUtils.isBlank(waistSize)) {
			p.setWaistSize(new Integer(waistSize));
		    }
		    String length = ((DefaultTableModel) pantsTable.getModel()).getValueAt(pantsTable.getSelectedRow(), 6).toString();
		    if (!StringUtils.isBlank(length)) {
			p.setLength(new Integer(length));
		    }
		    pantsList.remove(p);
		    ((DefaultTableModel) pantsTable.getModel()).removeRow(pantsTable.convertRowIndexToModel(pantsTable.getSelectedRow()));
		}
	    }
	});

	JButton pantsDodaj = new JButton("Dodaj");
	pantsDodaj.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		pantsTable.getSelectionModel().clearSelection();
		pantsFrame = new PantsView(true, "Dodaj spodnie", pantsTable, pantsList, promotionList);
		pantsFrame.show();
	    }
	});

	JButton pantsEdytuj = new JButton("Edytuj");
	pantsEdytuj.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		if (pantsTable.getSelectedRow() != -1) {
		    pantsFrame = new PantsView(true, "Edytuj spodnie", pantsTable, pantsList, promotionList);
		    pantsFrame.show();
		}
	    }
	});

	JButton pantsPokaz = new JButton("Poka\u017C");
	pantsPokaz.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		if (pantsTable.getSelectedRow() != -1) {
		    pantsFrame = new PantsView(false, "Pokaï¿½ spodnie", pantsTable, pantsList, promotionList);
		    pantsFrame.show();
		}
	    }
	});

	JLabel lblFiltr = new JLabel("Filtr :");

	filterPantsTextField = new JTextField();
	filterPantsTextField.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyReleased(KeyEvent e) {
		String query = filterPantsTextField.getText().toLowerCase();
		filter(query, tablePantsModel, pantsTable);
	    }
	});
	filterPantsTextField.setColumns(10);

	GroupLayout gl_pantsPanel = new GroupLayout(pantsPanel);
	gl_pantsPanel.setHorizontalGroup(gl_pantsPanel.createParallelGroup(Alignment.LEADING)
	        .addGroup(gl_pantsPanel.createSequentialGroup().addGroup(gl_pantsPanel.createParallelGroup(Alignment.LEADING)
	                .addGroup(gl_pantsPanel.createSequentialGroup().addContainerGap().addComponent(pantsDodaj)
	                        .addPreferredGap(ComponentPlacement.RELATED).addComponent(pantsEdytuj).addPreferredGap(ComponentPlacement.RELATED)
	                        .addComponent(pantsUsun).addPreferredGap(ComponentPlacement.RELATED).addComponent(pantsPokaz))
	                .addGroup(gl_pantsPanel.createSequentialGroup().addGap(23).addComponent(lblFiltr).addGap(18)
	                        .addComponent(filterPantsTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addGroup(gl_pantsPanel.createSequentialGroup().addContainerGap().addComponent(pantsTableScrollPane, GroupLayout.DEFAULT_SIZE,
	                        491, Short.MAX_VALUE)))
	                .addContainerGap()));
	gl_pantsPanel
	        .setVerticalGroup(
	                gl_pantsPanel.createParallelGroup(Alignment.LEADING)
	                        .addGroup(gl_pantsPanel.createSequentialGroup().addContainerGap()
	                                .addGroup(gl_pantsPanel.createParallelGroup(Alignment.BASELINE).addComponent(pantsDodaj)
	                                        .addComponent(pantsEdytuj).addComponent(pantsUsun).addComponent(pantsPokaz))
	                        .addPreferredGap(ComponentPlacement.RELATED)
	                        .addGroup(gl_pantsPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblFiltr).addComponent(
	                                filterPantsTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	        .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        .addComponent(pantsTableScrollPane, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE).addContainerGap()));

	pantsPanel.setLayout(gl_pantsPanel);

	JPanel shoesPanel = new JPanel();
	ShoesList shoesList = new ShoesList();
	mainTabbedPane.addTab("Buty", null, shoesPanel, null);
	JScrollPane shoesTableScrollPane = new JScrollPane();
	String[] shoesHeaders = { "Rodzaj", "Nazwa", "Cena", "Kolor", "Marka", "Rozmiar" };
	tableShoesModel = new DefaultTableModel(new Object[][] {}, shoesHeaders);
	shoesTable = new JTable(tableShoesModel);
	shoesTableScrollPane.setViewportView(shoesTable);

	JButton shoesPokaz = new JButton("Poka\u017C");
	shoesPokaz.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		if (shoesTable.getSelectedRow() != -1) {
		    shoesFrame = new ShoesView(false, "Przegl¹daj buty", shoesTable, shoesList, promotionList);
		    shoesFrame.show();
		}
	    }
	});

	JButton shoesDodaj = new JButton("Dodaj");
	shoesDodaj.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		shoesTable.getSelectionModel().clearSelection();
		shoesFrame = new ShoesView(true, "Dodaj buty", shoesTable, shoesList, promotionList);
		shoesFrame.show();
	    }
	});

	JButton shoesEdytuj = new JButton("Edytuj");
	shoesEdytuj.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		if (shoesTable.getSelectedRow() != -1) {
		    shoesFrame = new ShoesView(true, "Edytuj buty", shoesTable, shoesList, promotionList);
		    shoesFrame.show();
		}
	    }
	});

	JButton shoesUsun = new JButton("Usu\u0144");
	shoesUsun.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		if (shoesTable.getSelectedRow() != -1) {
		    Shoes p = new Shoes();
		    p.setGender(Gender.getByName(((DefaultTableModel) shoesTable.getModel()).getValueAt(shoesTable.getSelectedRow(), 0).toString()));
		    Object name = ((DefaultTableModel) shoesTable.getModel()).getValueAt(shoesTable.getSelectedRow(), 1);
		    if (name != null) {
			p.setName(name.toString());
		    }
		    String price = ((DefaultTableModel) shoesTable.getModel()).getValueAt(shoesTable.getSelectedRow(), 2).toString();
		    if (!StringUtils.isBlank(price)) {
			p.setPrice(new Double(price));
		    }
		    Object color = ((DefaultTableModel) shoesTable.getModel()).getValueAt(shoesTable.getSelectedRow(), 3);
		    if (color != null) {
			p.setColor(color.toString());
		    }
		    Object brand = ((DefaultTableModel) shoesTable.getModel()).getValueAt(shoesTable.getSelectedRow(), 4);
		    if (brand != null) {
			p.setBrand(brand.toString());
		    }
		    String size = ((DefaultTableModel) shoesTable.getModel()).getValueAt(shoesTable.getSelectedRow(), 5).toString();
		    if (!StringUtils.isBlank(size)) {
			p.setSize(new Integer(size));
		    }
		    shoesList.remove(p);
		    ((DefaultTableModel) shoesTable.getModel()).removeRow(shoesTable.convertRowIndexToModel(shoesTable.getSelectedRow()));
		}
	    }
	});

	JLabel lblFiltr_4 = new JLabel("Filtr :");

	filtrShoesTextField = new JTextField();
	filtrShoesTextField.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyReleased(KeyEvent e) {
		String query = filtrShoesTextField.getText().toLowerCase();
		filter(query, tableShoesModel, shoesTable);
	    }
	});
	filtrShoesTextField.setColumns(10);
	GroupLayout gl_shoesPanel = new GroupLayout(shoesPanel);
	gl_shoesPanel.setHorizontalGroup(gl_shoesPanel.createParallelGroup(Alignment.LEADING)
	        .addGroup(gl_shoesPanel.createSequentialGroup().addContainerGap()
	                .addGroup(gl_shoesPanel.createParallelGroup(Alignment.LEADING)
	                        .addComponent(shoesTableScrollPane, GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
	                        .addGroup(gl_shoesPanel.createSequentialGroup().addComponent(shoesDodaj).addPreferredGap(ComponentPlacement.RELATED)
	                                .addComponent(shoesEdytuj).addPreferredGap(ComponentPlacement.RELATED).addComponent(shoesUsun)
	                                .addPreferredGap(ComponentPlacement.RELATED).addComponent(shoesPokaz))
	                .addGroup(gl_shoesPanel.createSequentialGroup().addComponent(lblFiltr_4).addGap(31).addComponent(filtrShoesTextField,
	                        GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap()));
	gl_shoesPanel
	        .setVerticalGroup(
	                gl_shoesPanel.createParallelGroup(Alignment.LEADING)
	                        .addGroup(gl_shoesPanel.createSequentialGroup().addContainerGap()
	                                .addGroup(gl_shoesPanel.createParallelGroup(Alignment.BASELINE).addComponent(shoesDodaj)
	                                        .addComponent(shoesEdytuj).addComponent(shoesUsun).addComponent(shoesPokaz))
	                        .addGap(18)
	                        .addGroup(gl_shoesPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblFiltr_4).addComponent(
	                                filtrShoesTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	        .addGap(11).addComponent(shoesTableScrollPane, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE).addContainerGap()));

	shoesPanel.setLayout(gl_shoesPanel);
	masterPanel.setLayout(gl_masterPanel);

	JMenuBar menuBar = new JMenuBar();
	frame.getContentPane().add(menuBar, BorderLayout.NORTH);

	JMenu mnPlik = new JMenu("Plik");
	menuBar.add(mnPlik);

	JMenuItem mntmImportZXml = new JMenuItem("Import z XML");
	mntmImportZXml.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		System.out.println("import z xml");
	    }
	});
	mnPlik.add(mntmImportZXml);

	JMenuItem mntmExportDoXml = new JMenuItem("Export do XML");
	mntmExportDoXml.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		System.out.println("eksport do xml");
	    }
	});
	mnPlik.add(mntmExportDoXml);
    }

    private void filter(String query, DefaultTableModel modelTable, JTable table) {
	TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelTable);
	tr.setRowFilter(RowFilter.regexFilter(query, 1));
	table.setRowSorter(tr);

    }
}
