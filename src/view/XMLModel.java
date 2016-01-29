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

/**
 * 
 * Klasa zbierająca wszystkie ubrania przy imporcie/exporcie z/do pliku XML
 *
 */
@XmlRootElement(name = "xmlModel")
@XmlAccessorType (XmlAccessType.FIELD)
public class XMLModel {
	
	/**
	 * lista spodni dostępnych w sklepie
	 */
	@XmlElement(name = "pantsList")
	private List<Pants> pantsList;
	/**
	 * lista koszul dostępnych w sklepie
	 */
	@XmlElement(name = "shirtList")
	private List<Shirt> shirtList;
	/**
	 * lista koszulek dostępnych w sklepie
	 */
	@XmlElement(name = "tshirtList")
	private List<Tshirt> tshirtList;
	/**
	 * lista kurtek dostępnych w sklepie
	 */
	@XmlElement(name = "jacketList")
	private List<Jacket> jacketList;
	/**
	 * lista butów dostępnych w sklepie
	 */
	@XmlElement(name = "shoesList")
	private List<Shoes> shoesList;
	
	/**
	 * Import listy spodni
	 * @param {@link List} lista spodni
	 */
	public void setPantsList(List<Pants> list) {
		this.pantsList = list;
	}
	/**
	 * Import listy kurtek
	 * @param {@link List} lista kurtek
	 */
	public void setJacketList(List<Jacket> list) {
		this.jacketList = list;
	}
	/**
	 * Import listy butów
	 * @param {@link List} lista butów
	 */
	public void setShoesList(List<Shoes> list) {
		this.shoesList = list;
	}
	/**
	 * Import listy koszul
	 * @param {@link List} lista koszul
	 */
	public void setShirtList(List<Shirt> list) {
		this.shirtList = list;
	}
	/**
	 * Import listy koszulek
	 * @param {@link List} lista koszulek
	 */
	public void setTshirtList(List<Tshirt> list) {
		this.tshirtList = list;
	}
	
	/**
	 * Pobranie listy koszulek
	 * @return {@link List} lista koszulek
	 */
	public List<Tshirt> getTshirtList() {
		return tshirtList;
	}
	/**
	 * Pobranie listy spodni
	 * @return {@link List} lista spodni
	 */
	public List<Pants> getPantsList() {
		return pantsList;
	}
	/**
	 * Pobranie listy koszul
	 * @return {@link List} lista koszul
	 */
	public List<Shirt> getShirtList() {
		return shirtList;
	}
	/**
	 * Pobranie listy kurtek
	 * @return {@link List} lista kurtek
	 */
	public List<Jacket> getJacketList() {
		return jacketList;
	}
	/**
	 * Pobranie listy butów
	 * @return {@link List} lista butów
	 */
	public List<Shoes> getShoesList() {
		return shoesList;
	}

}
