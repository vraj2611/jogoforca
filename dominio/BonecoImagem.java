package dominio;

import java.io.PrintStream;

public class BonecoImagem implements Boneco {

	private BonecoImagem() {}

	@Override
	public void exibir(Object contexto, int partes) {
		String saida = new String();
		
		if (partes == 1) {
			saida = "CABECA";
		} else if (partes == 2) {
			saida = "CABECA, OLHO ESQ";
		} else if (partes == 3) {
			saida = "CABECA, OLHO ESQ, OLHO DIR";
		} else if (partes == 4) {
			saida = "CABECA, OLHO ESQ, OLHO DIR, NARIZ";
		} else if (partes == 5) {
			saida = "CABECA, OLHO ESQ, OLHO DIR, NARIZ, BOCA";
		} else if (partes == 6) {
			saida = "CABECA, OLHO ESQ, OLHO DIR, NARIZ, BOCA, TRONCO";
		} else if (partes == 7) {
			saida = "CABECA, OLHO ESQ, OLHO DIR, NARIZ, BOCA, TRONCO, BRA�O ESQ";
		} else if (partes == 8) {
			saida = "CABECA, OLHO ESQ, OLHO DIR, NARIZ, BOCA, TRONCO, BRA�O ESQ, BRA�O DIR";
		} else if (partes == 9) {
			saida = "CABECA, OLHO ESQ, OLHO DIR, NARIZ, BOCA, TRONCO, BRA�O ESQ, BRA�O DIR, PERNA ESQ";
		} else if (partes == 10) {
			saida = "CABECA, OLHO ESQ, OLHO DIR, NARIZ, BOCA, TRONCO, BRA�O ESQ, BRA�O DIR, PERNA ESQ, PERNA DIR";
		}
		
		((PrintStream) contexto).println(saida);
	}
	
	
	public BonecoImagem getSoleInstance() {
		BonecoImagem bonecoImagem = new BonecoImagem();
		return bonecoImagem;
	}
	
}
