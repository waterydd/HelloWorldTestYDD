
public class threadertest  extends Thread{

        public static void main(String[] args) {
                        final int count = 1000;
                        new Thread(){
                            public void run() {
                                for(int i = 1; i <= count ;i=i+2) {
                                    // ��������ʼֵΪ1����������Ϊ2
                                    try {
                                        System.out.println("�����̣߳�\t" + i);
                                        // ��ͣ0.5��
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
                                    // ż������ʼֵΪ0����������Ϊ2
                                    try {
                                        System.out.println("ż���̣߳�\t" + i);
                                        // ��ͣ0.5��
                                        sleep(1);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            };
                        }.start();
            }
}



