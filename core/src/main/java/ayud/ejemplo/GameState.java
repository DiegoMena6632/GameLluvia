package ayud.ejemplo;

public class GameState {
	// Campo Estático Privado: Almacena la única instancia.
	private static GameState instancia;
	
	private int highScore;
	private boolean isGameOver;
	
	// Constructor Privado: Bloquea la instanciación externa.
	private GameState() {
		this.highScore = 0; 
		this.isGameOver = false;
	}
	
	// Método Estático Público (Único punto de acceso)
	public static GameState getInstance() {
		if(instancia == null) {
			instancia = new GameState();
		}
		return instancia;
	}
	
	public int getHighScore() {	
		return highScore;
	}
	
	public boolean isGameOver() {
		return isGameOver;
	}
	
	public void setHighScore(int score) {
        if (score > highScore) {
            highScore = score;
        }
	}
	
	public void setGameOver(boolean state) {
		this.isGameOver = state;
	}

}
