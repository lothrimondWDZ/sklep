package view;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import model.Jacket;
import model.Pants;
import model.Shirt;
import model.Shoes;
import model.Tshirt;

@XmlRootElement(name = "xmlModel")
@XmlAccessorType (XmlAccessType.FIELD)
public class XMLModel {
	
	@XmlElement(name = "pantsList")
	private List<Pants> pantsList;
	@XmlElement(name = "shirtList")
	private List<Shirt> shirtList;
	@XmlElement(name = "tshirtList")
	private List<Tshirt> tshirtList;
	@XmlElement(name = "jacketList")
	private List<Jacket> jacketList;
	@XmlElement(name = "shoesList")
	private List<Shoes> shoesList;
	
	public void setPantsList(List<Pants> list) {
		this.pantsList = list;
	}
	public void setJacketList(List<Jacket> list) {
		this.jacketList = list;
	}
	public void setShoesList(List<Shoes> list) {
		this.shoesList = list;
	}
	public void setShirtList(List<Shirt> list) {
		this.shirtList = list;
	}
	public void setTshirtList(List<Tshirt> list) {
		this.tshirtList = list;
	}
	
	public List<Tshirt> getTshirtList() {
		return tshirtList;
	}
	public List<Pants> getPantsList() {
		return pantsList;
	}
	public List<Shirt> getShirtList() {
		return shirtList;
	}
	public List<Jacket> getJacketList() {
		return jacketList;
	}
	public List<Shoes> getShoesList() {
		return shoesList;
	}

}
