/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/**
 *
 * @author joaoluis
 */
public class Story {
    JFrame main;
    JLayeredPane dialoguePane;
    Player player;
    GameLoop gameLoop;


    public Story(JFrame main, JLayeredPane dialoguePane, Player player, GameLoop gameLoop) {
        this.main = main;
        this.dialoguePane = dialoguePane;
        this.player = player;
        this.gameLoop = gameLoop;
    }
    
    public void meetTheAntagonist(){
        // start tutorial
        dialogueBox tutorial = new dialogueBox("Jombson", "(Jombson te encara de cima a baixo, um suspiro quase inaudível escapa.) ... O que foi?", 1);
        tutorial.addDialogue("Qual é o seu nome, garoto? Anda, não tenho o dia todo.");
        tutorial.addDialogue(player.getName() + "?... É, combina.");
        tutorial.addDialogue("Você. É, você mesmo. Não olhe pros lados. Essa cara de desespero... Típico de quem não tem onde cair morto.");
        tutorial.addDialogue("Meu nome é Jombson. Guarde bem, talvez um dia precise implorar por algo. Sou o cérebro por trás... bem, de tudo que importa por aqui. E hoje, num raro momento de tédio, decidi notar sua insignificante existência.");
        tutorial.addDialogue("E não, antes que crie esperanças, você *não* trabalha pra mim. Isso é um luxo. E você, claramente, não tem nenhum.");
        tutorial.addDialogue("Mas sabe o que me diverte? Ver gente como você rastejar. É... inspirador, à sua maneira.");
        tutorial.addDialogue("Vê aquele farol caindo aos pedaços ali? É o seu novo 'palácio'. Perfeito pra quem não pode escolher.");
        tutorial.addDialogue("Sua 'missão', se é que podemos chamar assim: vá pra lá e venda água. Sim, água. Para os idiotas presos no trânsito.");
        tutorial.addDialogue("Não me olhe com essa cara. Ordens são para serem cumpridas, não entendidas.");
        tutorial.addDialogue("Cada garrafa vendida? Um mísero real. É quase um insulto, eu sei. Mas é mais do que você vale agora.");
        tutorial.addDialogue("Tem um botão aí... 'Trabalhar', ou algo do tipo. Veja se consegue ao menos *isso*. Me prove que você entende o conceito de 'clicar' e 'obedecer'. Não me decepcione... mais.");
        tutorial.addDialogue("Faça isso. Quem sabe, *quem sabe*, se você não me irritar demais ou tropeçar nos próprios pés, eu te jogue um osso maior.");
        tutorial.addDialogue("Mas por agora, menos conversa e mais servilismo. Venda. Toda grande fortuna começa com alguém engolindo o orgulho por trocados. E você tem *muito* orgulho pra engolir.");
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
    dialogueBox act2 = new dialogueBox("Pedrinho", "Ei amigo, pode me dar um dinheiro? Vejo que você está cheio da grana.", 0);
    act2.setContainsEvent(true, () -> player.addEmployee(new Employee(player, "farol", "Pedrinho", 0.5)));
    
    act2.addDialogue("(Você para. A voz dele te atinge, mas são as palavras de Jombson que ecoam na sua mente. Você olha para os 50 reais na sua mão, sentindo o peso deles. Um poder que você não tinha antes.)");
    act2.addDialogue("(Lentamente, você ergue o olhar para o garoto. Um sorriso torto, um que não pertence a você, se forma em seus lábios. Você balança a cabeça em uma negativa lenta e definitiva.)");

    act2.addDialogue("Não?... Mas... eu só preciso de uma ajuda...");

    act2.addDialogue("(Você o ignora e caminha até uma parede suja. Com um pedaço de carvão, você não escreve uma tarefa, mas sim um modelo de negócio. As letras são tortas e agressivas.)");
    act2.addDialogue("'FAÇA O QUE EU FAÇO. PEDIR. VENDER. O QUE FOR. METADE É MINHA.'");

    act2.addDialogue("Fazer o que você faz?... O que... o que você faz?");

    act2.addDialogue("(Você olha ao redor, pega três pedras de tamanhos diferentes do chão e começa um malabarismo patético e desajeitado. Duas caem imediatamente. Você as pega e estende a mão vazia, como se pedisse um trocado pela 'performance'.)");
    act2.addDialogue("(Você olha diretamente para ele. A mensagem é clara: 'Isso. É isso que eu faço. E agora, você também vai fazer'.)");

    act2.addDialogue("Eu... eu tenho que fazer... isso? Virar um pedinte... como você?");

    act2.addDialogue("(Você dá de ombros, como se a resposta fosse óbvia e a pergunta, estúpida. Então, tira a nota de 10 reais do bolso. É o capital inicial.)");
    act2.addDialogue("(Você estende o dinheiro na direção dele. Ele hesita, o rosto contorcido em humilhação.)");
    act2.addDialogue("(Para selar o acordo, você aponta para o dinheiro que ele está prestes a pegar, e com dois dedos da outra mão, faz um gesto de tesoura, de 'cortar ao meio', apontando uma metade imaginária para ele e a outra para o seu próprio bolso.)");
    act2.addDialogue("(A mensagem final é brutalmente clara. Não há mais dúvidas.)");
    act2.addDialogue("(Ele finalmente fecha os dedos ao redor da nota, o olhar derrotado.)");

    act2.addDialogue("...Entendi. Eu trabalho para você... agora.");

    act2.addDialogue("(Você assente uma vez, satisfeito. Você não criou apenas um empregado. Você terceirizou a sua própria miséria. Você se vira e vai embora, deixando para trás o seu novo e trágico reflexo.)");
    
    
    
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
