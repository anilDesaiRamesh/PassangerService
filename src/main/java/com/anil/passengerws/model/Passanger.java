/**
 * 
 */
package com.anil.passengerws.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Anil_Ramesh
 *
 */
@XmlRootElement
public class Passanger {

	private int id;
	private String name;

	public Passanger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Passanger(int currentId, String string) {
		// TODO Auto-generated constructor stub
		this.id = currentId;
		this.name = string;
	}

	@Override
	public String toString() {
		return "Passanger [id=" + id + ", name=" + name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
