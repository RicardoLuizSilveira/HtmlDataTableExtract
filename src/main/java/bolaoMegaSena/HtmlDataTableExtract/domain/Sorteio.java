package bolaoMegaSena.HtmlDataTableExtract.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="concursos")
public class Sorteio {
	
	private Long id;
	private Integer concurso;
	private Date dataDoSorteio;
	private Integer dezena1;
	private Integer dezena2;
	private Integer dezena3;
	private Integer dezena4;
	private Integer dezena5;
	private Integer dezena6;
	private Double arrecadacaoTotal;
	private Integer ganhadoresSena;
	private String cidade;
	private String UF;
	private Double rateioSena;
	private Integer ganhadoresQuina;
	private Double rateioQuina;
	private Integer ganhadoresQuadra;
	private Double rateioQuadra;
	private String acumulado;
	private Double valorAcumulado;
	private Double estimativaPremio;
	private Double acumuladoMegaDaVirada;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getConcurso() {
		return concurso;
	}
	public void setConcurso(Integer concurso) {
		this.concurso = concurso;
	}
	
	@Column(name="data_sorteio")
	@Temporal(TemporalType.DATE)
	public Date getDataDoSorteio() {
		return dataDoSorteio;
	}
	public void setDataDoSorteio(Date dataDoSorteio) {
		this.dataDoSorteio = dataDoSorteio;
	}
	
	@Column(name="dezena_1")
	public Integer getDezena1() {
		return dezena1;
	}
	public void setDezena1(Integer dezena1) {
		this.dezena1 = dezena1;
	}
	@Column(name="dezena_2")
	public Integer getDezena2() {
		return dezena2;
	}
	public void setDezena2(Integer dezena2) {
		this.dezena2 = dezena2;
	}
	@Column(name="dezena_3")
	public Integer getDezena3() {
		return dezena3;
	}
	public void setDezena3(Integer dezena3) {
		this.dezena3 = dezena3;
	}
	@Column(name="dezena_4")
	public Integer getDezena4() {
		return dezena4;
	}
	public void setDezena4(Integer dezena4) {
		this.dezena4 = dezena4;
	}
	@Column(name="dezena_5")
	public Integer getDezena5() {
		return dezena5;
	}
	public void setDezena5(Integer dezena5) {
		this.dezena5 = dezena5;
	}
	@Column(name="dezena_6")
	public Integer getDezena6() {
		return dezena6;
	}
	public void setDezena6(Integer dezena6) {
		this.dezena6 = dezena6;
	}
	@Column(name="arrecadacao_total")
	public Double getArrecadacaoTotal() {
		return arrecadacaoTotal;
	}
	public void setArrecadacaoTotal(Double arrecadacaoTotal) {
		this.arrecadacaoTotal = arrecadacaoTotal;
	}
	@Column(name="ganhadores_sena")
	public Integer getGanhadoresSena() {
		return ganhadoresSena;
	}
	public void setGanhadoresSena(Integer ganhadoresSena) {
		this.ganhadoresSena = ganhadoresSena;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUF() {
		return UF;
	}
	public void setUF(String uF) {
		UF = uF;
	}
	@Column(name="rateio_sena")
	public Double getRateioSena() {
		return rateioSena;
	}
	public void setRateioSena(Double rateioSena) {
		this.rateioSena = rateioSena;
	}
	@Column(name="ganhadores_quina")
	public Integer getGanhadoresQuina() {
		return ganhadoresQuina;
	}
	public void setGanhadoresQuina(Integer ganhadoresQuina) {
		this.ganhadoresQuina = ganhadoresQuina;
	}
	@Column(name="rateio_quina")
	public Double getRateioQuina() {
		return rateioQuina;
	}
	public void setRateioQuina(Double rateioQuina) {
		this.rateioQuina = rateioQuina;
	}
	@Column(name="ganhadores_quadra")
	public Integer getGanhadoresQuadra() {
		return ganhadoresQuadra;
	}
	public void setGanhadoresQuadra(Integer ganhadoresQuadra) {
		this.ganhadoresQuadra = ganhadoresQuadra;
	}
	@Column(name="rateio_quadra")
	public Double getRateioQuadra() {
		return rateioQuadra;
	}
	public void setRateioQuadra(Double rateioQuadra) {
		this.rateioQuadra = rateioQuadra;
	}
	public String getAcumulado() {
		return acumulado;
	}
	public void setAcumulado(String acumulado) {
		this.acumulado = acumulado;
	}
	@Column(name="valor_acumulado")
	public Double getValorAcumulado() {
		return valorAcumulado;
	}
	public void setValorAcumulado(Double valorAcumulado) {
		this.valorAcumulado = valorAcumulado;
	}
	@Column(name="estimativa_premio")
	public Double getEstimativaPremio() {
		return estimativaPremio;
	}
	public void setEstimativaPremio(Double estimativaPremio) {
		this.estimativaPremio = estimativaPremio;
	}
	@Column(name="acumulado_mega_virada")
	public Double getAcumuladoMegaDaVirada() {
		return acumuladoMegaDaVirada;
	}
	public void setAcumuladoMegaDaVirada(Double acumuladoMegaDaVirada) {
		this.acumuladoMegaDaVirada = acumuladoMegaDaVirada;
	}
	
}
