package ayud.ejemplo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
	private OrthographicCamera camera;
	private SpriteBatch batch;	   
	private BitmapFont font;
	
	private Sound shieldStartSound;
    private Sound shieldEndSound;
    private Sound speedStartSound;
    private Sound speedEndSound;
	   
	private Tarro tarro;
	private Lluvia lluvia;
	@Override
	public void create ()
	{
		font = new BitmapFont(); // use libGDX's default Arial font
		 
		// load the images for the droplet and the bucket, 64x64 pixels each 	     
		Sound hurtSound = Gdx.audio.newSound(Gdx.files.internal("hurt.ogg"));
		shieldStartSound = Gdx.audio.newSound(Gdx.files.internal("shield_start.mp3"));
        shieldEndSound = Gdx.audio.newSound(Gdx.files.internal("shield_end.mp3"));
        speedStartSound = Gdx.audio.newSound(Gdx.files.internal("speed_start.mp3"));
        speedEndSound = Gdx.audio.newSound(Gdx.files.internal("speed_end.mp3"));
		tarro = new Tarro(new Texture(Gdx.files.internal("bucket.png")),hurtSound, shieldEndSound, speedEndSound);
       
	    // load the drop sound effect and the rain background "music" 
		//Texture gota = new Texture(Gdx.files.internal("drop.png"));
        //Texture gotaMala = new Texture(Gdx.files.internal("dropBad.png"));
       
        Sound dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
      
	    Music rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
        lluvia = new Lluvia(tarro, dropSound, rainMusic, shieldStartSound, speedStartSound);
	      
	    // camera
	    camera = new OrthographicCamera();
	    camera.setToOrtho(false, 800, 480);
	    batch = new SpriteBatch();
	    // creacion del tarro
	    tarro.crear();
	      
	    // creacion de la lluvia
	    lluvia.crear();
	}
	


	@Override
	public void render () {
		//limpia la pantalla con color azul obscuro.
		ScreenUtils.clear(0, 0, 0.2f, 1);
		//actualizar matrices de la cámara
		camera.update();
		//actualizar 
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		
		Potenciador currentPU = tarro.getActualPowerUp();
		if (currentPU != null) {
		    // 1. Reduce el tiempo restante del power-up
		    currentPU.actualizar(Gdx.graphics.getDeltaTime()); 
		    
		    // 2. Verifica si el tiempo ya llegó a cero
		    if (currentPU.haExpirado()) { 
		        // Llama a la lógica de terminación
		        currentPU.revertir(tarro); 
		        
		        // Finaliza el power-up en el Tarro (limpia la referencia)
		        tarro.setPowerUp(null); 
		    }
		}
		
		//dibujar textos
		font.draw(batch, "Gotas totales: " + tarro.getPuntos(), 5, 475);
		font.draw(batch, "Vidas : " + tarro.getVidas(), 720, 475);
		
		if (!tarro.estaHerido()) {
			// movimiento del tarro desde teclado
	        tarro.actualizarMovimiento();        
			// caida de la lluvia 
	        lluvia.actualizarMovimiento(tarro);	   
		}
		
		tarro.dibujar(batch);
		lluvia.actualizarDibujoLluvia(batch);
		
		batch.end();	
		
	}
	
	@Override
	public void dispose () {
	      tarro.destruir();
       lluvia.destruir();
	      batch.dispose();
	      font.dispose();
	      shieldStartSound.dispose();
          shieldEndSound.dispose();
          speedStartSound.dispose();
          speedEndSound.dispose();
	}
}
