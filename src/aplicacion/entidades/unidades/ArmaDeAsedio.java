package entidades.unidades;

import Control.InformacionDeControl;
import entidades.edificios.Edificio;
import excepciones.NoPuedeRepararException;

public class ArmaDeAsedio extends Unidad {

	public ArmaDeAsedio() {
		super(150, 0, 75, "Arma de asedio",5);
	}




	public void actuar(){


	}
	//visor de informacion
	public void informacionBasica(){
		InformacionDeControl.visorDeInformacion(this);
	}
}
