package point3d;

public class Point3d {

	// ** координата X **/
	private double xCoord;
	// ** координата Y **/
	private double yCoord;
	// ** координата Z **/
	private double zCoord;

	// ** Конструктор инициализации **/
	public Point3d(double x, double y, double z) {
		xCoord = x;
		yCoord = y;
		zCoord = z;
	}

	// ** Конструктор по умолчанию. **/
	public Point3d() {
		// Вызовите конструктор с тремя параметрами и определите источник.
		this(0, 0, 0);
	}

	// ** Возвращение координаты X **/
	public double getX() {
		return xCoord;
	}

	// ** Возвращение координаты Y **/
	public double getY() {
		return yCoord;
	}

	// ** Возвращение координаты Z **/
	public double getZ() {
		return zCoord;
	}

	// ** Установка значения координаты X. **/
	public void setX(double val) {
		xCoord = val;
	}

	// ** Установка значения координаты Y. **/
	public void setY(double val) {
		yCoord = val;
	}

	// ** Установка значения координаты Y. **/
	public void setZ(double val) {
		zCoord = val;
	}

	// ** Сравнение значений двух объектов **/
	public static boolean compareObj(Point3d ob1, Point3d ob2) {
		return ob1.getX() == ob2.getX() && ob1.getY() == ob2.getY() && ob1.getZ() == ob2.getZ();
	}

	// **Вычисление расстояния между объектами**
	public double distanceTo(Point3d obj) {
		double distance = Math.sqrt(Math.pow(this.xCoord - obj.xCoord, 2) + Math.pow(this.yCoord - obj.yCoord, 2)
				+ Math.pow(this.zCoord - obj.zCoord, 2));
		return Math.round(distance * 100) / 100.0;
	}
}
