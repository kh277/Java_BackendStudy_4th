package Controller;

import Model.Ladder;
import View.InputView;
import View.ResultView;

public class Application
{
    public static void main(String[] args)
    {
        int ladderWidth = InputView.getLadderWidth();
        int ladderHeight = InputView.getLadderHeight();
        Ladder ladder = new Ladder(ladderWidth, ladderHeight);
        ladder.setAllLadder();

        // 생성한 사다리 출력
        ResultView.printLadder(ladder);

        // 시작점, 도착점 출력
        ResultView.printFinalPosition(ladder);
    }
}
