package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder
{
    private final List<Line> lines = new ArrayList<>();
    private final LadderSetting setting;

    public Ladder(int ladderWidth, int ladderHeight)
    {
        this.setting = new LadderSetting(ladderWidth, ladderHeight);
    }

    private boolean randomBoolean()
    {
        int randomNumber = (int)(Math.random() + 0.5);
        if (randomNumber == 1)
            return true;

        return false;
    }

    private void addLines(Line leftLine, Line curLine)
    {
        IntStream.range(0, setting.getHeight())
                .filter(curHeight -> !curLine.checkIsConflict(leftLine, curHeight))
                .forEach(curHeight -> curLine.setPoints(curHeight, randomBoolean()));
    }

    public void setAllLadder() {
        // 첫 번째 라인 생성 및 초기화
        Line firstLine = new Line(setting);
        lines.add(firstLine);
        addLines(firstLine, firstLine);  // 필요한 경우; 만약 첫 줄에 대해 다른 처리가 필요하다면 수정하세요.

        // 이후 라인 생성 및 설정
        for (int lineNumber = 1; lineNumber < setting.getWidth(); lineNumber++) {
            Line newLine = new Line(setting);  // 새로운 라인 생성
            addLines(lines.get(lineNumber - 1), newLine);  // 이전 라인과 새 라인을 대상으로 addLines 호출
            lines.add(newLine);  // 리스트에 추가
        }
    }


    public int getWidth()
    {
        return setting.getWidth();
    }

    public int getHeight()
    {
        return setting.getHeight();
    }

    public boolean getData(int ladderNumber, int ladderHeight)
    {
        return lines.get(ladderNumber).getPoints(ladderHeight);
    }
}
