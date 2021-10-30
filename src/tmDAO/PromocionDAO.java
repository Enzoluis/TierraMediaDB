package tmDAO;

public interface PromocionDAO<T> {
	public List<Promociones> getAll(List<Atraccion> atracciones) throws SQLException;
}
