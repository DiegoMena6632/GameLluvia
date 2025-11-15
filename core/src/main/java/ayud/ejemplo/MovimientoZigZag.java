package ayud.ejemplo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;

public class MovimientoZigZag implements EstrategiaMovimiento {
	
	private float intensidad;
	
	
	public MovimientoZigZag(float intensidad) {
        this.intensidad = intensidad;
    }
    @Override
    public void mover(Droppable objeto) {
        // Baja un poco
        objeto.getBounds().y -= objeto.getVelocidadY() * Gdx.graphics.getDeltaTime();
        
        
        float oscilacion = MathUtils.sin(Gdx.graphics.getFrameId() * 0.1f) * intensidad; 
        objeto.getBounds().x += oscilacion;
    }
}