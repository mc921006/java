
public class MethodOverRidingEx {
	static void paint(Shape p) {
		p.draw();
	}
	
	static void paintAll(Shape p) {
		while (p != null) {
			p.draw();
			p = p.next;
		}
	}
	public static void main(String[] args) {
		
		Shape p = new Line();
		p.next = new Circle();
		Shape p2 = new Rect();
		p2.next = p;
		p = new Line();
		p.next = p2;
		paintAll(p);
//		Line line = new Line();
//		
//		paint(line);
//		paint(new Shape()); //Shape.draw
//		paint(new Line()); //Line.draw
//		paint(new Rect()); //Rect.draw
//		paint(new Circle()); //Circle.draw
	}
}

class Shape {
	public Shape next;
	public Shape() {
		next = null;
	}
	
	public void draw() {
		System.out.println("Shape");
	}
}

class Line extends Shape {
	public void draw() {
		System.out.println("Line");
	}
}

class Rect extends Shape {
	public void draw() {
		System.out.println("Rect");
	}
}

class Circle extends Shape {
	public void draw() {
		System.out.println("Circle");
	}
}