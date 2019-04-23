package fx;

import java.util.Random;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Window extends Application implements Runnable{

    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private Pane pane;
    private Scene scene;
    private Canvas canvas;
    private Thread thread;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Random Graphics");
        initComponents(primaryStage);
        primaryStage.show();
    }

    private void initComponents(Stage primaryStage) {
        this.pane = new Pane();
        this.scene = new Scene(this.pane, WIDTH, HEIGHT);
        this.canvas = new Canvas(WIDTH, HEIGHT);
        
        this.thread = new Thread(this);
        this.thread.start();
        
        this.pane.getChildren().add(this.canvas);
        primaryStage.setScene(this.scene);
        //primaryStage.setOnCloseRequest(exit);
    }
    
    
    private void myDraw(GraphicsContext gc) {
        Random rand = new Random();
        int x = rand.nextInt(WIDTH-101)+1;
        int y = rand.nextInt(HEIGHT-101)+1;
        
        int auxX1 = x;
        int auxY1 = y;
        int auxX2 = x;
        int auxY2 = y;
        int auxX3 = x;
        int auxY3 = y;

        while(true){
            int x1 = rand.nextInt(WIDTH-101)+1;
            int y1 = rand.nextInt(HEIGHT-101)+1;
            int x2 = rand.nextInt(WIDTH-101)+1;
            int y2 = rand.nextInt(HEIGHT-101)+1;
            int x3 = rand.nextInt(WIDTH-101)+1;
            int y3 = rand.nextInt(HEIGHT-101)+1;
            
            
            if(auxX1 < WIDTH-100 && auxY1 < HEIGHT-100 && auxX1 > 0 && auxY1 > 0 
                && auxX2 < WIDTH-100 && auxY2 < HEIGHT-100 && auxX2 > 0 && auxY2 > 0 
                && auxX3 < WIDTH-100 && auxY3 < HEIGHT-100 && auxX3 > 0 && auxY3 > 0){
                while(auxX1!=x1 && auxY1!=y1 && auxX2!=x2 && auxY2!=y2 && auxX3!=x3 && auxY3!=y3){
                    int r = rand.nextInt(256);
                    int g = rand.nextInt(256);
                    int b = rand.nextInt(256);
                    int r1 = rand.nextInt(256);
                    int g1 = rand.nextInt(256);
                    int b1 = rand.nextInt(256);
                    int r2 = rand.nextInt(256);
                    int g2 = rand.nextInt(256);
                    int b2 = rand.nextInt(256);
                    try {
                        if(auxX1 < WIDTH-100 && auxY1 < HEIGHT-100 && auxX1 > 0 && auxY1 > 0){
                            gc.clearRect(0, 0, WIDTH, HEIGHT);
                            gc.setFill(Color.rgb(r, g, b));
                            gc.fillRect(auxX1,auxY1, 100, 100);
                            gc.setFill(Color.rgb(r1, g1, b1));
                            gc.fillRect(auxX2, auxY2, 100, 100);
                            gc.setFill(Color.rgb(r2, g2, b2));
                            gc.fillRect(auxX3, auxY3, 100, 100);

                            if(auxX1>x1){
                                auxX1-=1;
                            }
                            if(auxX1<x1){
                                auxX1+=1;
                            }
                            if(auxY1>y1){
                                auxY1-=1;
                            }
                            if(auxY1<y1){
                                auxY1+=1;
                            }
                            if(auxX2>x2){
                                auxX2-=1;
                            }
                            if(auxX2<x2){
                                auxX2+=1;
                            }
                            if(auxY2>y2){
                                auxY2-=1;
                            }
                            if(auxY2<y2){
                                auxY2+=1;
                            }
                            if(auxX3>x3){
                                auxX3-=1;
                            }
                            if(auxX3<x3){
                                auxX3+=1;
                            }
                            if(auxY3>y3){
                                auxY3-=1;
                            }
                            if(auxY3<y3){
                                auxY3+=1;
                            }
                            Thread.sleep(6);
                        }
                    }
                catch (InterruptedException ex) {}
                }
            }
        }
    }

    @Override
    public void run() {
        GraphicsContext gc = this.canvas.getGraphicsContext2D();
        myDraw(gc);
    }
    
    EventHandler<WindowEvent> exit = new EventHandler<WindowEvent>() {
        @Override
        public void handle(WindowEvent event) {
            System.exit(0);
        }
    };
    
    
}