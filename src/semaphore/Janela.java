package semaphore;

import javax.swing.*;

public class Janela {

    private  final JFrame monitor = new JFrame("Monitor");
    private JLabel label;

    public void   criaJanela() {
        monitor.setSize(400, 200);
        monitor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        monitor.setLocationRelativeTo(null);
        monitor.setVisible(true);
        label = new JLabel();
        monitor.add(label);
        // Enviar para segundo plano

    }

    public  void adicionarTexto(String texto) {

        label.setText(texto +  " usuários esperando para se  inscrever \n no canal.");

    }

}
