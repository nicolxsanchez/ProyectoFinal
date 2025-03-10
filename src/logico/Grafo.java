package logico;

import java.util.*;
public class Grafo {

    private static Grafo grafo = null;
    private Map<Parada, List<Ruta>> adyacencias; //conexiones

    public Grafo() {
        adyacencias = new HashMap<>();
    }

    /*public static Grafo getInstance() {
        if (grafo == null) {
            grafo = new Grafo();
        }
        return grafo;
    }*/

    public List<Parada> getParadas() {
        return new ArrayList<>(adyacencias.keySet());
    }

    public List<Ruta> getRutas() {
        List<Ruta> rutas = new ArrayList<>();
        for (List<Ruta> listaRutas : adyacencias.values()) {
            rutas.addAll(listaRutas);
        }
        return rutas;
    }

    public boolean agregarParada(Parada parada) {
        if (adyacencias.containsKey(parada)) {
            System.out.println("La parada '" + parada.getNombre() + "' ya existe.");
            return false;
        }
        adyacencias.put(parada, new ArrayList<>());
        System.out.println("Parada agregada: " + parada.getNombre());
        return true;
    }


    public boolean agregarRuta(Parada origen, Parada destino, int tiempo, int distancia, double costo, int transbordos) {
        if (!adyacencias.containsKey(origen) || !adyacencias.containsKey(destino)) {
            System.out.println("Origen o destino no existen.");
            return false;
        }

        // Validar que no exista la misma ruta
        for (Ruta ruta : adyacencias.get(origen)) {
            if (ruta.getDestino().equals(destino)) {
                System.out.println("Ya existe una ruta de " + origen.getNombre() + " a " + destino.getNombre());
                return false;
            }
        }

        Ruta nuevaRuta = new Ruta(origen, destino, tiempo, distancia, costo);
        nuevaRuta.setTransbordos(transbordos);
        adyacencias.get(origen).add(nuevaRuta);
        System.out.println("Ruta agregada de " + origen.getNombre() + " a " + destino.getNombre());
        return true;
    }



    public boolean modificarParada(Parada parada, String nuevoNombre) {
        if (!adyacencias.containsKey(parada)) {
            System.out.println("La parada no existe.");
            return false;
        }
        parada.setNombre(nuevoNombre);
        System.out.println("Parada modificada: " + parada.getNombre());
        return true;
    }

    public boolean modificarRuta(Parada origen, Parada destino, int nuevoTiempo, int nuevaDistancia, double nuevoCosto, int nuevosTransbordos) {
        if (!adyacencias.containsKey(origen)) {
            System.out.println("La parada de origen no existe.");
            return false;
        }

        for (Ruta ruta : adyacencias.get(origen)) {
            if (ruta.getDestino().equals(destino)) {
                ruta.setTiempo(nuevoTiempo);
                ruta.setDistancia(nuevaDistancia);
                ruta.setCosto(nuevoCosto);
                ruta.setTransbordos(nuevosTransbordos);
                System.out.println("Ruta modificada: " + origen.getNombre() + " → " + destino.getNombre());
                return true;
            }
        }

        System.out.println("No existe la ruta a modificar.");
        return false;
    }


    public boolean eliminarParada(Parada parada) {
        if (!adyacencias.containsKey(parada)) {
            System.out.println("La parada no existe.");
            return false;
        }
        adyacencias.remove(parada);
        adyacencias.forEach((key, rutas) -> rutas.removeIf(ruta -> ruta.getDestino().equals(parada)));
        System.out.println("Parada eliminada: " + parada.getNombre());
        return true;
    }

    public boolean eliminarRuta(Parada origen, Parada destino) {
        if (!adyacencias.containsKey(origen)) {
            System.out.println("La parada de origen no existe.");
            return false;
        }

        boolean eliminado = adyacencias.get(origen).removeIf(ruta -> ruta.getDestino().equals(destino));
        if (eliminado) {
            System.out.println("Ruta eliminada de " + origen.getNombre() + " a " + destino.getNombre());
        } else {
            System.out.println("No existe la ruta para eliminar.");
        }
        return eliminado;
    }


    public void mostrarGrafo() {
        System.out.println("\n--- Mapa de Rutas ---");
        for (Map.Entry<Parada, List<Ruta>> entry : adyacencias.entrySet()) {
            Parada parada = entry.getKey();
            List<Ruta> rutas = entry.getValue();
            System.out.println("Parada: " + parada.getNombre() + ")");
            for (Ruta ruta : rutas) {
                System.out.println("  → " + ruta.getDestino().getNombre() +
                        " | Tiempo: " + ruta.getTiempo() + " min | Distancia: " + ruta.getDistancia() + " km | Costo: $" + ruta.getCosto() +
                        " | Transbordos: " + ruta.getTransbordos());
            }
        }
    }

    public Map<Parada, List<Ruta>> getAdyacencias() {
        return adyacencias;
    }


}
