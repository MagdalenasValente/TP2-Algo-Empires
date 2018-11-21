package entidades.unidades;

import entidades.edificios.Cuartel;
import entidades.edificios.Edificio;
import entidades.unidades.StrategyAldeano.Constructor;
import entidades.unidades.StrategyAldeano.RecolectorOro;
import entidades.unidades.StrategyAldeano.Reparador;
import entidades.unidades.StrategyAldeano.StrategyAldeano;

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


	public Cuartel construirCuartel(){
		// Verificar q pueda construirlo en esa ubicacion
		Cuartel edificio = new Cuartel();
		this.setStrategy(new Constructor(edificio,this));
		return edificio;
	}


	public int getOro(){
		return this.oro;
	}

	public void sumarOro(int oro){
		this.oro +=oro;
	}

	public void actuar(){
		strategy.actuar( );
	}
}
