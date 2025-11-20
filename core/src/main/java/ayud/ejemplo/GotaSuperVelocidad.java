package ayud.ejemplo;

import com.badlogic.gdx.audio.Sound;

public class GotaSuperVelocidad extends Droppable {
    
    private Sound startSound; // El sonido de inicio de la velocidad

    public GotaSuperVelocidad(float x, float y, float velocidadY, Sound startSound, String PNG) {
        // Llama al constructor padre con la ruta de la textura
        // Esta gota cae un poco más rápido (ej. 1.2f)
        super(x, y, PNG, velocidadY * 1.2f , new MovimientoZigZag(5f)); 
        this.startSound = startSound;
    }

    // Implementación del método abstracto:
    @Override
    public void aplicarEfecto(Tarro tarro) {
        // 1. Crea una nueva instancia de la habilidad
        SuperVelocidad velocidadPowerUp = new SuperVelocidad();
        
        // 2. Asigna y activa la habilidad en el Tarro
        tarro.setPowerUp(velocidadPowerUp);
        
        // 3. Reproduce el sonido de inicio
        startSound.play();
    }
}