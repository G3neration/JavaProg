package point3d;

// Класс Lab2 служит для нахождения площади объемного треугольника.
public class Lab2 {
	// Метод main используется как точка инициализации. В нем происходит
	// инициализация координат точек, а также вызов метода computeArea.
	public static void main(String[] args) {
		Point3d ob1 = new Point3d(Double.parseDouble(args[0]), Double.parseDouble(args[1]),
				Double.parseDouble(args[2]));
		Point3d ob2 = new Point3d(Double.parseDouble(args[3]), Double.parseDouble(args[4]),
				Double.parseDouble(args[5]));
		Point3d ob3 = new Point3d(Double.parseDouble(args[6]), Double.parseDouble(args[7]),
				Double.parseDouble(args[8]));
		if (Point3d.compareObj(ob1, ob2) || Point3d.compareObj(ob1, ob3) || Point3d.compareObj(ob2, ob3))
			System.out.println("Некоторые точки совпадают");
		else
			System.out.println("Площадь искомого треугольника равна " + computeArea(ob1, ob2, ob3));

	}

	// Метод computeArea используется для нахождения площади треугольника по формуле
	// Герона.
	public static double computeArea(Point3d ob1, Point3d ob2, Point3d ob3) {
		double sA = ob1.distanceTo(ob2);
		double sB = ob2.distanceTo(ob3);
		double sC = ob3.distanceTo(ob1);
		double halfPer = (sA + sB + sC) / 2;
		return Math.sqrt(halfPer * (halfPer - sA) * (halfPer - sB) * (halfPer - sC));
	}
}
