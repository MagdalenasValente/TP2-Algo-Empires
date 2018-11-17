package habilidades.ataques;


public class AtaqueDeArmaDeAsedio extends Ataque {

    public AtaqueDeArmaDeAsedio(){
        danio_a_unidades = 0;/*el ataque a unidades debe ser invalido*/
        danio_a_edificios = 75;
        rango = 5;
        se_deve_montar = true;
    }
}
