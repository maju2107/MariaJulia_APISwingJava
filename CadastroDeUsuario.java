import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CadastroDeUsuario {
    public static void main(String[] args) {
        // Criação do frame (janela)
        JFrame frame = new JFrame("Cadastro de Usuário!");
        frame.setSize(300,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fechar e não continuar processando
        frame.setLayout(new FlowLayout()); /// FlowLayout: organiza os componentes em uma linha horizontal e quebra automaticamente para a próxima linha
        
        frame.getContentPane().setBackground(Color.pink); // pega o painel de fundo e muda a cor

        //Rótulos
        JLabel labelNome = new JLabel("Nome: ");
        JLabel labelEmail = new JLabel("E-mail: ");
        JLabel labelIdade = new JLabel("Idade: ");

        //Campos de texto
        JTextField campoNome = new JTextField(30);
        JTextField campoEmail = new JTextField(30);
        JTextField campoIdade = new JTextField(3);

        //Botão
        JButton botaoCadastrar = new JButton("Cadastrar");
        JButton botaoLimpar = new JButton("Limpar");
        JRadioButton sexoMasculino = new JRadioButton("Masculino");
        JRadioButton sexoFeminino = new JRadioButton("Feminino");

        sexoMasculino.setBackground(Color.pink); // cor de fundo do botão
        sexoFeminino.setBackground(Color.pink);

        sexoMasculino.setOpaque(true);  // torna o botão opaco
        sexoFeminino.setOpaque(true);

        ButtonGroup selecaoDeSexo = new ButtonGroup();
        selecaoDeSexo.add(sexoMasculino);
        selecaoDeSexo.add(sexoFeminino);

        //Ação do botão
        botaoCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String nome = campoNome.getText().trim(); // pega o texto e os espaços que tiver
                String email = campoEmail.getText().trim();
                String idade = campoIdade.getText().trim();

                if(!ValidadorEmail.validarEmail(email)) {
                    JOptionPane.showMessageDialog(frame, "E-mail inválido!", "Erro", JOptionPane.ERROR_MESSAGE);

                }

                if (nome.isEmpty() || email.isEmpty()|| idade.isEmpty()) {  // isEmpty() função para ver se está vazio
                    JOptionPane.showMessageDialog(frame, "Todos o campo precisam estar preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    String mensagem = String.format(" Usuário Cadastrado: \n Nome: %s \nE-mail:%s \nIdade: %s", nome, email, idade);
                    JOptionPane.showMessageDialog(frame,mensagem, "Cadastro realizado", JOptionPane.INFORMATION_MESSAGE ); // INFORMATION_MENSAGE/ ERROR_MENSAGE são constantes para definir o tipo do ícone e tom da janela de diálogo
            }
        }
        });

        botaoLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                campoNome.setText("");
                campoEmail.setText("");
                campoIdade.setText(""); 
            }
        });

        //Adicionando componentes ao Frame
        frame.add(labelNome);
        frame.add(campoNome);

        frame.add(labelEmail);
        frame.add(campoEmail);

        frame.add(labelIdade);
        frame.add(campoIdade);

        frame.add(botaoCadastrar);
        frame.add(botaoLimpar);
        
        frame.add(sexoMasculino);
        frame.add(sexoFeminino);

        //Exibir a janela 
        frame.setVisible(true);
        
    }

}
