package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import model.Pants;

public class PantsListView extends JPanel {

	private List<Pants> pantsList;
	
	public PantsListView() {
		pantsList = new ArrayList<Pants>();
	}
	
	public void addPants(final Pants pants){
		System.out.println(pants);
		this.pantsList.add(pants);
		System.out.println(pantsList.size());
	}

	public List<Pants> getPantsList() {
		return pantsList;
	}

	public void setPantsList(List<Pants> pantsList) {
		this.pantsList = pantsList;
	}
	
}
