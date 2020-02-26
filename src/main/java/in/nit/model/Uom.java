package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="uom")
public class Uom {
	
	@Id
	@GeneratedValue
	private Integer uomID;
	private String uomType;
	private String uomModel;
	@Column(name="udesc")
	private String uomdescription;
	public Uom() {
		super();
	}
	public Uom(Integer uomID) {
		super();
		this.uomID = uomID;
	}
	public Integer getUomID() {
		return uomID;
	}
	public void setUomID(Integer uomID) {
		this.uomID = uomID;
	}
	public String getUomType() {
		return uomType;
	}
	public void setUomType(String uomType) {
		this.uomType = uomType;
	}
	public String getUomModel() {
		return uomModel;
	}
	public void setUomModel(String uomModel) {
		this.uomModel = uomModel;
	}
	public String getUomdescription() {
		return uomdescription;
	}
	public void setUomdescription(String uomdescription) {
		this.uomdescription = uomdescription;
	}
	@Override
	public String toString() {
		return "Uom [uomID=" + uomID + ", uomType=" + uomType + ", uomModel=" + uomModel + ", uomdescription="
				+ uomdescription + "]";
	}
	

}
