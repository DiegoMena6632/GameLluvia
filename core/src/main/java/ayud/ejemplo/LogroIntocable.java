package ayud.ejemplo;

public class LogroIntocable extends Logro {
    public LogroIntocable() {
        super("Anti-Perros (Perfect Score) ");
    }

    @Override
    protected boolean cumpleCondicion(Tarro tarro) {
        
        return tarro.getPuntos() >= 1000 && tarro.getVidas() == 3;
    }
}
