package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainView {

    private JFrame frame;
    private TshirtView tshirtFrame;

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
	JFrame JacketFrame = new JacketView();
	JFrame ShirtFrame = new ShirtView();
	JFrame PantsFrame = new PantsView();
	JFrame ShoesFrame = new ShoesView();
	JPanel masterPanel = new JPanel();
	frame.getContentPane().add(masterPanel, BorderLayout.CENTER);

	JTabbedPane mainTabbedPane = new JTabbedPane(JTabbedPane.TOP);
	GroupLayout gl_masterPanel = new GroupLayout(masterPanel);
	gl_masterPanel.setHorizontalGroup(gl_masterPanel.createParallelGroup(Alignment.LEADING).addComponent(mainTabbedPane, Alignment.TRAILING,
	        GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE));
	gl_masterPanel.setVerticalGroup(gl_masterPanel.createParallelGroup(Alignment.LEADING).addComponent(mainTabbedPane, Alignment.TRAILING,
	        GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE));

	JPanel jacketPanel = new JPanel();
	mainTabbedPane.addTab("Kurtki", null, jacketPanel, null);

	JButton jacketDodaj = new JButton("Dodaj");
	jacketDodaj.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		JacketFrame.show();
	    }
	});

	JButton jacketEdytuj = new JButton("Edytuj");

	JButton jacketUsun = new JButton("Usu\u0144");

	JButton jacketPokaz = new JButton("Poka\u017C");
	GroupLayout gl_jacketPanel = new GroupLayout(jacketPanel);
	gl_jacketPanel
	        .setHorizontalGroup(gl_jacketPanel.createParallelGroup(Alignment.LEADING)
	                .addGroup(gl_jacketPanel.createSequentialGroup().addContainerGap().addComponent(jacketDodaj)
	                        .addPreferredGap(ComponentPlacement.RELATED).addComponent(jacketEdytuj).addPreferredGap(ComponentPlacement.RELATED)
	                        .addComponent(jacketUsun).addPreferredGap(ComponentPlacement.RELATED).addComponent(jacketPokaz)
	                        .addContainerGap(131, Short.MAX_VALUE)));
	gl_jacketPanel.setVerticalGroup(gl_jacketPanel.createParallelGroup(Alignment.LEADING)
	        .addGroup(gl_jacketPanel.createSequentialGroup()
	                .addContainerGap().addGroup(gl_jacketPanel.createParallelGroup(Alignment.BASELINE).addComponent(jacketDodaj)
	                        .addComponent(jacketEdytuj).addComponent(jacketUsun).addComponent(jacketPokaz))
	        .addContainerGap(202, Short.MAX_VALUE)));
	jacketPanel.setLayout(gl_jacketPanel);

	JPanel shirtPanel = new JPanel();
	mainTabbedPane.addTab("Koszule", null, shirtPanel, null);

	JButton shirtEdytuj = new JButton("Edytuj");

	JButton shirtDodaj = new JButton("Dodaj");
	shirtDodaj.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		ShirtFrame.show();
	    }
	});

	JButton shirtUsun = new JButton("Usu\u0144");

	JButton shirtPokaz = new JButton("Poka\u017C");
	GroupLayout gl_shirtPanel = new GroupLayout(shirtPanel);
	gl_shirtPanel.setHorizontalGroup(gl_shirtPanel.createParallelGroup(Alignment.LEADING)
	        .addGroup(gl_shirtPanel.createSequentialGroup().addContainerGap().addComponent(shirtDodaj).addPreferredGap(ComponentPlacement.RELATED)
	                .addComponent(shirtEdytuj).addPreferredGap(ComponentPlacement.RELATED).addComponent(shirtUsun)
	                .addPreferredGap(ComponentPlacement.RELATED).addComponent(shirtPokaz).addContainerGap(131, Short.MAX_VALUE)));
	gl_shirtPanel.setVerticalGroup(gl_shirtPanel.createParallelGroup(Alignment.LEADING)
	        .addGroup(gl_shirtPanel
	                .createSequentialGroup().addContainerGap().addGroup(gl_shirtPanel.createParallelGroup(Alignment.BASELINE)
	                        .addComponent(shirtEdytuj).addComponent(shirtDodaj).addComponent(shirtUsun).addComponent(shirtPokaz))
	        .addContainerGap(202, Short.MAX_VALUE)));
	shirtPanel.setLayout(gl_shirtPanel);

	JPanel tshirtPanel = new JPanel();
	mainTabbedPane.addTab("T-shirt", null, tshirtPanel, null);

	JButton tshirtDodaj = new JButton("Dodaj");
	tshirtDodaj.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		tshirtFrame = new TshirtView(true, "Dodaj T-shirt");
		tshirtFrame.show();
	    }
	});

	JButton tshirtEdytuj = new JButton("Edytuj");
	tshirtEdytuj.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		tshirtFrame = new TshirtView(true, "Edytuj T-shirt");
		tshirtFrame.show();
	    }
	});

	JButton tshirtUsun = new JButton("Usu\u0144");

	JButton tshirtPokaz = new JButton("Poka\u017C");
	tshirtPokaz.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		tshirtFrame = new TshirtView(false, "Przeglądaj T-shirt");
		tshirtFrame.show();
	    }
	});
	GroupLayout gl_tshirtPanel = new GroupLayout(tshirtPanel);
	gl_tshirtPanel
	        .setHorizontalGroup(gl_tshirtPanel.createParallelGroup(Alignment.LEADING)
	                .addGroup(gl_tshirtPanel.createSequentialGroup().addContainerGap().addComponent(tshirtDodaj)
	                        .addPreferredGap(ComponentPlacement.RELATED).addComponent(tshirtEdytuj).addPreferredGap(ComponentPlacement.RELATED)
	                        .addComponent(tshirtUsun).addPreferredGap(ComponentPlacement.RELATED).addComponent(tshirtPokaz)
	                        .addContainerGap(213, Short.MAX_VALUE)));
	gl_tshirtPanel.setVerticalGroup(gl_tshirtPanel.createParallelGroup(Alignment.LEADING)
	        .addGroup(gl_tshirtPanel.createSequentialGroup()
	                .addContainerGap().addGroup(gl_tshirtPanel.createParallelGroup(Alignment.BASELINE).addComponent(tshirtDodaj)
	                        .addComponent(tshirtEdytuj).addComponent(tshirtUsun).addComponent(tshirtPokaz))
	        .addContainerGap(231, Short.MAX_VALUE)));
	tshirtPanel.setLayout(gl_tshirtPanel);

	JPanel pantsPanel = new JPanel();
	mainTabbedPane.addTab("Spodnie", null, pantsPanel, null);

	JButton pantsUsun = new JButton("Usu\u0144");

	JButton pantsDodaj = new JButton("Dodaj");
	pantsDodaj.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		PantsFrame.show();
	    }
	});

	JButton pantsEdytuj = new JButton("Edytuj");

	JButton pantsPokaz = new JButton("Poka\u017C");
	GroupLayout gl_pantsPanel = new GroupLayout(pantsPanel);
	gl_pantsPanel.setHorizontalGroup(gl_pantsPanel.createParallelGroup(Alignment.LEADING)
	        .addGroup(gl_pantsPanel.createSequentialGroup().addContainerGap().addComponent(pantsDodaj).addPreferredGap(ComponentPlacement.RELATED)
	                .addComponent(pantsEdytuj).addPreferredGap(ComponentPlacement.RELATED).addComponent(pantsUsun)
	                .addPreferredGap(ComponentPlacement.RELATED).addComponent(pantsPokaz).addContainerGap(131, Short.MAX_VALUE)));
	gl_pantsPanel.setVerticalGroup(gl_pantsPanel.createParallelGroup(Alignment.LEADING)
	        .addGroup(gl_pantsPanel
	                .createSequentialGroup().addContainerGap().addGroup(gl_pantsPanel.createParallelGroup(Alignment.BASELINE)
	                        .addComponent(pantsDodaj).addComponent(pantsEdytuj).addComponent(pantsUsun).addComponent(pantsPokaz))
	        .addContainerGap(202, Short.MAX_VALUE)));
	pantsPanel.setLayout(gl_pantsPanel);

	JPanel shoesPanel = new JPanel();
	mainTabbedPane.addTab("Buty", null, shoesPanel, null);

	JButton shoesPokaz = new JButton("Poka\u017C");

	JButton shoesDodaj = new JButton("Dodaj");
	shoesDodaj.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		ShoesFrame.show();
	    }
	});

	JButton shoesEdytuj = new JButton("Edytuj");

	JButton shoesUsun = new JButton("Usu\u0144");
	GroupLayout gl_shoesPanel = new GroupLayout(shoesPanel);
	gl_shoesPanel.setHorizontalGroup(gl_shoesPanel.createParallelGroup(Alignment.LEADING)
	        .addGroup(gl_shoesPanel.createSequentialGroup().addContainerGap().addComponent(shoesDodaj).addPreferredGap(ComponentPlacement.RELATED)
	                .addComponent(shoesEdytuj).addPreferredGap(ComponentPlacement.RELATED).addComponent(shoesUsun)
	                .addPreferredGap(ComponentPlacement.RELATED).addComponent(shoesPokaz).addContainerGap(131, Short.MAX_VALUE)));
	gl_shoesPanel.setVerticalGroup(gl_shoesPanel.createParallelGroup(Alignment.LEADING)
	        .addGroup(gl_shoesPanel
	                .createSequentialGroup().addContainerGap().addGroup(gl_shoesPanel.createParallelGroup(Alignment.BASELINE)
	                        .addComponent(shoesDodaj).addComponent(shoesEdytuj).addComponent(shoesUsun).addComponent(shoesPokaz))
	        .addContainerGap(202, Short.MAX_VALUE)));
	shoesPanel.setLayout(gl_shoesPanel);
	masterPanel.setLayout(gl_masterPanel);

	JMenuBar menuBar = new JMenuBar();
	frame.getContentPane().add(menuBar, BorderLayout.NORTH);

	JMenu mnPlik = new JMenu("Plik");
	menuBar.add(mnPlik);

	JMenuItem mntmImportZXml = new JMenuItem("Import z XML");
	mnPlik.add(mntmImportZXml);

	JMenuItem mntmExportDoXml = new JMenuItem("Export do XML");
	mnPlik.add(mntmExportDoXml);
    }
}
