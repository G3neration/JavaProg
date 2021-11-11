package point3d;

public class Point3d {

	// ** ���������� X **/
	private double xCoord;
	// ** ���������� Y **/
	private double yCoord;
	// ** ���������� Z **/
	private double zCoord;

	// ** ����������� ������������� **/
	public Point3d(double x, double y, double z) {
		xCoord = x;
		yCoord = y;
		zCoord = z;
	}

	// ** ����������� �� ���������. **/
	public Point3d() {
		// �������� ����������� � ����� ����������� � ���������� ��������.
		this(0, 0, 0);
	}

	// ** ����������� ���������� X **/
	public double getX() {
		return xCoord;
	}

	// ** ����������� ���������� Y **/
	public double getY() {
		return yCoord;
	}

	// ** ����������� ���������� Z **/
	public double getZ() {
		return zCoord;
	}

	// ** ��������� �������� ���������� X. **/
	public void setX(double val) {
		xCoord = val;
	}

	// ** ��������� �������� ���������� Y. **/
	public void setY(double val) {
		yCoord = val;
	}

	// ** ��������� �������� ���������� Y. **/
	public void setZ(double val) {
		zCoord = val;
	}

	// ** ��������� �������� ���� �������� **/
	public static boolean compareObj(Point3d ob1, Point3d ob2) {
		return ob1.getX() == ob2.getX() && ob1.getY() == ob2.getY() && ob1.getZ() == ob2.getZ();
	}

	// **���������� ���������� ����� ���������**
	public double distanceTo(Point3d obj) {
		double distance = Math.sqrt(Math.pow(this.xCoord - obj.xCoord, 2) + Math.pow(this.yCoord - obj.yCoord, 2)
				+ Math.pow(this.zCoord - obj.zCoord, 2));
		return Math.round(distance * 100) / 100.0;
	}
}
