import edu.duke.*;

public class HelloWorld {
	public void runHello () {
		FileResource res = new FileResource("hello_unicode.txt");
		for (String line : res.lines()) {
			System.out.println(line);
		}
		System.out.println("Hello World I am here");
	}
}
