package engnetconsultoria.cadastro_teste;

/**
 * Created by daniel on 20/07/17.
 */

public class Usuario {
    private String name;
    private String email;

    public Usuario() {}

    public Usuario(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
