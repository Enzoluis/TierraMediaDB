package tmDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PromocionesDAOImp implements PromocionDAO<Promociones> {

	@Override
	public List<Promociones> getAll(List<Atraccion> atracciones) throws SQLException {
		List<Promociones> promocion = new ArrayList<Promociones>();
		Map<Promociones, List<Atraccion>> mappromocion = new HashMap<Promociones, List<Atraccion>>();
		String sql = "SELECT * FROM Promociones" + " inner join tipo on tipo.id=Promociones.tipo_id"
				+ "inner join Atracciones_promociones on Atracciones_promociones.Promociones_id=Promociones_id"
				+ "inner join Atraccion on Atraccion.id=Atracciones_promociones.Atraccion_id;";
		Connection conexion = Conexion.getConexcion();
		PreparedStatement statement = conexion.prepareStatement(sql);
		ResultSet results = statement.executeQuery();

		return promocion;
	}

}
