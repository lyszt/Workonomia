/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import trabalho.Game;
/**
 *
 * @author joaoluis
 */
public class Story {
    private Game main;
    private JLayeredPane dialoguePane;
    private Player player;
    private int currentChapter;
    


    public Story(Game main, JLayeredPane dialoguePane, Player player) {
        this.main = main;
        this.dialoguePane = dialoguePane;
        this.player = player;
    }

    public int getCurrentChapter() {
        return currentChapter;
    }

    public void setCurrentChapter(int currentChapter) {
        this.currentChapter = currentChapter;
    }
    
    
    public void meetTheAntagonist(){
        // start tutorial
        this.currentChapter = 1;
        dialogueBox tutorial = new dialogueBox("Jombson", "(Jombson te escaneia, ajeita o colete e suspira.) ...Pois não? Se não for urgente, manda um e-mail. Minha agenda hoje tá surreal.", 1);
        tutorial.addDialogue("Ok, seu nome. E vamos ser ágeis, que eu tenho um call em cinco minutos.");
        tutorial.setAnimation("laugh", 5);
        if(player.getName().toLowerCase().equals("jombson")){
            tutorial.addDialogue("(Jombson te olha feio e coloca as mãos no bolso para pegar um objeto.)");
            tutorial.addDialogue("(É uma .38...)");
            tutorial.addDialogue("Você disse Jombson?");
            tutorial.setContainsEvent(true, () -> {
                JOptionPane.showMessageDialog(main, "Fim de jogo, você morreu.");
                System.exit(0);
            });
        }
        else {
            tutorial.addDialogue(player.getName() + "? Ok, anotei. O nome é só um label, o que importa é o delivery no final do dia.");
            tutorial.addDialogue("Cara, vou ser bem direto com você. Esse seu look de quem não bateu a meta... tá te entregando. Zero sinergia com o nosso ecossistema.");
            tutorial.addDialogue("Sou Jombson. Adiciona no LinkedIn depois. Basicamente, sou o head por trás do ecossistema daqui. Se tem valuation, passou pela minha mesa. E hoje, no gap de um meeting, resolvi alocar meu tempo pra analisar seu case.");
            tutorial.addDialogue("E vamos alinhar as expectativas: você *não* faz parte do meu time. O onboarding aqui tem um custo, e seu track record atual não justifica o investimento.");
            tutorial.addDialogue("Mas eu tenho um mindset de dar oportunidade pra quem tem drive. Achar um talento bruto no meio do nada... Isso sim é ser disruptivo.");
            tutorial.addDialogue("Tá vendo aquele farol? Considera ele o seu primeiro projeto. Seu MVP (Minimum Viable Product).");
            tutorial.addDialogue("Seu desafio, seu OKR do trimestre, vai ser validar um modelo de negócio B2C de baixo custo: vender água no trânsito.");
            tutorial.addDialogue("Não precisa fazer essa cara. A gente precisa de gente proativa, com foco em execução, não em questionamento.");
            tutorial.addDialogue("O unit economics é simples: um real por garrafa. A grana é irrelevante. O goal aqui é testar seu drive comercial, ver se você tem o tal do 'sangue no olho'.");
            tutorial.addDialogue("Aí na interface tem um botão, 'Trabalhar' ou algo do tipo. É o seu call to action. Espero que sua capacidade de execução seja melhor que o seu branding pessoal. Me dá um feedback positivo sobre isso.");
            tutorial.addDialogue("Performa bem nesse projeto-piloto. Quem sabe, se os seus KPIs forem interessantes, a gente marca um one-on-one pra discutir os próximos steps.");
            tutorial.addDialogue("Agora vai. Menos talk e mais action. Todo unicórnio começou com alguém ralando muito pra vender uma solução simples. E você, cara, tem muito o que ralar pra sequer virar um pônei.");
        }

        tutorial.setSize(tutorial.getPreferredSize()); 
        tutorial.setSoundPath("./src/trabalho/resources/audio/jombson.wav");
        dialoguePane.add(tutorial, JLayeredPane.PALETTE_LAYER);
        int x = (dialoguePane.getWidth() - tutorial.getWidth()) / 2;
        int y = (dialoguePane.getHeight() - tutorial.getHeight()) / 2;
        tutorial.setLocation(x, y);

        tutorial.setVisible(true); 
        tutorial.playVoice();
        main.revalidate();
        main.repaint();    
    }
    
