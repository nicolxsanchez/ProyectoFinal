package logico;

public class Parada {

    private static int contadorId = 1;
    private int id;
    private String nombre;
    private String ubicacion;
    private double latitud;             // Coordenada de latitud
    private double longitud;

    public Parada(String nombre, double latitud, double longitud) {
        this.nombre = nombre;
        this.id = contadorId++;
        this.latitud = latitud;
        this.longitud = longitud;

    }

    public double getLatitud() {
        return latitud;
    }
    public double getLongitud() {
        return longitud;
    }

    public double setLatitud(double latitud) {
        return this.latitud = latitud;
    }
    public double setLongitud(double longitud) {
        return this.longitud = longitud;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
