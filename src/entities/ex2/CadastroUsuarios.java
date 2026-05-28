package entities.ex2;

import java.util.ArrayList;

public class CadastroUsuarios {
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public boolean removeUsuario(String codigo) {
        return usuarios.removeIf(u -> u.getCodigo_unico().equals(codigo));
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public boolean idExiste(String codigo) {
        for (Usuario u : usuarios) {
            if (u.getCodigo_unico().equals(codigo)) {
                return true;
            }
        }
        return false;
    }
}