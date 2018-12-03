package juego;

public class Juego {
        private Jugador jugadorDeTurno;
        private Jugador jugadorOponente;

        public Juego(String nombre1, String nombre2){
            this.jugadorDeTurno = new Jugador(nombre1);
            this.jugadorOponente = new Jugador(nombre2);
        }

        public void terminarTurno(){
            this.jugadorDeTurno.terminarTurno();
            if(this.acabo()){
                //se acabo el juego
            }
            this.cambiarJugadores();

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
}
