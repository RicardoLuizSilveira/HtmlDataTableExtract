package bolaoMegaSena.HtmlDataTableExtract.util;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class HtmlExtractorTest {

	HtmlExtractor extractor;

	@Test
	public void testReadLine() throws IOException {

		Path path = Paths.get("resources/test/readLineTest.htm");
		Charset utf8 = StandardCharsets.UTF_8;
		extractor = new HtmlExtractor(utf8);
		BufferedReader reader = Files.newBufferedReader(path);

		String expected = "<td rowspan=\"1\">1</td>";
		String actual = extractor.readLine(reader);
		assertEquals(expected, actual);
	}

	@Test
	public void testReadOneEntireEntity() throws IOException{
		Path path = Paths.get("resources/test/extractData.htm");
		Charset utf8 = StandardCharsets.UTF_8;
		extractor = new HtmlExtractor();
		BufferedReader reader = Files.newBufferedReader(path,utf8);
		
		String expected = "11/03/1996;04;0;&nbsp;&nbsp;0,00;17;SIM;1.714.650,23;0,00";
		String actual = extractor.readOneEntireEntity(reader);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

}









































