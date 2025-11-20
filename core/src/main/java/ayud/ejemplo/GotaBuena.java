package ayud.ejemplo;

import com.badlogic.gdx.audio.Sound;

// GotaBuena extiende la clase abstracta
public class GotaBuena extends Droppable {

    private Sound dropSound;

    public GotaBuena(float x, float y, Sound dropSound, float velocidadY, String PNG) {
        super(x, y, PNG, velocidadY , new MovimientoRecto());
        this.dropSound = dropSound; 
    }

    // Implementación del método abstracto:
    @Override
    public void aplicarEfecto(Tarro tarro) {
        tarro.sumarPuntos(10);
        
        // Efecto de sonido
        dropSound.play();
    }
}