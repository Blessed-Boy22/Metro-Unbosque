package co.edu.unbosque.vista;

import javax.swing.JFrame;

public class FramePrincipal extends JFrame {

    private PanelPrincipal pp;

    public FramePrincipal() {

        setSize(600, 800);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        iniciarPanel();
    }

    private void iniciarPanel() {

        pp = new PanelPrincipal();
        repaint();
        add(pp);

    }

    public PanelPrincipal getPp() {
        return pp;
    }

    public void setPp(PanelPrincipal pp) {
        this.pp = pp;
    }

}
