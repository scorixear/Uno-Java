import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	static String readString() throws IOException {
		return br.readLine();
	}
	static void out(Object s) {
		System.out.println(s);
	}

}
