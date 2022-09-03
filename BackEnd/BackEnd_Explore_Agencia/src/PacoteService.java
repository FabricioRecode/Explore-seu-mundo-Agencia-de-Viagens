
public class PacoteService {
	CidadeDao cidadeDao = new CidadeDao();
	PacoteDao pacoteDao = new PacoteDao();

	public void buscarPacotes(String cidadeNome) {

		int id_cidade = cidadeDao.selectIdByNome(cidadeNome);

		for (Pacote p : pacoteDao.getById(id_cidade)) {
			System.out.println("_____PACOTE_____");
			System.out.println("");
			System.out.println("Id: " + p.getId());
			System.out.println("Nome: " + cidadeNome);
			System.out.println("Diária: " + p.getDiaria());
			System.out.println("Preço: " + p.getPreco());
			System.out.println("Café da Manha " + p.isCafe_manha());
		}

	}

	public void mostrarCidades() {

		System.out.println("_____CIDADES DISPONÍVEIS_____");
		for (Cidade c : cidadeDao.select()) {

			System.out.println("");
			System.out.println("Id: " + c.getId());
			System.out.println("Nome " + c.getNome());
			System.out.println("UF: " + c.getEstado());
			System.out.println("Continente: " + c.getContinente());
			System.out.println("País: " + c.getPais());

		}

	}

	public void buscarPacotesByContinente(String continente) {

		for (Cidade c : cidadeDao.getBycontinente(continente)) {
			
			for (Pacote p : pacoteDao.getById(c.getId())) {
			System.out.println("_____PACOTE_____");
			System.out.println("");
			System.out.println("Id: " + p.getId());
			System.out.println("Nome: " + c.getNome());
			System.out.println("Diária: " + p.getDiaria());
			System.out.println("Preço: " + p.getPreco());
			System.out.println("Café da Manha " + p.isCafe_manha());
			}
		}

	}

}
