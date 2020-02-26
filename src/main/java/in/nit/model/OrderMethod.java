package in.nit.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;

@Entity
public class OrderMethod {
	@Id
	@GeneratedValue
private Integer ordId;

private  String ordType;
private String ordCode;
private String ordMethod;
@ElementCollection(fetch = FetchType.EAGER)
@CollectionTable(name="OrdAceptab",joinColumns = @JoinColumn(name="ordId"))
@OrderColumn(name="pojs")
@Column(name="Accepttab")
private List<String> ordAccept;
private String ordDesc;
public OrderMethod() {
	super();
}
public Integer getOrdId() {
	return ordId;
}
public void setOrdId(Integer ordId) {
	this.ordId = ordId;
}
public String getOrdType() {
	return ordType;
}
public void setOrdType(String ordType) {
	this.ordType = ordType;
}
public String getOrdCode() {
	return ordCode;
}
public void setOrdCode(String ordCode) {
	this.ordCode = ordCode;
}
public String getOrdMethod() {
	return ordMethod;
}
public void setOrdMethod(String ordMethod) {
	this.ordMethod = ordMethod;
}
public List<String> getOrdAccept() {
	return ordAccept;
}
public void setOrdAccept(List<String> ordAccept) {
	this.ordAccept = ordAccept;
}
public String getOrdDesc() {
	return ordDesc;
}
public void setOrdDesc(String ordDesc) {
	this.ordDesc = ordDesc;
}
@Override
public String toString() {
	return "OrderMethod [ordId=" + ordId + ", ordType=" + ordType + ", ordCode=" + ordCode + ", ordMethod=" + ordMethod
			+ ", ordAccept=" + ordAccept + ", ordDesc=" + ordDesc + "]";
}

}
