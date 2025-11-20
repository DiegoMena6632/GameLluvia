package ayud.ejemplo;

public class LogroPrimerosPuntos extends Logro {
	
	public LogroPrimerosPuntos()
	{
		super("Primeros Puntos (500 Ptos)");
	}
	
	@Override
    protected boolean cumpleCondicion(Tarro tarro) {
        return tarro.getPuntos() >= 250;
    }

	

}
