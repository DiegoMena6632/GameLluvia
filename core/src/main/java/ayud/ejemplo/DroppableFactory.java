package ayud.ejemplo;

import com.badlogic.gdx.audio.Sound;

public abstract class DroppableFactory 
{
	protected String gotabuenaPNG;
	protected String gotaMalaPNG;
	protected String gotaEscudoPNG;
	protected String gotaSupervelocidadPNG;
	
	
	public abstract GotaBuena crearGotaBuena(float x, float y, Sound dropSound, float velocidadY);
    public abstract GotaMala crearGotaMala(float x, float y, float velocidadY);
    public abstract GotaEscudo crearEscudo(float x, float y, Sound dropSound, float velocidadY);
    public abstract GotaSuperVelocidad crearSuperVelocidad(float x, float y, Sound dropSound, float velocidadY);

}
