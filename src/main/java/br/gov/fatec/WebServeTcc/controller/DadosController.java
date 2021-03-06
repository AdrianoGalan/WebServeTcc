package br.gov.fatec.WebServeTcc.controller;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.fatec.WebServeTcc.model.Dados;
import br.gov.fatec.WebServeTcc.model.Funcionario;
import br.gov.fatec.WebServeTcc.model.Maquina;
import br.gov.fatec.WebServeTcc.model.Os;
import br.gov.fatec.WebServeTcc.repository.DadosRepository;
import br.gov.fatec.WebServeTcc.repository.OsRepository;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

@CrossOrigin
@RestController
@RequestMapping("/")
public class DadosController {

	@Autowired
	private OsRepository oRep;

	@GetMapping("/dados")
	public ResponseEntity<String> salvar() {
		
		
		Random gerador = new Random();

		try {
			Workbook workbook = Workbook.getWorkbook(new File("/home/adriano/Documentos/Fatec/Tcc/10Anos.xls"));

			Sheet sheet = workbook.getSheet(0);
			int linhas = sheet.getRows();

			String dia;
			String mes;
			String ano;

			String as1;

			String as2;

			String as3;

			String as4;
							//12906
			for (int i = 0; i < 12906; i++) {

				Os os = new Os();
				Maquina maquina  = new Maquina();
				Funcionario funcionario = new Funcionario();
				

				Cell a1 = sheet.getCell(0, i);

				Cell a2 = sheet.getCell(1, i);

				Cell a3 = sheet.getCell(2, i);

				Cell a4 = sheet.getCell(3, i);

				as1 = a1.getContents();

				as2 = a2.getContents();

				as3 = a3.getContents();

				as4 = a4.getContents();

				as4 = as4.substring(0, 1);

				if (as4.equals("E")) {
					as4 = "Eletrica";
				} else {
					as4 = "Mecanico";
				}

				dia = as3.substring(0, 1);

				if (!as3.substring(0, 1).matches("[0-9]*")) {

					as3 = "10-10-2010";

				} else {

					dia = as3.substring(0, 2);
					mes = as3.substring(3, 5);
					ano = as3.substring(6, 10);

					as3 = mes + "-" + dia + "-" + ano;
				}

				maquina.setSigla(as1);
				funcionario.setMatricula(gerador.nextInt(3) + 1);
				
				os.setDataGerada(as3);
				os.setProblema(as2);
				os.setDefeito(as2);
				os.setReparo("Feito reparo do " +as2);
				os.setStatusOs("C");
				os.setOficina(as4);
				os.setMaquina(maquina);
				os.setManutentorResponsavel(funcionario);

				oRep.save(os);
				
				//dRep.save(dados);

			}

			workbook.close();

		} catch (BiffException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		// dRep.save(d);
		return ResponseEntity.ok("Fabricante adicionado");

	}

}
