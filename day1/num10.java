import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class CoffeeMachine extends JFrame {
    private CenterPanel cPanel = new CenterPanel();
    private SouthPanel sPanel = new SouthPanel();
    private NorthPanel nPanel = new NorthPanel();

    public CoffeeMachine() {
        setTitle("커피 자판기");
        setSize(550, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.add(nPanel, BorderLayout.NORTH); // 센터영역에 패널 부착
        c.add(cPanel, BorderLayout.CENTER);
        c.add(sPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    class CenterPanel extends JPanel { // 자판기 시뮬레이터
        private BoxLabel[] boxes = new BoxLabel[5];

        // BoxLabel[]에 대한 인덱스
        private final int CUP = 0;
        private final int COFFEE = 1;
        private final int WATER = 2;
        private final int SUGAR = 3;
        private final int CREAM = 4;

        public CenterPanel() {
            setLayout(null);

            // 재료 이름
            String ing[] = { "Cup", "Coffee", "Water", "Sugar", "Cream" };

            for (int i = 0; i < boxes.length; i++) {
                boxes[i] = new BoxLabel();
                boxes[i].setLocation(55 + 90 * i, 60); // 레이블의 위치 설정
                boxes[i].setSize(50, 120);

                JLabel la = new JLabel(ing[i]);
                la.setBounds(65 + (i * 90), 170, 100, 50);

                add(la);
                add(boxes[i]);
            }
        }

        public boolean consumeResource(int[] indices) {
            for (int index : indices) {
                if (!boxes[index].consume()) { // 재료 소모 불가능한 경우
                    return false;
                }
            }
            return true;
        }

        public void resetResources() {
            for (BoxLabel box : boxes) {
                box.reset();
            }
        }
    }

    class BoxLabel extends JPanel {
        private final int MAX = 10;
        private int currentSize;
        private JProgressBar progressBar;

        boolean consume() {
            if (currentSize > 0) {
                currentSize--;
                updateProgress();
                return true;
            } else {
                return false;
            }
        }

        void reset() {
            currentSize = MAX;
            updateProgress();
        }

        boolean isEmpty() {
            return currentSize == 0;
        }

        private void updateProgress() {
            progressBar.setValue((currentSize * 100) / MAX);
        }

        public BoxLabel() {
            setLayout(null);

            currentSize = MAX;

            progressBar = new JProgressBar(JProgressBar.VERTICAL, 0, 100);
            progressBar.setValue(100); // 초기값
            progressBar.setBounds(0, 0, 50, 120);
            add(progressBar);
        }
    }

    class SouthPanel extends JPanel { // 4개 버튼
        private JButton[] coffeeButtons = new JButton[4]; // 3 개의 커피 선택 버튼과 "Reset" 버튼
        private String[] names = { "Black Coffee", "Sugar Coffee", "Dabang Coffee", "Reset" }; // 버튼 문자열 배열

        public SouthPanel() {
            for (int i = 0; i < coffeeButtons.length; i++) { // 버튼 배열의 개수(4)만큼 루프
                coffeeButtons[i] = new JButton(names[i]); // 버튼 컴포넌트 생성
                add(coffeeButtons[i]);

                int index = i; // 버튼 번호 저장
                coffeeButtons[i].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (index == 3) { // Reset 버튼
                            cPanel.resetResources();
                            JOptionPane.showMessageDialog(null, "재료가 리셋되었습니다.", "Reset", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            handleCoffeeMaking(index);
                        }
                    }
                });
            }
        }

        private void handleCoffeeMaking(int coffeeType) {
            int[] requiredResources;
            switch (coffeeType) {
                case 0: // Black Coffee
                    requiredResources = new int[] { 0, 1, 2 }; // Cup, Coffee, Water
                    break;
                case 1: // Sugar Coffee
                    requiredResources = new int[] { 0, 1, 2, 3 }; // Cup, Coffee, Water, Sugar
                    break;
                case 2: // Dabang Coffee
                    requiredResources = new int[] { 0, 1, 2, 3, 4 }; // Cup, Coffee, Water, Sugar, Cream
                    break;
                default:
                    return;
            }

            if (cPanel.consumeResource(requiredResources)) {
                JOptionPane.showMessageDialog(null, "뜨거워요. 즐거운 하루...", "커피 나왔습니다.", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "재료가 부족합니다.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class NorthPanel extends JPanel { // 레이블
        public NorthPanel() {
            Color color = new Color(0xCD28F6);
            setBackground(color);
            JLabel la = new JLabel("Welcome, Hot Coffee!");
            add(la);
        }
    }

    public static void main(String[] args) {
        new CoffeeMachine();
    }
}
