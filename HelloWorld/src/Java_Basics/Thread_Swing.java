package Java_Basics;

/*使用 Swing 和线程相结合的技术，实现图标移动的功能
 * 这个代码有些问题
 * 
 */
import java.awt.Container;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Thread_Swing extends JFrame {
        private JLabel jl = new JLabel();
        private static Thread t;
        private int count = 0;
        private Container container = getContentPane();
        
        public Thread_Swing(){
                setBounds(300, 200, 250, 100);
                container.setLayout(null);
                URL url = Thread_Swing.class.getResource("/1.gif");
                Icon icon = new ImageIcon(url);
                jl.setIcon(icon);
                
                jl.setHorizontalAlignment(SwingConstants.LEFT);
                jl.setBounds(10, 10, 200, 50);
                jl.setOpaque(true);
                t = new Thread(new Runnable (){
                        public void run(){
                                while(count <= 200){
                                        jl.setBounds(count, 10,200, 50);
                                        try{
                                                Thread.sleep(1000);
                                        }catch(Exception e){
                                                e.printStackTrace();
                                        }
                                        count +=4;
                                        if(count == 200){
                                                count = 10;
                                        }
                                }
                        }
                });
                t.start();
                container.add(jl);
                setVisible(true);
                setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                                
        }
        public static void main(String[] args) {
                // TODO Auto-generated method stub
                new Thread_Swing();
        }

}
