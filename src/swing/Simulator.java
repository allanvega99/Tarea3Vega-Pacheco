package swing;

import java.awt.*;
import javax.swing.ImageIcon;
import java.lang.String;

public class Simulator 
{

    private DisplayFrame myDisplayer;  //JFrame
    private Circle myCircle;
    private Rectangle myRectangle;
    private Rectangle myRectangle2;

    //constructor
    public Simulator(DisplayFrame myDisplayer_)
    {
        this.setMyDisplayer(myDisplayer_);
        this.setMyCircle(new Circle());
        this.setMyRectangle(new Rectangle());       
        this.setMyRectangle2(new Rectangle());
        //valores de las figuras
        myCircle.setHeight(70);
        myCircle.setWidth(70);
        
        myRectangle.setHeight(70);
        myRectangle.setWidth(70);
        
        myRectangle2.setHeight(60);
        myRectangle2.setWidth(60);

    }

    
    //ciclo infinito para mover las figuras
    public void startSimulation(int waitingTime) throws InterruptedException {
        int x = (int) (Math.random() * 721) + (4);//(int) (Math.random() * (myDisplayer.getWidth() - 240));  //(int) (Math.random() * 721) + (4);
        int y = (int) (Math.random() * 489) + (37);//(int) (Math.random() * (myDisplayer.getHeight() - 240));
        //rectangulo
        int rX = (int) (Math.random() * 721) + (4); 
        int rY = (int) (Math.random() * 489) + (37);
        //cuadrado
        int cX = (int) (Math.random() * 721) + (4); 
        int cY = (int) (Math.random() * 489) + (37);
        //ciclo infinito Circulo
        while (true){
        
            System.out.println("XXXXXXX "+x+" - "+y);
            int x1 = (int) (Math.random() * 721) + (4);//(int) (Math.random() * (myDisplayer.getWidth() - 240));
            int y1 = (int) (Math.random() * 489) + (37);//(int) (Math.random() * (myDisplayer.getWidth() - 240));
            System.out.println("fffffff "+x1+" - "+y1+"\n");
            //Rectangulo          
            int rX1 = (int) (Math.random() * 721) + (4);
            int rY1 = (int) (Math.random() * 489) + (37);
            System.out.println("RRRRR "+rX+" - "+rY+"*************");
            System.out.println("rrrrr "+rX1+" - "+rY1+"*************\n");
            //Cuadrado        
            int cX1 = (int) (Math.random() * 721) + (4);
            int cY1 = (int) (Math.random() * 489) + (37);

            while(x1!=x && y1!=y && rX1!=rX && rY1!=rY && cX1!=cX && cY1!=cY){
               //posicion fila columna 
                getMyCircle().setRow(y);
                getMyCircle().setColumn(x);
                //rect
                getMyRectangle().setRow(rY);
                getMyRectangle().setColumn(rX);
                //cua
                getMyRectangle2().setRow(cY);
                getMyRectangle2().setColumn(cX);
                this.createImages();                          
                Thread.sleep(waitingTime);//pone en espera el flujo del programa
                //circulo
                if(x<x1)
                    x+=1;
                if(x>x1)
                    x-=1;
                if(y<y1)
                    y+=1;
                if(y>y1)
                    y-=1;
                
                //Rectangulo
                 if(rX<rX1)
                    rX+=1;
                if(rX>rX1)
                    rX-=1;
                if(rY<rY1)
                    rY+=1;
                if(rY>rY1)
                    rY-=1;
                
                //Cuadrado
                 if(cX<cX1)
                    cX+=1;
                if(cX>cX1)
                    cX-=1;
                if(cY<cY1)
                    cY+=1;
                if(cY>cY1)
                    cY-=1;

                System.out.println("XXXXXXX "+x+" - "+y);
                System.out.println("fffffff "+x1+" - "+y1+"\n");
//                System.out.println("RRRRR "+rX+" - "+rY);
//                System.out.println("rrrrr "+rX1+" - "+rY1+"\n");
            }//while
            
            
  
        }//WHILE (TRUE)
        
    }//end method


    //cambio los valores de las variables de las figuras que tengo
//    public void moveShapes() {
//        int x = (int) (Math.random() * (myDisplayer.getWidth() - 100));
//        int y = (int) (Math.random() * (myDisplayer.getHeight() - 100));
//        
//        System.out.println("XXXXXXX "+x+" - "+y);
//        int x1 = (int) (Math.random() * (myDisplayer.getWidth() - 100));
//        int y1 = (int) (Math.random() * (myDisplayer.getWidth() - 100));
//        System.out.println("fffffff "+x1+" - "+y1+"\n");
//        
//        while(x1!=x && y1!=y){
//            
//            getMyCircle().setRow(y);
//            getMyCircle().setColumn(x);
//            
//            if(x<x1)
//                x+=1;
//            if(x>x1)
//                x-=1;
//            if(y<y1)
//                y+=1;
//            if(y>y1)
//                y-=1;
//           
//            
//            System.out.println("XXXXXXX "+x+" - "+y);
//            System.out.println("fffffff "+x1+" - "+y1+"\n");        
//        }
//            
//            
//    }

    //coloca nuevos valores aleatorios en las figuras
    public void createImages()
    {
        myDisplayer.initImage();
        Graphics graphic = myDisplayer.getGraphicsImage();

        graphic.setColor(Color.BLUE);
        graphic.fillOval(getMyCircle().getColumn(),
                getMyCircle().getRow(),
                getMyCircle().getWidth(),
                getMyCircle().getHeight());

        graphic.setColor(Color.ORANGE);
        graphic.fillRect(getMyRectangle().getColumn(),
                getMyRectangle().getRow(),
                getMyRectangle().getWidth(),
                getMyRectangle().getHeight());
        
        graphic.setColor(Color.green);
        graphic.fillRect(getMyRectangle2().getColumn(),
                getMyRectangle2().getRow(),
                getMyRectangle2().getWidth(),
                getMyRectangle2().getHeight());
        
        myDisplayer.paintAgain();
    }



    //**************************************************************************
    /*     metodos accesores      */

    public Circle getMyCircle() {
        return myCircle;
    }   
    public void setMyCircle(Circle myCircle) {
        this.myCircle = myCircle;
    }

    public void setMyRectangle(Rectangle myRectangle) {
        this.myRectangle = myRectangle;
    }
    public Rectangle getMyRectangle() {
        return myRectangle;
    }
    //Rect 2
     public void setMyRectangle2(Rectangle myRectangle2) {
        this.myRectangle2 = myRectangle2;
    }
    public Rectangle getMyRectangle2() {
        return myRectangle2;
    }
    
    public DisplayFrame getMyDisplayer() {
        return myDisplayer;
    }

    public void setMyDisplayer(DisplayFrame myDisplayer) {
        this.myDisplayer = myDisplayer;
    }

    

}
