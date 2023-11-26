package co.edu.unbosque.vista;

import javax.swing.JFrame;

/**
 * Clase que representa la ventana principal del programa.
 */
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

    /**
     * Obtiene el panel principal de la ventana.
     * 
     * @return PanelPrincipal El panel principal de la ventana.
     */
    public PanelPrincipal getPp() {
        return pp;
    }

    /**
     * Establece el panel principal de la ventana.
     * 
     * @param pp El nuevo panel principal de la ventana.
     */
    public void setPp(PanelPrincipal pp) {
        this.pp = pp;
    }

}
