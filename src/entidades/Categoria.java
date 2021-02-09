//Ctrl+alt+shift+E
package entidades;


public class Categoria {
    private int id;
    private String nome;
    private char tipo;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return  nome ;
                
    }
    
    public String getNomeTipo(){
        return tipo =='F' ? "Filme" :"Jogo"; //condicinal ternario
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Categoria other = (Categoria) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
