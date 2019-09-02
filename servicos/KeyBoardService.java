package servicos;

public class KeyBoardService {

	public static String readline(){
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
