package in.nit.service;

import java.util.List;

import in.nit.model.ShipmentType;

public interface IShipmentTypeService {
	public Integer saveShipmentType(ShipmentType sp);
	public List<ShipmentType> getAllShipmentType();
	public void deleteShipmentType(Integer id);
	public ShipmentType getOneShipmentType(Integer id);
	public void updateShipmentType(ShipmentType st);
}
