import java.io.Serializable;
import java.util.Date;

public class Persona implements Serializable {
    private static final long serialVersionUID = 100L;
    private String name;
    private String email;
    private Date nacimiento;

    public Persona(String name, String email, Date nacimiento) {
        this.name = name;
        this.email = email;
        this.nacimiento = nacimiento;
    }

    public void escribir() {
        System.out.println("Persona -> Nombre: "+name+", email: "+email+", fecha de nacimiento: "+nacimiento);
    }
}
