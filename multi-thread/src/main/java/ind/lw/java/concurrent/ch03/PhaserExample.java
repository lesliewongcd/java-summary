package ind.lw.java.thread.ch03;

import java.util.concurrent.TimeUnit;

/**
 * Created by wang.zhe8 on 2018/3/23.
 */
public class PhaserExample {


    public static class StudentTask implements Runnable{

        private String name;

        private ExamPhaser examPhaser;

        public StudentTask(String name, ExamPhaser examPhaser) {
            this.name = name;
            this.examPhaser = examPhaser;
        }

        @Override
        public void run() {

            trace("arrive at classroom");
            examPhaser.arriveAndAwaitAdvance();

            trace("start to do exercise part 1");
            doExercisePart1();
            trace("complete exercise part 1");
            examPhaser.arriveAndAwaitAdvance();


            trace("start to do exercise part 2");
            doExercisePart2();
            trace("complete exercise part 2");
            examPhaser.arriveAndAwaitAdvance();


            trace("start to do exercise part 3");
            doExercisePart3();
            trace("complete exercise part 3");
            examPhaser.arriveAndAwaitAdvance();


        }

        private void doExercisePart3() {
            doExercisePart1();
        }

        private void doExercisePart2() {
            doExercisePart1();
        }

        private void doExercisePart1() {
            long waitTime = (long) (Math.random()*10);

            try {
                TimeUnit.SECONDS.sleep(waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        void trace(String message){
            System.out.println(String.format("[%s] %s",name,message));
        }
    }


    public static void main(String[] args) {

        ExamPhaser phaser = new ExamPhaser();


        StudentTask[] studentTasks = new StudentTask[5];

         for (int i=0;i<studentTasks.length;i++){
             studentTasks[i] = new StudentTask("S"+i,phaser);
             phaser.register();
         }

        Thread[] threads = new Thread[studentTasks.length];
        for (int i=0;i<threads.length;i++){
            threads[i] = new Thread(studentTasks[i]);
            threads[i].start();
        }


        for (int i =0;i<threads.length;i++){
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All threads has finished");
    }
}
