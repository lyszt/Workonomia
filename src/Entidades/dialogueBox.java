/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Entidades;

import Sound.SoundPlayer;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.SwingWorker;
/**
 *
 * @author joaoluis
 */
public class dialogueBox extends javax.swing.JPanel {
    private ArrayList<String> dialogues;
    private int dialogueIndex;
    private String speaker;
    private String soundPath;
    private int skippable;
    private boolean containsEvent;
    private DynamicEvent dialogueEvent = null;
    private String action;
    private boolean has_set_animation = false;
    private int max_frames;
    
    /**
     * Creates new form dialogueBox
     */
    public dialogueBox(String speaker, String first_dialogue, int skippable) {
        this.speaker = speaker;
        this.skippable = skippable;
        this.dialogues = new ArrayList<String>();
        initComponents();
        this.dialogues.add(first_dialogue);
        dialogueField.setText(first_dialogue);
        characterName.setText(speaker);
       }
    
    public dialogueBox(String speaker, String first_dialogue, int skippable, ImageIcon icon) {
        this.speaker = speaker;
        this.skippable = skippable;
        this.dialogues = new ArrayList<String>();
        initComponents();
        authorIcon.setIcon(icon);
        this.dialogues.add(first_dialogue);
        dialogueField.setText(first_dialogue);
        characterName.setText(speaker);
       }
    
    public void setAuthorIcon(String path){
        authorIcon.setIcon(new ImageIcon(path));
    }
    
    public void setAnimation(String action, int max_frames){
        has_set_animation = true;
        this.action = action;
        this.max_frames = max_frames;
    }
    
    public void playAnimation(int repeats) {
        final Icon originalIcon = authorIcon.getIcon();
        new SwingWorker<Void, ImageIcon>() {
            @Override
            protected Void doInBackground() throws Exception {
                // THREAD no plano de fundo pra não crashar a caixa de dialogo
                
                for (int i = 0; i < repeats; i++) {
                    
                    for (int j = 0; j < max_frames; j++) {
                        String resourcePath = "/trabalho/resources/sprites/" + speaker.toLowerCase() + "/" + speaker.toLowerCase() + "-" + action.toLowerCase() + "-" + j + ".png";
                        java.net.URL imageUrl = getClass().getResource(resourcePath);
                        
                         if (imageUrl != null) {
                        ImageIcon nextIcon = new ImageIcon(imageUrl);
                        publish(nextIcon); 
                        Thread.sleep(70); 
                    } else {
                        System.err.println("Falha ao encontrar imagem de icone: " + resourcePath);
                    }

                    }
                    
                }Thread.sleep(1000);                      
                return null;
            }
            
            @Override
            protected void done() {
                authorIcon.setIcon(originalIcon);
            }
            
            
            @Override
            protected void process(List<ImageIcon> chunks) {
                ImageIcon latestIcon = chunks.get(chunks.size() - 1);
                authorIcon.setIcon(latestIcon);
            }
        }.execute(); 
        
        
    }

    
    public void addDialogue(String sentence){
        dialogues.add(sentence);
    }
    public ArrayList<String> getDialogues(){
        return dialogues;
    }
    public void setDialogues(ArrayList<String> dialogues){
        this.dialogues = dialogues;
    }
    public int getDialogueIndex(){
        return dialogueIndex;
    }
    public int passDialogue() {
        int nextIndex = (dialogueIndex + 1);
        if (nextIndex >= dialogues.size()) {
            java.awt.Container parent = this.getParent(); 
            if (parent != null) { 
                parent.remove(this); 
                parent.revalidate(); 
                parent.repaint(); 
                return dialogueIndex;
            }
        }

        dialogueIndex = nextIndex;
        if(this.has_set_animation){
            playAnimation(3);
        }
        playVoice();
        return dialogueIndex;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public int getSkippable() {
        return skippable;
    }

    public void setSkippable(int skippable) {
        this.skippable = skippable;
    }

    public boolean isContainsEvent() {
        return containsEvent;
    }

    public void setContainsEvent(boolean containsEvent, DynamicEvent dialogueEvent) {
        this.containsEvent = containsEvent;
        this.dialogueEvent = dialogueEvent;
    }

    public JLabel getAuthorIcon() {
        return authorIcon;
    }

    public JLabel getCharacterName() {
        return characterName;
    }

    public void setCharacterName(JLabel characterName) {
        this.characterName = characterName;
    }

    

   public void playVoice() {
    if (dialogueIndex >= dialogues.size()) return;

    String fullText = dialogues.get(dialogueIndex);
    final int textLength = fullText.length();
    final int[] currentIndex = {0};

    dialogueField.setText(""); // Clear before starting

    // Disable the button during typing
    nextDialogButton.setEnabled(false);

    final StringBuilder buffer = new StringBuilder();

    Timer timer = new Timer(30, null);
    timer.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (currentIndex[0] < textLength) {
            buffer.append(fullText.charAt(currentIndex[0]));
            currentIndex[0]++;

            // Update text and play sound every 3 characters or at the end
            if (currentIndex[0] % 3 == 0 || currentIndex[0] == textLength) {
                dialogueField.setText(buffer.toString());

                if (soundPath != null && !soundPath.isEmpty()) {
                    new Thread(() -> SoundPlayer.playSound(soundPath)).start();
                }
            }
        } else {
            ((Timer) e.getSource()).stop();
            nextDialogButton.setEnabled(true);
        }
        }
    });
    timer.start();
}


    public String getCurrentDialogue(){
        return dialogues.get(dialogueIndex);
    }

    public String getSoundPath() {
        return soundPath;
    }

    public void setSoundPath(String soundPath) {
        this.soundPath = soundPath;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        authorIcon = new javax.swing.JLabel();
        characterName = new javax.swing.JLabel();
        nextDialogButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        dialogueField = new javax.swing.JTextArea();
        skipButton = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        authorIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho/resources/sprites/jombson/jombson-normal-0.png"))); // NOI18N

        characterName.setText("Character name");

        nextDialogButton.setText("Próximo");
        nextDialogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passDialogueClick(evt);
            }
        });

        dialogueField.setEditable(false);
        dialogueField.setBackground(new java.awt.Color(235, 235, 235));
        dialogueField.setColumns(20);
        dialogueField.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        dialogueField.setLineWrap(true);
        dialogueField.setRows(5);
        dialogueField.setWrapStyleWord(true);
        dialogueField.setAutoscrolls(false);
        dialogueField.setFocusable(false);
        jScrollPane2.setViewportView(dialogueField);

        skipButton.setText("Pular");
        skipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipButtonpassDialogue(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(skipButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nextDialogButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(authorIcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(characterName)
                                .addGap(484, 484, 484))
                            .addComponent(jScrollPane2))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(characterName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(authorIcon)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextDialogButton)
                    .addComponent(skipButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void passDialogueClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passDialogueClick
    if (passDialogue() == dialogues.size()-1 && containsEvent) {
        dialogueEvent.doEvent();
    }
    }//GEN-LAST:event_passDialogueClick

    private void skipButtonpassDialogue(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipButtonpassDialogue
        if(this.skippable == 1){
        java.awt.Container parent = this.getParent(); 
            if (parent != null) { 
                parent.remove(this); 
                parent.revalidate(); 
                parent.repaint(); 
            }
    }//GEN-LAST:event_skipButtonpassDialogue
    if(containsEvent){
        dialogueEvent.doEvent();
    }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authorIcon;
    private javax.swing.JLabel characterName;
    private javax.swing.JTextArea dialogueField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton nextDialogButton;
    private javax.swing.JButton skipButton;
    // End of variables declaration//GEN-END:variables
}
