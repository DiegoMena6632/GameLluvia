package ayud.ejemplo;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class Droppable {
	protected Rectangle bounds;
	protected Texture texture;
	protected float velocidadY;
	
	public Droppable(float x, float y, String texturePath, float velocidadY)
	{
		this.bounds = new Rectangle(x, y, 64, 64);
		this.texture = new Texture(Gdx.files.internal(texturePath));
		this.velocidadY = velocidadY;
	}
	
	public void mover()
	{
		bounds.y -= velocidadY * Gdx.graphics.getDeltaTime();
	}
	
	public void dibujar(SpriteBatch batch) {
        batch.draw(texture, bounds.x, bounds.y, bounds.width, bounds.height);
    }
	
	//Método abstracto(las clases hijas deben definir su efecto) 
	public abstract void aplicarEfecto(Tarro tarro);
	
	public Rectangle getBounds() {
        return bounds;
    }
	
	public void dispose() {
        texture.dispose();
    }
}
