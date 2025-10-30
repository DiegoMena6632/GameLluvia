package ayud.ejemplo;

import com.badlogic.gdx.audio.Sound;

public class GotaEscudo extends Droppable {
    
    private Sound startSound; // El sonido de inicio del escudo

    public GotaEscudo(float x, float y, float velocidadY, Sound startSound) {
        // Llama al constructor padre con la ruta de la textura
        super(x, y, "escudo.png", velocidadY); 
        this.startSound = startSound;
    }

    // Implementación del método abstracto:
    @Override
    public void aplicarEfecto(Tarro tarro) {
        // 1. Crea una nueva instancia de la habilidad
        Escudo escudoPowerUp = new Escudo(); 
        
        // 2. Asigna y activa la habilidad en el Tarro
        tarro.setPowerUp(escudoPowerUp);
        
        // 3. Reproduce el sonido de inicio
        startSound.play(); 
    }
}