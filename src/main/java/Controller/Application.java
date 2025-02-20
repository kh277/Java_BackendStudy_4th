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

        ResultView.printLadder(ladder);
    }
}
