package juego;

public class Juego {
        private Jugador jugadorDeTurno;
        private Jugador jugadorOponente;

        public Juego(String nombre1, String nombre2){
            this.jugadorDeTurno = new Jugador(nombre1);
            this.jugadorOponente = new Jugador(nombre2);
        }

        public Jugador terminarTurno(){
            this.jugadorDeTurno.terminarTurno();
            if(this.acabo()){
                //se acabo el juego
            }
            this.cambiarJugadores();
            return this.jugadorDeTurno;

        }

        private void cambiarJugadores(){
            Jugador aux;
            aux = this.jugadorDeTurno;
            this.jugadorDeTurno = this.jugadorOponente;
            this.jugadorOponente = aux;
        }

        public boolean acabo(){
            return this.jugadorOponente.haPerdido();
        }

    public Jugador getJugadorDeTurno() {
        return jugadorDeTurno;
    }
    public Jugador getJugadorEnEspera() {
        return jugadorOponente;
    }
}
