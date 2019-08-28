package servicos;

import java.io.IOException;

public class KeyBoardService {

	public static String readline() throws IOException {
		StringBuffer input = new StringBuffer();
		try {
			char in = (char) System.in.read();
			while( in != '\n') {
				input.append(in);
				in = (char) System.in.read();
			}
			
		} catch(Exception e) {
			System.out.println("Erro na digitação.");
		}
		return input.toString().trim();
	}
}
