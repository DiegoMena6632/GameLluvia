package ayud.ejemplo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import java.util.Iterator;

public class Lluvia {
	private Array<Droppable> objetosCayendo;
    private long lastDropTime;
    private Sound dropSound;
    private Music rainMusic;
    private Tarro tarro; // Referencia al Tarro
    private Sound shieldStartSound;
    private Sound speedStartSound;
	   
	public Lluvia(Tarro tarro, Sound ss, Music mm, Sound shieldStartSound, Sound speedStartSound) {
		this.tarro = tarro;
		rainMusic = mm;
		dropSound = ss;
		this.shieldStartSound = shieldStartSound;
        this.speedStartSound = speedStartSound;
	}
	
	public void crear() {
		// Inicializamos el Array con el tipo abstracto Droppable
		objetosCayendo = new Array<>(); 
		crearGotaDeLluvia();
	    rainMusic.setLooping(true);
	    rainMusic.play();
	}
	
	private void crearGotaDeLluvia() {
		float x = MathUtils.random(0, 800 - 64);
	    float y = 480;
	    float velocidad = 300; // Velocidad de caída
	      
	    int tipo = MathUtils.random(1, 25); // Probabilidad de Power-up: 1 de cada 15 (aprox 6.6%)
	      
	    if (tipo < 3) {	    	  
	        objetosCayendo.add(new GotaMala(x, y, velocidad));
	    } else if (tipo == 24) { // Gota de Escudo
	        objetosCayendo.add(new GotaEscudo(x, y, velocidad, shieldStartSound));
        } else if (tipo == 25) { // Gota de SuperVelocidad
	        objetosCayendo.add(new GotaSuperVelocidad(x, y, velocidad, speedStartSound));
	    } else { 
	        objetosCayendo.add(new GotaBuena(x, y, dropSound, velocidad));
	    }
	    lastDropTime = TimeUtils.nanoTime();
	}
	
   public void actualizarMovimiento(Tarro tarro) { 
	   // Generar gotas de lluvia 
	   if(TimeUtils.nanoTime() - lastDropTime > 100000000) crearGotaDeLluvia();
	  
	// Iterador usando la clase abstracta Droppable
	   Iterator<Droppable> iter = objetosCayendo.iterator();
	   while (iter.hasNext()) {
		  Droppable objeto = iter.next();
	      
		  // Movimiento
	      objeto.mover();
	      
	      // Si cae al suelo y se elimina
	      if(objeto.getBounds().y + 64 < 0) {
	    	  objeto.dispose(); 
	    	  iter.remove(); 
	      }
	      
	      // Si el objeto choca con el tarro
	      if(objeto.getBounds().overlaps(tarro.getArea())) { 
	    	  
	    	// POLIMORFISMO: Se llama a aplicarEfecto(tarro)
	    	objeto.aplicarEfecto(tarro);
	          
	    	objeto.dispose();
	        iter.remove();
	      }
	   }
   }
   
   public void actualizarDibujoLluvia(SpriteBatch batch) { 
	   
	   for (Droppable objeto : objetosCayendo) {
		      objeto.dibujar(batch); 
		  }
   }
   public void destruir() {
	      dropSound.dispose();
	      rainMusic.dispose();
	      
	      for (Droppable objeto : objetosCayendo) {
	          objeto.dispose();
	      }
   }
   
}
