package ayud.ejemplo;
import com.badlogic.gdx.audio.Sound;
public class PatioFactory extends DroppableFactory
{
	public PatioFactory()
	{
		this.gotabuenaPNG = "drop.png";
		this.gotaMalaPNG = "dropBad.png";
		this.gotaEscudoPNG = "escudo.png";
		this.gotaSupervelocidadPNG = "Rayo.png";
	}
	
	@Override
	public GotaBuena crearGotaBuena(float x, float y, Sound dropSound, float velocidadY)
    {
        return new GotaBuena( x,  y, dropSound, velocidadY, gotabuenaPNG);
    }
	
	@Override
    public GotaMala crearGotaMala(float x, float y, float velocidadY)
    {
        return new GotaMala( x,  y,  velocidadY, gotaMalaPNG);
    }
	
	@Override
    public  GotaEscudo crearEscudo(float x, float y, Sound dropSound, float velocidadY)
    {
        return new GotaEscudo(x,  y,  velocidadY, dropSound, gotaEscudoPNG);
    }
	
	@Override
    public GotaSuperVelocidad crearSuperVelocidad(float x, float y, Sound dropSound, float velocidadY)
    {
        return new GotaSuperVelocidad(x,  y,  velocidadY, dropSound, gotaSupervelocidadPNG);
    }
}
