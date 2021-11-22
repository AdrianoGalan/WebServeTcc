package br.gov.fatec.WebServeTcc.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.fatec.WebServeTcc.model.Dados;
import br.gov.fatec.WebServeTcc.repository.DadosRepository;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

@CrossOrigin
@RestController
@RequestMapping("/")
public class DadosController {

	@Autowired
	private DadosRepository dRep;

	@GetMapping("/dados")
	public ResponseEntity<String> salvar() {

		try {
			Workbook workbook = Workbook.getWorkbook(new File("/home/adriano/Documentos/10Anos.xls"));

			Sheet sheet = workbook.getSheet(0);
			int linhas = sheet.getRows();

			String dia;
			String mes;
			String ano;

			String as1;

			String as2;

			String as3;

			String as4;

			for (int i = 0; i < 12906; i++) {

				Dados dados = new Dados();

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

				dados.setMaquina(as1);
				dados.setDefeito(as2);
				dados.setData(as3);
				dados.setOficina(as4);

				System.out.println(dados + "/////" + i);

				dRep.save(dados);

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
