package ayud.ejemplo;

public class Escudo implements Potenciador {
    
    private float duracion = 7.0f; // Duración del efecto en segundos
    private float tiempoRestante = duracion;

    @Override
    public void aplicar(Tarro tarro) {
        // Activa la bandera de inmunidad en el Tarro (Tarro debe tener setInmune(true))
        tarro.setInmune(true); 
    }

    @Override
    public void revertir(Tarro tarro) {
        // Desactiva la bandera de inmunidad
        tarro.setInmune(false);
        
        // Llama a Tarro para reproducir el sonido de fin del power-up
        tarro.reproducirSonidoFin(this);
    }

    @Override
    public void actualizar(float deltaTime) {
        tiempoRestante -= deltaTime;
    }

    @Override
    public boolean haExpirado() {
        return tiempoRestante <= 0;
    }
}
