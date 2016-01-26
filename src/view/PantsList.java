package view;

import java.util.ArrayList;
import java.util.List;

import model.Pants;

public class PantsList {

    private List<Pants> pantsList;

	public PantsList(){
		this.pantsList = new ArrayList<Pants>();
	}
	
	public void add(final Pants p){
		pantsList.add(p);
	}
	
	public void remove(final Integer index){
		pantsList.remove(index);
	}
	
	public void edit(final Pants p, final Integer index){
		pantsList.set(index, p);
	}
	
	public Pants get(Integer index){
		return pantsList.get(index);
	}
	
	public Object[][] getTableModel(){
		Object[][] data = new Object[pantsList.size()][7];
		int i = 0;
		// "Rodzaj", "Nazwa", "Cena", "Kolor", "Marka", "Rozmiar w pasie", "D³ugoœæ"
		for (Pants p : pantsList) {
		    data[i][0] = p.getGender().getName();
		    data[i][1] = p.getName();
		    data[i][2] = p.getPrice().toString();
		    data[i][3] = p.getColor();
		    data[i][4] = p.getBrand();
		    data[i][5] = p.getWaistSize().toString();
		    data[i][6] = p.getLength().toString();
		    i++;
		}
		return data;
    }

}
