package appagenda;
public class Telefone
{   private String numero;
    private String tipo;
    public Telefone(String numero, String tipo)
    {   this.numero = numero;
        this.tipo = tipo;
    }
    public String getTelefone()
    {   return numero+" "+tipo;
    }

}
