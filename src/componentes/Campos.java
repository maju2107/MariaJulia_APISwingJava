package src.componentes; 

import javax.swing.*;
import java.awt.*;

public class Campos {
    //Rótulos
    private JLabel labelNome;
    private JLabel labelEmail;
    private JLabel labelIdade;

    //Campos de texto
    private JTextField campoNome;
    private JTextField campoEmail;
    private JTextField campoIdade;
     
    public Campos() {

        labelNome = new JLabel("Nome: ");
        labelEmail = new JLabel("E-mail: ");
        labelIdade = new JLabel("Idade: ");

        campoNome = new JTextField(30);
        campoEmail = new JTextField(30);
        campoIdade = new JTextField(3);
    }

    public JLabel getLabelNome() {
        return labelNome;
    }

    public JLabel getLabelEmail() {
        return labelEmail;
    }

    public JLabel getLabelIdade() {
        return labelIdade;
    }

    public JTextField getCampoNome() {
        return campoNome;
    }

    public JTextField getCampoEmail() {
        return campoEmail;
    }

    public JTextField getCampoIdade() {
        return campoIdade;
    }

}