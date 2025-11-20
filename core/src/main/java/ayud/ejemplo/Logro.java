package ayud.ejemplo;

public abstract class Logro {
    private boolean desbloqueado = false;
    private String nombre;

    public Logro(String nombre) {
        this.nombre = nombre;
    }

   
    public final boolean verificar(Tarro tarro) {
       
        if (desbloqueado) return false;

        
        if (cumpleCondicion(tarro)) {
            
            
            desbloqueado = true;
            
            
            return true;
        }
        
        return false;
    }

    protected abstract boolean cumpleCondicion(Tarro tarro);

    public String getNombre() {
        return nombre;
    }
}  
  
