package entidades.unidades;

public class ArmaDeAsedio extends Unidad {

	public ArmaDeAsedio() {
		super(150);
	}

	public Unidad crear_unidad() {
		ArmaDeAsedio arma_de_asedio_nueva = new ArmaDeAsedio();
		/*coste en oro, poblacion etc*/
		return arma_de_asedio_nueva;
	}
}
