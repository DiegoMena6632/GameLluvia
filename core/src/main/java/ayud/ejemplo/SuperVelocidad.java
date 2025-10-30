package ayud.ejemplo;

public class SuperVelocidad implements Potenciador {
    
    private float duracion = 5.0f; // Duración del efecto en segundos
    private float tiempoRestante = duracion;

    @Override
    public void aplicar(Tarro tarro) {
        // Duplica la velocidad (Tarro debe tener getVelocidadOriginal() y setVelocidad())
        tarro.setVelocidad(tarro.getVelocidadOriginal() * 2);
    }

    @Override
    public void revertir(Tarro tarro) {
        // Restaura la velocidad original
        tarro.setVelocidad(tarro.getVelocidadOriginal()); 
        
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
