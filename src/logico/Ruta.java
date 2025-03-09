package logico;

public class Ruta {

    private Parada origen;
    private Parada destino;
    private int tiempo;
    private int distancia;
    private double costo;
    private int transbordos;

    public Ruta(Parada origen, Parada destino, int tiempo, int distancia, double costo) {
        this.origen = origen;
        this.destino = destino;
        this.tiempo = tiempo;
        this.distancia = distancia;
        this.costo = costo;
        this.transbordos = 0;
    }

    public Parada getOrigen() {
        return origen;
    }

    public Parada getDestino() {
        return destino;
    }

    public int getTiempo() {
        return tiempo;
    }

    public int getDistancia() {
        return distancia;
    }

    public int getTransbordos() {
        return transbordos;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setTransbordos(int transbordos) {
        this.transbordos = transbordos;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public void setOrigen(Parada origen) {
        this.origen = origen;
    }

    public void setDestino(Parada destino) {
        this.destino = destino;
    }

}
