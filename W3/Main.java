package shapes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * this programme is for assignment2 and 3 in JAC444.
 * 1. get all shape information from text file (start task1)
 * 2. to valid these shapes and get perimeter in each Shape class
 * 3. output task1
 * 4. check min perimeter in shapes that is triangle class to delete (start task2)
 * 5. check max perimeter in shapes that is circle class to delete
 * 6. output task2
 * 7. caliculate total perimeter in parallelogram class (start task3)
 * 8. caliculate total perimeter in triangle class
 * 9. output task3
 * @author MonicaYam
 * @version 2.0
 *
 */
public class Main {

	public static void main(String[] args) {
		final String fileName = "shapes.txt";
		int lineCount = 0;
		Shape[] shapes;

		System.out.println("------->JAC 444 Assignment 1<-------");
		displayTask(1);

		try {
			Path path = Paths.get(fileName);
			lineCount = (int)Files.lines(path).count();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

		shapes = new Shape[(int) lineCount];
		runTask1(fileName,shapes);

		displayTask(2);
		runTask2(shapes);

		displayTask(3);
		runTask3(shapes);

	}


	/**
	 * this method collects all methods for task2
	 * to getShape(tokens), displayResult(shapes)
	 * @param fileName
	 * @param shapes
	 */
	private static void runTask1(String fileName, Shape[] shapes) {
		String s;
		int numOfShapes = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
			while((s = br.readLine()) != null) {
				String[] tokens = s.split(",");
				try {
					Shape shape  = getShape(tokens);

					if(shape != null ) {
						shapes[numOfShapes] = shape;
						numOfShapes++;
					}
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}

		System.out.printf("%n%s shapes were created: %n", numOfShapes);
		displayResult(shapes);
	}

	/**
	 * get Shape from a text and call each shape class to validation.
	 * @param tokens: it is one line from text file.
	 * @return Shape shape: it includes all shapes
	 * @throws CircleException
	 * @throws SquareException
	 * @throws ParallelogramException
	 * @throws TriangleException
	 */
	private static Shape getShape(String[] tokens) throws CircleException, SquareException, ParallelogramException, TriangleException {
		Shape shape = null;

		switch(tokens[0]) {
		case "Circle":
			if(tokens.length == 2) {
				shape = new Circle(parseDouble(tokens[1]));
			}
			break;
		case "Square":
			if(tokens.length == 2) {
				shape= new Square(parseDouble(tokens[1]));
			}
			break;
		case "Parallelogram":
			if(tokens.length == 3) {
				shape = new Parallelogram(parseDouble(tokens[1]),parseDouble(tokens[2]));
			}
			break;
		case "Rectangle":
			if(tokens.length == 3) {
				shape = new Rectangle(parseDouble(tokens[1]),parseDouble(tokens[2]));
			}
			break;
		case "Triangle":
			if(tokens.length == 4) {
				shape = new Triangle(parseDouble(tokens[1]),parseDouble(tokens[2]), parseDouble(tokens[3]));
			}
			break;
		default:
			break; //nothing to do
		} //switch

		return shape;
	}

	/**
	 * this method collects all methods for task2
	 * to includes deleteMinPerimeterTri, deleteMaxPerimeterCircle, displayResult
	 * @param shapes (for all methods)
	 */
	private static void runTask2(Shape[] shapes) {
		deleteMinPerimeterTri(shapes);
		deleteMaxPerimeterCircle(shapes);
		displayResult(shapes);
	}

	/**
	 * delete Triangle has min perimeter from shape array
	 * @param shapes, arrayLength
	 */
	private static void deleteMinPerimeterTri(Shape[] shapes) {
		double minPerimeter = 100.0;
		for(Shape triangle: shapes) {
			if(triangle instanceof Triangle) {
				if( minPerimeter > triangle.getPerimeter()) {
					minPerimeter = triangle.getPerimeter();
				}
			}
		}

		for(int i = 0; i < shapes.length; i++) {
			if(shapes[i] instanceof Triangle) {
				if( shapes[i].getPerimeter() == minPerimeter) {
					shapes[i] = null;
				}
			}
		}
	}

	/**
	 * delete Circle has max perimeter from shape array
	 * @param shapes, arrayLength
	 */
	private static void deleteMaxPerimeterCircle(Shape[] shapes) {
		double maxPerimeter = 0.0;
		for(Shape circle: shapes) {
			if(circle instanceof Circle) {
				if( circle.getPerimeter() > maxPerimeter) {
					maxPerimeter = circle.getPerimeter();
				}
			}
		}

		for(int i =0; i < shapes.length; i++) {
			if(shapes[i] instanceof Circle) {
				if( shapes[i].getPerimeter() == maxPerimeter) {
					shapes[i] = null;
				}
			}
		}
	}

	/**
	 * this method collects all methods for task3
	 * @param shapes
	 */
	private static void runTask3(Shape[] shapes) {
		double pTotal = getTotalParallelogram(shapes);
		double tTotal = getTotalTriangle(shapes);
		displayTotal(pTotal, tTotal);
	}

	/**
	 * get total perimeter of Parallelogram
	 * @param shapes
	 * @return total perimeter of Parallelogram
	 */
	private static double getTotalParallelogram(Shape[] shapes) {
		double total = 0.0;
		for(Shape p: shapes) {
			if(p instanceof Parallelogram && !(p instanceof Square) && !(p instanceof Rectangle)) {
				total += p.getPerimeter();
			}
		}

		return total;
	}

	/**
	 * get total perimeter of Triangle
	 * @param shapes
	 * @return total perimeter of Triangle
	 */
	private static double getTotalTriangle(Shape[] shapes) {
		double total = 0.0;
		for(Shape t: shapes) {
			if(t != null && t instanceof Triangle) {
				total += t.getPerimeter();
			}
		}

		return total;
	}

	/**
	 * display Task i (i = 1 or 2 or 3)
	 * @param i
	 */
	private static void displayTask(int i) {
		System.out.printf("------->Task %s ... <-------%n", i);
	}

	/**
	 * display result of task1, 2
	 * @param shapes
	 */
	private static void displayResult(Shape[] shapes) {
		for(Shape shape: shapes) {
			if(shape != null) {
				System.out.printf("%s perimeter = %g %n%n", shape.toString(), shape.getPerimeter());
			}
		}
	}

	/**
	 * display total perimeter for Parallelogram and Triangle
	 * @param pTotal: total perimeter of Parallelogram
	 * @param tTotal: total perimeter of Triangle
	 */
	private static void displayTotal(double pTotal, double tTotal) {
		System.out.printf("Total perimeter of Parallelogram is:%s %n%n", pTotal);
		System.out.printf("Total perimeter of Triangle is:%.3g %n%n", tTotal);
	}

	/**
	 * it convert String to double
	 * @param String
	 * @return double
	 */
	private static double parseDouble(String s) {
		return Double.parseDouble(s);
	}
}
