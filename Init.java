package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

//保存机组信息的类
class Arr {
	public int i;// 组
	public int j;// 端
	public int value;// 段价
	public double volume;// 各机组的段容量
	public double v;// 爬坡速率
	public double init;// 初始发力
	public double max; // 机组出力上限

	Arr(int i, int j, int value, double volume, double v, double init) {
		this.i = i;
		this.j = j;
		this.value = value;
		this.volume = volume;
		this.v = v;
		max = v * 15 + init;
	}
}

class Msort {
	public static List<Arr> sort(List<Arr> l) {
		for (int x = 0; x < l.size() - 1; x++) {
			for (int y = 0; y < l.size() - 1 - x; y++) {
				if (l.get(y).value > l.get(y + 1).value) {
					Arr temp = l.get(y);
					l.set(y, l.get(y + 1));
					l.set(y + 1, temp);
				}
			}
		}
		return l;
	}

}

public class Init {
	// 先初始化信息，然后进行排序
	public static List<Arr> sort() {
		List<Arr> arr = new ArrayList<Arr>();// 定义存放各机组的段价
		// 初始化保存段价
		int A[][] = { { -505, 0, 124, 168, 210, 252, 312, 330, 363, 489, },
				{ -560, 0, 182, 203, 245, 300, 320, 360, 410, 495, },
				{ -610, 0, 152, 189, 233, 258, 308, 356, 415, 500, },
				{ -500, 150, 170, 200, 255, 302, 325, 380, 435, 800, },
				{ -590, 0, 116, 146, 188, 215, 250, 310, 396, 510, },
				{ -607, 0, 159, 173, 205, 252, 305, 380, 405, 520, },
				{ -500, 120, 180, 251, 260, 306, 315, 335, 348, 548, },
				{ -800, 153, 183, 233, 253, 283, 303, 318, 400, 800, } };
		// 机组容量
		double B[][] = { { 70, 0, 50, 0, 0, 30, 0, 0, 0, 40 },
				{ 30, 0, 20, 8, 15, 6, 2, 0, 0, 8 },
				{ 110, 0, 40, 0, 30, 0, 20, 40, 0, 40 },
				{ 55, 5, 10, 10, 10, 10, 15, 0, 0, 1 },
				{ 75, 5, 15, 0, 15, 15, 0, 10, 10, 10 },
				{ 95, 0, 10, 20, 0, 15, 10, 20, 0, 10 },
				{ 50, 15, 5, 15, 10, 10, 5, 10, 3, 2 },
				{ 70, 0, 20, 0, 20, 0, 20, 10, 15, 5 } };
		// 机组爬坡速率
		double C[] = { 2.2, 1, 3.2, 1.3, 1.8, 2, 1.4, 1.8 };
		// 机组的出事发力
		double D[] = { 120, 73, 180, 80, 125, 125, 81.1, 90 };
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 10; j++) {

				Arr temp = new Arr(i + 1, j + 1, A[i][j], B[i][j], C[i], D[i]);
				arr.add(temp);
			}
		}
		List<Arr> sortedarr = Msort.sort(arr);
		return sortedarr;
	}
	 
	

}
