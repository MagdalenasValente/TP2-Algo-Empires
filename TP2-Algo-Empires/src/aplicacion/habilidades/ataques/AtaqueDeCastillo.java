package habilidades.ataques;


public class AtaqueDeCastillo extends Ataque {

    public AtaqueDeCastillo(){
        danio_a_unidades = 20;
        danio_a_edificios = danio_a_unidades;
        rango = 3;
        se_deve_montar = false;
    }
}
