
public class threadertest  extends Thread{

        public static void main(String[] args) {
                        final int count = 1000;
                        new Thread(){
                            public void run() {
                                for(int i = 1; i <= count ;i=i+2) {
                                    // 奇数，起始值为1，增长步长为2
                                    try {
                                        System.out.println("奇数线程：\t" + i);
                                        // 暂停0.5秒
                                        sleep(1);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            };
                        }.start();
                        new Thread(){
                            public void run() {
                                for(int i = 0; i <= count ;i=i+2) {
                                    // 偶数，起始值为0，增长步长为2
                                    try {
                                        System.out.println("偶数线程：\t" + i);
                                        // 暂停0.5秒
                                        sleep(1);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            };
                        }.start();
            }
}



