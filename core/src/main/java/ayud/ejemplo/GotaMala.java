package ayud.ejemplo;

// GotaMala extiende la clase abstracta
public class GotaMala extends Droppable
{
	
    public GotaMala(float x, float y, float velocidadY, String PNG)
    {
        // Llama al constructor padre con la ruta de su textura
        super(x, y,PNG, velocidadY , new MovimientoZigZag(18f));
    }

    // Implementación del método abstracto:
    @Override
    public void aplicarEfecto(Tarro tarro) {
        // Lógica: Dañar al tarro (usa el método que ya tienes en Tarro)
        tarro.dañar();
    }
}
