package entidades.unidades;

import entidades.edificios.EdificioConstruible;
import entidades.edificios.Cuartel;
import entidades.edificios.Edificio;
import entidades.edificios.Plaza;
import entidades.unidades.StrategyAldeano.Constructor;
import entidades.unidades.StrategyAldeano.RecolectorOro;
import entidades.unidades.StrategyAldeano.Reparador;
import entidades.unidades.StrategyAldeano.StrategyAldeano;

public class Aldeano extends Unidad {

	private int oro;
	private StrategyAldeano strategy;


	public Aldeano() {
		super(50, 0, 0, "Aldeano",0);
		this.oro = 0;
		this.strategy = new RecolectorOro(this);
	}


	/////// SETEAR STRATEGY
	public void setStrategy(StrategyAldeano strategy){
		this.strategy = strategy;
	}

	// FIN SETEAR STRATEGY

	/////// REPARAR

	public void reparar(Edificio edificio){
		if(edificio.fullVida()){
			return; // exception aca!!.
		}
		this.setStrategy(new Reparador(edificio, this));
	}

	// FIN REPARAR.

	/////// CONSTRUCCION

	public Cuartel construirCuartel(){
		// Verificar q pueda construirlo en esa ubicacion
		Cuartel edificio = new Cuartel();
		this.construir(edificio);
		return edificio;
	}

	public Plaza construirPlaza(){
		// Verificar q pueda construirlo en esa ubicacion
		Plaza edificio = new Plaza();
		this.construir(edificio);
		return edificio;
	}

	public void construir(EdificioConstruible edificio){
		if(edificio.construido()){
			return;
		}
		this.setStrategy(new Constructor(edificio,this));
	}

	// FIN CONSTRUCCION

	/////// METODOS ORO
	public int getOro(){
		return this.oro;
	}

	public void sumarOro(int oro){
		this.oro +=oro;
	}

	// FIN METODOS ORO.
	//////// MODO ACTUAR / TURNO
	public void actuar(){
		this.strategy.actuar( );
	}
}
