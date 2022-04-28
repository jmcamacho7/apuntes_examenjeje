package utilidades;

import modelos.Entrenador;
import modelos.LineaEvolutiva;
import modelos.Pokemon;
import modelos.TipoPokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilidadesCombate {


    // este ni lo intentes

    public static Map<Entrenador, Integer>   repartirPokemon(List<Entrenador> entrenadores, List<Pokemon> pokemon){

        Map<Entrenador, Integer> mapaFinal = new HashMap<>();

        int pokemonsPorEntrenador = pokemon.size() / entrenadores.size();

        int n = 0;

        for (Entrenador e : entrenadores){
            for (int i = 0; i < (pokemonsPorEntrenador); i++){
                e.getEquipoPokemon().add(pokemon.get(n));
                n++;
            }
        }

        for (Entrenador e : entrenadores){
            Integer puntos = 0;
            for (Pokemon p : e.getEquipoPokemon()){
                if (e.getTiposPreferidos().contains(p.getTipos().get(0))){
                    puntos++;
                }
                if (p.getTipos().size() >= 2) {
                    if (e.getTiposPreferidos().contains(p.getTipos().get(1))) {
                        puntos++;
                    }
                }
            }
            mapaFinal.put(e,puntos);
        }

        return mapaFinal;
    }






    public static void subirAlNivel(Pokemon pokemon , Integer nivel){
        if (pokemon.getNivel() < 100){
            pokemon.getStats().setSpdf(pokemon.getStats().getSpdf() + nivel * 2);
            pokemon.getStats().setSpd(pokemon.getStats().getSpd() + nivel * 2);
            pokemon.getStats().setSpa(pokemon.getStats().getSpa() + nivel * 2);
            pokemon.getStats().setDf(pokemon.getStats().getDf() + nivel * 2);
            pokemon.getStats().setPs(pokemon.getStats().getPs() + nivel * 2);
            pokemon.getStats().setAt(pokemon.getStats().getAt() + nivel * 2);
            pokemon.setNivel(nivel);
        }
    }




    public static boolean puedeEvolucionar(Pokemon pokemon){
        int numero = 0;
        List<LineaEvolutiva> linea = pokemon.getLineaEvolutiva();

        for (LineaEvolutiva x: linea){
            if (x.getPokemon() == pokemon){
                numero = linea.indexOf(x);
            }
            if (linea.indexOf(x) == numero + 1){
                if (x.getNivelParaEvolucionar() <= pokemon.getNivel()){
                    return true;
                }
            }
        }
        return false;
    }}








