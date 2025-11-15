package ayud.ejemplo;

import com.badlogic.gdx.Gdx;

public class MovimientoRecto implements EstrategiaMovimiento {
    @Override
    public void mover(Droppable objeto) {
       
        objeto.getBounds().y -= objeto.getVelocidadY() * Gdx.graphics.getDeltaTime();
    }
}