package ayud.ejemplo;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class Droppable {
	protected Rectangle bounds;
	protected Texture texture;
	protected float velocidadY;
	protected EstrategiaMovimiento estrategia;
	
	public Droppable(float x, float y, String texturePath, float velocidadY , EstrategiaMovimiento estrategiaInicial)
	{
		this.bounds = new Rectangle(x, y, 64, 64);
		this.texture = new Texture(Gdx.files.internal(texturePath));
		this.velocidadY = velocidadY;
		this.estrategia = estrategiaInicial;
	}
	
	public void mover() {
        estrategia.mover(this);
    }
	
	public void dibujar(SpriteBatch batch) {
        batch.draw(texture, bounds.x, bounds.y, bounds.width, bounds.height);
    }
	
	public Rectangle getBounds() { return bounds; }
	public float getVelocidadY() {return velocidadY;}
		
	public abstract void aplicarEfecto(Tarro tarro);
	
	
	public void dispose() {
        texture.dispose();
    }
}
