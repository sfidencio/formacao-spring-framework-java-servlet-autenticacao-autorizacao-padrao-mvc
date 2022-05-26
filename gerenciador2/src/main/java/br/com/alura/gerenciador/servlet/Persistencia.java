package br.com.alura.gerenciador.servlet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Persistencia {
	private static List<Empresa> lista = new ArrayList<Empresa>(0);
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

	// Bloco estatico de codigo executa toda vez que cria uma referencia da classe
	// em memoria.
	static {
		try {
			Empresa empresa1 = new Empresa(UUID.randomUUID(), "Alura", "88888888888", sdf.parse("01/01/2022"));
			Empresa empresa2 = new Empresa(UUID.randomUUID(), "Americanas", "98585874587", sdf.parse("01/05/2022"));
			Empresa empresa3 = new Empresa(UUID.randomUUID(), "Caçador - Arí", "98585874587", sdf.parse("01/12/2021"));
			lista.add(empresa1);
			lista.add(empresa2);
			lista.add(empresa3);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void adicionar(Empresa objEmpresa) {
		Persistencia.lista.add(objEmpresa);
	}

	public List<Empresa> obterTodasEmpresas() {
		return Persistencia.lista;
	}

	public void excluirEmpresa(UUID id) {
		Empresa empresaExcluida = null;
		for (Empresa e : Persistencia.lista) {
			if (e.getId().equals(id)) {
				empresaExcluida = e;
			}
		}

		if (Objects.nonNull(empresaExcluida))
			Persistencia.lista.remove(empresaExcluida);
	}

	public void excluirEmpresa2(UUID id) {
		Iterator<Empresa> it = Persistencia.lista.iterator();
		while (it.hasNext()) {
			Empresa e = it.next();
			if (e.getId().equals(id))
				it.remove();
		}
	}

	public Empresa buscarIdEmpresa(UUID id) {
		for (Empresa e : Persistencia.lista)
			if (e.getId().equals(id))
				return e;
		return null;
	}

	public void atualizar(Empresa objEmpresa) {
		Iterator<Empresa> it = Persistencia.lista.iterator();
		while (it.hasNext()) {
			Empresa e = it.next();
			if (e.getId().equals(objEmpresa.getId())) {
				e.setId(objEmpresa.getId());
				e.setEmpresa(objEmpresa.getEmpresa());
				e.setDataAbertura(objEmpresa.getDataAbertura());
				e.setCnpj(objEmpresa.getCnpj());
			}
		}
		
	}

}
