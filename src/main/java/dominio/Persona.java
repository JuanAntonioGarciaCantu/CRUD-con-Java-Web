//representa una entidad de la base de datos (MODELO)

package dominio;

public class Persona {
    //atributos, deben corresponder a los de la BD
    private int IdPersona;
    private String Nombre;
    private String ApellidoPaterno;
    private String ApellidoMaterno;
    private int Edad;
    private char Sexo;

    // constructor vacio
    public Persona() {
    }

    // constructor solo con el idPersona
    public Persona(int IdPersona) {
        this.IdPersona = IdPersona;
    }

    // constructor con todos los atributos excepto idPersona
    public Persona(String Nombre, String ApellidoPaterno, String ApellidoMaterno, int Edad, char Sexo) {
        this.Nombre = Nombre;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
        this.Edad = Edad;
        this.Sexo = Sexo;
    }

    // constructor con todos los atributos
    public Persona(int IdPersona, String Nombre, String ApellidoPaterno, String ApellidoMaterno, int Edad, char Sexo) {
        this.IdPersona = IdPersona;
        this.Nombre = Nombre;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
        this.Edad = Edad;
        this.Sexo = Sexo;
    }

    public int getIdPersona() {
        return IdPersona;
    }
    
    public void setIdPersona(int IdPersona) {
        this.IdPersona = IdPersona;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoPaterno(String ApellidoPaterno) {
        this.ApellidoPaterno = ApellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String ApellidoMaterno) {
        this.ApellidoMaterno = ApellidoMaterno;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public char getSexo() {
        return Sexo;
    }

    public void setSexo(char Sexo) {
        this.Sexo = Sexo;
    }

    @Override
    public String toString() {
        return "Persona{" + "IdPersona=" + IdPersona + ", Nombre=" + Nombre + ", ApellidoPaterno=" + ApellidoPaterno + ", ApellidoMaterno=" + ApellidoMaterno + ", Edad=" + Edad + ", Sexo=" + Sexo + '}';
    }
    
    
}
