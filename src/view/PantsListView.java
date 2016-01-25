package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import model.Pants;

public class PantsListView extends JPanel {

	List<Pants> pantsList;
	
	public PantsListView() {
		pantsList = new ArrayList<Pants>();
	}
	
	public void addPants(final Pants pants){
		this.pantsList.add(pants);
	}
}
