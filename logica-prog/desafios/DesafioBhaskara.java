import java.util.Scanner;

public class DesafioBhaskara {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o valor de a: ");
        double a = entrada.nextDouble();

        System.out.print("Digite o valor de b: ");
        double b = entrada.nextDouble();

        System.out.print("Digite o valor de c: ");
        double c = entrada.nextDouble();

        double[] raizes = calcularRaizes(a, b, c);


        if (raizes.length > 0) {
            System.out.println("Raízes reais:");
            for (double raiz : raizes) {
                System.out.println("x = " + raiz);
            }
        } else {
            System.out.println("Raízes complexas.");
        }

        entrada.close();
    }
    private static double[] calcularRaizes(double a, double b, double c) {
        double delta = Math.pow(b, 2) - (4 * a * c);

        if (delta >= 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            return new double[]{x1, x2};
        } else {
            return new double[0];
        }
    }
}
