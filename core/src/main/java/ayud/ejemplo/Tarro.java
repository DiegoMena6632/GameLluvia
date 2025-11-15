package ayud.ejemplo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;


public class Tarro {
	   private Rectangle bucket;
	   private Texture bucketImage;
	   private Sound sonidoHerido;
	   private int vidas = 3;
	   private int puntos = 0;
	   private int velx = 400;
	   private final int VELX_ORIGINAL = 400;
	   private boolean herido = false;
	   private int tiempoHeridoMax=50;
	   private int tiempoHerido;
	   
	   private Potenciador actualPowerUp = null;
	   private boolean inmune = false;
	   
	   private Sound shieldEndSound; 
	   private Sound speedEndSound;
	   
	   public Tarro(Texture tex, Sound ss, Sound shieldEnd, Sound speedEnd) {
		   this.bucketImage = tex;
		   this.sonidoHerido = ss;
		   this.shieldEndSound = shieldEnd;
	       this.speedEndSound = speedEnd;
	   }
	   
	   public Potenciador getActualPowerUp() {
		    return actualPowerUp;
		}
	   
		public int getVidas() {
			return vidas;
		}
	
		public int getPuntos() {
			return puntos;
		}
		public Rectangle getArea() {
			return bucket;
		}
		public void sumarPuntos(int pp) {
			puntos+=pp;
		}
		
		public int getVelocidadOriginal() {
            return VELX_ORIGINAL;
        }
		
		public void setVelocidad(int nuevaVelx) {
            this.velx = nuevaVelx;
        }
		
		public void setInmune(boolean estado) {
            this.inmune = estado;
        }
	
	   public void crear() {

		      bucket = new Rectangle();
		      bucket.x = 800 / 2 - 64 / 2;
		      bucket.y = 20;
		      bucket.width = 70;
		      bucket.height = 70;
	   }
	   
	   public void reproducirSonidoFin(Potenciador powerUp)
	   {
	        if (powerUp instanceof Escudo)
	        {
	            shieldEndSound.play();
	        } else if (powerUp instanceof SuperVelocidad) {
	            speedEndSound.play();
	        }
	   }
	   
	   public void setPowerUp(Potenciador newPowerUp) {
		   // 1. Revertir el anterior si existe
		    if (this.actualPowerUp != null) {
		        this.actualPowerUp.revertir(this); 
		    }
		    
		    // 2. Asignar el nuevo
		    this.actualPowerUp = newPowerUp;
		    
		    // 3. ¡SOLO aplicar si NO es NULL
		    if (this.actualPowerUp != null) { 
		        this.actualPowerUp.aplicar(this);
		    }
		}
	   
	   public void dañar() {
		   if(this.inmune) {return;}
		  vidas--;
		  herido = true;
		  tiempoHerido=tiempoHeridoMax;
		  sonidoHerido.play();
		  
		  if (vidas <= 0) {
			  // Se obtiene la única instancia y se establece el estado a Game Over
			  GameState.getInstance().setGameOver(true); 
		  }
	   }
	   public void dibujar(SpriteBatch batch) {
		 float drawX = bucket.x;
		 float drawY = bucket.y;
		 float drawWidth = bucket.width; // 64
		 float drawHeight = bucket.height; // 64
		 if (!herido)  
		   batch.draw(bucketImage, drawX, drawY, drawWidth, drawHeight);
		 else {
		
		   batch.draw(bucketImage, drawX, drawY, drawWidth, drawHeight);
		   tiempoHerido--;
		   if (tiempoHerido<=0) herido = false;
		 }
	   } 
	   
	   
	   public void actualizarMovimiento() { 
		   // movimiento desde mouse/touch
		   /*if(Gdx.input.isTouched()) {
			      Vector3 touchPos = new Vector3();
			      touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			      camera.unproject(touchPos);
			      bucket.x = touchPos.x - 64 / 2;
			}*/
		   //movimiento desde teclado
		   if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) bucket.x -= velx * Gdx.graphics.getDeltaTime();
		   if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) bucket.x += velx * Gdx.graphics.getDeltaTime();
		   // que no se salga de los bordes izq y der
		   if(bucket.x < 0) bucket.x = 0;
		   if(bucket.x > 800 - 64) bucket.x = 800 - 64;
	   }
	    

	public void destruir() {
		    bucketImage.dispose();
	   }
	
   public boolean estaHerido() {
	   return herido;
   }	
	   
}
