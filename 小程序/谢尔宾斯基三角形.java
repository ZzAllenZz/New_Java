import java.awt.Color;  
import java.awt.Dimension;  
import java.awt.Graphics;  
import java.awt.Toolkit;  
import java.awt.event.MouseAdapter;  
import java.awt.event.MouseEvent;  
import javax.swing.JFrame;  
import javax.swing.JPanel;  
/** 
 * 画出一个谢尔宾斯基三角形 
 * @author LONG 
 * 
 */  
public class SanJiao extends JFrame {  
    private static final long serialVersionUID = 1L;  
    Dimension di = null;  
    Graphics gr = null;  
    JPanel jp = null;  
      
    /** 
     * 主函数，程序的入口 
     * @param args 
     */  
    public static void main(String[] args){  
        SanJiao sj = new SanJiao();  
        sj.showFrame();  
    }  
      
    /** 
     * 设置用来画出图形的面板 
     */  
    public void showFrame(){  
          
        this.setTitle("画图");  
        Toolkit tl = Toolkit.getDefaultToolkit();  
        di = tl.getScreenSize();  
        this.setSize(di.width,di.height);  
        this.setDefaultCloseOperation(3);  
          
        jp = new JPanel();  
        jp.setPreferredSize(new Dimension(600,400));  
        this.add(jp);  
          
        this.setResizable(false);  
        jp.setBackground(Color.BLACK);  
          
        this.setVisible(true);  
          
        gr = jp.getGraphics();  
        jp.addMouseListener(new MouseAdapter(){  
            public void mousePressed(MouseEvent e){  
                  
            }  
            public void mouseReleased(MouseEvent e){  
                draw(e);  
            }  
        });  
          
        /** 
         * 画出一个谢尔宾斯基三角形的准备工作，设置好显示的位置 
         */  
    }  
    public void draw(MouseEvent e){  
          
        int x1 = di.width/4;  
        int y1 = di.height*4/5;  
        int x2 = di.width*3/4;  
        int y2 = di.height*4/5;  
        doSomething(x1,y1,x2,y2);  
    }  
      
    /** 
     * 最终用来递归的函数，来递归画出三角形 
     * @param x1    传入的左x坐标 
     * @param y1    传入的左y坐标 
     * @param x2    传入的右x坐标 
     * @param y2    传入的右y坐标 
     */  
    public void doSomething(int x1,int y1,int x2,int y2){  
          
        //控制线程，可以更清楚的看见递归执行的过程  
        try {  
            Thread.sleep(10);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        //设置控制条件为，最终画的三角形两底边的x坐标值之差大于10个像素  
        if(Math.max(x2, x1) - Math.min(x2, x1) > 10){  
            int x3 = (x1 + x2)/2;       //用来计算顶点坐标x值  
            int y3 = (int)((y1 + y2)/2 - (Math.max(x2, x1) - Math.min(x2, x1))*Math.sqrt(3)/2); //用来计算定点坐标的y值  
              
            //为了绚丽一点，设置画笔颜色为随机色  
            gr.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));  
              
            //将三条边连接起来  
            gr.drawLine(x1,y1,x2,y2);  
            gr.drawLine(x1,y1,x3,y3);  
            gr.drawLine(x2,y2,x3,y3);  
              
            //得到三条边的中点坐标  
            int c_x1 = (x1 + x2)/2;  
            int c_y1 = (y1 + y2)/2;  
            int c_x2 = (x1 + x3)/2;  
            int c_y2 = (y1 + y3)/2;  
            int c_x3 = (x2 + x3)/2;  
            int c_y3 = (y2 + y3)/2;  
              
              
            //在此处，递归时，先把一个画完，然后才会执行另外的一个，所以关键步骤是要明确终止递归的条件  
            gr.drawLine(c_x1, c_y1, c_x2, c_y2);  
            gr.drawLine(c_x1, c_y1, c_x3, c_y3);  
            gr.drawLine(c_x2, c_y2, c_x3, c_y3);  
            doSomething(x1,y1,c_x1,c_y1);  
            doSomething(c_x1,c_y1,x2,y2);  
            doSomething(c_x2,c_y2,c_x3,c_y3);  
        }  
          
    }  
      
  
}