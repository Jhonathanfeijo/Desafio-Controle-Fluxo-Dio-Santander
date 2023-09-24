import java.util.Scanner;

public class Contador {
	public static void main(String[] args) {

		Scanner terminal = new Scanner(System.in);
		System.out.println("Digite o primeiro parametro");
		int parametroUm = terminal.nextInt();
		System.out.println("Digite o segundo parametro");
		int parametroDois = terminal.nextInt();

		try {
			contar(parametroUm, parametroDois);
		} catch (ParametrosInvalidosException ex) {
			System.out.println(ex.getMessage());
		}
	}

	static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
		if (parametroUm > parametroDois)
			throw new ParametrosInvalidosException("O primeiro parametro nao pode ser maior que o segundo");
		int contagem = parametroDois - parametroUm;
		System.out.println("\nA quantidade de contagem vai ser: " + contagem);
		for (int i = 1; i <= contagem; i++) {
			System.out.println("Imprimindo numero " + i + "\n");
		}
	}
}
