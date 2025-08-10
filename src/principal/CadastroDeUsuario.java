package src.principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import src.componentes.*;

public class CadastroDeUsuario {
    public static void main(String[] args) {
        // Criação do frame (janela)
        JFrame frame = new JFrame("Cadastro de Usuário!");
        frame.setSize(300,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fechar e não continuar processando
        frame.setLayout(new FlowLayout()); /// FlowLayout: organiza os componentes em uma linha horizontal e quebra automaticamente para a próxima linha
        
        frame.getContentPane().setBackground(Color.pink); // pega o painel de fundo e muda a cor

        Campos campo = new Campos();

        //Botão
        JButton botaoCadastrar = new JButton("Cadastrar");
        JButton botaoLimpar = new JButton("Limpar");
        JRadioButton sexoMasculino = new JRadioButton("Masculino");
        JRadioButton sexoFeminino = new JRadioButton("Feminino");

        sexoMasculino.setBackground(Color.pink); // cor de fundo do botão
        sexoFeminino.setBackground(Color.pink);

        sexoMasculino.setOpaque(true);  // torna o botão opaco
        sexoFeminino.setOpaque(true);

        sexoMasculino.setBorder(BorderFactory.createEmptyBorder()); // remove a borda interna
        sexoFeminino.setBorder(BorderFactory.createEmptyBorder());

        ButtonGroup selecaoDeSexo = new ButtonGroup();
        selecaoDeSexo.add(sexoMasculino);
        selecaoDeSexo.add(sexoFeminino);

        //Ação do botão
        botaoCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String nome = campo.getCampoNome().getText().trim(); // pega o texto e os espaços que tiver
                String email = campo.getCampoEmail().getText().trim();
                String idade = campo.getCampoIdade().getText().trim();

            
                if (nome.isEmpty() || email.isEmpty()|| idade.isEmpty()) {  // isEmpty() função para ver se está vazio
                    JOptionPane.showMessageDialog(frame, "Todos o campo precisam estar preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                } else if (!ValidadorEmail.validarEmail(email)) {
                    JOptionPane.showMessageDialog(frame, "E-mail inválido!", "Erro", JOptionPane.ERROR_MESSAGE); // validação de e-mail
                } else {
                    String mensagem = String.format(" Usuário Cadastrado: \nNome: %s \nE-mail: %s \nIdade: %s", nome, email, idade);
                    JOptionPane.showMessageDialog(frame,mensagem, "Cadastro realizado", JOptionPane.INFORMATION_MESSAGE ); // INFORMATION_MENSAGE/ ERROR_MENSAGE são constantes para definir o tipo do ícone e tom da janela de diálogo
            }
        }
        });

        botaoLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                campo.getCampoNome().setText("");
                campo.getCampoEmail().setText("");
                campo.getCampoIdade().setText(""); 
            }
        });

        //Adicionando componentes ao Frame
        frame.add(campo.getLabelNome());
        frame.add(campo.getCampoNome());

        frame.add(campo.getLabelEmail());
        frame.add(campo.getCampoEmail());

        frame.add(campo.getLabelIdade());
        frame.add(campo.getCampoIdade());

        frame.add(botaoCadastrar);
        frame.add(botaoLimpar);
        
        frame.add(sexoMasculino);
        frame.add(sexoFeminino);

        //Exibir a janela 
        frame.setVisible(true);
        
    }

}
