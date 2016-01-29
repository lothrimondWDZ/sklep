package view;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import model.Pants;

public class PantsList {

	private List<Pants> pantsList;

	public PantsList() {
		pantsList = new ArrayList<Pants>();
	}

	public void add(final Pants p) {
		pantsList.add(p);
	}

	public void remove(final Pants pants) {
		pantsList.remove(pants);
	}

	public void edit(final Pants p, final Integer index) {
		pantsList.set(index, p);
	}

	public Pants get(Integer index) {
		return pantsList.get(index);
	}

	public Object[][] getTableModel() {
		Object[][] data = new Object[pantsList.size()][7];
		int i = 0;
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

	public List<Pants> getList() {
		return this.pantsList;
	}

	public void setList(List<Pants> pantsList) {
		this.pantsList = pantsList;
	}

}
