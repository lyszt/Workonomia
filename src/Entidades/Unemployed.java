package Entidades;

import Entidades.Profession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Unemployed extends Profession {
    
    private String name;
    private ArrayList<String> randomActs;
    private Random random;

    public Unemployed(String place, String name, double wage) {
        super("Desempregado", place, wage);
        this.name = name;
        random = new Random();

        randomActs = new ArrayList<>(Arrays.asList(
                "tentou vender um poema sobre esperança no semáforo",
            "debateu com um pombo por um pedaço de pão e perdeu",
            "fez um tutorial no YouTube de 'como sobreviver com R$2 por dia'",
            "passou duas horas na fila de uma apresentação de timeshare só pelo lanche grátis",
            "criou um perfil no LinkedIn para seu alter ego bem-sucedido, 'Jubileison, o Coach Quântico'",
            "deu uma palestra motivacional para si mesmo no espelho do banheiro público",
            "inscreveu-se como voluntário em um teste clínico para um energético suspeito",
            "tentou pagar o aluguel com 'visibilidade' nas redes sociais (ele tem 14 seguidores)",
            "montou um 'escritório' num banco de praça e ofereceu consultoria de vida a transeuntes",
            "doou sangue em troca do lanche e de um momento deitado na maca",
            "reivindicou um carrinho de supermercado abandonado e o batizou de 'meu novo empreendimento'",
            "assistiu a uma obra por 4 horas seguidas, dando palpites não solicitados aos pedreiros",
            "entrou numa competição de quem come mais cachorro-quente, não pela glória, mas pela comida",
            "organizou os gatos de rua do bairro em uma 'milícia' para proteger seu território",
            "tentou devolver na loja um produto que achou na rua para pegar o dinheiro de volta",
            "declarou-se o 'fiscal de qualidade' do corredor de amostras grátis do supermercado",
            "preencheu um formulário de emprego para 'astronauta' com total seriedade",
            "vendeu abraços grátis, mas cobrava pela duração do aperto",
            "usou o Wi-Fi de uma lanchonete para fazer um curso online de 'Como ficar rico rápido'",
            "criou uma coreografia elaborada para pedir trocados, mas as pessoas acharam que era arte de rua",
            "passou o dia caçando a moeda que caiu no bueiro",
            "escreveu uma reclamação formal à prefeitura sobre a falta de conforto dos bancos do parque",
            "tentou ensinar seu vira-lata a dar consultoria financeira",
            "participou de um programa de auditório só para comer o sanduíche da plateia",
            "limpou as botas do Jombson, mas desta vez, com uma flanela que achou no lixo",
            "ofereceu-se para 'testar a segurança' das grades de todas as casas da vizinhança",
            "fez amizade com um manequim de loja e desabafou sobre a crise econômica",
            "fundou uma república independente no terreno baldio da esquina",
            "lutou bravamente contra o vento para ler uma única página de jornal por uma hora",
            "planejou um assalto a um banco de sementes",
            "passou uma hora encerando o capô do carro do Jombson com a própria camisa",
            "escreveu uma canção de louvor a Jombson e a cantou do outro lado da rua de seu escritório",
            "recolheu o lixo que Jombson jogou pela janela do carro e o guardou como uma 'lembrança'",
            "recolheu o lixo que Jombson jogou pela janela do carro e o guardou como uma 'lembrança'",
            "esperou duas horas na chuva só para dizer 'bom dia' ao Jombson, que não respondeu",
            "tentou imitar o jeito de andar confiante de Jombson e tropeçou numa pedra solta",
            "fez um boneco de vudu do Jombson com pão velho, mas ficou com dó e o alimentou",
            "tentou 'adivinhar' o signo de Jombson para puxar assunto, e errou de forma espetacular",
            "limpou as botas do Jombson com tanto esmero que conseguiu ver seu próprio reflexo desolado nelas",
            "ofereceu-se para ser o 'guarda-costas não oficial' de Jombson, seguindo-o a uma distância de 10 metros",
            "roubou uma flor do jardim público para deixar no para-brisa do Jombson, que a jogou fora com desprezo",
            "comprou o jornal só para ler o horóscopo para Jombson, esperando um dia de sorte para ambos",
            "desenhou um retrato 'heroico' de Jombson com carvão em uma calçada, que a chuva apagou",
            "praticou no espelho diferentes maneiras de dizer 'Sim, senhor, Jombson' com o máximo de servilismo",
            "fez amizade com um manequim de loja e desabafou sobre como admira o Jombson",
            "tentou devolver na loja um produto que achou na rua para pegar o dinheiro de volta",
            "declarou-se o 'fiscal de qualidade' do corredor de amostras grátis do supermercado",
            "usou o Wi-Fi de uma lanchonete para fazer um curso online de 'Como se tornar indispensável para seu chefe'",
            "criou uma coreografia elaborada para pedir trocados, mas as pessoas acharam que era arte de rua",
            "passou o dia caçando a moeda que caiu no bueiro",
            "tentou ensinar seu vira-lata a dar consultoria financeira",
            "participou de um programa de auditório só para comer o sanduíche da plateia",
            "vendeu água no sinal",
            "dançou no parque",
            "apostou em corrida de cavalos",
            "assaltou uma velha",
            "cantou",
            "limpou as botas do Jombson",
            "pediu dinheiro na esquina",
            "varreu a calçada",
            "lavou carros",
            "vendeu balas no ônibus",
            "consertou bicicletas",
            "catou latinhas para reciclagem",
            "fez um bico de pintor",
            "entregou panfletos",
            "jogou baralho com amigos",
            "alimentou os pombos",
            "roubou doce de uma criança",
            "fez malabarismo",
            "montou um móvel que achou",
            "cuidou do cachorro de um conhecido",
            "participou de uma pesquisa remunerada",
            "dormiu até o meio-dia",
            "escreveu um poema sobre a vida",
            "ajudou um turista perdido",
            "tocou violão pedindo trocados",
            "limpou o quintal de alguém por dinheiro",
            "vendeu salgado",
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
        return this.name + " " + randomVerb() + " em " + this.place + ".";
    }

    public ArrayList<String> getRandomActs() {
        return randomActs;
    }

    public void setRandomActs(ArrayList<String> randomActs) {
        this.randomActs = randomActs;
    }
    
    
}