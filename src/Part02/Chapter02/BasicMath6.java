package Part02.Chapter02;

public class BasicMath6 {
    public static void main(String[] args) {
        // log aB - a가 b가 되기 위해 제곱해야 하는 수

        System.out.println("Math 클래스 이용");
        System.out.println(" == 제곱 == ");
        System.out.println(Math.pow(2, 3)); // 2 * 2 * 2
        System.out.println(Math.pow(2, -3)); // 음의 지수이면 2 * 2 * 2한 후 1로 나눔
        System.out.println(Math.pow(-2, -3));

        System.out.println(Math.pow(2, 30));
        System.out.printf("%.0f\n", Math.pow(2, 30));

        System.out.println(" == 제곱근 == ");
        System.out.println(Math.sqrt(16)); // 어떤 수를 제곱해서 나오는 수
        System.out.println(Math.pow(16, 1.0 / 2));
        System.out.println(Math.pow(16, 1.0 / 4));

        System.out.println(" == 절대값 == ");
        System.out.println(Math.abs(5));
        System.out.println(Math.abs(-5));
        System.out.println(Math.abs(0.2342));

        System.out.println(" == 로그 == ");
        System.out.println(Math.E);
        System.out.println(Math.log(2.718281828459045));
        System.out.println(Math.log10(1000));
        System.out.println(Math.log(4) / Math.log(2));
    }
}
