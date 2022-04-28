package utilidades;

import modelos.Pokemon;
import modelos.TipoPokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UtilidadesPokemon {

    public UtilidadesPokemon() {
    }

    public static List<Pokemon> obtenerPokemonConTipos(List<Pokemon> pokemons,
                                                       List<TipoPokemon> tipos){
        List<Pokemon> untipo = new ArrayList<>();

        for (Pokemon x : pokemons){
            for (TipoPokemon t: tipos){
                if (x.getTipos().contains(t)){
                    untipo.add(x);
                }
            }
        }

        return untipo;
    }



    public static Map<TipoPokemon, List<Pokemon>> obtenerPokemonPurosPorTipo(List<Pokemon> pokemons){

        ArrayList<Pokemon> lista = new ArrayList<>();

        for (Pokemon x: pokemons){
            if (x.getTipos().size() == 1){
                lista.add(x);
            }
        }

        Map<TipoPokemon, List<Pokemon>> unosolo = lista.stream().collect(Collectors.groupingBy(x -> x.getTipos().get(0)));

        return unosolo;
    }
}
