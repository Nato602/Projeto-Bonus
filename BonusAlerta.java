
package Principal;



public class BonusAlerta extends Exception{
    private int codigoErro;

    public BonusAlerta(int codigoErro, String mensagem) {
        super(mensagem);
        this.codigoErro = codigoErro;
    }

    public int getCodigoErro() {
        return codigoErro;
    }

    
}
