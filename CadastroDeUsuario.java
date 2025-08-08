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

        //Ação do botão
        botaoCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String nome = campoNome.getText().trim(); // pega o texto e os espaços que tiver
                String email = campoEmail.getText().trim();
                String idade = campoIdade.getText().trim();

                if (nome.isEmpty() || email.isEmpty()|| idade.isEmpty()) {  // isEmpty() função para ver se está vaziio
                    JOptionPane.showMessageDialog(frame, "Todos o campo precisam estar preenchidos!");
                } else {
                    JOptionPane.showMessageDialog(frame, " Usuário Cadastrado: \n" + "Nome: " + campoNome.getText() + "\n E-mail: " + campoEmail.getText() + "\n Idade:" + campoIdade.getText() );
            }
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

        //Exibir a janela 
        frame.setVisible(true);
        
    }

}
