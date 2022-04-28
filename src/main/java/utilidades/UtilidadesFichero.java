package utilidades;

import com.opencsv.CSVReader;
import modelos.Movimiento;
import modelos.Pokemon;
import modelos.TipoAtaque;
import modelos.TipoPokemon;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class UtilidadesFichero {

    private static final char SEPARATOR =',';

    public static  List<Pokemon> leerPokemonConAtaques() throws IOException {
        List<Pokemon> listaPokemon = new ArrayList<>();

        CSVReader reader = null;

        try{
            reader = new CSVReader(new FileReader("C:\\Users\\daw20\\IdeaProjects\\examen_daw_java_2022\\src\\main\\java\\archivos\\pokemon.csv"),SEPARATOR);
            String[] nextLine = null;
            int count = 0;

            while ((nextLine = reader.readNext()) != null) {

                if (count > 0) {
                    String[] valores = nextLine;
                    Pokemon p = new Pokemon();
                    if (valores[0] != ""){
                        p.setNumPokedex(Integer.parseInt(valores[0]));
                    }
                    else{
                        break;
                    }
                    p.setGeneracion(Integer.valueOf(valores[1]));
                    p.setNombre(String.valueOf(valores[2]));
                    p.setNivel(Integer.valueOf(valores[3]));
                    listaPokemon.add(p);
                }
                count++;

            }

        } catch (Exception e){
            throw e;
        }

        reader.close();

        CSVReader reader2 = null;

        List<Movimiento> listaMovimientos = new ArrayList<>();

        try {
            reader2 = new CSVReader(new FileReader("C:\\Users\\daw20\\IdeaProjects\\examen_daw_java_2022\\src\\main\\java\\archivos\\movimientos.csv"), SEPARATOR);
            String[] nextLine = null;
            int count = 0;

            while ((nextLine = reader2.readNext()) != null) {

                if (count > 0) {
                    String[] valores2 = nextLine;
                    Movimiento m = new Movimiento();
                    if (valores2[0] != ""){
                        m.setId(parseInt(valores2[0]));
                    }
                    else{
                        break;
                    }
                    Integer numpokedex = Integer.valueOf(valores2[1]);
                    m.setNombre(String.valueOf(valores2[2]));
                    m.setTipo(TipoPokemon.valueOf(valores2[3]));
                    m.setTipoAtaque(TipoAtaque.valueOf(valores2[4]));
                    for (Pokemon p : listaPokemon) {
                        if (p.getNumPokedex() == numpokedex) {
                            p.getMovimientos().add(m);
                        }
                    }
                }
                count++;

            }
        } catch (Exception b) {
            throw b;
        }

        reader2.close();

        return listaPokemon;


    }




}
