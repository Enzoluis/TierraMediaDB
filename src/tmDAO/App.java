package tmDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

//import turismoDeLaTierraMedia.TurismoTierraMedia;

public class App {

	public static void main(String[] args) throws SQLException {
		AtraccionDAOImp aDAO = new AtraccionDAOImp();
		List<Atraccion> atracciones= aDAO.getAll();
		atracciones.get(0).setCupo(0);
		aDAO.update(atracciones.get(0));
		System.out.print(atracciones);		
	}

}
