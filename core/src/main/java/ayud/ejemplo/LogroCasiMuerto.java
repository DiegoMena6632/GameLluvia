package ayud.ejemplo;

public class LogroCasiMuerto extends Logro {
	
	public LogroCasiMuerto() {
        super("¡Al borde de la muerte!");
    }

    @Override
    protected boolean cumpleCondicion(Tarro tarro) {
        
        return tarro.getVidas() == 1 && tarro.getPuntos() > 200;
    }

}
