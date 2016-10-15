

public class Letra {
	private String caractere;
	private String md5Code;

	public Letra(String caractere) {
		this.caractere = caractere;
		SecurityProvider.md5(caractere);
	}

	public String getCaractere() {
		return caractere;
	}

	public void setCaractere(String caractere) {
		this.caractere = caractere;
	}

	public String getMd5Code() {
		return md5Code;
	}

	public void setMd5Code(String md5Code) {
		this.md5Code = md5Code;
	}

}
