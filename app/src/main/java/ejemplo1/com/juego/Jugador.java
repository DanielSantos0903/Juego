package ejemplo1.com.juego;

public class Jugador {
    private String nick;
    private String puntaje;

    public Jugador(){

    }
    public Jugador(String nick, String puntaje) {
        this.nick = nick;
        this.puntaje = puntaje;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(String puntaje) {
        this.puntaje = puntaje;
    }
}

