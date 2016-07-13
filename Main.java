package test;

import java.text.DecimalFormat;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// double goal = 982.4;// 目标值
		double goal = 1052.8;// 目标值
		double sum = 0;// 累计出力
		double[] gen_sum = new double[8];// 各机组累计初级,这里面不能超过机组上限出力
		int n = 0;
		int m = 0;
		int[] last = new int[8];// 保存最后一个段被利用
		List<Arr> arr = Init.sort();// 初始化原始数据，然后对段价进行排序
		for (int i = 0; i < arr.size(); i++) {
			if (sum < goal) {
				if (gen_sum[arr.get(i).i - 1] <= arr.get(i).max) {
					gen_sum[arr.get(i).i - 1] += arr.get(i).volume;
					sum += arr.get(i).volume;
					System.out.print("机组:");
					System.out.print(arr.get(i).i);
					System.out.print(" 段:");
					System.out.print(arr.get(i).j);
					System.out.println(" 被加入");
					System.out.println("sum:" + sum);
					System.out.println("max "+arr.get(i).max);
					last[arr.get(i).i - 1] = arr.get(i).j;
					if (gen_sum[arr.get(i).i - 1] > arr.get(i).max) {
						sum -= gen_sum[arr.get(i).i - 1] - arr.get(i).max;
						gen_sum[arr.get(i).i - 1] = arr.get(i).max;

					}

				} else {
					continue;
				}

			} else {
				double temp = sum - goal;

				gen_sum[arr.get(i - 1).i - 1] -= temp;
				n = arr.get(i - 1).i;
				m = arr.get(i - 1).j;
				System.out.println("第" + n + "机组" + m + "段加入后超过预测负荷");
				System.out.println("清算价" + arr.get(i - 1).value);
				break;
			}
		}

		System.out.println("每个机组累计出力:");
		for (int x = 0; x < gen_sum.length; x++) {
			System.out.print(x + 1);
			DecimalFormat df = new DecimalFormat("#.0");
			System.out.println("机组累计出力" + df.format(gen_sum[x]));

		}
		for (int x = 0; x < gen_sum.length; x++) {
			System.out.print(x + 1);
			System.out.println("机组——段" + last[x]);

		}

	}

}
