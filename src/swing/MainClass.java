package swing;


class MainSwing {

    static final int X_MAPA = 300;//posiciona la"escena" en la pantalla
    static final int Y_MAPA = 100;//posiciona la"escena" en la pantalla
    static final int ANCHO_MAPA = 800;
    static final int ALTO_MAPA = 600;
    static final int TIEMPO_ESPERA = 2; 

    public static void main (String[] args) throws InterruptedException {
        DisplayFrame myFrame = new DisplayFrame(X_MAPA, Y_MAPA, ANCHO_MAPA, ALTO_MAPA);
        Simulator mySimulator = new Simulator(myFrame);

        myFrame.setVisible(true);
        mySimulator.startSimulation(TIEMPO_ESPERA);
    }

}
