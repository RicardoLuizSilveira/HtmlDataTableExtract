package bolaoMegaSena.HtmlDataTableExtract;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;

import bolaoMegaSena.HtmlDataTableExtract.util.HtmlExtractor;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		Charset charset = StandardCharsets.ISO_8859_1;
//		String path = "resources/test/d_megasc_test.htm";
		String path = "resources/megasc.html";
		
		HtmlExtractor extractor = new HtmlExtractor(path, charset);
		extractor.extractDataFromHtml();
		
//		Sorteio sorteio = new Sorteio();
//		sorteio.setData(DateFormat.getDateInstance().parse("11/03/1996"));
//		sorteio.setConcurso(52);
//		sorteio.setDezena1(30);
//		
//		SorteiosDAO sorteioDAO = new SorteiosDAO();
//		sorteioDAO.salvar(sorteio);
		
		
	}

}
