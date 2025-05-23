package Entidades;

import Entidades.Profession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Unemployed extends Profession {

    private ArrayList<String> randomActs;
    private Random random;

    public Unemployed(String place) {
        super("Desempregado", place);
        random = new Random();

        randomActs = new ArrayList<>(Arrays.asList(
                "vendeu água no sinal",
                "dançou no parque",
                "apostou em corrida de cavalos",
                "assaltou uma velha",
                "cantou no metrô",
                "pediu dinheiro na esquina",
                "varreu a calçada do vizinho",
                "lavou carros",
                "vendeu balas no ônibus",
                "consertou bicicletas",
                "catou latinhas para reciclagem",
                "fez um bico de pintor",
                "entregou panfletos",
                "jogou baralho com amigos na praça",
                "alimentou os pombos",
                "procurou emprego no jornal",
                "fez malabarismo no semáforo",
                "montou um móvel que achou na rua",
                "cuidou do cachorro de um conhecido",
                "participou de uma pesquisa remunerada",
                "dormiu até o meio-dia",
                "escreveu um poema sobre a vida",
                "ajudou um turista perdido",
                "tocou violão pedindo trocados",
                "limpou o quintal de alguém por dinheiro",
                "vendeu salgado na praia",
                "fez um curso online gratuito",
                "doou sangue por um lanche",
                "assistiu a uma obra o dia todo"
        ));
    }

    /**
     * Retorna um verbo de ação aleatório da lista.
     * @return Uma String com a ação.
     */
    public String randomVerb() {
        int index = random.nextInt(randomActs.size());
        return randomActs.get(index);
    }

    /**
     * Gera a frase completa da atividade realizada.
     * @return A String formatada da atividade.
     */
    @Override
    public String doJobActivity() {
        return "Você " + randomVerb() + " em " + this.place + ".";
    }
}