 public void corruptionOfMen(){
     this.currentChapter = 2;
    dialogueBox act2 = new dialogueBox(
        "Pedrinho, a Capivara",
        "(Uma capivara, de boa, te olha piscando lentamente.) E aí, chefe. Suave? Pô, tô vendo que o dia pra você tá bom, né? Não teria como descolar um trocado aí pra ajudar no corre?",
        1,
        new ImageIcon(getClass().getResource("/trabalho/resources/sprites/pedrinho/pedrinho-normal-0.png"))
    );

    act2.setContainsEvent(true, () -> {
        player.addEmployee(this.main, new Employee(player, "farol", "pedrinho", 10, 15));
        main.getHireButton().setVisible(true);
    });

    act2.addDialogue("(Você para. A voz mansa dele te atinge, mas são as palavras de Jombson que ecoam na sua mente. Você olha para os 50 reais na sua mão, sentindo o peso deles. Um poder que você não tinha antes.)");
    act2.addDialogue("(Lentamente, você ergue o olhar para o bicho. Um sorriso torto, um que não pertence a você, se forma em seus lábios. Você balança a cabeça em uma negativa lenta e definitiva.)");

    act2.addDialogue("(O bicho pisca de novo, meio confuso, como se você tivesse falado uma língua estranha.) Puts... como assim, \"não\"? É só uma ajuda, tipo... pra não ficar boiando aqui, tá ligado?");

    act2.addDialogue("(Você o ignora e caminha até uma parede suja. Com um pedaço de carvão, você não escreve uma tarefa, mas sim um modelo de negócio. As letras são tortas e agressivas.)");
    act2.addDialogue("'FAÇA O QUE EU FAÇO. PEDIR. VENDER. O QUE FOR. METADE É MINHA.'");

    act2.addDialogue("(Ele inclina a cabeça, lendo o carvão com zero entendimento.) \"Metade é minha\"... tá, metade do quê? E... o que é que cê faz, exatamente?");

    act2.addDialogue("(Você olha ao redor, pega três pedras de tamanhos diferentes do chão e começa um malabarismo patético e desajeitado. Duas caem imediatamente. Você as pega e estende a mão vazia, como se pedisse um trocado pela 'performance'.)");
    act2.addDialogue("(Você olha diretamente para ele. A mensagem é clara: 'Isso. É isso que eu faço. E agora, você também vai fazer'.)");

    // A objeção dele não é sobre a humilhação, mas sobre o esforço. Capivaras não querem se esforçar.
    act2.addDialogue("(A capivara olha pras pedras, depois pra você, e solta um suspiro cansado.) Eita... Fazer... isso aí? Mó esforço, cara. Certeza? Não tem um jeito mais de boa, não?");

    act2.addDialogue("(Você dá de ombros, como se a resposta fosse óbvia e a pergunta, estúpida. Então, tira a nota de 10 reais do bolso. É o capital inicial.)");
    act2.addDialogue("(Você estende o dinheiro na direção dele. Ele hesita, o rosto contorcido não em humilhação, mas em pura preguiça de entender o conceito.)");
    act2.addDialogue("(Para selar o acordo, você aponta para o dinheiro que ele está prestes a pegar, e com dois dedos da outra mão, faz um gesto de tesoura, de 'cortar ao meio', apontando uma metade imaginária para ele e a outra para o seu próprio bolso.)");
    act2.addDialogue("(A mensagem final é brutalmente clara. Não há mais dúvidas.)");
    act2.addDialogue("(Ele finalmente fecha os dedos ao redor da nota, o olhar de quem aceitou um novo e esquisito fluxo pro rio da vida.)");

    act2.addDialogue("...Ah... saquei. Tipo... eu faço o corre, e uma parte da firma é sua. Um... sócio, né? ...Tá bom, então. Fechou. Eu topo.");

    act2.addDialogue("(Você assente uma vez, satisfeito. Você não criou apenas um empregado. Você monetizou a paz de espírito de uma capivara. Você se vira e vai embora, deixando para trás o seu novo e trágico reflexo.)");

    
    
    act2.setSize(act2.getPreferredSize());
    act2.setSoundPath("./src/trabalho/resources/audio/jombson.wav");
    dialoguePane.add(act2, JLayeredPane.PALETTE_LAYER);
    int x = (dialoguePane.getWidth() - act2.getWidth()) / 2;
    int y = (dialoguePane.getHeight() - act2.getHeight()) / 2;
    act2.setLocation(x, y);

    act2.setVisible(true);
    act2.playVoice();
    main.revalidate();
    main.repaint();
}

}
