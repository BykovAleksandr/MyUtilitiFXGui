package engine.guiControllers;


import javafx.concurrent.Task;

public class DoWork extends Task<Integer> {

    private int arrayNum;


    public DoWork(int arrayNum) {
        this.arrayNum = arrayNum;
    }

    @Override
    protected Integer call() throws Exception {
        for (int i = 0; i < arrayNum; i++) {
            //System.out.println(i + 1);
            updateProgress(i + 1, arrayNum);
            Thread.sleep(0);
            if (isCancelled()) {
                return i;
            }
        }
        return null;
    }
}