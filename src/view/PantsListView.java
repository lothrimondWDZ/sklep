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

    public void addPants(final Pants pants) {
	System.out.println(pants);
	pantsList.add(pants);
	System.out.println(pantsList.size());
    }

    public List<Pants> getPantsList() {
	return pantsList;
    }

    public void setPantsList(List<Pants> pantsList) {
	this.pantsList = pantsList;
    }

    public Object[][] getData() {
	Object[][] data = new Object[pantsList.size()][7];
	int i = 0;
	// "Rodzaj", "Nazwa", "Cena", "Kolor", "Marka", "Rozmiar w pasie", "D³ugoœæ"
	for (Pants p : pantsList) {
	    int j = 0;
	    data[i][j] = p.getGender().getName();
	    j++;
	    data[i][j] = p.getName();
	    j++;
	    data[i][j] = p.getPrice().toString();
	    j++;
	    data[i][j] = p.getColor();
	    j++;
	    data[i][j] = p.getBrand();
	    j++;
	    data[i][j] = p.getWaistSize().toString();
	    j++;
	    data[i][j] = p.getLength().toString();
	    j++;
	    i++;
	}
	return data;
    }

}
