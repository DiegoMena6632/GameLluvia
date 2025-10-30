package ayud.ejemplo;

/**
 * Define el contrato para cualquier habilidad temporal (Power-Up) que el Tarro pueda adquirir.
 */
public interface Potenciador {

    /**
     * Aplica los efectos iniciales del potenciador al Tarro.
     * @param tarro La instancia de Tarro afectada.
     */
    void aplicar(Tarro tarro);

    /**
     * Revierte los cambios hechos al Tarro y desactiva el potenciador.
     * @param tarro La instancia de Tarro afectada.
     */
    void revertir(Tarro tarro);

    /**
     * Actualiza el estado del potenciador, generalmente reduciendo su tiempo restante.
     * @param deltaTime El tiempo transcurrido desde el último frame (Gdx.graphics.getDeltaTime()).
     */
    void actualizar(float deltaTime);
    
    /**
     * Verifica si el tiempo del potenciador ha expirado.
     * @return true si el potenciador debe ser removido.
     */
    boolean haExpirado();
}
