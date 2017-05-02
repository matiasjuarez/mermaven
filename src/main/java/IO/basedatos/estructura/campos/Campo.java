package IO.basedatos.estructura.campos;

/**
 * Created by Matías on 01/05/2017.
 */
public class Campo {

    public enum Tipo{
        FLOAT("FLOAT"),
        DATE("DATE");

        private String nombre;

        private Tipo(String nombre){
            this.nombre = nombre;
        }

        public String toString(){
            return nombre;
        }
    }

    private String nombre;
    private Tipo tipoValor;
    private CampoAtributosExtra campoAtributosExtra;

    public Campo(String nombre, Tipo tipoValor){
        this(nombre, tipoValor, null);
    }

    public Campo(String nombre, Tipo tipoValor, CampoAtributosExtra campoAtributosExtra){
        this.nombre = nombre;
        this.tipoValor = tipoValor;
        this.campoAtributosExtra = campoAtributosExtra;
    }

    public String getNombre() {
        return nombre;
    }

    public Tipo getTipoValor() {
        return tipoValor;
    }

    public CampoAtributosExtra getCampoAtributosExtra() {
        return campoAtributosExtra;
    }
}
