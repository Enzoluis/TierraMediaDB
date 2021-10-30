package turismoDeLaTierraMedia;

import java.util.Comparator;

public class CompararPorPreferencia implements Comparator<Producto> {
	private TipoAtraccion preferencia;

	public CompararPorPreferencia(TipoAtraccion preferencia) {
		this.preferencia = preferencia;
	}

	@Override
	public int compare(Producto p1, Producto p2) {
		int retorno;
		
		retorno = -Boolean.compare(p1.getTipo() == this.preferencia, p2.getTipo() == this.preferencia);
		//si ambas son del tipo de preferencia o no, se compara por el siguiente campo
		if (retorno == 0) {
			retorno = -Boolean.compare(p1.esPromo(), p2.esPromo());

			if (retorno == 0) {
				retorno = -Double.compare(p1.getCosto(), p2.getCosto());

				if (retorno == 0) {
					retorno = -Double.compare(p1.getTiempoDeVisita(), p2.getTiempoDeVisita());
				}
			}
		}

		return retorno;
	}

}
