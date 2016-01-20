package bolaoMegaSena.HtmlDataTableExtract.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bolaoMegaSena.HtmlDataTableExtract.domain.Sorteio;
import bolaoMegaSena.HtmlDataTableExtract.persistence.SorteiosDAO;

public class HtmlExtractor {

	private Path path;
	private Charset charset;
	private int contador = 0;
	
	private final int indiceDataSorteio = 0;
	private final int indiceDezena1 = 1;
	private final int indiceDezena2 = 2;
	private final int indiceDezena3 = 3;
	private final int indiceDezena4 = 4;
	private final int indiceDezena5 = 5;
	private final int indiceDezena6 = 6;
	private final int indiceArrecadacaoTotal = 7;
	private final int indiceGanhadoresSena = 8;
	private final int indiceCidade = 9;
	private final int indiceUF = 10;
	private final int indiceRateioSena = 11;
	private final int indiceGanhadoresQuina = 12;
	private final int indiceRateioQuina = 13;
	private final int indiceGanhadoresQuadra = 14;
	private final int indiceRateioQuadra = 15;
	private final int indiceAcumulado = 16;
	private final int indiceValorAcumulado = 17;
	private final int indiceEstimativaPremio = 18;
	private final int indiceAcumuladoMegaDaVirada = 19;
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("bolaomegaPU");
	EntityManager em = emf.createEntityManager();

	public HtmlExtractor() {
	}

	public HtmlExtractor(Charset charset) {
		this.charset = charset;
	}

	public HtmlExtractor(String path, Charset charset) {
		this.path = Paths.get(path);
		this.charset = charset;
	}

	public void extractDataFromHtml() throws ParseException {
		BufferedReader reader;
		String line = null;

		try {
			reader = Files.newBufferedReader(path, charset);

			while ((line = reader.readLine()) != null) {
				String plainEntity = "";
				System.out.println("WHILE=1");
				if (line.matches("<tr.*")) {
					System.out.println("IF=1");
					line = readLine(reader);
					if ((line.matches("<td rowspan=\"\\d+\">.*"))) {

						System.out.println("IF = 2");
						plainEntity = readOneEntireEntity(reader);
						contador++;
						System.out.println("linha numero: " + contador);
						System.err.println(plainEntity);
						Sorteio sorteio = assemblyEntity(plainEntity);
						persistData(sorteio);
						
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Erro com o reader");
			e.printStackTrace();
		} finally {
			try {
				if(em != null) {
					em.close();
				}
			} catch (Exception e2) {
				System.out.println("erro fechando EntityManager");
			}
		}

	}
	public void persistData(Sorteio sorteio){
		
		em.getTransaction().begin();
		em.persist(sorteio);
		em.getTransaction().commit();

	}
	
	public Sorteio assemblyEntity(String plainEnity) throws ParseException{
		String[] entity = plainEnity.split(";");
		Sorteio sorteio = new Sorteio();
		sorteio.setConcurso(contador);
		sorteio.setDataDoSorteio(DateFormat.getDateInstance().parse(entity[indiceDataSorteio]));
		sorteio.setDezena1(Integer.parseInt(entity[indiceDezena1]));
		sorteio.setDezena2(Integer.parseInt(entity[indiceDezena2]));
		sorteio.setDezena3(Integer.parseInt(entity[indiceDezena3]));
		sorteio.setDezena4(Integer.parseInt(entity[indiceDezena4]));
		sorteio.setDezena5(Integer.parseInt(entity[indiceDezena5]));
		sorteio.setDezena6(Integer.parseInt(entity[indiceDezena6]));
		sorteio.setArrecadacaoTotal(Double.parseDouble(entity[indiceArrecadacaoTotal]));
		sorteio.setGanhadoresSena(Integer.parseInt(entity[indiceGanhadoresSena]));
		if (!(entity[indiceCidade].equals("vazio"))) {
			sorteio.setCidade(entity[indiceCidade]);
		}
		if (!(entity[indiceUF].equals("vazio"))) {
			sorteio.setUF(entity[indiceUF]);
		}
		sorteio.setRateioSena(Double.parseDouble(entity[indiceRateioSena]));
		sorteio.setGanhadoresQuina(Integer.parseInt(entity[indiceGanhadoresQuina]));
		sorteio.setRateioQuina(Double.parseDouble(entity[indiceRateioQuina]));
		sorteio.setGanhadoresQuadra(Integer.parseInt(entity[indiceGanhadoresQuadra]));
		sorteio.setRateioQuadra(Double.parseDouble(entity[indiceRateioQuadra]));
		sorteio.setAcumulado(entity[indiceAcumulado]);
		sorteio.setValorAcumulado(Double.parseDouble(entity[indiceValorAcumulado]));
		sorteio.setEstimativaPremio(Double.parseDouble(entity[indiceEstimativaPremio]));
		sorteio.setAcumuladoMegaDaVirada(Double.parseDouble(entity[indiceAcumuladoMegaDaVirada]));
		return sorteio;
	}

	public String readOneEntireEntity(BufferedReader reader) throws IOException {
		String plainEntityToReturn = "";
		String line = "";
		while ((!line.matches(".*</tr>.*"))) {
			plainEntityToReturn = plainEntityToReturn + "" + line;
			line = readLine(reader);
		}
		plainEntityToReturn = plainEntityToReturn.replaceAll("<td rowspan=\"\\d+\">", "");
		plainEntityToReturn = plainEntityToReturn.replaceAll("</td><td>", ";");
		plainEntityToReturn = plainEntityToReturn.replaceAll("<td></td>", "");
		plainEntityToReturn = plainEntityToReturn.replaceAll("<td>", "");
		plainEntityToReturn = plainEntityToReturn.replaceAll("</td>", ";");
		plainEntityToReturn = plainEntityToReturn.replaceAll("&nbsp", "vazio");
		plainEntityToReturn = plainEntityToReturn.replaceAll("\\s", "");
		plainEntityToReturn = plainEntityToReturn.replaceAll(";$", "");
		plainEntityToReturn = plainEntityToReturn.replaceAll("\\.", "");
		plainEntityToReturn = plainEntityToReturn.replaceAll(",", ".");
		plainEntityToReturn = plainEntityToReturn.replaceAll(";;", ";vazio;");
		
		// apelando
//		plainEntityToReturn = plainEntityToReturn.replaceAll("vazio;BELOHORIZONTE;vazio;MG;", "BELOHORIZONTE;MG;");
		
//		plainEntityToReturn = plainEntityToReturn.replaceAll("</td><td rowspan=\"\\d+\">", ";");
//		plainEntityToReturn = plainEntityToReturn.replaceAll("</td>", "");
//		plainEntityToReturn = plainEntityToReturn.replaceAll("<td>", ";");
		return plainEntityToReturn;
	}

	public String readLine(BufferedReader reader) throws IOException {
		String lineToReturn = null;
		
		do {
			lineToReturn = reader.readLine();
		} while (lineToReturn.matches(""));
		return lineToReturn;
	}
}
