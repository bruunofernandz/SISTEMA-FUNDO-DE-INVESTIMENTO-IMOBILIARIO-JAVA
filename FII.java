public class FII {
    private String codigo;
    private double valor_cota;

    public FII() {
        this("", 0.0);
    }

    public FII(String codigo, double cota) {
        setCodigo(codigo);
        setCota(cota);
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCota(double cota) {
        this.valor_cota = cota;
    }

    public double getValorCota() {
        return this.valor_cota;
    }
}