package entidades.unidades;

import Control.InformacionDeControl;
import entidades.edificios.Edificio;
import excepciones.NoPuedeRepararException;

public class ArmaDeAsedio extends Unidad {
	private boolean montada;

	public ArmaDeAsedio() {
		super(150, 0, 75, "Arma de asedio",5);
		montada = false;
		this.agregarCosteEnOro(200);
	}

	public void montarDesmontar(){
		montada = !montada;
	}
	public boolean estaMontada(){
		return montada;
	}


	public void actuar(){


	}
	//visor de informacion
	public void informacionBasica(){
		InformacionDeControl.visorDeInformacion(this);
	}
}
