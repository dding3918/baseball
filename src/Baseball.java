import java.sql.SQLOutput;
import java.util.PrimitiveIterator;
import java.util.Random;
import java.util.Scanner;

public class Baseball {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //랜덤수 생성
        int[] randomNumber = generateRandomNumber();

        //볼, 스트라이크 변수
        int ball = 0;
        int strike = 0;

        //몇번째 시도인지 체크할 변수
        int index = 0;

        //생선한 랜덤수
        for (int i : randomNumber) {
            System.out.print(i);
        }
        System.out.println();

        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");

        while (true) {
            System.out.print((index++ + 1) + "번째 시도 : ");

            //수 입력받은 후 배열로 재배치
            int[] inputNumber = generateInputNumber(sc.nextInt());

            //입력받은 수 중복체크
            if (hasDuplicate(inputNumber)) {
                System.out.println("중복된 수를 입력하였습니다. 다시 입력해 주세요.");
                index--;
                continue;
            }

            //입력받은 수와 랜덤수 비교
            for (int i = 0; i < randomNumber.length; i++) {
                for (int j = 0; j < inputNumber.length; j++) {
                    if (randomNumber[i] == inputNumber[j] && i == j) {
                        strike++;
                    } else if (randomNumber[i] == inputNumber[j] && i != j) {
                        ball++;
                    }
                }
            }

            if (ball == 3) {
                System.out.println(ball + "B");
            } else if (strike == 3) {
                System.out.println(strike + "S");
            } else {
                System.out.println(ball + "B" + strike + "S");
            }
            if (strike == 3) {
                System.out.println(index + "번만에 맞히셨습니다.\n게임을 종료합니다.");
                break;
            }

            strike = 0;
            ball = 0;
        }
    }

    //랜덤수 생성 함수
    private static int[] generateRandomNumber() {
        Random random = new Random();

        int first, second, third;

        //각 자리수가 다른지 체크
        while (true) {
            first = random.nextInt(10);
            second = random.nextInt(10);
            third = random.nextInt(10);
            if (first != second && second != third && third != first) {
                break;
            }
        }

        return new int[]{first, second, third};
    }

    //입력받은 수 생성 함수
    private static int[] generateInputNumber(int input){
        //입력받은 수 각자리를 input_arr에 대입
        int input_first = input / 100;
        int input_second = input / 10 % 10;
        int input_third = input % 10;

        return new int[]{input_first, input_second, input_third};
    }

    //입력받은 수 중복체크
    private static boolean hasDuplicate(int[] inputNumber) {
        return inputNumber[0] == inputNumber[1] || inputNumber[1] == inputNumber[2] || inputNumber[2] == inputNumber[0];
    }
}