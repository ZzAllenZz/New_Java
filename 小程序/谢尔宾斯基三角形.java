import java.awt.Color;  
import java.awt.Dimension;  
import java.awt.Graphics;  
import java.awt.Toolkit;  
import java.awt.event.MouseAdapter;  
import java.awt.event.MouseEvent;  
import javax.swing.JFrame;  
import javax.swing.JPanel;  
/** 
 * ����һ��л����˹�������� 
 * @author LONG 
 * 
 */  
public class SanJiao extends JFrame {  
    private static final long serialVersionUID = 1L;  
    Dimension di = null;  
    Graphics gr = null;  
    JPanel jp = null;  
      
    /** 
     * ���������������� 
     * @param args 
     */  
    public static void main(String[] args){  
        SanJiao sj = new SanJiao();  
        sj.showFrame();  
    }  
      
    /** 
     * ������������ͼ�ε���� 
     */  
    public void showFrame(){  
          
        this.setTitle("��ͼ");  
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
         * ����һ��л����˹�������ε�׼�����������ú���ʾ��λ�� 
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
     * ���������ݹ�ĺ��������ݹ黭�������� 
     * @param x1    �������x���� 
     * @param y1    �������y���� 
     * @param x2    �������x���� 
     * @param y2    �������y���� 
     */  
    public void doSomething(int x1,int y1,int x2,int y2){  
          
        //�����̣߳����Ը�����Ŀ����ݹ�ִ�еĹ���  
        try {  
            Thread.sleep(10);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        //���ÿ�������Ϊ�����ջ������������ױߵ�x����ֵ֮�����10������  
        if(Math.max(x2, x1) - Math.min(x2, x1) > 10){  
            int x3 = (x1 + x2)/2;       //�������㶥������xֵ  
            int y3 = (int)((y1 + y2)/2 - (Math.max(x2, x1) - Math.min(x2, x1))*Math.sqrt(3)/2); //�������㶨�������yֵ  
              
            //Ϊ��Ѥ��һ�㣬���û�����ɫΪ���ɫ  
            gr.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));  
              
            //����������������  
            gr.drawLine(x1,y1,x2,y2);  
            gr.drawLine(x1,y1,x3,y3);  
            gr.drawLine(x2,y2,x3,y3);  
              
            //�õ������ߵ��е�����  
            int c_x1 = (x1 + x2)/2;  
            int c_y1 = (y1 + y2)/2;  
            int c_x2 = (x1 + x3)/2;  
            int c_y2 = (y1 + y3)/2;  
            int c_x3 = (x2 + x3)/2;  
            int c_y3 = (y2 + y3)/2;  
              
              
            //�ڴ˴����ݹ�ʱ���Ȱ�һ�����꣬Ȼ��Ż�ִ�������һ�������Թؼ�������Ҫ��ȷ��ֹ�ݹ������  
            gr.drawLine(c_x1, c_y1, c_x2, c_y2);  
            gr.drawLine(c_x1, c_y1, c_x3, c_y3);  
            gr.drawLine(c_x2, c_y2, c_x3, c_y3);  
            doSomething(x1,y1,c_x1,c_y1);  
            doSomething(c_x1,c_y1,x2,y2);  
            doSomething(c_x2,c_y2,c_x3,c_y3);  
        }  
          
    }  
      
  
}