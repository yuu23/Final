package selfStudy;

public class Training {
	public static void main(String[] args) {

		// アンダースコア使用例
		System.out.println("---アンダースコア使用を使用した結果---");
		int price = 2_000_000;
		System.out.println(price + "円");
		System.out.println();

		// エスケープシーケンス使用例(￥マークが何故か「\」になってしまう）
		System.out.println("---エスケープシーケンスを使用した結果---");
		System.out.println("私の好きな記号は二重引用符(\")です");
		System.out.println("\\");
		System.out.println();

		// ランダムな数を生成する命令
		System.out.println("---ランダムな数を生成します---");
		int r = new java.util.Random().nextInt(90);
		System.out.println(r);
		System.out.println();

		// キーボードから一行の入力を受け取る命令
		System.out.println("---一行文字を入力してください---");
		String input = new java.util.Scanner(System.in).nextLine();
		System.out.println();

		// キーボードから1つの整数を入力を受け付ける
		System.out.println("---整数を入力してください---");
		int input2 = new java.util.Scanner(System.in).nextInt();
		System.out.println();


	}
}
