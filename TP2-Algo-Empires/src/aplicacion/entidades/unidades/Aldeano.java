package entidades.unidades;

import entidades.edificios.Edificio;
import entidades.unidades.StateAldeano.RecolectorOro;
import entidades.unidades.StateAldeano.Reparador;
import entidades.unidades.StateAldeano.StrategyAldeano;

public class Aldeano extends Unidad {

	private int oro;
	private StrategyAldeano strategy;

	public Aldeano() {
		super(50);
		this.oro = 0;
		this.strategy = new RecolectorOro(this);
	}

	public void reparar(Edificio edificio){
		if(edificio.fullVida()){
			return; // exception aca!!.
		}
		this.setStrategy(new Reparador(edificio, this));
	}

	public void setStrategy(StrategyAldeano strategy){
		this.strategy = strategy;
	}


	public void construir(Edificio edificio){

	}
    public void actuar(){
		strategy.actuar( );
	}

	public int getOro(){
		return this.oro;
	}

	public void sumarOro(int oro){
		this.oro +=oro;
	}
}
