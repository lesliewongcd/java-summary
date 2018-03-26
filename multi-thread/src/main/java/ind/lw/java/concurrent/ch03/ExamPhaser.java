package ind.lw.java.thread.ch03;

import java.util.concurrent.Phaser;

/**
 * Created by wang.zhe8 on 2018/3/23.
 */
public class ExamPhaser extends Phaser {

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        switch (phase) {
            case 0:
                return studentArrived();
            case 1:
                return completeExercisePart1();
            case 2:
                return completeExercisePart2();
            case 3:
                return completeExercisePart3();
            default:
                return true;
        }
    }

    private boolean studentArrived() {
        System.out.println("All student arrived");
        return false;
    }

    private boolean completeExercisePart1(){
        System.out.println("All student complete exercise part 1");
        return false;
    }
    private boolean completeExercisePart2(){
        System.out.println("All student complete exercise part 2");
        return false;
    }
    private boolean completeExercisePart3(){
        System.out.println("All student complete exercise part 3");
        return false;
    }
}
