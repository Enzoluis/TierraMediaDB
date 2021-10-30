package tmDAO;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T> {
	public List<T> getAll() throws SQLException;
	public void update(T y)throws SQLException;
}
